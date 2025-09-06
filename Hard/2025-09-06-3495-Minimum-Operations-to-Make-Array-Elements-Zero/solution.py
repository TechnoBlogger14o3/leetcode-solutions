class Solution:
    def minOperations(self, queries: List[List[int]]) -> int:
        def count_operations(x):
            ops = 0
            while x > 0:
                x //= 4
                ops += 1
            return ops
        
        total_operations = 0
        for l, r in queries:
            for num in range(l, r + 1):
                total_operations += count_operations(num)
        
        return total_operations

# Example usage:
# sol = Solution()
# print(sol.minOperations([[1,2],[2,4]]))  # Output: 3
# print(sol.minOperations([[2,6]]))        # Output: 4