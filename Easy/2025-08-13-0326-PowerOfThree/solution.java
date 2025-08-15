class Solution {
    public boolean isPowerOfThree(int n) {
        // Handle edge cases
        if (n <= 0) return false;
        if (n == 1) return true;
        
        // Keep dividing by 3 until we can't
        while (n % 3 == 0) {
            n /= 3;
        }
        
        // If we end up with 1, it's a power of 3
        return n == 1;
    }
}

// Alternative approach using mathematical properties
class Solution2 {
    public boolean isPowerOfThree(int n) {
        // The largest power of 3 that fits in int is 3^19 = 1162261467
        // So if n is a power of 3, it must divide this number
        return n > 0 && 1162261467 % n == 0;
    }
}


