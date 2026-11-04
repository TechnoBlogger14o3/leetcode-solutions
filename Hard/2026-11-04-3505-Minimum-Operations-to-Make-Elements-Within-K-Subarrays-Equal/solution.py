from collections import defaultdict
from typing import List

class Solution:
    def minOperations(self, nums: List[int], x: int, k: int) -> int:
        n = len(nums)
        if k * x > n:
            return -1
        
        # Calculate the cost to make each subarray of size x equal
        cost = []
        for i in range(n - x + 1):
            subarray = nums[i:i + x]
            median = sorted(subarray)[x // 2]
            total_cost = sum(abs(num - median) for num in subarray)
            cost.append(total_cost)
        
        # Dynamic programming to find the minimum operations for k non-overlapping subarrays
        dp = [float('inf')] * (len(cost) + 1)
        dp[0] = 0
        
        for i in range(1, len(cost) + 1):
            for j in range(1, k + 1):
                if i >= j * x:
                    dp[i] = min(dp[i], dp[i - x] + cost[i - x])
        
        return dp[len(cost)] if dp[len(cost)] != float('inf') else -1