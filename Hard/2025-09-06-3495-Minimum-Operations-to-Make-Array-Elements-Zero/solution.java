import java.util.*;

public class Solution {
    public long minOperations(int[][] queries) {
        long totalOperations = 0;
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            totalOperations += calculateOperations(l, r);
        }
        return totalOperations;
    }

    private long calculateOperations(int l, int r) {
        long operations = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = l; i <= r; i++) {
            queue.offer(i);
        }
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            operations++;
            for (int i = 0; i < size; i++) {
                int num = queue.poll();
                if (num > 0) {
                    queue.offer(num / 4);
                }
            }
        }
        return operations - 1; // Subtract the last operation when all are zero
    }
}