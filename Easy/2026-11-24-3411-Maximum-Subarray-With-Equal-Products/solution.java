import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxProductEquivalentSubarray(int[] nums) {
        int n = nums.length;
        int maxLength = 0;

        for (int start = 0; start < n; start++) {
            long prod = 1;
            long gcd = nums[start];
            long lcm = nums[start];
            for (int end = start; end < n; end++) {
                prod *= nums[end];
                gcd = gcd(gcd, nums[end]);
                lcm = lcm(lcm, nums[end]);

                if (prod == lcm * gcd) {
                    maxLength = Math.max(maxLength, end - start + 1);
                }
            }
        }
        return maxLength;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}