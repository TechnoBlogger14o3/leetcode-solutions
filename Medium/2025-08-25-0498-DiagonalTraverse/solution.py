from typing import List
from collections import defaultdict

class Solution:
    def findDiagonalOrder(self, mat: List[List[int]]) -> List[int]:
        if not mat or not mat[0]:
            return []
        
        m, n = len(mat), len(mat[0])
        
        # Dictionary to group elements by diagonal sum
        diagonals = defaultdict(list)
        
        # Group elements by diagonal sum (row + col)
        for i in range(m):
            for j in range(n):
                diagonal_sum = i + j
                diagonals[diagonal_sum].append(mat[i][j])
        
        # Build result array
        result = []
        
        # Process diagonals in order
        for diagonal_sum in range(m + n - 1):
            diagonal = diagonals[diagonal_sum]
            if diagonal:
                # Even diagonals go from bottom-left to top-right (reverse order)
                # Odd diagonals go from top-left to bottom-right (normal order)
                if diagonal_sum % 2 == 0:
                    # Reverse for even diagonals
                    result.extend(diagonal[::-1])
                else:
                    # Normal order for odd diagonals
                    result.extend(diagonal)
        
        return result
