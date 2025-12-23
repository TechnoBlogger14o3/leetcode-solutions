import java.util.Arrays;

public class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[1], b[1]));
        int n = events.length;
        int[] maxValue = new int[n];
        maxValue[0] = events[0][2];

        for (int i = 1; i < n; i++) {
            maxValue[i] = Math.max(maxValue[i - 1], events[i][2]);
        }

        int maxSum = 0;

        for (int i = 0; i < n; i++) {
            int currentValue = events[i][2];
            int nextStartTime = events[i][1] + 1;
            int j = binarySearch(events, nextStartTime);
            if (j != -1) {
                currentValue += maxValue[j];
            }
            maxSum = Math.max(maxSum, currentValue);
        }

        return maxSum;
    }

    private int binarySearch(int[][] events, int startTime) {
        int left = 0, right = events.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (events[mid][0] >= startTime) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right; // return the last index where events[index][0] < startTime
    }
}