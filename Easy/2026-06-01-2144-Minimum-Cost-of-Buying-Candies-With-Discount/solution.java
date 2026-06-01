class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int totalCost = 0;
        int n = cost.length;

        for (int i = n - 1; i >= 0; i--) {
            totalCost += cost[i];
            if (i - 2 >= 0) {
                i--; // Skip the next candy as it will be free
            }
        }

        return totalCost;
    }
}