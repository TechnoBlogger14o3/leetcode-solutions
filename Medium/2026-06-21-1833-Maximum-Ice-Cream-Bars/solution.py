class Solution:
    def maxIceCream(self, costs: List[int], coins: int) -> int:
        count = [0] * 100001
        
        for cost in costs:
            count[cost] += 1
        
        total_bars = 0
        for price in range(1, 100001):
            if count[price] == 0:
                continue
            if coins >= price:
                can_buy = min(count[price], coins // price)
                total_bars += can_buy
                coins -= can_buy * price
            else:
                break
        
        return total_bars