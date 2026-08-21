class Solution {
    kthSmallest(coins, k) {
        const minHeap = new MinPriorityQueue();
        const visited = new Set();
        
        for (const coin of coins) {
            minHeap.enqueue(coin);
            visited.add(coin);
        }
        
        let currentAmount = 0;
        
        for (let i = 0; i < k; i++) {
            currentAmount = minHeap.dequeue().element;
            for (const coin of coins) {
                const newAmount = currentAmount + coin;
                if (!visited.has(newAmount)) {
                    visited.add(newAmount);
                    minHeap.enqueue(newAmount);
                }
            }
        }
        
        return currentAmount;
    }
}