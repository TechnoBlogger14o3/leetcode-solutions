/**
 * Time Complexity: O(m * n) - Fill DP table
 * Space Complexity: O(m * n) - DP table
 */
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // Base case: empty string matches empty pattern
        dp[0][0] = true;
        
        // Handle patterns like a*, a*b*, a*b*c*
        for (int j = 2; j <= n; j += 2) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        
        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    // Case 1: '*' matches zero characters
                    dp[i][j] = dp[i][j - 2];
                    
                    // Case 2: '*' matches one or more characters
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    // Case 3: characters match or pattern is '.'
                    if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        
        return dp[m][n];
    }
}

// Alternative approach using space-optimized DP
class SolutionSpaceOptimized {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        // Use shorter string for space optimization
        if (m < n) {
            return isMatch(p, s);
        }
        
        boolean[] prev = new boolean[n + 1];
        boolean[] curr = new boolean[n + 1];
        
        // Initialize first row
        prev[0] = true;
        for (int j = 2; j <= n; j += 2) {
            if (p.charAt(j - 1) == '*') {
                prev[j] = prev[j - 2];
            }
        }
        
        for (int i = 1; i <= m; i++) {
            curr[0] = false;
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    curr[j] = curr[j - 2];
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        curr[j] = curr[j] || prev[j];
                    }
                } else {
                    curr[j] = (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') && prev[j - 1];
                }
            }
            boolean[] temp = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev[n];
    }
}

// Alternative approach using recursion with memoization
class SolutionMemoization {
    public boolean isMatch(String s, String p) {
        Boolean[][] memo = new Boolean[s.length() + 1][p.length() + 1];
        return isMatchHelper(s, p, 0, 0, memo);
    }
    
    private boolean isMatchHelper(String s, String p, int i, int j, Boolean[][] memo) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        
        if (j == p.length()) {
            return i == s.length();
        }
        
        boolean firstMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            memo[i][j] = isMatchHelper(s, p, i, j + 2, memo) || 
                        (firstMatch && isMatchHelper(s, p, i + 1, j, memo));
        } else {
            memo[i][j] = firstMatch && isMatchHelper(s, p, i + 1, j + 1, memo);
        }
        
        return memo[i][j];
    }
}

// Alternative approach using iterative
class SolutionIterative {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        dp[0][0] = true;
        
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (i > 0 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    dp[i][j] = i > 0 && dp[i - 1][j - 1] && 
                               (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
                }
            }
        }
        
        return dp[m][n];
    }
}

// Alternative approach using recursion
class SolutionRecursion {
    public boolean isMatch(String s, String p) {
        return isMatchHelper(s, p, 0, 0);
    }
    
    private boolean isMatchHelper(String s, String p, int i, int j) {
        if (j == p.length()) {
            return i == s.length();
        }
        
        boolean firstMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            return isMatchHelper(s, p, i, j + 2) || 
                   (firstMatch && isMatchHelper(s, p, i + 1, j));
        } else {
            return firstMatch && isMatchHelper(s, p, i + 1, j + 1);
        }
    }
}

// More concise version
class SolutionConcise {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        dp[0][0] = true;
        for (int j = 2; j <= n; j += 2) {
            if (p.charAt(j - 1) == '*') dp[0][j] = dp[0][j - 2];
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    dp[i][j] = (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') && dp[i - 1][j - 1];
                }
            }
        }
        
        return dp[m][n];
    }
}
