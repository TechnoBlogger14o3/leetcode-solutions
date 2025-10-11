/**
 * Time Complexity: O(n) - Single pass
 * Space Complexity: O(1) - Two variables
 */
class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0;
        int maxOpen = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else { // c == '*'
                minOpen--;
                maxOpen++;
            }
            
            if (maxOpen < 0) {
                return false;
            }
            
            if (minOpen < 0) {
                minOpen = 0;
            }
        }
        
        return minOpen == 0;
    }
}

// Alternative approach using Dynamic Programming
class SolutionDP {
    public boolean checkValidString(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n + 1][n + 1];
        dp[0][0] = true;
        
        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i - 1);
            
            for (int j = 0; j <= n; j++) {
                if (c == '(') {
                    if (j > 0) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else if (c == ')') {
                    if (j < n) {
                        dp[i][j] = dp[i - 1][j + 1];
                    }
                } else { // c == '*'
                    dp[i][j] = dp[i - 1][j];
                    if (j > 0) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j - 1];
                    }
                    if (j < n) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j + 1];
                    }
                }
            }
        }
        
        return dp[n][0];
    }
}

// Alternative approach using backtracking
class SolutionBacktracking {
    public boolean checkValidString(String s) {
        return checkValidStringHelper(s, 0, 0);
    }
    
    private boolean checkValidStringHelper(String s, int index, int openCount) {
        if (index == s.length()) {
            return openCount == 0;
        }
        
        char c = s.charAt(index);
        
        if (c == '(') {
            return checkValidStringHelper(s, index + 1, openCount + 1);
        } else if (c == ')') {
            if (openCount <= 0) {
                return false;
            }
            return checkValidStringHelper(s, index + 1, openCount - 1);
        } else { // c == '*'
            // Try all three possibilities: '(', ')', or empty
            return checkValidStringHelper(s, index + 1, openCount + 1) ||
                   checkValidStringHelper(s, index + 1, openCount - 1) ||
                   checkValidStringHelper(s, index + 1, openCount);
        }
    }
}

// Alternative approach using iterative
class SolutionIterative {
    public boolean checkValidString(String s) {
        int minOpen = 0;
        int maxOpen = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else { // c == '*'
                minOpen--;
                maxOpen++;
            }
            
            if (maxOpen < 0) {
                return false;
            }
            
            if (minOpen < 0) {
                minOpen = 0;
            }
        }
        
        return minOpen == 0;
    }
}

// Alternative approach using while loop
class SolutionWhileLoop {
    public boolean checkValidString(String s) {
        int minOpen = 0;
        int maxOpen = 0;
        int i = 0;
        
        while (i < s.length()) {
            char c = s.charAt(i);
            
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else { // c == '*'
                minOpen--;
                maxOpen++;
            }
            
            if (maxOpen < 0) {
                return false;
            }
            
            if (minOpen < 0) {
                minOpen = 0;
            }
            
            i++;
        }
        
        return minOpen == 0;
    }
}

// Alternative approach using enhanced for loop
class SolutionEnhancedForLoop {
    public boolean checkValidString(String s) {
        int minOpen = 0;
        int maxOpen = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else { // c == '*'
                minOpen--;
                maxOpen++;
            }
            
            if (maxOpen < 0) {
                return false;
            }
            
            if (minOpen < 0) {
                minOpen = 0;
            }
        }
        
        return minOpen == 0;
    }
}

// More concise version
class SolutionConcise {
    public boolean checkValidString(String s) {
        int minOpen = 0, maxOpen = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else { // c == '*'
                minOpen--;
                maxOpen++;
            }
            
            if (maxOpen < 0) return false;
            if (minOpen < 0) minOpen = 0;
        }
        
        return minOpen == 0;
    }
}
