/**
 * Time Complexity: O(n log n) - Sorting
 * Space Complexity: O(1) - In-place modification
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        
        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        
        for (int i = 1; i < intervals.length; i++) {
            if (current[1] >= intervals[i][0]) {
                // Overlapping intervals, merge them
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                // Non-overlapping interval, add current and move to next
                result.add(current);
                current = intervals[i];
            }
        }
        
        // Add the last interval
        result.add(current);
        
        return result.toArray(new int[result.size()][]);
    }
}

// Alternative approach using sweep line algorithm
class SolutionSweepLine {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        
        List<int[]> events = new ArrayList<>();
        for (int[] interval : intervals) {
            events.add(new int[]{interval[0], 1}); // Start event
            events.add(new int[]{interval[1], -1}); // End event
        }
        
        events.sort((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(b[1], a[1]); // End events before start events
        });
        
        List<int[]> result = new ArrayList<>();
        int count = 0;
        int start = -1;
        
        for (int[] event : events) {
            if (event[1] == 1) { // Start event
                if (count == 0) {
                    start = event[0];
                }
                count++;
            } else { // End event
                count--;
                if (count == 0) {
                    result.add(new int[]{start, event[0]});
                }
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
}

// Alternative approach using iterative
class SolutionIterative {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        
        for (int i = 1; i < intervals.length; i++) {
            if (current[1] >= intervals[i][0]) {
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                result.add(current);
                current = intervals[i];
            }
        }
        
        result.add(current);
        return result.toArray(new int[result.size()][]);
    }
}

// Alternative approach using while loop
class SolutionWhileLoop {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        int i = 1;
        
        while (i < intervals.length) {
            if (current[1] >= intervals[i][0]) {
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                result.add(current);
                current = intervals[i];
            }
            i++;
        }
        
        result.add(current);
        return result.toArray(new int[result.size()][]);
    }
}

// Alternative approach using enhanced for loop
class SolutionEnhancedForLoop {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        
        for (int i = 1; i < intervals.length; i++) {
            if (current[1] >= intervals[i][0]) {
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                result.add(current);
                current = intervals[i];
            }
        }
        
        result.add(current);
        return result.toArray(new int[result.size()][]);
    }
}

// Alternative approach using recursive
class SolutionRecursive {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> result = new ArrayList<>();
        mergeHelper(intervals, 0, result);
        
        return result.toArray(new int[result.size()][]);
    }
    
    private void mergeHelper(int[][] intervals, int index, List<int[]> result) {
        if (index >= intervals.length) {
            return;
        }
        
        int[] current = intervals[index];
        int i = index + 1;
        
        while (i < intervals.length && current[1] >= intervals[i][0]) {
            current[1] = Math.max(current[1], intervals[i][1]);
            i++;
        }
        
        result.add(current);
        mergeHelper(intervals, i, result);
    }
}

// More concise version
class SolutionConcise {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        
        for (int i = 1; i < intervals.length; i++) {
            if (current[1] >= intervals[i][0]) {
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                result.add(current);
                current = intervals[i];
            }
        }
        
        result.add(current);
        return result.toArray(new int[result.size()][]);
    }
}
