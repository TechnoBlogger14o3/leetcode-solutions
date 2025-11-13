class Solution:
    def maximumOperations(self, s: str) -> int:
        count_ones = 0
        operations = 0
        
        for char in s:
            if char == '1':
                count_ones += 1
            elif count_ones > 0:
                operations += count_ones
        
        return operations