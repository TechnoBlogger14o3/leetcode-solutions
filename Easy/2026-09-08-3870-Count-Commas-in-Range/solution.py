class Solution:
    def countCommas(self, n: int) -> int:
        if n < 1000:
            return 0
        
        count = 0
        for i in range(1, n + 1):
            if i >= 1000:
                count += (len(str(i)) - 1) // 3
        
        return count