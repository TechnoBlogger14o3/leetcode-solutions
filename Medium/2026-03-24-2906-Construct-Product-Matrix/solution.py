class Solution:
    def constructProductMatrix(self, grid: List[List[int]]) -> List[List[int]]:
        n = len(grid)
        m = len(grid[0])
        total_product = 1
        zero_count = 0
        
        for row in grid:
            for num in row:
                if num == 0:
                    zero_count += 1
                else:
                    total_product *= num
                    total_product %= 12345
        
        result = [[0] * m for _ in range(n)]
        
        if zero_count > 1:
            return result
        
        for i in range(n):
            for j in range(m):
                if zero_count == 1:
                    if grid[i][j] == 0:
                        result[i][j] = total_product % 12345
                else:
                    result[i][j] = (total_product * pow(grid[i][j], 12343, 12345)) % 12345
        
        return result