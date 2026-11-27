import java.util.*;

class Solution {
    public int maxItems(int[][] items, int budget) {
        int n = items.length;
        int[] dp = new int[budget + 1];
        Map<Integer, Set<Integer>> freeItemsMap = new HashMap<>();

        // Build the free items map
        for (int i = 0; i < n; i++) {
            int factorI = items[i][0];
            for (int j = 0; j < n; j++) {
                if (i != j && factorJ % factorI == 0) {
                    freeItemsMap.computeIfAbsent(i, k -> new HashSet<>()).add(j);
                }
            }
        }

        // Dynamic programming to calculate maximum items
        for (int i = 0; i < n; i++) {
            int priceI = items[i][1];
            for (int b = priceI; b <= budget; b++) {
                dp[b] = Math.max(dp[b], dp[b - priceI] + 1);
            }
        }

        int maxItems = 0;
        for (int b = 0; b <= budget; b++) {
            maxItems = Math.max(maxItems, dp[b]);
        }

        // Calculate free items
        int totalItems = maxItems;
        for (int i = 0; i < n; i++) {
            if (dp[budget] > 0) {
                totalItems += freeItemsMap.getOrDefault(i, Collections.emptySet()).size();
            }
        }

        return totalItems;
    }
}