/**
 * Time Complexity: O(n) - Single pass
 * Space Complexity: O(1) - Excluding output array
 */
class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        
        return ans;
    }
}

// Alternative approach using bit manipulation
class SolutionBitManipulation {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        
        for (int i = 0; i <= n; i++) {
            int count = 0;
            int num = i;
            
            while (num != 0) {
                num = num & (num - 1);
                count++;
            }
            
            ans[i] = count;
        }
        
        return ans;
    }
}

// Alternative approach using built-in function
class SolutionBuiltIn {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        
        for (int i = 0; i <= n; i++) {
            ans[i] = Integer.bitCount(i);
        }
        
        return ans;
    }
}

// Alternative approach using iterative
class SolutionIterative {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        
        return ans;
    }
}

// Alternative approach using while loop
class SolutionWhileLoop {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        
        int i = 1;
        while (i <= n) {
            ans[i] = ans[i >> 1] + (i & 1);
            i++;
        }
        
        return ans;
    }
}

// Alternative approach using enhanced for loop
class SolutionEnhancedForLoop {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        
        return ans;
    }
}

// Alternative approach using recursive
class SolutionRecursive {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        
        countBitsHelper(n, ans);
        
        return ans;
    }
    
    private void countBitsHelper(int n, int[] ans) {
        if (n == 0) {
            return;
        }
        
        countBitsHelper(n - 1, ans);
        ans[n] = ans[n >> 1] + (n & 1);
    }
}

// Alternative approach using power of 2
class SolutionPowerOfTwo {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 0;
        
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                ans[i] = 1;
            } else {
                ans[i] = ans[i - (1 << (int)(Math.log(i) / Math.log(2)))] + 1;
            }
        }
        
        return ans;
    }
}

// More concise version
class SolutionConcise {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }
}
