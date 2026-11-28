import java.util.*;

public class Solution {
    public int maxItems(int[][] items, int budget) {
        Arrays.sort(items, Comparator.comparingInt(a -> a[1]));
        int n = items.length;
        int[] freeItems = new int[n];
        int totalItems = 0;

        for (int i = 0; i < n; i++) {
            int factor = items[i][0];
            int price = items[i][1];
            int count = budget / price;
            totalItems += count;
            budget -= count * price;

            for (int j = 0; j < n; j++) {
                if (i != j && factor != 0 && items[j][0] % factor == 0) {
                    freeItems[j] = Math.max(freeItems[j], count);
                }
            }
        }

        for (int free : freeItems) {
            totalItems += free;
        }

        return totalItems;
    }
}