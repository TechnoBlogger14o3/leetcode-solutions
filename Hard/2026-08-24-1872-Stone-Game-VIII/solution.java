class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        for (int i = 1; i < n; i++) {
            stones[i] += stones[i - 1];
        }
        
        int maxDiff = stones[n - 1];
        int result = maxDiff;
        
        for (int i = n - 2; i >= 1; i--) {
            maxDiff = Math.max(maxDiff, stones[i]);
            result = Math.max(result, maxDiff - stones[i]);
        }
        
        return result;
    }
}