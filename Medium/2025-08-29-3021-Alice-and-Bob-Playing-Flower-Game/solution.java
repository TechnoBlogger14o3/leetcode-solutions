java
class Solution {
    public int countPairs(int n, int m) {
        int count = 0;
        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= m; y++) {
                if ((x + y) % 2 == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}