class Solution {
    public int mirrorDistance(int n) {
        int reversed = 0;
        int original = n;
        
        while (n > 0) {
            reversed = reversed * 10 + n % 10;
            n /= 10;
        }
        
        return Math.abs(original - reversed);
    }
}