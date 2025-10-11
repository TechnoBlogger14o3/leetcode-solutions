class Solution:
    def maxDamage(self, power: List[int]) -> int:
        from collections import Counter
        
        count = Counter(power)
        dp = {}
        
        for spell in sorted(count.keys()):
            dp[spell] = count[spell] * spell
            if spell - 1 in dp:
                dp[spell] = max(dp[spell], dp[spell - 1])
            if spell - 2 in dp:
                dp[spell] = max(dp[spell], dp[spell - 2] + count[spell] * spell)
        
        return max(dp.values())