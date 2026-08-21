import heapq

class Solution:
    def kthSmallest(self, coins: List[int], k: int) -> int:
        min_heap = []
        for coin in coins:
            heapq.heappush(min_heap, coin)
        
        current_amount = 0
        for _ in range(k):
            current_amount = heapq.heappop(min_heap)
            for coin in coins:
                new_amount = current_amount + coin
                if new_amount > 2 * 10**9:
                    continue
                heapq.heappush(min_heap, new_amount)
                # To avoid duplicates, we can use a set to track seen amounts
                if new_amount in min_heap:
                    min_heap.remove(new_amount)
        
        return current_amount