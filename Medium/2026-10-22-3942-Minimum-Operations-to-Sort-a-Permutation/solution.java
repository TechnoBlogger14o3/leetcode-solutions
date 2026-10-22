class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[nums[i]] = i;
        }
        
        boolean[] visited = new boolean[n];
        int cycles = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                cycles++;
                int j = i;
                while (!visited[j]) {
                    visited[j] = true;
                    j = pos[j];
                }
            }
        }
        
        if (cycles == 1) {
            return 0; // Already sorted
        }
        
        int minOperations = cycles - 1;
        if (n % 2 == 0) {
            return (minOperations % 2 == 0) ? minOperations : -1;
        } else {
            return minOperations;
        }
    }
}