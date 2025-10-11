"""
Time Complexity: O(log n) - Binary search
Space Complexity: O(1) - Only uses constant extra space
"""
class Solution:
    def findMin(self, nums: List[int]) -> int:
        left = 0
        right = len(nums) - 1
        
        while left < right:
            mid = left + (right - left) // 2
            
            if nums[mid] > nums[right]:
                left = mid + 1
            else:
                right = mid
        
        return nums[left]

# Alternative approach using recursive binary search
class SolutionRecursive:
    def findMin(self, nums: List[int]) -> int:
        return self.findMinHelper(nums, 0, len(nums) - 1)
    
    def findMinHelper(self, nums: List[int], left: int, right: int) -> int:
        if left >= right:
            return nums[left]
        
        mid = left + (right - left) // 2
        
        if nums[mid] > nums[right]:
            return self.findMinHelper(nums, mid + 1, right)
        else:
            return self.findMinHelper(nums, left, mid)

# Alternative approach comparing with leftmost element
class SolutionLeft:
    def findMin(self, nums: List[int]) -> int:
        left = 0
        right = len(nums) - 1
        
        while left < right:
            mid = left + (right - left) // 2
            
            if nums[mid] < nums[left]:
                right = mid
            else:
                left = mid + 1
        
        return nums[left]

# More concise version
class SolutionConcise:
    def findMin(self, nums: List[int]) -> int:
        left, right = 0, len(nums) - 1
        
        while left < right:
            mid = (left + right) // 2
            if nums[mid] > nums[right]:
                left = mid + 1
            else:
                right = mid
        
        return nums[left]

# Using bit manipulation for mid calculation
class SolutionBitManipulation:
    def findMin(self, nums: List[int]) -> int:
        left = 0
        right = len(nums) - 1
        
        while left < right:
            mid = (left + right) >> 1  # Right shift by 1
            
            if nums[mid] > nums[right]:
                left = mid + 1
            else:
                right = mid
        
        return nums[left]

# Using min function (not efficient but concise)
class SolutionMin:
    def findMin(self, nums: List[int]) -> int:
        return min(nums)

# Using numpy for array operations
import numpy as np

class SolutionNumpy:
    def findMin(self, nums: List[int]) -> int:
        nums_array = np.array(nums)
        return np.min(nums_array)
