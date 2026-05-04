class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        n = len(matrix)
        # First, transpose the matrix
        for i in range(n):
            for j in range(i, n):
                matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
        
        # Then, reverse each row
        for i in range(n):
            matrix[i].reverse()