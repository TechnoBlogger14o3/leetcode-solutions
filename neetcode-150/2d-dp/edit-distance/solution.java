/**
 * Time Complexity: O(m * n) - Fill DP table
 * Space Complexity: O(m * n) - DP table
 */
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        // Initialize base cases
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        
        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                }
            }
        }
        
        return dp[m][n];
    }
}

// Alternative approach using space-optimized DP
class SolutionSpaceOptimized {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        // Use shorter string for space optimization
        if (m < n) {
            return minDistance(word2, word1);
        }
        
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];
        
        // Initialize first row
        for (int j = 0; j <= n; j++) {
            prev[j] = j;
        }
        
        for (int i = 1; i <= m; i++) {
            curr[0] = i;
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                } else {
                    curr[j] = 1 + Math.min(Math.min(prev[j], curr[j - 1]), prev[j - 1]);
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
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] memo = new int[m][n];
        
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        return minDistanceHelper(word1, word2, m - 1, n - 1, memo);
    }
    
    private int minDistanceHelper(String word1, String word2, int i, int j, int[][] memo) {
        if (i < 0) return j + 1;
        if (j < 0) return i + 1;
        
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        
        if (word1.charAt(i) == word2.charAt(j)) {
            memo[i][j] = minDistanceHelper(word1, word2, i - 1, j - 1, memo);
        } else {
            int insert = minDistanceHelper(word1, word2, i, j - 1, memo);
            int delete = minDistanceHelper(word1, word2, i - 1, j, memo);
            int replace = minDistanceHelper(word1, word2, i - 1, j - 1, memo);
            memo[i][j] = 1 + Math.min(Math.min(insert, delete), replace);
        }
        
        return memo[i][j];
    }
}

// Alternative approach using iterative
class SolutionIterative {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                }
            }
        }
        
        return dp[m][n];
    }
}

// Alternative approach using bottom-up DP
class SolutionBottomUp {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i == m) {
                    dp[i][j] = n - j;
                } else if (j == n) {
                    dp[i][j] = m - i;
                } else if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]), dp[i + 1][j + 1]);
                }
            }
        }
        
        return dp[0][0];
    }
}

// Alternative approach using recursion
class SolutionRecursion {
    public int minDistance(String word1, String word2) {
        return minDistanceHelper(word1, word2, word1.length() - 1, word2.length() - 1);
    }
    
    private int minDistanceHelper(String word1, String word2, int i, int j) {
        if (i < 0) return j + 1;
        if (j < 0) return i + 1;
        
        if (word1.charAt(i) == word2.charAt(j)) {
            return minDistanceHelper(word1, word2, i - 1, j - 1);
        } else {
            int insert = minDistanceHelper(word1, word2, i, j - 1);
            int delete = minDistanceHelper(word1, word2, i - 1, j);
            int replace = minDistanceHelper(word1, word2, i - 1, j - 1);
            return 1 + Math.min(Math.min(insert, delete), replace);
        }
    }
}

// More concise version
class SolutionConcise {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = word1.charAt(i - 1) == word2.charAt(j - 1) 
                    ? dp[i - 1][j - 1] 
                    : 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
            }
        }
        
        return dp[m][n];
    }
}
