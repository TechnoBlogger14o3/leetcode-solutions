class Solution:
    def largestSubmatrix(self, matrix: List[List[int]]) -> int:
        if not matrix:
            return 0
        
        m, n = len(matrix), len(matrix[0])
        heights = [[0] * n for _ in range(m)]
        
        for j in range(n):
            for i in range(m):
                if matrix[i][j] == 1:
                    heights[i][j] = heights[i - 1][j] + 1 if i > 0 else 1
        
        max_area = 0
        
        for i in range(m):
            sorted_heights = sorted(heights[i], reverse=True)
            for j in range(n):
                max_area = max(max_area, sorted_heights[j] * (j + 1))
        
        return max_area