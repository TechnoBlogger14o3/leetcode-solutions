/**
 * Time Complexity: O(n) - Single pass
 * Space Complexity: O(n) - DP array
 */
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            // Single digit
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            
            // Double digit
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[n];
    }
}

// Alternative approach using space-optimized DP
class SolutionSpaceOptimized {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        
        int n = s.length();
        int prev2 = 1; // dp[i-2]
        int prev1 = 1; // dp[i-1]
        
        for (int i = 2; i <= n; i++) {
            int current = 0;
            
            // Single digit
            if (s.charAt(i - 1) != '0') {
                current += prev1;
            }
            
            // Double digit
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                current += prev2;
            }
            
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
    }
}

// Alternative approach using recursion with memoization
class SolutionMemoization {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return numDecodingsHelper(s, 0, memo);
    }
    
    private int numDecodingsHelper(String s, int index, int[] memo) {
        if (index == s.length()) {
            return 1;
        }
        
        if (s.charAt(index) == '0') {
            return 0;
        }
        
        if (memo[index] != -1) {
            return memo[index];
        }
        
        int result = numDecodingsHelper(s, index + 1, memo);
        
        if (index + 1 < s.length()) {
            int twoDigit = Integer.parseInt(s.substring(index, index + 2));
            if (twoDigit >= 10 && twoDigit <= 26) {
                result += numDecodingsHelper(s, index + 2, memo);
            }
        }
        
        memo[index] = result;
        return result;
    }
}

// Alternative approach using iterative
class SolutionIterative {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        
        for (int i = 1; i <= n; i++) {
            // Single digit
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            
            // Double digit
            if (i > 1) {
                int twoDigit = Integer.parseInt(s.substring(i - 2, i));
                if (twoDigit >= 10 && twoDigit <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        
        return dp[n];
    }
}

// Alternative approach using two variables
class SolutionTwoVariables {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        
        int n = s.length();
        int prev2 = 1; // dp[i-2]
        int prev1 = 1; // dp[i-1]
        
        for (int i = 1; i < n; i++) {
            int current = 0;
            
            // Single digit
            if (s.charAt(i) != '0') {
                current += prev1;
            }
            
            // Double digit
            int twoDigit = Integer.parseInt(s.substring(i - 1, i + 1));
            if (twoDigit >= 10 && twoDigit <= 26) {
                current += prev2;
            }
            
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
    }
}

// Alternative approach using bottom-up DP
class SolutionBottomUp {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;
        
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i + 1];
                
                if (i + 1 < n) {
                    int twoDigit = Integer.parseInt(s.substring(i, i + 2));
                    if (twoDigit >= 10 && twoDigit <= 26) {
                        dp[i] += dp[i + 2];
                    }
                }
            }
        }
        
        return dp[0];
    }
}

// More concise version
class SolutionConcise {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        
        int n = s.length();
        int prev2 = 1, prev1 = 1;
        
        for (int i = 2; i <= n; i++) {
            int curr = 0;
            if (s.charAt(i - 1) != '0') curr += prev1;
            
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) curr += prev2;
            
            prev2 = prev1;
            prev1 = curr;
        }
        
        return prev1;
    }
}
