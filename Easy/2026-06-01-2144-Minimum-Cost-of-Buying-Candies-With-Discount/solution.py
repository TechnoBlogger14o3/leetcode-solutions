class Solution:
    def minimumCost(self, cost: List[int]) -> int:
        cost.sort(reverse=True)
        total_cost = 0
        
        for i in range(0, len(cost), 3):
            total_cost += cost[i]  # Buy the most expensive candy
            if i + 1 < len(cost):
                total_cost += cost[i + 1]  # Buy the second most expensive candy
            # The third candy is free, so we do not add its cost
        
        return total_cost