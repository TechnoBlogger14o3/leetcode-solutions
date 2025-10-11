"""
Time Complexity: O(n) - Each number visited at most twice
Space Complexity: O(n) - For set
"""
class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if not nums:
            return 0
        
        num_set = set(nums)
        max_length = 0
        
        for num in nums:
            # Check if this is the start of a sequence
            if num - 1 not in num_set:
                current_length = 1
                current_num = num
                
                # Count consecutive numbers
                while current_num + 1 in num_set:
                    current_length += 1
                    current_num += 1
                
                max_length = max(max_length, current_length)
        
        return max_length

# Alternative approach using sorting
class SolutionSorting:
    def longestConsecutive(self, nums: List[int]) -> int:
        if not nums:
            return 0
        
        nums.sort()
        
        max_length = 1
        current_length = 1
        
        for i in range(1, len(nums)):
            if nums[i] == nums[i - 1]:
                # Skip duplicates
                continue
            elif nums[i] == nums[i - 1] + 1:
                # Consecutive
                current_length += 1
            else:
                # Not consecutive, reset
                max_length = max(max_length, current_length)
                current_length = 1
        
        return max(max_length, current_length)

# More concise version
class SolutionConcise:
    def longestConsecutive(self, nums: List[int]) -> int:
        num_set = set(nums)
        max_length = 0
        
        for num in num_set:
            if num - 1 not in num_set:
                length = 1
                while num + length in num_set:
                    length += 1
                max_length = max(max_length, length)
        
        return max_length

# Using itertools for more functional approach
from itertools import groupby

class SolutionFunctional:
    def longestConsecutive(self, nums: List[int]) -> int:
        if not nums:
            return 0
        
        nums.sort()
        
        # Group consecutive numbers
        groups = []
        for key, group in groupby(enumerate(nums), key=lambda x: x[0] - x[1]):
            groups.append([x[1] for x in group])
        
        # Find longest group
        return max(len(group) for group in groups)
