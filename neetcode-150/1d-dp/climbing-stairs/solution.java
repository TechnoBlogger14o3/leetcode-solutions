/**
 * Time Complexity: O(n) - Single pass
 * Space Complexity: O(n) - DP array
 */
class Solution {
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }
}

// Alternative approach using space-optimized DP
class SolutionSpaceOptimized {
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        
        int prev2 = 1; // dp[i-2]
        int prev1 = 1; // dp[i-1]
        
        for (int i = 2; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
    }
}

// Alternative approach using recursion with memoization
class SolutionMemoization {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return climbStairsHelper(n, memo);
    }
    
    private int climbStairsHelper(int n, int[] memo) {
        if (n <= 1) {
            return 1;
        }
        
        if (memo[n] != -1) {
            return memo[n];
        }
        
        memo[n] = climbStairsHelper(n - 1, memo) + climbStairsHelper(n - 2, memo);
        return memo[n];
    }
}

// Alternative approach using matrix exponentiation
class SolutionMatrix {
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        
        int[][] matrix = {{1, 1}, {1, 0}};
        int[][] result = matrixPower(matrix, n);
        
        return result[0][0];
    }
    
    private int[][] matrixPower(int[][] matrix, int n) {
        if (n == 1) {
            return matrix;
        }
        
        if (n % 2 == 0) {
            int[][] half = matrixPower(matrix, n / 2);
            return matrixMultiply(half, half);
        } else {
            int[][] half = matrixPower(matrix, n / 2);
            return matrixMultiply(matrixMultiply(half, half), matrix);
        }
    }
    
    private int[][] matrixMultiply(int[][] a, int[][] b) {
        int[][] result = new int[2][2];
        result[0][0] = a[0][0] * b[0][0] + a[0][1] * b[1][0];
        result[0][1] = a[0][0] * b[0][1] + a[0][1] * b[1][1];
        result[1][0] = a[1][0] * b[0][0] + a[1][1] * b[1][0];
        result[1][1] = a[1][0] * b[0][1] + a[1][1] * b[1][1];
        return result;
    }
}

// Alternative approach using mathematical formula
class SolutionMathematical {
    public int climbStairs(int n) {
        double sqrt5 = Math.sqrt(5);
        double phi = (1 + sqrt5) / 2;
        double psi = (1 - sqrt5) / 2;
        
        return (int) Math.round((Math.pow(phi, n + 1) - Math.pow(psi, n + 1)) / sqrt5);
    }
}

// Alternative approach using iterative with variables
class SolutionIterative {
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        
        int a = 1, b = 1, c;
        
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        
        return b;
    }
}

// More concise version
class SolutionConcise {
    public int climbStairs(int n) {
        if (n <= 1) return 1;
        
        int prev2 = 1, prev1 = 1;
        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
