class Solution:
    def incrementSubmatrices(self, n: int, queries: List[List[int]]) -> List[List[int]]:
        mat = [[0] * n for _ in range(n)]
        
        for row1, col1, row2, col2 in queries:
            for i in range(row1, row2 + 1):
                for j in range(col1, col2 + 1):
                    mat[i][j] += 1
        
        return mat