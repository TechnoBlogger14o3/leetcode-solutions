class Solution {
    public boolean stoneGameIX(int n) {
        if (n < 10) return false;
        return (n - 10) % 11 != 0;
    }
}