class Solution:
    def shiftRow(self, row, k, direction):
        n = len(row)
        k = k % n
        if direction == 'left':
            return row[k:] + row[:k]
        else:
            return row[-k:] + row[:-k]

    def matrixSimilar(self, mat: List[List[int]], k: int) -> bool:
        original = [row[:] for row in mat]
        for i in range(k):
            for j in range(len(mat)):
                if j % 2 == 0:
                    mat[j] = self.shiftRow(mat[j], 1, 'left')
                else:
                    mat[j] = self.shiftRow(mat[j], 1, 'right')
        return mat == original