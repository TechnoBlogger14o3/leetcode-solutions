class Solution:
    def getDescentPeriods(self, prices: List[int]) -> int:
        total_periods = len(prices)
        current_period = 0
        
        for i in range(1, len(prices)):
            if prices[i] == prices[i - 1] - 1:
                current_period += 1
            else:
                current_period = 0
            total_periods += current_period
        
        return total_periods