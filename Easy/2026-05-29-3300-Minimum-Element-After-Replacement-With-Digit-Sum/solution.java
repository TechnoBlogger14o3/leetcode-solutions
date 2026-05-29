class Solution {
    public int minimumElementAfterReplacement(int[] nums) {
        int minElement = Integer.MAX_VALUE;
        
        for (int num : nums) {
            minElement = Math.min(minElement, digitSum(num));
        }
        
        return minElement;
    }
    
    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}