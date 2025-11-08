class Solution {
    public int minimumOneBitOperations(int n) {
        int operations = 0;
        while (n > 0) {
            operations += n;
            n = n >> 1;
        }
        return operations;
    }
}