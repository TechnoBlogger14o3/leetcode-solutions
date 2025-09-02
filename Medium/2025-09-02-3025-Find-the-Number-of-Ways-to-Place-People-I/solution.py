class Solution:
    def countPairs(self, points: List[List[int]]) -> int:
        points.sort()
        count = 0
        n = len(points)
        
        for i in range(n):
            for j in range(i + 1, n):
                A = points[i]
                B = points[j]
                if A[0] < B[0] and A[1] < B[1]:
                    valid = True
                    for k in range(n):
                        if k != i and k != j:
                            C = points[k]
                            if A[0] < C[0] < B[0] and A[1] < C[1] < B[1]:
                                valid = False
                                break
                    if valid:
                        count += 1
        return count