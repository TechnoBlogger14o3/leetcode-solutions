class Solution:
    def countWays(self, points: List[List[int]]) -> int:
        points.sort()
        n = len(points)
        count = 0
        
        for i in range(n):
            for j in range(i + 1, n):
                if points[i][0] < points[j][0] and points[i][1] > points[j][1]:
                    count += 1
        
        return count