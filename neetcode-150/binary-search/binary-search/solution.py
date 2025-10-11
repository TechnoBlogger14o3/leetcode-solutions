"""
Time Complexity: O(log n) - Halves search space each iteration
Space Complexity: O(1) - Only uses constant extra space
"""
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums) - 1
        
        while left <= right:
            mid = left + (right - left) // 2  # Prevent overflow
            
            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        
        return -1

# Alternative approach using recursive binary search
class SolutionRecursive:
    def search(self, nums: List[int], target: int) -> int:
        return self.binary_search(nums, target, 0, len(nums) - 1)
    
    def binary_search(self, nums: List[int], target: int, left: int, right: int) -> int:
        if left > right:
            return -1
        
        mid = left + (right - left) // 2
        
        if nums[mid] == target:
            return mid
        elif nums[mid] < target:
            return self.binary_search(nums, target, mid + 1, right)
        else:
            return self.binary_search(nums, target, left, mid - 1)

# Alternative approach using bisect module
import bisect

class SolutionBisect:
    def search(self, nums: List[int], target: int) -> int:
        index = bisect.bisect_left(nums, target)
        return index if index < len(nums) and nums[index] == target else -1

# More concise version
class SolutionConcise:
    def search(self, nums: List[int], target: int) -> int:
        left, right = 0, len(nums) - 1
        
        while left <= right:
            mid = (left + right) // 2
            if nums[mid] == target:
                return mid
            if nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        
        return -1

# Using bit manipulation for mid calculation
class SolutionBitManipulation:
    def search(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums) - 1
        
        while left <= right:
            mid = (left + right) >> 1  # Right shift by 1
            
            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        
        return -1

# Using list comprehension (not efficient but concise)
class SolutionListComp:
    def search(self, nums: List[int], target: int) -> int:
        try:
            return nums.index(target)
        except ValueError:
            return -1

# Using numpy for array operations
import numpy as np

class SolutionNumpy:
    def search(self, nums: List[int], target: int) -> int:
        nums_array = np.array(nums)
        indices = np.where(nums_array == target)[0]
        return indices[0] if len(indices) > 0 else -1
