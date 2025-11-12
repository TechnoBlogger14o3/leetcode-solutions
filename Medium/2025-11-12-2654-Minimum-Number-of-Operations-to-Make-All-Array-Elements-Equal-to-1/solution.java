import java.util.Arrays;

class Solution {
    public int minOperations(int[] nums) {
        if (Arrays.stream(nums).allMatch(num -> num == 1)) {
            return 0;
        }
        
        int gcd = nums[0];
        for (int num : nums) {
            gcd = gcd(gcd, num);
            if (gcd == 1) {
                break;
            }
        }
        
        if (gcd > 1) {
            return -1;
        }
        
        int operations = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (gcd(nums[i], nums[i + 1]) == 1) {
                operations++;
            }
        }
        
        return operations + (nums.length - 1);
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}