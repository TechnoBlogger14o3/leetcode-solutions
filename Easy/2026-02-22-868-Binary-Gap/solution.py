class Solution:
    def binaryGap(self, n: int) -> int:
        last_position = -1
        max_gap = 0
        
        for i in range(32):
            if n & (1 << i):
                if last_position != -1:
                    max_gap = max(max_gap, i - last_position)
                last_position = i
        
        return max_gap