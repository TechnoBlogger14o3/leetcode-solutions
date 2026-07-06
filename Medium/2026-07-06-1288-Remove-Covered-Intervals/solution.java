import java.util.Arrays;

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int count = 0;
        int end = 0;

        for (int[] interval : intervals) {
            if (interval[1] > end) {
                count++;
                end = interval[1];
            }
        }

        return count;
    }
}