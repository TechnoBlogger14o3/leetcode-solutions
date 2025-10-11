/**
 * Time Complexity: O(n) - Single pass
 * Space Complexity: O(1) - Two variables
 */
class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;
        
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }
        
        return jumps;
    }
}

// Alternative approach using Dynamic Programming
class SolutionDP {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= nums[i] && i + j < nums.length; j++) {
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }
        
        return dp[nums.length - 1];
    }
}

// Alternative approach using BFS
class SolutionBFS {
    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        
        queue.offer(0);
        visited[0] = true;
        
        int jumps = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                
                if (current == nums.length - 1) {
                    return jumps;
                }
                
                int farthestJump = Math.min(current + nums[current], nums.length - 1);
                
                for (int next = current + 1; next <= farthestJump; next++) {
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
            
            jumps++;
        }
        
        return jumps;
    }
}

// Alternative approach using backtracking
class SolutionBacktracking {
    public int jump(int[] nums) {
        return jumpHelper(nums, 0);
    }
    
    private int jumpHelper(int[] nums, int position) {
        if (position >= nums.length - 1) {
            return 0;
        }
        
        int minJumps = Integer.MAX_VALUE;
        int farthestJump = Math.min(position + nums[position], nums.length - 1);
        
        for (int nextPosition = position + 1; nextPosition <= farthestJump; nextPosition++) {
            int jumps = jumpHelper(nums, nextPosition);
            if (jumps != Integer.MAX_VALUE) {
                minJumps = Math.min(minJumps, jumps + 1);
            }
        }
        
        return minJumps;
    }
}

// Alternative approach using iterative
class SolutionIterative {
    public int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;
        
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
                
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }
        
        return jumps;
    }
}

// Alternative approach using recursion with memoization
class SolutionMemoization {
    public int jump(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return jumpHelper(nums, 0, memo);
    }
    
    private int jumpHelper(int[] nums, int position, int[] memo) {
        if (position >= nums.length - 1) {
            return 0;
        }
        
        if (memo[position] != -1) {
            return memo[position];
        }
        
        int minJumps = Integer.MAX_VALUE;
        int farthestJump = Math.min(position + nums[position], nums.length - 1);
        
        for (int nextPosition = position + 1; nextPosition <= farthestJump; nextPosition++) {
            int jumps = jumpHelper(nums, nextPosition, memo);
            if (jumps != Integer.MAX_VALUE) {
                minJumps = Math.min(minJumps, jumps + 1);
            }
        }
        
        memo[position] = minJumps;
        return minJumps;
    }
}

// More concise version
class SolutionConcise {
    public int jump(int[] nums) {
        int jumps = 0, currentEnd = 0, farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }
        return jumps;
    }
}
