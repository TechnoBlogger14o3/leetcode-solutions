import java.util.Arrays;

public class Solution {
    public int sumOfGcdOfFormedPairs(int[] nums) {
        int n = nums.length;
        int[] prefixGcd = new int[n];
        int max = nums[0];
        
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            prefixGcd[i] = gcd(nums[i], max);
        }
        
        Arrays.sort(prefixGcd);
        int sum = 0;
        
        for (int i = 0; i < n / 2; i++) {
            sum += gcd(prefixGcd[i], prefixGcd[n - 1 - i]);
        }
        
        return sum;
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