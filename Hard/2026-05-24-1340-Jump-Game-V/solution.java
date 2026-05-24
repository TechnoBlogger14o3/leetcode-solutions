import java.util.Arrays;

public class Solution {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= Math.min(i + d, n - 1); j++) {
                if (arr[j] < arr[i] && isValidJump(arr, i, j)) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
            for (int j = i - 1; j >= Math.max(i - d, 0); j--) {
                if (arr[j] < arr[i] && isValidJump(arr, i, j)) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }
        
        return Arrays.stream(dp).max().getAsInt();
    }
    
    private boolean isValidJump(int[] arr, int i, int j) {
        if (i < j) {
            for (int k = i + 1; k < j; k++) {
                if (arr[k] >= arr[i]) {
                    return false;
                }
            }
        } else {
            for (int k = j + 1; k < i; k++) {
                if (arr[k] >= arr[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}