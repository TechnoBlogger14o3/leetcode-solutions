/**
 * Time Complexity: O(1) - Constant time
 * Space Complexity: O(1) - No extra space
 */
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}

// Alternative approach using mathematical division
class SolutionMathematical {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        
        while (n % 2 == 0) {
            n /= 2;
        }
        
        return n == 1;
    }
}

// Alternative approach using logarithm
class SolutionLogarithm {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        
        return (Math.log(n) / Math.log(2)) % 1 == 0;
    }
}

// Alternative approach using iterative
class SolutionIterative {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        
        while (n > 1) {
            if (n % 2 != 0) {
                return false;
            }
            n /= 2;
        }
        
        return true;
    }
}

// Alternative approach using while loop
class SolutionWhileLoop {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        
        while (n % 2 == 0) {
            n /= 2;
        }
        
        return n == 1;
    }
}

// Alternative approach using enhanced for loop
class SolutionEnhancedForLoop {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        
        while (n > 1) {
            if (n % 2 != 0) {
                return false;
            }
            n /= 2;
        }
        
        return true;
    }
}

// Alternative approach using recursive
class SolutionRecursive {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        
        if (n == 1) {
            return true;
        }
        
        if (n % 2 != 0) {
            return false;
        }
        
        return isPowerOfTwo(n / 2);
    }
}

// Alternative approach using bit counting
class SolutionBitCounting {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        
        return Integer.bitCount(n) == 1;
    }
}

// More concise version
class SolutionConcise {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
