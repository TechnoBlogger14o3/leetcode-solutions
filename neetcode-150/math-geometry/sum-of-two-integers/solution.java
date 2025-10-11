/**
 * Time Complexity: O(32) - Constant time
 * Space Complexity: O(1) - No extra space
 */
class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int sum = a ^ b;        // Sum without carry
            int carry = (a & b) << 1; // Carry
            a = sum;
            b = carry;
        }
        return a;
    }
}

// Alternative approach using iterative
class SolutionIterative {
    public int getSum(int a, int b) {
        while (b != 0) {
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }
}

// Alternative approach using recursive
class SolutionRecursive {
    public int getSum(int a, int b) {
        if (b == 0) {
            return a;
        }
        
        return getSum(a ^ b, (a & b) << 1);
    }
}

// Alternative approach using while loop
class SolutionWhileLoop {
    public int getSum(int a, int b) {
        while (b != 0) {
            int sum = a ^ b;
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }
}

// Alternative approach using enhanced for loop
class SolutionEnhancedForLoop {
    public int getSum(int a, int b) {
        for (int i = 0; i < 32; i++) {
            if (b == 0) {
                break;
            }
            int sum = a ^ b;
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }
}

// Alternative approach using bit manipulation with different logic
class SolutionBitManipulation {
    public int getSum(int a, int b) {
        while (b != 0) {
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }
}

// Alternative approach using lookup table
class SolutionLookupTable {
    private static final int[] ADD_TABLE = {
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
    
    public int getSum(int a, int b) {
        int result = 0;
        int carry = 0;
        
        for (int i = 0; i < 32; i++) {
            int bitA = (a >> i) & 1;
            int bitB = (b >> i) & 1;
            int sum = bitA + bitB + carry;
            
            result |= (sum & 1) << i;
            carry = sum >> 1;
        }
        
        return result;
    }
}

// Alternative approach using mathematical properties
class SolutionMathematical {
    public int getSum(int a, int b) {
        while (b != 0) {
            int sum = a ^ b;
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }
}

// More concise version
class SolutionConcise {
    public int getSum(int a, int b) {
        while (b != 0) {
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }
}
