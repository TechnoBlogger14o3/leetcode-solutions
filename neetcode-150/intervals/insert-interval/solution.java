/**
 * Time Complexity: O(n) - Three passes
 * Space Complexity: O(1) - In-place modification
 */
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        
        // First pass: Add all intervals before newInterval
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        
        // Second pass: Merge overlapping intervals with newInterval
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);
        
        // Third pass: Add all intervals after newInterval
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }
        
        return result.toArray(new int[result.size()][]);
    }
}

// Alternative approach using binary search
class SolutionBinarySearch {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        
        // Find insertion point using binary search
        int left = 0, right = intervals.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (intervals[mid][0] < newInterval[0]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        // Add intervals before insertion point
        for (int i = 0; i < left; i++) {
            result.add(intervals[i]);
        }
        
        // Merge overlapping intervals
        int start = newInterval[0];
        int end = newInterval[1];
        
        while (left < intervals.length && intervals[left][0] <= end) {
            start = Math.min(start, intervals[left][0]);
            end = Math.max(end, intervals[left][1]);
            left++;
        }
        
        result.add(new int[]{start, end});
        
        // Add remaining intervals
        for (int i = left; i < intervals.length; i++) {
            result.add(intervals[i]);
        }
        
        return result.toArray(new int[result.size()][]);
    }
}

// Alternative approach using single pass
class SolutionSinglePass {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        boolean inserted = false;
        
        for (int[] interval : intervals) {
            if (!inserted && interval[0] > newInterval[1]) {
                result.add(newInterval);
                inserted = true;
            }
            
            if (inserted || interval[1] < newInterval[0]) {
                result.add(interval);
            } else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        
        if (!inserted) {
            result.add(newInterval);
        }
        
        return result.toArray(new int[result.size()][]);
    }
}

// Alternative approach using iterative
class SolutionIterative {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);
        
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }
        
        return result.toArray(new int[result.size()][]);
    }
}

// Alternative approach using while loop
class SolutionWhileLoop {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);
        
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }
        
        return result.toArray(new int[result.size()][]);
    }
}

// Alternative approach using enhanced for loop
class SolutionEnhancedForLoop {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        boolean inserted = false;
        
        for (int[] interval : intervals) {
            if (!inserted && interval[0] > newInterval[1]) {
                result.add(newInterval);
                inserted = true;
            }
            
            if (inserted || interval[1] < newInterval[0]) {
                result.add(interval);
            } else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        
        if (!inserted) {
            result.add(newInterval);
        }
        
        return result.toArray(new int[result.size()][]);
    }
}

// More concise version
class SolutionConcise {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i++]);
        }
        
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);
        
        while (i < intervals.length) {
            result.add(intervals[i++]);
        }
        
        return result.toArray(new int[result.size()][]);
    }
}
