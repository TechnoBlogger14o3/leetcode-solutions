class Solution:
    def countOrders(self, complexity: List[int]) -> int:
        MOD = 10**9 + 7
        n = len(complexity)
        
        # Sort the complexity with their original indices
        indexed_complexity = sorted((c, i) for i, c in enumerate(complexity))
        
        # dp[i] will store the number of valid permutations for the first i computers
        dp = [0] * (n + 1)
        dp[0] = 1  # Base case: 1 way to unlock 0 computers
        
        # Count how many computers have the same complexity
        count = [0] * (n + 1)
        
        for i in range(1, n + 1):
            c, idx = indexed_complexity[i - 1]
            count[i] = count[i - 1]
            # Count how many computers have complexity less than the current
            for j in range(i):
                if indexed_complexity[j][0] < c:
                    count[i] += 1
            
            # Calculate the number of valid permutations
            dp[i] = dp[i - 1] * count[i] % MOD
        
        return dp[n]