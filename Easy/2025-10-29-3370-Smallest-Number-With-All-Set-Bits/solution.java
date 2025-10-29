class Solution {
    public int smallestGoodBase(int n) {
        for (int m = 60; m >= 1; m--) {
            long k = (long) Math.pow(2, m) - 1;
            if (k >= n) {
                long base = (long) Math.pow(n, 1.0 / m);
                while (true) {
                    long sum = 0, current = 1;
                    for (int i = 0; i <= m; i++) {
                        sum += current;
                        current *= base;
                    }
                    if (sum >= n) {
                        return (int) sum;
                    }
                    base++;
                }
            }
        }
        return n;
    }
}