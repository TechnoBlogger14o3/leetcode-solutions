/**
 * Time Complexity: O(target * nums.length)
 * Space Complexity: O(target) - DP array
 */
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        
        return dp[target];
    }
}

// Alternative approach using recursion with memoization
class SolutionMemoization {
    public int combinationSum4(int[] nums, int target) {
        int[] memo = new int[target + 1];
        Arrays.fill(memo, -1);
        return combinationSum4Helper(nums, target, memo);
    }
    
    private int combinationSum4Helper(int[] nums, int target, int[] memo) {
        if (target == 0) {
            return 1;
        }
        
        if (target < 0) {
            return 0;
        }
        
        if (memo[target] != -1) {
            return memo[target];
        }
        
        int result = 0;
        for (int num : nums) {
            result += combinationSum4Helper(nums, target - num, memo);
        }
        
        memo[target] = result;
        return result;
    }
}

// Alternative approach using iterative DP
class SolutionIterative {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        
        for (int i = 0; i <= target; i++) {
            for (int num : nums) {
                if (i + num <= target) {
                    dp[i + num] += dp[i];
                }
            }
        }
        
        return dp[target];
    }
}

// Alternative approach using bottom-up DP
class SolutionBottomUp {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        
        return dp[target];
    }
}

// Alternative approach using recursion
class SolutionRecursion {
    public int combinationSum4(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        
        if (target < 0) {
            return 0;
        }
        
        int result = 0;
        for (int num : nums) {
            result += combinationSum4(nums, target - num);
        }
        
        return result;
    }
}

// More concise version
class SolutionConcise {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) dp[i] += dp[i - num];
            }
        }
        
        return dp[target];
    }
}
