/**
 * Time Complexity: O(amount * coins.length)
 * Space Complexity: O(amount) - DP array
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}

// Alternative approach using BFS
class SolutionBFS {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[amount + 1];
        
        queue.offer(0);
        visited[0] = true;
        
        int level = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                
                for (int coin : coins) {
                    int next = current + coin;
                    
                    if (next == amount) {
                        return level;
                    }
                    
                    if (next < amount && !visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
        }
        
        return -1;
    }
}

// Alternative approach using recursion with memoization
class SolutionMemoization {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -1);
        return coinChangeHelper(coins, amount, memo);
    }
    
    private int coinChangeHelper(int[] coins, int amount, int[] memo) {
        if (amount == 0) {
            return 0;
        }
        
        if (amount < 0) {
            return -1;
        }
        
        if (memo[amount] != -1) {
            return memo[amount];
        }
        
        int minCoins = Integer.MAX_VALUE;
        
        for (int coin : coins) {
            int result = coinChangeHelper(coins, amount - coin, memo);
            if (result != -1) {
                minCoins = Math.min(minCoins, result + 1);
            }
        }
        
        memo[amount] = (minCoins == Integer.MAX_VALUE) ? -1 : minCoins;
        return memo[amount];
    }
}

// Alternative approach using iterative DP
class SolutionIterative {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
    }
}

// Alternative approach using bottom-up DP
class SolutionBottomUp {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}

// Alternative approach using Set
class SolutionSet {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        
        Set<Integer> current = new HashSet<>();
        Set<Integer> next = new HashSet<>();
        boolean[] visited = new boolean[amount + 1];
        
        current.add(0);
        visited[0] = true;
        
        int level = 0;
        
        while (!current.isEmpty()) {
            level++;
            
            for (int curr : current) {
                for (int coin : coins) {
                    int nextAmount = curr + coin;
                    
                    if (nextAmount == amount) {
                        return level;
                    }
                    
                    if (nextAmount < amount && !visited[nextAmount]) {
                        visited[nextAmount] = true;
                        next.add(nextAmount);
                    }
                }
            }
            
            current = next;
            next = new HashSet<>();
        }
        
        return -1;
    }
}

// More concise version
class SolutionConcise {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
