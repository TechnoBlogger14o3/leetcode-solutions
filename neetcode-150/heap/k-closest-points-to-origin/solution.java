/**
 * Time Complexity: O(n log k) - n points, heap size k
 * Space Complexity: O(k) - Heap size
 */
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> 
            (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1])
        );
        
        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        
        return maxHeap.toArray(new int[k][]);
    }
}

// Alternative approach using sorting
class SolutionSorting {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (a, b) -> 
            (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1])
        );
        
        return Arrays.copyOf(points, k);
    }
}

// Alternative approach using min heap
class SolutionMinHeap {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> 
            (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1])
        );
        
        for (int[] point : points) {
            minHeap.offer(point);
        }
        
        int[][] result = new int[k][];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }
        
        return result;
    }
}

// Alternative approach using custom class
class SolutionCustom {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> maxHeap = new PriorityQueue<>((a, b) -> 
            b.distance - a.distance
        );
        
        for (int[] point : points) {
            Point p = new Point(point[0], point[1]);
            maxHeap.offer(p);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        
        int[][] result = new int[k][];
        int index = 0;
        for (Point p : maxHeap) {
            result[index++] = new int[]{p.x, p.y};
        }
        
        return result;
    }
    
    private static class Point {
        int x, y, distance;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.distance = x * x + y * y;
        }
    }
}

// Alternative approach using quick select
class SolutionQuickSelect {
    public int[][] kClosest(int[][] points, int k) {
        int left = 0, right = points.length - 1;
        
        while (left < right) {
            int pivot = partition(points, left, right);
            if (pivot == k) break;
            if (pivot < k) left = pivot + 1;
            else right = pivot - 1;
        }
        
        return Arrays.copyOf(points, k);
    }
    
    private int partition(int[][] points, int left, int right) {
        int pivot = left;
        int pivotDist = getDistance(points[right]);
        
        for (int i = left; i < right; i++) {
            if (getDistance(points[i]) <= pivotDist) {
                swap(points, i, pivot++);
            }
        }
        
        swap(points, pivot, right);
        return pivot;
    }
    
    private int getDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
    
    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
}

// More concise version
class SolutionConcise {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> 
            (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1])
        );
        
        for (int[] point : points) {
            heap.offer(point);
            if (heap.size() > k) heap.poll();
        }
        
        return heap.toArray(new int[k][]);
    }
}
