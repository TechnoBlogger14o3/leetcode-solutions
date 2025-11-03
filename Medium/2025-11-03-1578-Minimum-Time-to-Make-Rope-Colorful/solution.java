class Solution {
    public int minCost(String colors, int[] neededTime) {
        int totalCost = 0;
        int maxTime = 0;
        int n = colors.length();
        
        for (int i = 0; i < n; i++) {
            if (i > 0 && colors.charAt(i) == colors.charAt(i - 1)) {
                totalCost += Math.min(maxTime, neededTime[i]);
                maxTime = Math.max(maxTime, neededTime[i]);
            } else {
                maxTime = neededTime[i];
            }
        }
        
        return totalCost;
    }
}