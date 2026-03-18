class Solution:
    def countSubmatrices(self, grid: List[List[int]], k: int) -> int:
        m, n = len(grid), len(grid[0])
        count = 0
        
        for r1 in range(m):
            row_sum = [0] * n
            for r2 in range(r1, m):
                for c in range(n):
                    row_sum[c] += grid[r2][c]
                
                # Use a hashmap to count the number of subarrays with sum < k
                prefix_sum = {0: 1}
                current_sum = 0
                
                for sum_value in row_sum:
                    current_sum += sum_value
                    # We need to find the number of prefix sums that are less than current_sum - k
                    target = current_sum - k
                    for ps in list(prefix_sum.keys()):
                        if ps <= target:
                            count += prefix_sum[ps]
                    
                    # Update the prefix_sum map
                    if current_sum in prefix_sum:
                        prefix_sum[current_sum] += 1
                    else:
                        prefix_sum[current_sum] = 1
        
        return count