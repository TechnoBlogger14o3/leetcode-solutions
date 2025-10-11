/**
 * Time Complexity: O(n log n) - Sorting
 * Space Complexity: O(1) - In-place modification
 */
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            return 0;
        }
        
        // Sort intervals by end time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        
        int count = 0;
        int end = intervals[0][1];
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                count++;
            } else {
                end = intervals[i][1];
            }
        }
        
        return count;
    }
}

// Alternative approach using Dynamic Programming
class SolutionDP {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            return 0;
        }
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        int[] dp = new int[intervals.length];
        dp[0] = 1;
        
        for (int i = 1; i < intervals.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (intervals[j][1] <= intervals[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        int maxNonOverlapping = 0;
        for (int i = 0; i < intervals.length; i++) {
            maxNonOverlapping = Math.max(maxNonOverlapping, dp[i]);
        }
        
        return intervals.length - maxNonOverlapping;
    }
}

// Alternative approach using iterative
class SolutionIterative {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            return 0;
        }
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        
        int count = 0;
        int end = intervals[0][1];
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                count++;
            } else {
                end = intervals[i][1];
            }
        }
        
        return count;
    }
}

// Alternative approach using while loop
class SolutionWhileLoop {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            return 0;
        }
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        
        int count = 0;
        int end = intervals[0][1];
        int i = 1;
        
        while (i < intervals.length) {
            if (intervals[i][0] < end) {
                count++;
            } else {
                end = intervals[i][1];
            }
            i++;
        }
        
        return count;
    }
}

// Alternative approach using enhanced for loop
class SolutionEnhancedForLoop {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            return 0;
        }
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        
        int count = 0;
        int end = intervals[0][1];
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                count++;
            } else {
                end = intervals[i][1];
            }
        }
        
        return count;
    }
}

// Alternative approach using recursive
class SolutionRecursive {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            return 0;
        }
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        
        return eraseOverlapIntervalsHelper(intervals, 0, intervals[0][1], 0);
    }
    
    private int eraseOverlapIntervalsHelper(int[][] intervals, int index, int end, int count) {
        if (index >= intervals.length) {
            return count;
        }
        
        if (intervals[index][0] < end) {
            return eraseOverlapIntervalsHelper(intervals, index + 1, end, count + 1);
        } else {
            return eraseOverlapIntervalsHelper(intervals, index + 1, intervals[index][1], count);
        }
    }
}

// More concise version
class SolutionConcise {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) return 0;
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        
        int count = 0, end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                count++;
            } else {
                end = intervals[i][1];
            }
        }
        
        return count;
    }
}
