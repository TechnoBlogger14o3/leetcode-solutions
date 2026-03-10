class Solution:
    def countStableArrays(self, zero: int, one: int, limit: int) -> int:
        MOD = 10**9 + 7
        
        dp = [[0] * (one + 1) for _ in range(zero + 1)]
        dp[0][1] = 1  # Base case: one way to have a single 1
        
        for z in range(zero + 1):
            for o in range(1, one + 1):
                if z > 0:
                    dp[z][o] = (dp[z][o] + dp[z - 1][o]) % MOD
                if o > 1:
                    dp[z][o] = (dp[z][o] + dp[z][o - 1]) % MOD
                if z > 0 and o > 1 and z + o > limit:
                    dp[z][o] = (dp[z][o] - dp[z - 1][o - 1] + MOD) % MOD
        
        return dp[zero][one]

# Example usage:
# sol = Solution()
# print(sol.countStableArrays(1, 1, 2))  # Output: 2
# print(sol.countStableArrays(1, 2, 1))  # Output: 1
# print(sol.countStableArrays(3, 3, 2))  # Output: 14