/**
 * Time Complexity: O(n) - Single pass
 * Space Complexity: O(1) - One variable
 */
class Solution {
    public boolean canJump(int[] nums) {
        int farthest = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (i > farthest) {
                return false;
            }
            farthest = Math.max(farthest, i + nums[i]);
        }
        
        return farthest >= nums.length - 1;
    }
}

// Alternative approach using Dynamic Programming
class SolutionDP {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && j + nums[j] >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[nums.length - 1];
    }
}

// Alternative approach using backtracking
class SolutionBacktracking {
    public boolean canJump(int[] nums) {
        return canJumpHelper(nums, 0);
    }
    
    private boolean canJumpHelper(int[] nums, int position) {
        if (position == nums.length - 1) {
            return true;
        }
        
        int farthestJump = Math.min(position + nums[position], nums.length - 1);
        
        for (int nextPosition = position + 1; nextPosition <= farthestJump; nextPosition++) {
            if (canJumpHelper(nums, nextPosition)) {
                return true;
            }
        }
        
        return false;
    }
}

// Alternative approach using iterative
class SolutionIterative {
    public boolean canJump(int[] nums) {
        int farthest = 0;
        
        for (int i = 0; i < nums.length && i <= farthest; i++) {
            farthest = Math.max(farthest, i + nums[i]);
        }
        
        return farthest >= nums.length - 1;
    }
}

// Alternative approach using BFS
class SolutionBFS {
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        
        queue.offer(0);
        visited[0] = true;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            if (current == nums.length - 1) {
                return true;
            }
            
            int farthestJump = Math.min(current + nums[current], nums.length - 1);
            
            for (int next = current + 1; next <= farthestJump; next++) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
        
        return false;
    }
}

// Alternative approach using recursion with memoization
class SolutionMemoization {
    public boolean canJump(int[] nums) {
        Boolean[] memo = new Boolean[nums.length];
        return canJumpHelper(nums, 0, memo);
    }
    
    private boolean canJumpHelper(int[] nums, int position, Boolean[] memo) {
        if (position == nums.length - 1) {
            return true;
        }
        
        if (memo[position] != null) {
            return memo[position];
        }
        
        int farthestJump = Math.min(position + nums[position], nums.length - 1);
        
        for (int nextPosition = position + 1; nextPosition <= farthestJump; nextPosition++) {
            if (canJumpHelper(nums, nextPosition, memo)) {
                memo[position] = true;
                return true;
            }
        }
        
        memo[position] = false;
        return false;
    }
}

// More concise version
class SolutionConcise {
    public boolean canJump(int[] nums) {
        int farthest = 0;
        for (int i = 0; i < nums.length && i <= farthest; i++) {
            farthest = Math.max(farthest, i + nums[i]);
        }
        return farthest >= nums.length - 1;
    }
}
