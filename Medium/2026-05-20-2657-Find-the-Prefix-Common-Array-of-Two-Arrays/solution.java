class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] C = new int[n];
        boolean[] seenA = new boolean[n + 1];
        boolean[] seenB = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            seenA[A[i]] = true;
            seenB[B[i]] = true;

            int commonCount = 0;
            for (int j = 1; j <= n; j++) {
                if (seenA[j] && seenB[j]) {
                    commonCount++;
                }
            }
            C[i] = commonCount;
        }
        return C;
    }
}