class Solution:
    def maxSquareArea(self, m: int, n: int, hFences: List[int], vFences: List[int]) -> int:
        MOD = 10**9 + 7
        
        hFences.sort()
        vFences.sort()
        
        max_h = max(hFences[0] - 1, m - hFences[-1])
        max_v = max(vFences[0] - 1, n - vFences[-1])
        
        for i in range(1, len(hFences)):
            max_h = max(max_h, hFences[i] - hFences[i - 1] - 1)
        
        for i in range(1, len(vFences)):
            max_v = max(max_v, vFences[i] - vFences[i - 1] - 1)
        
        side_length = min(max_h, max_v)
        
        if side_length <= 0:
            return -1
        
        return (side_length * side_length) % MOD