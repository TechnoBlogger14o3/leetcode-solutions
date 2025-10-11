"""
Time Complexity: O(n * log(max(piles))) - Binary search + validation
Space Complexity: O(1) - Only uses constant extra space
"""
class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        left = 1
        right = max(piles)
        
        while left < right:
            mid = left + (right - left) // 2
            
            if self.can_finish(piles, mid, h):
                right = mid
            else:
                left = mid + 1
        
        return left
    
    def can_finish(self, piles: List[int], speed: int, h: int) -> bool:
        total_hours = 0
        
        for pile in piles:
            total_hours += (pile + speed - 1) // speed  # Ceiling division
        
        return total_hours <= h

# Alternative approach using math.ceil
import math

class SolutionCeil:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        left = 1
        right = max(piles)
        
        while left < right:
            mid = left + (right - left) // 2
            
            if self.can_finish(piles, mid, h):
                right = mid
            else:
                left = mid + 1
        
        return left
    
    def can_finish(self, piles: List[int], speed: int, h: int) -> bool:
        total_hours = 0
        
        for pile in piles:
            total_hours += math.ceil(pile / speed)
        
        return total_hours <= h

# More concise version
class SolutionConcise:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        left, right = 1, max(piles)
        
        while left < right:
            mid = (left + right) // 2
            if sum((pile + mid - 1) // mid for pile in piles) <= h:
                right = mid
            else:
                left = mid + 1
        
        return left

# Using list comprehension
class SolutionListComp:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        left, right = 1, max(piles)
        
        while left < right:
            mid = (left + right) // 2
            if sum(math.ceil(pile / mid) for pile in piles) <= h:
                right = mid
            else:
                left = mid + 1
        
        return left

# Using numpy for array operations
import numpy as np

class SolutionNumpy:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        piles_array = np.array(piles)
        left, right = 1, np.max(piles_array)
        
        while left < right:
            mid = (left + right) // 2
            if np.sum(np.ceil(piles_array / mid)) <= h:
                right = mid
            else:
                left = mid + 1
        
        return left

# Using bisect for binary search
import bisect

class SolutionBisect:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        def can_finish(speed):
            return sum((pile + speed - 1) // speed for pile in piles) <= h
        
        left, right = 1, max(piles)
        
        while left < right:
            mid = (left + right) // 2
            if can_finish(mid):
                right = mid
            else:
                left = mid + 1
        
        return left
