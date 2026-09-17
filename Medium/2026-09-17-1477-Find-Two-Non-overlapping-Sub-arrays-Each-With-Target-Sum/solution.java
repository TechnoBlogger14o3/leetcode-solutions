import java.util.HashMap;

public class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] dp = new int[n];
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        int minLength = Integer.MAX_VALUE;

        // Calculate the lengths of subarrays that sum to target
        for (int i = 0, sum = 0; i < n; i++) {
            sum += arr[i];
            if (sum == target) {
                dp[i] = i + 1; // length of subarray from 0 to i
            } else if (sum > target) {
                while (sum > target) {
                    sum -= arr[i - (dp[i - 1] - 1)];
                }
                if (sum == target) {
                    dp[i] = i + 1 - (i - (dp[i - 1] - 1)); // length of subarray
                }
            }
            if (i > 0) {
                dp[i] = Math.min(dp[i], dp[i - 1]);
            }
            sumMap.put(sum, i);
        }

        // Find two non-overlapping subarrays
        for (int i = 0, sum = 0; i < n; i++) {
            sum += arr[i];
            if (sum == target) {
                if (i + 1 < n && dp[i + 1] > 0) {
                    minLength = Math.min(minLength, (i + 1) + dp[i + 1]);
                }
            } else if (sum > target) {
                while (sum > target) {
                    sum -= arr[i - (dp[i - 1] - 1)];
                }
                if (sum == target) {
                    if (i + 1 < n && dp[i + 1] > 0) {
                        minLength = Math.min(minLength, (i + 1) + dp[i + 1]);
                    }
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}