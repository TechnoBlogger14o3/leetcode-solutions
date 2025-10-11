/**
 * Time Complexity: O(m * n) - Fill DP table
 * Space Complexity: O(m * n) - DP table
 */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[m][n];
    }
}

// Alternative approach using space-optimized DP
class SolutionSpaceOptimized {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        
        // Use shorter string for space optimization
        if (m < n) {
            return longestCommonSubsequence(text2, text1);
        }
        
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    curr[j] = prev[j - 1] + 1;
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
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
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] memo = new int[m][n];
        
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        return lcsHelper(text1, text2, m - 1, n - 1, memo);
    }
    
    private int lcsHelper(String text1, String text2, int i, int j, int[][] memo) {
        if (i < 0 || j < 0) {
            return 0;
        }
        
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        
        if (text1.charAt(i) == text2.charAt(j)) {
            memo[i][j] = lcsHelper(text1, text2, i - 1, j - 1, memo) + 1;
        } else {
            memo[i][j] = Math.max(lcsHelper(text1, text2, i - 1, j, memo),
                                 lcsHelper(text1, text2, i, j - 1, memo));
        }
        
        return memo[i][j];
    }
}

// Alternative approach using iterative
class SolutionIterative {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[m][n];
    }
}

// Alternative approach using bottom-up DP
class SolutionBottomUp {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        
        return dp[0][0];
    }
}

// Alternative approach using recursion
class SolutionRecursion {
    public int longestCommonSubsequence(String text1, String text2) {
        return lcsHelper(text1, text2, text1.length() - 1, text2.length() - 1);
    }
    
    private int lcsHelper(String text1, String text2, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        
        if (text1.charAt(i) == text2.charAt(j)) {
            return lcsHelper(text1, text2, i - 1, j - 1) + 1;
        } else {
            return Math.max(lcsHelper(text1, text2, i - 1, j),
                          lcsHelper(text1, text2, i, j - 1));
        }
    }
}

// More concise version
class SolutionConcise {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = text1.charAt(i - 1) == text2.charAt(j - 1) 
                    ? dp[i - 1][j - 1] + 1 
                    : Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        
        return dp[m][n];
    }
}
