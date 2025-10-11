/**
 * Time Complexity: O(n) - Two passes
 * Space Complexity: O(1) - Two variables
 */
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        if (nums.length == 1) {
            return nums[0];
        }
        
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        
        // Case 1: Rob houses 0 to n-2 (exclude last house)
        int case1 = robLinear(nums, 0, nums.length - 2);
        
        // Case 2: Rob houses 1 to n-1 (exclude first house)
        int case2 = robLinear(nums, 1, nums.length - 1);
        
        return Math.max(case1, case2);
    }
    
    private int robLinear(int[] nums, int start, int end) {
        int prev2 = nums[start];
        int prev1 = Math.max(nums[start], nums[start + 1]);
        
        for (int i = start + 2; i <= end; i++) {
            int current = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
    }
}

// Alternative approach using helper function
class SolutionHelper {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        
        return Math.max(robHelper(nums, 0, nums.length - 2), 
                       robHelper(nums, 1, nums.length - 1));
    }
    
    private int robHelper(int[] nums, int start, int end) {
        int robPrev = 0, robCurrent = 0;
        
        for (int i = start; i <= end; i++) {
            int temp = robCurrent;
            robCurrent = Math.max(robPrev + nums[i], robCurrent);
            robPrev = temp;
        }
        
        return robCurrent;
    }
}

// Alternative approach using arrays
class SolutionArray {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        
        // Case 1: Exclude last house
        int[] dp1 = new int[nums.length - 1];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < nums.length - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i]);
        }
        
        // Case 2: Exclude first house
        int[] dp2 = new int[nums.length - 1];
        dp2[0] = nums[1];
        dp2[1] = Math.max(nums[1], nums[2]);
        
        for (int i = 2; i < nums.length - 1; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i + 1]);
        }
        
        return Math.max(dp1[nums.length - 2], dp2[nums.length - 2]);
    }
}

// Alternative approach using recursion with memoization
class SolutionMemoization {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        
        int[] memo1 = new int[nums.length];
        int[] memo2 = new int[nums.length];
        Arrays.fill(memo1, -1);
        Arrays.fill(memo2, -1);
        
        int case1 = robHelper(nums, 0, nums.length - 2, memo1);
        int case2 = robHelper(nums, 1, nums.length - 1, memo2);
        
        return Math.max(case1, case2);
    }
    
    private int robHelper(int[] nums, int start, int end, int[] memo) {
        if (start > end) return 0;
        if (start == end) return nums[start];
        
        if (memo[start] != -1) return memo[start];
        
        int robCurrent = nums[start] + robHelper(nums, start + 2, end, memo);
        int skipCurrent = robHelper(nums, start + 1, end, memo);
        
        memo[start] = Math.max(robCurrent, skipCurrent);
        return memo[start];
    }
}

// Alternative approach using iterative
class SolutionIterative {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        
        return Math.max(robRange(nums, 0, nums.length - 2), 
                       robRange(nums, 1, nums.length - 1));
    }
    
    private int robRange(int[] nums, int start, int end) {
        int include = 0, exclude = 0;
        
        for (int i = start; i <= end; i++) {
            int newInclude = exclude + nums[i];
            int newExclude = Math.max(include, exclude);
            
            include = newInclude;
            exclude = newExclude;
        }
        
        return Math.max(include, exclude);
    }
}

// More concise version
class SolutionConcise {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        
        return Math.max(robRange(nums, 0, nums.length - 2), 
                       robRange(nums, 1, nums.length - 1));
    }
    
    private int robRange(int[] nums, int start, int end) {
        int prev2 = nums[start], prev1 = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int curr = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
