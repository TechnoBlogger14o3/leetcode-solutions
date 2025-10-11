"""
Time Complexity: O(n) - Single pass through the array
Space Complexity: O(1) - Only using two pointers
"""
class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        left = 0
        right = len(numbers) - 1
        
        while left < right:
            sum_val = numbers[left] + numbers[right]
            
            if sum_val == target:
                return [left + 1, right + 1]
            elif sum_val < target:
                left += 1
            else:
                right -= 1
        
        return []  # Should not reach here

# Alternative approach using binary search
class SolutionBinarySearch:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        for i in range(len(numbers)):
            complement = target - numbers[i]
            left = i + 1
            right = len(numbers) - 1
            
            while left <= right:
                mid = (left + right) // 2
                if numbers[mid] == complement:
                    return [i + 1, mid + 1]
                elif numbers[mid] < complement:
                    left = mid + 1
                else:
                    right = mid - 1
        
        return []

# Using dictionary (not optimal for sorted array)
class SolutionDict:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        num_to_index = {}
        
        for i, num in enumerate(numbers):
            complement = target - num
            
            if complement in num_to_index:
                return [num_to_index[complement] + 1, i + 1]
            
            num_to_index[num] = i
        
        return []

# More concise version
class SolutionConcise:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        left, right = 0, len(numbers) - 1
        while left < right:
            if numbers[left] + numbers[right] == target:
                return [left + 1, right + 1]
            elif numbers[left] + numbers[right] < target:
                left += 1
            else:
                right -= 1
        return []
