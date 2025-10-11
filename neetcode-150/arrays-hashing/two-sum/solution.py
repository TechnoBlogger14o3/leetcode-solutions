"""
Time Complexity: O(n) - Single pass through the array
Space Complexity: O(n) - Dictionary can store up to n elements
"""
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        num_to_index = {}
        
        for i, num in enumerate(nums):
            complement = target - num
            
            if complement in num_to_index:
                return [num_to_index[complement], i]
            
            num_to_index[num] = i
        
        return []  # Should not reach here

# Brute force approach (not recommended for large inputs)
class SolutionBruteForce:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for i in range(len(nums)):
            for j in range(i + 1, len(nums)):
                if nums[i] + nums[j] == target:
                    return [i, j]
        return []

# Two-pass approach
class SolutionTwoPass:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        num_to_index = {}
        
        # First pass: build the map
        for i, num in enumerate(nums):
            num_to_index[num] = i
        
        # Second pass: find the complement
        for i, num in enumerate(nums):
            complement = target - num
            if complement in num_to_index and num_to_index[complement] != i:
                return [i, num_to_index[complement]]
        
        return []

# Using enumerate for cleaner code
class SolutionClean:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        seen = {}
        for i, num in enumerate(nums):
            if target - num in seen:
                return [seen[target - num], i]
            seen[num] = i
        return []
