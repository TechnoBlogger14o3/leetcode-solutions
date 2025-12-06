class Solution:
    def countPartitions(self, nums: List[int], k: int) -> int:
        MOD = 10**9 + 7
        n = len(nums)
        dp = [0] * (n + 1)
        dp[0] = 1
        
        for i in range(1, n + 1):
            min_val = max_val = nums[i - 1]
            for j in range(i - 1, -1, -1):
                if j < i - 1:
                    min_val = min(min_val, nums[j])
                    max_val = max(max_val, nums[j])
                if max_val - min_val > k:
                    break
                dp[i] = (dp[i] + dp[j]) % MOD
        
        return dp[n] - 1  # Subtract the empty partition