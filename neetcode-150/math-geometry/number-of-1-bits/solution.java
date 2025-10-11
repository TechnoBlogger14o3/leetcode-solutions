/**
 * Time Complexity: O(k) - Where k is number of 1 bits
 * Space Complexity: O(1) - No extra space
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        
        return count;
    }
}

// Alternative approach using bit shifting
class SolutionBitShifting {
    public int hammingWeight(int n) {
        int count = 0;
        
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>>= 1; // Use unsigned right shift
        }
        
        return count;
    }
}

// Alternative approach using built-in function
class SolutionBuiltIn {
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}

// Alternative approach using iterative
class SolutionIterative {
    public int hammingWeight(int n) {
        int count = 0;
        
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>>= 1;
        }
        
        return count;
    }
}

// Alternative approach using while loop
class SolutionWhileLoop {
    public int hammingWeight(int n) {
        int count = 0;
        
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        
        return count;
    }
}

// Alternative approach using enhanced for loop
class SolutionEnhancedForLoop {
    public int hammingWeight(int n) {
        int count = 0;
        
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>>= 1;
        }
        
        return count;
    }
}

// Alternative approach using recursive
class SolutionRecursive {
    public int hammingWeight(int n) {
        if (n == 0) {
            return 0;
        }
        
        return (n & 1) + hammingWeight(n >>> 1);
    }
}

// Alternative approach using lookup table
class SolutionLookupTable {
    private static final int[] BIT_COUNT = {
        0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4,
        1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5,
        1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5,
        2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6,
        1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5,
        2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6,
        2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6,
        3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7,
        1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5,
        2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6,
        2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6,
        3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7,
        2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6,
        3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7,
        3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7,
        4, 5, 5, 6, 5, 6, 6, 7, 5, 6, 6, 7, 6, 7, 7, 8
    };
    
    public int hammingWeight(int n) {
        int count = 0;
        
        for (int i = 0; i < 4; i++) {
            count += BIT_COUNT[n & 0xFF];
            n >>>= 8;
        }
        
        return count;
    }
}

// More concise version
class SolutionConcise {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }
}
