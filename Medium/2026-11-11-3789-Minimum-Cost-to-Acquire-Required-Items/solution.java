class Solution {
    public int minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        int minCost = Integer.MAX_VALUE;

        for (int both = 0; both <= Math.min(need1, need2); both++) {
            int remainingNeed1 = Math.max(0, need1 - both);
            int remainingNeed2 = Math.max(0, need2 - both);
            int currentCost = both * costBoth + remainingNeed1 * cost1 + remainingNeed2 * cost2;
            minCost = Math.min(minCost, currentCost);
        }

        return minCost;
    }
}