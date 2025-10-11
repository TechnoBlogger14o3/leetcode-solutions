/**
 * Time Complexity: O(log n) - Number of digits
 * Space Complexity: O(1) - No extra space
 */
class Solution {
    public int reverse(int x) {
        int result = 0;
        
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            
            // Check for overflow before adding
            if (result > Integer.MAX_VALUE / 10 || 
                (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || 
                (result == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }
            
            result = result * 10 + digit;
        }
        
        return result;
    }
}

// Alternative approach using string conversion
class SolutionStringConversion {
    public int reverse(int x) {
        String str = String.valueOf(x);
        boolean negative = false;
        
        if (str.charAt(0) == '-') {
            negative = true;
            str = str.substring(1);
        }
        
        StringBuilder reversed = new StringBuilder(str).reverse();
        
        try {
            int result = Integer.parseInt(reversed.toString());
            return negative ? -result : result;
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}

// Alternative approach using iterative
class SolutionIterative {
    public int reverse(int x) {
        int result = 0;
        
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            
            // Check for overflow
            if (result > Integer.MAX_VALUE / 10 || 
                (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || 
                (result == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }
            
            result = result * 10 + digit;
        }
        
        return result;
    }
}

// Alternative approach using while loop
class SolutionWhileLoop {
    public int reverse(int x) {
        int result = 0;
        
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            
            // Check for overflow
            if (result > Integer.MAX_VALUE / 10 || 
                (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || 
                (result == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }
            
            result = result * 10 + digit;
        }
        
        return result;
    }
}

// Alternative approach using enhanced for loop
class SolutionEnhancedForLoop {
    public int reverse(int x) {
        int result = 0;
        
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            
            // Check for overflow
            if (result > Integer.MAX_VALUE / 10 || 
                (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || 
                (result == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }
            
            result = result * 10 + digit;
        }
        
        return result;
    }
}

// Alternative approach using recursive
class SolutionRecursive {
    public int reverse(int x) {
        return reverseHelper(x, 0);
    }
    
    private int reverseHelper(int x, int result) {
        if (x == 0) {
            return result;
        }
        
        int digit = x % 10;
        x /= 10;
        
        // Check for overflow
        if (result > Integer.MAX_VALUE / 10 || 
            (result == Integer.MAX_VALUE / 10 && digit > 7)) {
            return 0;
        }
        if (result < Integer.MIN_VALUE / 10 || 
            (result == Integer.MIN_VALUE / 10 && digit < -8)) {
            return 0;
        }
        
        return reverseHelper(x, result * 10 + digit);
    }
}

// Alternative approach using stack
class SolutionStack {
    public int reverse(int x) {
        Stack<Integer> stack = new Stack<>();
        
        while (x != 0) {
            stack.push(x % 10);
            x /= 10;
        }
        
        int result = 0;
        int multiplier = 1;
        
        while (!stack.isEmpty()) {
            int digit = stack.pop();
            
            // Check for overflow
            if (result > Integer.MAX_VALUE / 10 || 
                (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || 
                (result == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }
            
            result = result * 10 + digit;
        }
        
        return result;
    }
}

// Alternative approach using long
class SolutionLong {
    public int reverse(int x) {
        long result = 0;
        
        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        
        return (int) result;
    }
}

// More concise version
class SolutionConcise {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            
            if (result > Integer.MAX_VALUE / 10 || 
                (result == Integer.MAX_VALUE / 10 && digit > 7)) return 0;
            if (result < Integer.MIN_VALUE / 10 || 
                (result == Integer.MIN_VALUE / 10 && digit < -8)) return 0;
            
            result = result * 10 + digit;
        }
        return result;
    }
}
