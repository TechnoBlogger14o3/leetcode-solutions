class Solution:
    def minSwaps(self, grid: List[List[int]]) -> int:
        n = len(grid)
        zeros_needed = [0] * n
        
        for i in range(n):
            count = 0
            for j in range(n):
                if grid[i][j] == 0:
                    count += 1
            zeros_needed[i] = count
        
        swaps = 0
        for i in range(n):
            if zeros_needed[i] < n - 1 - i:
                return -1
            
            for j in range(i, n):
                if zeros_needed[j] >= n - 1 - i:
                    swaps += j - i
                    zeros_needed[i:j + 1] = [zeros_needed[j]] + zeros_needed[i:j]
                    break
        
        return swaps