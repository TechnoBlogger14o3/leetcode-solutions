class Solution:
    def stoneGameVIII(self, stones: List[int]) -> int:
        n = len(stones)
        for i in range(1, n):
            stones[i] += stones[i - 1]
        
        max_diff = stones[-1]
        result = max_diff
        
        for i in range(n - 2, 0, -1):
            max_diff = max(max_diff, stones[i])
            result = max(result, max_diff - stones[i])
        
        return result