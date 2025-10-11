/**
 * Time Complexity: O(m * n) - Fill DP table
 * Space Complexity: O(m * n) - DP table
 */
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int k = s3.length();
        
        if (m + n != k) {
            return false;
        }
        
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        
        // Initialize first row
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        
        // Initialize first column
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        
        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                          (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        
        return dp[m][n];
    }
}

// Alternative approach using space-optimized DP
class SolutionSpaceOptimized {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int k = s3.length();
        
        if (m + n != k) {
            return false;
        }
        
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        
        // Initialize first row
        for (int j = 1; j <= n; j++) {
            dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        
        // Fill DP table
        for (int i = 1; i <= m; i++) {
            dp[0] = dp[0] && s1.charAt(i - 1) == s3.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                       (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        
        return dp[n];
    }
}

// Alternative approach using recursion with memoization
class SolutionMemoization {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int k = s3.length();
        
        if (m + n != k) {
            return false;
        }
        
        Boolean[][] memo = new Boolean[m + 1][n + 1];
        return isInterleaveHelper(s1, s2, s3, 0, 0, 0, memo);
    }
    
    private boolean isInterleaveHelper(String s1, String s2, String s3, int i, int j, int k, Boolean[][] memo) {
        if (k == s3.length()) {
            return i == s1.length() && j == s2.length();
        }
        
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        
        boolean result = false;
        
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            result = result || isInterleaveHelper(s1, s2, s3, i + 1, j, k + 1, memo);
        }
        
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            result = result || isInterleaveHelper(s1, s2, s3, i, j + 1, k + 1, memo);
        }
        
        memo[i][j] = result;
        return result;
    }
}

// Alternative approach using iterative
class SolutionIterative {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int k = s3.length();
        
        if (m + n != k) {
            return false;
        }
        
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) continue;
                
                if (i > 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j];
                }
                
                if (j > 0 && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i][j] || dp[i][j - 1];
                }
            }
        }
        
        return dp[m][n];
    }
}

// Alternative approach using bottom-up DP
class SolutionBottomUp {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int k = s3.length();
        
        if (m + n != k) {
            return false;
        }
        
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[m][n] = true;
        
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i == m && j == n) continue;
                
                if (i < m && s1.charAt(i) == s3.charAt(i + j)) {
                    dp[i][j] = dp[i][j] || dp[i + 1][j];
                }
                
                if (j < n && s2.charAt(j) == s3.charAt(i + j)) {
                    dp[i][j] = dp[i][j] || dp[i][j + 1];
                }
            }
        }
        
        return dp[0][0];
    }
}

// Alternative approach using recursion
class SolutionRecursion {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int k = s3.length();
        
        if (m + n != k) {
            return false;
        }
        
        return isInterleaveHelper(s1, s2, s3, 0, 0, 0);
    }
    
    private boolean isInterleaveHelper(String s1, String s2, String s3, int i, int j, int k) {
        if (k == s3.length()) {
            return i == s1.length() && j == s2.length();
        }
        
        boolean result = false;
        
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            result = result || isInterleaveHelper(s1, s2, s3, i + 1, j, k + 1);
        }
        
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            result = result || isInterleaveHelper(s1, s2, s3, i, j + 1, k + 1);
        }
        
        return result;
    }
}

// More concise version
class SolutionConcise {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length(), k = s3.length();
        if (m + n != k) return false;
        
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i > 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j];
                }
                if (j > 0 && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i][j] || dp[i][j - 1];
                }
            }
        }
        
        return dp[m][n];
    }
}
