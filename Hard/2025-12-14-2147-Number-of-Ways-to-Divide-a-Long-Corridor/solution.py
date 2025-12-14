class Solution:
    def numberOfWays(self, corridor: str) -> int:
        MOD = 10**9 + 7
        seats = corridor.count('S')
        
        if seats % 2 != 0 or seats == 0:
            return 0
        
        sections = seats // 2
        plants = corridor.split('S')
        
        ways = 1
        for i in range(1, sections):
            ways *= len(plants[i])
            ways %= MOD
        
        return ways