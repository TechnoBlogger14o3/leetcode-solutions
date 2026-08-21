import java.util.PriorityQueue;

public class Solution {
    public int kthSmallest(int[] coins, int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for (int coin : coins) {
            minHeap.offer((long) coin);
        }
        
        long amount = 0;
        for (int i = 0; i < k; i++) {
            amount = minHeap.poll();
            for (int coin : coins) {
                long newAmount = amount + coin;
                if (newAmount > 0 && newAmount <= 2_000_000_000) {
                    minHeap.offer(newAmount);
                }
            }
        }
        
        return (int) amount;
    }
}