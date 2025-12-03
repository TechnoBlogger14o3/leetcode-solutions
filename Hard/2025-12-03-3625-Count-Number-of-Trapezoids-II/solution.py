from collections import defaultdict
from itertools import combinations

class Solution:
    def countTrapezoids(self, points: List[List[int]]) -> int:
        slopes = defaultdict(set)
        n = len(points)
        
        for i in range(n):
            for j in range(i + 1, n):
                if points[i][0] != points[j][0]:  # Avoid vertical lines
                    slope = (points[j][1] - points[i][1], points[j][0] - points[i][0])
                    gcd = self.gcd(slope[0], slope[1])
                    slope = (slope[0] // gcd, slope[1] // gcd)
                    slopes[slope].add((i, j))
        
        trapezoid_count = 0
        
        for pairs in slopes.values():
            m = len(pairs)
            if m >= 2:
                trapezoid_count += m * (m - 1) // 2
        
        return trapezoid_count

    def gcd(self, a: int, b: int) -> int:
        while b:
            a, b = b, a % b
        return abs(a)