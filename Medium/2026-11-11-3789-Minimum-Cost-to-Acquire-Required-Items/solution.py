class Solution:
    def minimumCost(self, cost1: int, cost2: int, costBoth: int, need1: int, need2: int) -> int:
        min_cost = float('inf')
        
        for x in range(max(0, need1 + need2)):
            type3 = x
            type1 = max(0, need1 - type3)
            type2 = max(0, need2 - type3)
            total_cost = type3 * costBoth + type1 * cost1 + type2 * cost2
            min_cost = min(min_cost, total_cost)
        
        return min_cost