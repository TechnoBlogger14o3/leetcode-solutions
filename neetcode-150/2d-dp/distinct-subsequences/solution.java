/**
 * Time Complexity: O(m * n) - Fill DP table
 * Space Complexity: O(m * n) - DP table
 */
class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        
        // Initialize base case: empty string can form empty target
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        
        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return dp[m][n];
    }
}

// Alternative approach using space-optimized DP
class SolutionSpaceOptimized {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        // Use shorter string for space optimization
        if (m < n) {
            return numDistinct(t, s);
        }
        
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];
        
        // Initialize first row
        prev[0] = 1;
        
        for (int i = 1; i <= m; i++) {
            curr[0] = 1;
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    curr[j] = prev[j - 1] + prev[j];
                } else {
                    curr[j] = prev[j];
                }
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev[n];
    }
}

// Alternative approach using recursion with memoization
class SolutionMemoization {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] memo = new int[m][n];
        
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        return numDistinctHelper(s, t, 0, 0, memo);
    }
    
    private int numDistinctHelper(String s, String t, int i, int j, int[][] memo) {
        if (j == t.length()) {
            return 1;
        }
        
        if (i == s.length()) {
            return 0;
        }
        
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        
        int result = 0;
        
        if (s.charAt(i) == t.charAt(j)) {
            result += numDistinctHelper(s, t, i + 1, j + 1, memo);
        }
        
        result += numDistinctHelper(s, t, i + 1, j, memo);
        
        memo[i][j] = result;
        return result;
    }
}

// Alternative approach using iterative
class SolutionIterative {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return dp[m][n];
    }
}

// Alternative approach using bottom-up DP
class SolutionBottomUp {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        
        for (int j = 0; j <= n; j++) {
            dp[m][j] = (j == n) ? 1 : 0;
        }
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        
        return dp[0][0];
    }
}

// Alternative approach using recursion
class SolutionRecursion {
    public int numDistinct(String s, String t) {
        return numDistinctHelper(s, t, 0, 0);
    }
    
    private int numDistinctHelper(String s, String t, int i, int j) {
        if (j == t.length()) {
            return 1;
        }
        
        if (i == s.length()) {
            return 0;
        }
        
        int result = 0;
        
        if (s.charAt(i) == t.charAt(j)) {
            result += numDistinctHelper(s, t, i + 1, j + 1);
        }
        
        result += numDistinctHelper(s, t, i + 1, j);
        
        return result;
    }
}

// More concise version
class SolutionConcise {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 0; i <= m; i++) dp[i][0] = 1;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = s.charAt(i - 1) == t.charAt(j - 1) 
                    ? dp[i - 1][j - 1] + dp[i - 1][j] 
                    : dp[i - 1][j];
            }
        }
        
        return dp[m][n];
    }
}
