class Solution:
    def minCost(self, nums: List[int]) -> int:
        n = len(nums)
        if n < 3:
            return 0
        
        # Prefix minimums to store the minimum costs for the first i elements
        prefix_min = [0] * n
        prefix_min[0] = nums[0]
        for i in range(1, n):
            prefix_min[i] = min(prefix_min[i - 1], nums[i])
        
        # Suffix minimums to store the minimum costs for the last n-i elements
        suffix_min = [0] * n
        suffix_min[n - 1] = nums[n - 1]
        for i in range(n - 2, -1, -1):
            suffix_min[i] = min(suffix_min[i + 1], nums[i])
        
        min_cost = float('inf')
        
        # Iterate to find the minimum cost by splitting into three parts
        for j in range(1, n - 1):
            for k in range(j + 1, n):
                cost = prefix_min[j - 1] + suffix_min[k]
                min_cost = min(min_cost, cost)
        
        return min_cost