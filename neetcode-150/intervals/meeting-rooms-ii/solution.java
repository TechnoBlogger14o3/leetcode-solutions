/**
 * Time Complexity: O(n log n) - Sorting + Heap operations
 * Space Complexity: O(n) - Heap
 */
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        
        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Min heap to track end times
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Add first meeting's end time
        minHeap.offer(intervals[0][1]);
        
        for (int i = 1; i < intervals.length; i++) {
            // If current meeting starts after earliest ending meeting
            if (intervals[i][0] >= minHeap.peek()) {
                minHeap.poll();
            }
            
            // Add current meeting's end time
            minHeap.offer(intervals[i][1]);
        }
        
        return minHeap.size();
    }
}

// Alternative approach using sweep line algorithm
class SolutionSweepLine {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
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
        int maxRooms = 0;
        
        for (int[] event : events) {
            count += event[1];
            maxRooms = Math.max(maxRooms, count);
        }
        
        return maxRooms;
    }
}

// Alternative approach using two pointers
class SolutionTwoPointers {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        
        int n = intervals.length;
        int[] startTimes = new int[n];
        int[] endTimes = new int[n];
        
        for (int i = 0; i < n; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }
        
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        
        int startPointer = 0;
        int endPointer = 0;
        int rooms = 0;
        
        while (startPointer < n) {
            if (startTimes[startPointer] >= endTimes[endPointer]) {
                rooms--;
                endPointer++;
            }
            rooms++;
            startPointer++;
        }
        
        return rooms;
    }
}

// Alternative approach using iterative
class SolutionIterative {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(intervals[0][1]);
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= minHeap.peek()) {
                minHeap.poll();
            }
            minHeap.offer(intervals[i][1]);
        }
        
        return minHeap.size();
    }
}

// Alternative approach using while loop
class SolutionWhileLoop {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(intervals[0][1]);
        
        int i = 1;
        while (i < intervals.length) {
            if (intervals[i][0] >= minHeap.peek()) {
                minHeap.poll();
            }
            minHeap.offer(intervals[i][1]);
            i++;
        }
        
        return minHeap.size();
    }
}

// Alternative approach using enhanced for loop
class SolutionEnhancedForLoop {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(intervals[0][1]);
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= minHeap.peek()) {
                minHeap.poll();
            }
            minHeap.offer(intervals[i][1]);
        }
        
        return minHeap.size();
    }
}

// More concise version
class SolutionConcise {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(intervals[0][1]);
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= minHeap.peek()) minHeap.poll();
            minHeap.offer(intervals[i][1]);
        }
        
        return minHeap.size();
    }
}
