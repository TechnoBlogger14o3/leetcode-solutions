class Solution:
    def maxPower(self, stations: List[int], r: int, k: int) -> int:
        def canAchieve(minPower):
            n = len(stations)
            additional = [0] * n
            current_add = 0
            total_add = 0
            
            for i in range(n):
                if i > r:
                    current_add -= additional[i - r - 1]
                if stations[i] + current_add < minPower:
                    needed = minPower - (stations[i] + current_add)
                    total_add += needed
                    current_add += needed
                    if i + r < n:
                        additional[i + r] += needed
            
            return total_add <= k
        
        left, right = 0, max(stations) + k
        while left < right:
            mid = (left + right + 1) // 2
            if canAchieve(mid):
                left = mid
            else:
                right = mid - 1
        
        return left