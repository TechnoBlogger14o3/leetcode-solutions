"""
Time Complexity: O(log(mn)) - Binary search on flattened array
Space Complexity: O(1) - Only uses constant extra space
"""
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or not matrix[0]:
            return False
        
        m = len(matrix)
        n = len(matrix[0])
        left = 0
        right = m * n - 1
        
        while left <= right:
            mid = left + (right - left) // 2
            row = mid // n
            col = mid % n
            
            if matrix[row][col] == target:
                return True
            elif matrix[row][col] < target:
                left = mid + 1
            else:
                right = mid - 1
        
        return False

# Alternative approach using two binary searches
class SolutionTwoBinarySearches:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or not matrix[0]:
            return False
        
        m = len(matrix)
        n = len(matrix[0])
        
        # First binary search: find the correct row
        top, bottom = 0, m - 1
        while top <= bottom:
            mid = top + (bottom - top) // 2
            if matrix[mid][0] <= target <= matrix[mid][n - 1]:
                # Second binary search: find target in the row
                left, right = 0, n - 1
                while left <= right:
                    col_mid = left + (right - left) // 2
                    if matrix[mid][col_mid] == target:
                        return True
                    elif matrix[mid][col_mid] < target:
                        left = col_mid + 1
                    else:
                        right = col_mid - 1
                return False
            elif matrix[mid][0] > target:
                bottom = mid - 1
            else:
                top = mid + 1
        
        return False

# Alternative approach using diagonal search
class SolutionDiagonal:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or not matrix[0]:
            return False
        
        row = 0
        col = len(matrix[0]) - 1
        
        while row < len(matrix) and col >= 0:
            if matrix[row][col] == target:
                return True
            elif matrix[row][col] > target:
                col -= 1
            else:
                row += 1
        
        return False

# More concise version
class SolutionConcise:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix:
            return False
        
        m, n = len(matrix), len(matrix[0])
        left, right = 0, m * n - 1
        
        while left <= right:
            mid = (left + right) // 2
            val = matrix[mid // n][mid % n]
            
            if val == target:
                return True
            if val < target:
                left = mid + 1
            else:
                right = mid - 1
        
        return False

# Using bisect module
import bisect

class SolutionBisect:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or not matrix[0]:
            return False
        
        # Flatten the matrix
        flattened = [val for row in matrix for val in row]
        
        # Use bisect to find target
        index = bisect.bisect_left(flattened, target)
        return index < len(flattened) and flattened[index] == target

# Using numpy for array operations
import numpy as np

class SolutionNumpy:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or not matrix[0]:
            return False
        
        matrix_array = np.array(matrix)
        flattened = matrix_array.flatten()
        
        # Use numpy's searchsorted
        index = np.searchsorted(flattened, target)
        return index < len(flattened) and flattened[index] == target
