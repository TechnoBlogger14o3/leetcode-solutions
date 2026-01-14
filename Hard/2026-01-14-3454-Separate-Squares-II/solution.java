import java.util.*;

public class Solution {
    public double minYCoordinate(int[][] squares) {
        Set<int[]> events = new HashSet<>();
        int totalArea = 0;

        for (int[] square : squares) {
            int x = square[0], y = square[1], l = square[2];
            totalArea += l * l;
            events.add(new int[]{x, y, y + l, 1}); // start of square
            events.add(new int[]{x + l, y, y + l, -1}); // end of square
        }

        List<int[]> eventList = new ArrayList<>(events);
        eventList.sort((a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[3], b[3]));

        int currentArea = 0;
        TreeMap<Integer, Integer> heightCount = new TreeMap<>();
        double targetArea = totalArea / 2.0;

        for (int[] event : eventList) {
            int x = event[0], y1 = event[1], y2 = event[2], type = event[3];

            if (currentArea >= targetArea) {
                double y = heightCount.firstKey();
                return y;
            }

            if (type == 1) {
                heightCount.put(y1, heightCount.getOrDefault(y1, 0) + 1);
                heightCount.put(y2, heightCount.getOrDefault(y2, 0) - 1);
            } else {
                heightCount.put(y1, heightCount.get(y1) - 1);
                if (heightCount.get(y1) == 0) heightCount.remove(y1);
                heightCount.put(y2, heightCount.getOrDefault(y2, 0) + 1);
            }

            currentArea = calculateArea(heightCount);
        }

        return -1; // In case no valid y-coordinate is found
    }

    private int calculateArea(TreeMap<Integer, Integer> heightCount) {
        int area = 0;
        int prevHeight = -1;
        int currentHeight = 0;

        for (Map.Entry<Integer, Integer> entry : heightCount.entrySet()) {
            int height = entry.getKey();
            if (currentHeight > 0 && prevHeight != -1) {
                area += (height - prevHeight) * currentHeight;
            }
            currentHeight += entry.getValue();
            prevHeight = height;
        }

        return area;
    }
}