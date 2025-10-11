/**
 * Time Complexity: O(n log n) - Sorting
 * Space Complexity: O(1) - In-place modification
 */
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length <= 1) {
            return true;
        }
        
        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Check if any interval overlaps with the next
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        
        return true;
    }
}

// Alternative approach using brute force
class SolutionBruteForce {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length <= 1) {
            return true;
        }
        
        // Check all pairs of intervals for overlap
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i][0] < intervals[j][1] && intervals[j][0] < intervals[i][1]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}

// Alternative approach using sweep line algorithm
class SolutionSweepLine {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length <= 1) {
            return true;
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
        
        int count = 0;
        for (int[] event : events) {
            count += event[1];
            if (count > 1) {
                return false;
            }
        }
        
        return true;
    }
}

// Alternative approach using iterative
class SolutionIterative {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length <= 1) {
            return true;
        }
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        
        return true;
    }
}

// Alternative approach using while loop
class SolutionWhileLoop {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length <= 1) {
            return true;
        }
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        int i = 0;
        while (i < intervals.length - 1) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
            i++;
        }
        
        return true;
    }
}

// Alternative approach using enhanced for loop
class SolutionEnhancedForLoop {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length <= 1) {
            return true;
        }
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        
        return true;
    }
}

// Alternative approach using recursive
class SolutionRecursive {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length <= 1) {
            return true;
        }
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        return canAttendMeetingsHelper(intervals, 0);
    }
    
    private boolean canAttendMeetingsHelper(int[][] intervals, int index) {
        if (index >= intervals.length - 1) {
            return true;
        }
        
        if (intervals[index][1] > intervals[index + 1][0]) {
            return false;
        }
        
        return canAttendMeetingsHelper(intervals, index + 1);
    }
}

// More concise version
class SolutionConcise {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length <= 1) return true;
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) return false;
        }
        
        return true;
    }
}
