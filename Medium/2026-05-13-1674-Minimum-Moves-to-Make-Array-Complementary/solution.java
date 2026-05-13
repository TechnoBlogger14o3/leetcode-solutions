class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] moves = new int[2 * limit + 2];
        
        for (int i = 0; i < n / 2; i++) {
            int a = nums[i];
            int b = nums[n - 1 - i];
            int low = Math.min(a, b) + 1;
            int high = Math.max(a, b) + limit;
            
            moves[low]++;
            moves[high + 1]--;
        }
        
        int minMoves = n;
        int currentMoves = 0;
        
        for (int i = 1; i < moves.length; i++) {
            currentMoves += moves[i];
            minMoves = Math.min(minMoves, currentMoves);
        }
        
        return minMoves;
    }
}