/**
 * Time Complexity: O(n log n) - Sorting
 * Space Complexity: O(n) - Stack and sorting
 */
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];
        
        // Create pairs of (position, time to reach target)
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }
        
        // Sort by position (closest to target first)
        Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));
        
        Stack<Double> stack = new Stack<>();
        
        // Process cars from right to left
        for (int i = n - 1; i >= 0; i--) {
            double time = cars[i][1];
            
            // If stack is empty or current car reaches target after stack top
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
        }
        
        return stack.size();
    }
}

// Alternative approach using ArrayDeque
class SolutionArrayDeque {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];
        
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }
        
        Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));
        
        Deque<Double> stack = new ArrayDeque<>();
        
        for (int i = n - 1; i >= 0; i--) {
            double time = cars[i][1];
            
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
        }
        
        return stack.size();
    }
}

// More concise version
class SolutionConcise {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[] times = new double[n];
        
        for (int i = 0; i < n; i++) {
            times[i] = (double)(target - position[i]) / speed[i];
        }
        
        // Sort by position
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> Integer.compare(position[a], position[b]));
        
        Stack<Double> stack = new Stack<>();
        
        for (int i = n - 1; i >= 0; i--) {
            double time = times[indices[i]];
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
        }
        
        return stack.size();
    }
}

// Using TreeMap for sorting
class SolutionTreeMap {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Double> cars = new TreeMap<>();
        
        for (int i = 0; i < position.length; i++) {
            cars.put(position[i], (double)(target - position[i]) / speed[i]);
        }
        
        Stack<Double> stack = new Stack<>();
        
        for (double time : cars.descendingMap().values()) {
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
        }
        
        return stack.size();
    }
}
