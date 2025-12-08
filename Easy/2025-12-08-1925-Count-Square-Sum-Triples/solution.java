class Solution {
    public int countTriples(int n) {
        int count = 0;
        for (int a = 1; a <= n; a++) {
            for (int b = a; b <= n; b++) {
                int c2 = a * a + b * b;
                int c = (int) Math.sqrt(c2);
                if (c * c == c2 && c <= n) {
                    count += (a == b) ? 1 : 2; // (a, b, c) and (b, a, c) are different if a != b
                }
            }
        }
        return count;
    }
}