class Solution {
    public char findKthBit(int n, int k) {
        int length = (1 << n) - 1; // Length of S_n is 2^n - 1
        return findKthBitHelper(n, k);
    }

    private char findKthBitHelper(int n, int k) {
        if (n == 1) {
            return '0';
        }
        
        int mid = (1 << (n - 1)); // Midpoint of S_n
        
        if (k == mid) {
            return '1'; // The middle bit is always '1'
        } else if (k < mid) {
            return findKthBitHelper(n - 1, k); // In the first half
        } else {
            // In the second half, we need to find the corresponding bit in the inverted and reversed part
            char bit = findKthBitHelper(n - 1, length(n) - k + 1);
            return bit == '0' ? '1' : '0'; // Invert the bit
        }
    }

    private int length(int n) {
        return (1 << n) - 1; // Length of S_n
    }
}