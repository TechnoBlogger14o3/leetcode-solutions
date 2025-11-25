class Solution {
    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }
        
        int length = 1;
        int remainder = 1 % k;
        
        while (remainder != 0) {
            remainder = (remainder * 10 + 1) % k;
            length++;
        }
        
        return length;
    }
}