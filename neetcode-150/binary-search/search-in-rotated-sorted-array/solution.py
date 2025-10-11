"""
Time Complexity: O(log n) - Binary search
Space Complexity: O(1) - Only uses constant extra space
"""
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums) - 1
        
        while left <= right:
            mid = left + (right - left) // 2
            
            if nums[mid] == target:
                return mid
            
            # Check which half is sorted
            if nums[left] <= nums[mid]:
                # Left half is sorted
                if nums[left] <= target < nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
            else:
                # Right half is sorted
                if nums[mid] < target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1
        
        return -1

# Alternative approach using two binary searches
class SolutionTwoPass:
    def search(self, nums: List[int], target: int) -> int:
        pivot = self.find_pivot(nums)
        
        if pivot == -1:
            # No rotation, use standard binary search
            return self.binary_search(nums, target, 0, len(nums) - 1)
        
        if nums[pivot] == target:
            return pivot
        
        if target >= nums[0]:
            return self.binary_search(nums, target, 0, pivot - 1)
        else:
            return self.binary_search(nums, target, pivot + 1, len(nums) - 1)
    
    def find_pivot(self, nums: List[int]) -> int:
        left = 0
        right = len(nums) - 1
        
        while left < right:
            mid = left + (right - left) // 2
            
            if nums[mid] > nums[right]:
                left = mid + 1
            else:
                right = mid
        
        return left
    
    def binary_search(self, nums: List[int], target: int, left: int, right: int) -> int:
        while left <= right:
            mid = left + (right - left) // 2
            
            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        
        return -1

# More concise version
class SolutionConcise:
    def search(self, nums: List[int], target: int) -> int:
        left, right = 0, len(nums) - 1
        
        while left <= right:
            mid = (left + right) // 2
            
            if nums[mid] == target:
                return mid
            
            if nums[left] <= nums[mid]:
                if nums[left] <= target < nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
            else:
                if nums[mid] < target <= nums[right]:
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
            
            if nums[left] <= nums[mid]:
                if nums[left] <= target < nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
            else:
                if nums[mid] < target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1
        
        return -1

# Using bisect module
import bisect

class SolutionBisect:
    def search(self, nums: List[int], target: int) -> int:
        # Find pivot point
        pivot = self.find_pivot(nums)
        
        if pivot == 0:
            # No rotation
            index = bisect.bisect_left(nums, target)
            return index if index < len(nums) and nums[index] == target else -1
        
        # Search in appropriate half
        if target >= nums[0]:
            # Search in left half
            left_half = nums[:pivot]
            index = bisect.bisect_left(left_half, target)
            return index if index < len(left_half) and left_half[index] == target else -1
        else:
            # Search in right half
            right_half = nums[pivot:]
            index = bisect.bisect_left(right_half, target)
            return pivot + index if index < len(right_half) and right_half[index] == target else -1
    
    def find_pivot(self, nums: List[int]) -> int:
        left, right = 0, len(nums) - 1
        while left < right:
            mid = (left + right) // 2
            if nums[mid] > nums[right]:
                left = mid + 1
            else:
                right = mid
        return left
