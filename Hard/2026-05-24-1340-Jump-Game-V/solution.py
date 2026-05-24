class Solution:
    def maxJumps(self, arr: List[int], d: int) -> int:
        n = len(arr)
        dp = [1] * n
        
        for i in range(n):
            for j in range(1, d + 1):
                if i + j < n and arr[i] > arr[i + j]:
                    if all(arr[i] > arr[k] for k in range(i + 1, i + j)):
                        dp[i + j] = max(dp[i + j], dp[i] + 1)
                if i - j >= 0 and arr[i] > arr[i - j]:
                    if all(arr[i] > arr[k] for k in range(i - j + 1, i)):
                        dp[i - j] = max(dp[i - j], dp[i] + 1)

        return max(dp)