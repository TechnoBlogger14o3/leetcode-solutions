class Solution:
    def minOperations(self, grid: List[List[int]], x: int) -> int:
        flat_grid = [num for row in grid for num in row]
        min_val = min(flat_grid)
        total_operations = 0
        
        for num in flat_grid:
            if (num - min_val) % x != 0:
                return -1
            total_operations += (num - min_val) // x
        
        return total_operations