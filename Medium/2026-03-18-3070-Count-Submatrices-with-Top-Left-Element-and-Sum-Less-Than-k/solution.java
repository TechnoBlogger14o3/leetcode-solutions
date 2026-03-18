class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            int[] sum = new int[n];
            for (int j = i; j < m; j++) {
                for (int col = 0; col < n; col++) {
                    sum[col] += grid[j][col];
                }
                count += countSubarraysWithSumLessThanK(sum, k);
            }
        }
        return count;
    }

    private int countSubarraysWithSumLessThanK(int[] sum, int k) {
        int count = 0, currentSum = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 1); // To account for the case when currentSum itself is less than k

        for (int s : sum) {
            currentSum += s;
            count += map.headMap(currentSum - k).size();
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }
}