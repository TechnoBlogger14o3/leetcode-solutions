/**
 * Time Complexity: O(m * n) - Fill DP table
 * Space Complexity: O(m * n) - DP table
 */
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        // Initialize first row
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        
        // Initialize first column
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        
        // Fill DP table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        
        return dp[m - 1][n - 1];
    }
}

// Alternative approach using space-optimized DP
class SolutionSpaceOptimized {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        
        return dp[n - 1];
    }
}

// Alternative approach using mathematical formula
class SolutionMathematical {
    public int uniquePaths(int m, int n) {
        // Use combination formula: C(m+n-2, m-1)
        long result = 1;
        int total = m + n - 2;
        int k = Math.min(m - 1, n - 1);
        
        for (int i = 0; i < k; i++) {
            result = result * (total - i) / (i + 1);
        }
        
        return (int) result;
    }
}

// Alternative approach using recursion with memoization
class SolutionMemoization {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        return uniquePathsHelper(m - 1, n - 1, memo);
    }
    
    private int uniquePathsHelper(int i, int j, int[][] memo) {
        if (i == 0 || j == 0) {
            return 1;
        }
        
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        
        memo[i][j] = uniquePathsHelper(i - 1, j, memo) + uniquePathsHelper(i, j - 1, memo);
        return memo[i][j];
    }
}

// Alternative approach using iterative
class SolutionIterative {
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                
                int fromTop = (i > 0) ? dp[i - 1][j] : 0;
                int fromLeft = (j > 0) ? dp[i][j - 1] : 0;
                
                dp[i][j] = fromTop + fromLeft;
            }
        }
        
        return dp[m - 1][n - 1];
    }
}

// Alternative approach using bottom-up DP
class SolutionBottomUp {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 || j == n - 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }
        
        return dp[0][0];
    }
}

// More concise version
class SolutionConcise {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        
        return dp[n - 1];
    }
}
