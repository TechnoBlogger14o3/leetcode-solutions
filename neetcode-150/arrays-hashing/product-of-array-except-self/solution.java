/**
 * Time Complexity: O(n) - Two passes through the array
 * Space Complexity: O(1) - Excluding the output array
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // First pass: calculate left products
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        
        // Second pass: calculate right products and multiply
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        
        return result;
    }
}

// Alternative approach using two arrays
class SolutionTwoArrays {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftProducts = new int[n];
        int[] rightProducts = new int[n];
        int[] result = new int[n];
        
        // Calculate left products
        leftProducts[0] = 1;
        for (int i = 1; i < n; i++) {
            leftProducts[i] = leftProducts[i - 1] * nums[i - 1];
        }
        
        // Calculate right products
        rightProducts[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            rightProducts[i] = rightProducts[i + 1] * nums[i + 1];
        }
        
        // Multiply left and right products
        for (int i = 0; i < n; i++) {
            result[i] = leftProducts[i] * rightProducts[i];
        }
        
        return result;
    }
}

// Brute force approach (not recommended)
class SolutionBruteForce {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    product *= nums[j];
                }
            }
            result[i] = product;
        }
        
        return result;
    }
}
