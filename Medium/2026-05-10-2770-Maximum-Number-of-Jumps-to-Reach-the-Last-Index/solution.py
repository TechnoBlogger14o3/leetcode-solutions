from collections import deque

class Solution:
    def maxJumps(self, nums: List[int], target: int) -> int:
        n = len(nums)
        if n == 1:
            return 0
        
        dp = [-1] * n
        dp[0] = 0
        queue = deque([0])
        
        while queue:
            i = queue.popleft()
            for j in range(i + 1, n):
                if nums[j] - nums[i] > target:
                    break
                if dp[j] < dp[i] + 1:
                    dp[j] = dp[i] + 1
                    queue.append(j)
        
        return dp[-1] if dp[-1] != -1 else -1