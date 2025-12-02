class Solution:
    def countTrapezoids(self, points: List[List[int]]) -> int:
        from collections import defaultdict
        MOD = 10**9 + 7
        
        y_map = defaultdict(list)
        
        for x, y in points:
            y_map[y].append(x)
        
        count = 0
        
        y_keys = sorted(y_map.keys())
        
        for i in range(len(y_keys)):
            for j in range(i + 1, len(y_keys)):
                y1 = y_keys[i]
                y2 = y_keys[j]
                
                x1 = y_map[y1]
                x2 = y_map[y2]
                
                common_x = set(x1) & set(x2)
                
                if len(common_x) >= 2:
                    k = len(common_x)
                    count = (count + (k * (k - 1) // 2)) % MOD
        
        return count