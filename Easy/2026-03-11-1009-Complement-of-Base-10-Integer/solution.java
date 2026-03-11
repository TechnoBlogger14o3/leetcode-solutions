class Solution {
    public int findComplement(int n) {
        int mask = Integer.highestOneBit(n) - 1;
        return n ^ mask;
    }
}