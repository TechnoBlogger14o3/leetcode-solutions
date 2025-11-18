class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        int i = 0;
        
        while (i < n - 1) {
            if (bits[i] == 1) {
                i += 2; // Skip the next bit as it's part of a two-bit character
            } else {
                i++; // Move to the next bit
            }
        }
        
        return i == n - 1; // Check if we ended on a one-bit character
    }
}