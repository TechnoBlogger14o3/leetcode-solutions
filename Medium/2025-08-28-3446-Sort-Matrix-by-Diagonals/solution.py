python
class Solution:
    def diagonalSort(self, grid: List[List[int]]) -> List[List[int]]:
        n = len(grid)
        # Sort bottom-left diagonals
        for col in range(n):
            diag = []
            r, c = 0, col
            while r < n and c >= 0:
                diag.append(grid[r][c])
                r += 1
                c -= 1
            diag.sort(reverse=True)
            r, c = 0, col
            for val in diag:
                grid[r][c] = val
                r += 1
                c -= 1
        
        # Sort top-right diagonals
        for row in range(1, n):
            diag = []
            r, c = row, n - 1
            while r < n and c >= 0:
                diag.append(grid[r][c])
                r += 1
                c -= 1
            diag.sort()
            r, c = row, n - 1
            for val in diag:
                grid[r][c] = val
                r += 1
                c -= 1
        
        return grid