import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public int[] maxJump(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MIN_VALUE);
        
        // Forward pass
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                ans[stack.pop()] = Math.max(ans[stack.peek()], nums[i]);
            }
            stack.push(i);
        }
        
        // Clear stack for backward pass
        stack.clear();
        
        // Backward pass
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                ans[stack.pop()] = Math.max(ans[stack.peek()], nums[i]);
            }
            stack.push(i);
        }
        
        // Fill in the maximum values for each index
        for (int i = 0; i < n; i++) {
            ans[i] = Math.max(ans[i], nums[i]);
        }
        
        return ans;
    }
}