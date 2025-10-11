/**
 * Time Complexity: O(n log n) - Sorting
 * Space Complexity: O(1) - In-place modification
 */
class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        
        // Sort balloons by end position
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        
        int arrows = 1;
        int end = points[0][1];
        
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                arrows++;
                end = points[i][1];
            }
        }
        
        return arrows;
    }
}

// Alternative approach using sorting by start position
class SolutionSortByStart {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        
        // Sort balloons by start position
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        
        int arrows = 1;
        int end = points[0][1];
        
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                arrows++;
                end = points[i][1];
            } else {
                end = Math.min(end, points[i][1]);
            }
        }
        
        return arrows;
    }
}

// Alternative approach using iterative
class SolutionIterative {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        
        int arrows = 1;
        int end = points[0][1];
        
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                arrows++;
                end = points[i][1];
            }
        }
        
        return arrows;
    }
}

// Alternative approach using while loop
class SolutionWhileLoop {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        
        int arrows = 1;
        int end = points[0][1];
        int i = 1;
        
        while (i < points.length) {
            if (points[i][0] > end) {
                arrows++;
                end = points[i][1];
            }
            i++;
        }
        
        return arrows;
    }
}

// Alternative approach using enhanced for loop
class SolutionEnhancedForLoop {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        
        int arrows = 1;
        int end = points[0][1];
        
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                arrows++;
                end = points[i][1];
            }
        }
        
        return arrows;
    }
}

// Alternative approach using recursive
class SolutionRecursive {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        
        return findMinArrowShotsHelper(points, 0, points[0][1], 1);
    }
    
    private int findMinArrowShotsHelper(int[][] points, int index, int end, int arrows) {
        if (index >= points.length) {
            return arrows;
        }
        
        if (points[index][0] > end) {
            return findMinArrowShotsHelper(points, index + 1, points[index][1], arrows + 1);
        } else {
            return findMinArrowShotsHelper(points, index + 1, end, arrows);
        }
    }
}

// More concise version
class SolutionConcise {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        
        int arrows = 1, end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                arrows++;
                end = points[i][1];
            }
        }
        
        return arrows;
    }
}
