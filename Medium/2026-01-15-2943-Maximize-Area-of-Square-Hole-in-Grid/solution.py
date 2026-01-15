class Solution:
    def maxArea(self, n: int, m: int, hBars: List[int], vBars: List[int]) -> int:
        hBars.sort()
        vBars.sort()
        
        max_h = max(hBars[0] - 1, n + 2 - hBars[-1])
        for i in range(1, len(hBars)):
            max_h = max(max_h, hBars[i] - hBars[i - 1] - 1)
        
        max_v = max(vBars[0] - 1, m + 2 - vBars[-1])
        for i in range(1, len(vBars)):
            max_v = max(max_v, vBars[i] - vBars[i - 1] - 1)
        
        return min(max_h, max_v) ** 2