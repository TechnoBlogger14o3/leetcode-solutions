class Solution:
    def maximumProfit(self, n: int, present: List[int], future: List[int], hierarchy: List[List[int]], budget: int) -> int:
        from collections import defaultdict
        import heapq
        
        graph = defaultdict(list)
        for u, v in hierarchy:
            graph[u].append(v)
        
        profits = []
        costs = []
        
        def dfs(employee):
            nonlocal profits, costs
            buy_cost = present[employee - 1]
            sell_price = future[employee - 1]
            profit = sell_price - buy_cost
            
            profits.append(profit)
            costs.append(buy_cost)
            
            for subordinate in graph[employee]:
                discounted_cost = present[subordinate - 1] // 2
                discounted_profit = future[subordinate - 1] - discounted_cost
                
                profits.append(discounted_profit)
                costs.append(discounted_cost)
                
                dfs(subordinate)
        
        dfs(1)
        
        max_profit = 0
        dp = [0] * (budget + 1)
        
        for cost, profit in zip(costs, profits):
            for b in range(budget, cost - 1, -1):
                dp[b] = max(dp[b], dp[b - cost] + profit)
        
        return max(dp)