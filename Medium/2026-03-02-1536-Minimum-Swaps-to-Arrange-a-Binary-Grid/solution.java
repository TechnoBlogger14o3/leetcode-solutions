class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] zerosCount = new int[n];
        
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    count++;
                } else {
                    break;
                }
            }
            zerosCount[i] = count;
        }

        int swaps = 0;
        for (int i = 0; i < n; i++) {
            int requiredZeros = n - 1 - i;
            int j = i;
            while (j < n && zerosCount[j] < requiredZeros) {
                j++;
            }
            if (j == n) {
                return -1;
            }
            for (int k = j; k > i; k--) {
                int temp = zerosCount[k];
                zerosCount[k] = zerosCount[k - 1];
                zerosCount[k - 1] = temp;
                swaps++;
            }
        }
        return swaps;
    }
}