import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int count = 0;
        int end1 = -1, end2 = -1;

        for (int[] interval : intervals) {
            if (end2 < interval[0]) {
                count += 2;
                end1 = interval[1];
                end2 = interval[1] - 1;
            } else if (end1 < interval[0]) {
                count += 1;
                end1 = end2;
                end2 = interval[1];
            }
        }

        return count;
    }
}