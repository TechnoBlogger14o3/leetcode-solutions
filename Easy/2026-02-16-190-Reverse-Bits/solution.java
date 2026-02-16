public class Solution {
    // Function to reverse bits of a given 32 bits signed integer
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1; // Shift result to the left
            result |= (n & 1); // Add the last bit of n to result
            n >>= 1; // Shift n to the right
        }
        return result;
    }
}