from typing import List
import math

class Solution:
    def areaOfMaxDiagonal(self, dimensions: List[List[int]]) -> int:
        if not dimensions:
            return 0
        
        max_diagonal = 0
        max_area = 0
        
        for rect in dimensions:
            length = rect[0]
            width = rect[1]
            
            # Calculate diagonal length using Pythagorean theorem
            diagonal = math.sqrt(length * length + width * width)
            
            # If this diagonal is longer, update both diagonal and area
            if diagonal > max_diagonal:
                max_diagonal = diagonal
                max_area = length * width
            # If diagonal is equal, keep the rectangle with larger area
            elif abs(diagonal - max_diagonal) < 1e-9:
                max_area = max(max_area, length * width)
        
        return max_area
