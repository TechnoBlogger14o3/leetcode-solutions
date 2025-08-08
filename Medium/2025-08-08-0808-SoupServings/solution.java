class Solution {
    private Double[][] memo;
    
    public double soupServings(int n) {
        // For large n, probability approaches 1.0
        if (n >= 5000) return 1.0;
        
        // Convert to units of 25ml for efficiency
        int units = (n + 24) / 25; // Ceiling division
        memo = new Double[units + 1][units + 1];
        
        return solve(units, units);
    }
    
    private double solve(int a, int b) {
        // Base cases
        if (a <= 0 && b <= 0) return 0.5; // Both empty
        if (a <= 0) return 1.0; // A empty first
        if (b <= 0) return 0.0; // B empty first
        
        // Check memoization
        if (memo[a][b] != null) return memo[a][b];
        
        // Four operations with equal probability
        double result = 0.25 * (
            solve(a - 4, b) +      // Serve 100ml A, 0ml B
            solve(a - 3, b - 1) +  // Serve 75ml A, 25ml B
            solve(a - 2, b - 2) +  // Serve 50ml A, 50ml B
            solve(a - 1, b - 3)    // Serve 25ml A, 75ml B
        );
        
        memo[a][b] = result;
        return result;
    }
}