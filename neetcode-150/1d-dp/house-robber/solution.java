/**
 * Time Complexity: O(n) - Single pass
 * Space Complexity: O(n) - DP array
 */
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        if (nums.length == 1) {
            return nums[0];
        }
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        
        return dp[nums.length - 1];
    }
}

// Alternative approach using space-optimized DP
class SolutionSpaceOptimized {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        if (nums.length == 1) {
            return nums[0];
        }
        
        int prev2 = nums[0]; // dp[i-2]
        int prev1 = Math.max(nums[0], nums[1]); // dp[i-1]
        
        for (int i = 2; i < nums.length; i++) {
            int current = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
    }
}

// Alternative approach using recursion with memoization
class SolutionMemoization {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return robHelper(nums, 0, memo);
    }
    
    private int robHelper(int[] nums, int index, int[] memo) {
        if (index >= nums.length) {
            return 0;
        }
        
        if (memo[index] != -1) {
            return memo[index];
        }
        
        // Either rob current house or skip it
        int robCurrent = nums[index] + robHelper(nums, index + 2, memo);
        int skipCurrent = robHelper(nums, index + 1, memo);
        
        memo[index] = Math.max(robCurrent, skipCurrent);
        return memo[index];
    }
}

// Alternative approach using iterative with variables
class SolutionIterative {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int robPrev = 0; // Money robbed from previous house
        int robCurrent = 0; // Money robbed from current house
        
        for (int num : nums) {
            int temp = robCurrent;
            robCurrent = Math.max(robPrev + num, robCurrent);
            robPrev = temp;
        }
        
        return robCurrent;
    }
}

// Alternative approach using two variables
class SolutionTwoVariables {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int include = 0; // Include current house
        int exclude = 0; // Exclude current house
        
        for (int num : nums) {
            int newInclude = exclude + num;
            int newExclude = Math.max(include, exclude);
            
            include = newInclude;
            exclude = newExclude;
        }
        
        return Math.max(include, exclude);
    }
}

// Alternative approach using bottom-up DP
class SolutionBottomUp {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        int[] dp = new int[n + 2];
        
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
        }
        
        return dp[0];
    }
}

// More concise version
class SolutionConcise {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        int prev2 = nums[0], prev1 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int curr = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
