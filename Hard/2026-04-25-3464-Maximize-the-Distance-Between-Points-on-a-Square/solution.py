from itertools import combinations

class Solution:
    def maxDistance(self, side: int, points: List[List[int]], k: int) -> int:
        def manhattan_distance(p1, p2):
            return abs(p1[0] - p2[0]) + abs(p1[1] - p2[1])
        
        def can_place(points, k, min_dist):
            count = 1
            last_point = points[0]
            for i in range(1, len(points)):
                if manhattan_distance(last_point, points[i]) >= min_dist:
                    count += 1
                    last_point = points[i]
                    if count == k:
                        return True
            return False
        
        points.sort()
        left, right = 0, 2 * side
        
        while left < right:
            mid = (left + right + 1) // 2
            if can_place(points, k, mid):
                left = mid
            else:
                right = mid - 1
        
        return left