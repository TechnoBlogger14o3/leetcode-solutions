"""
Time Complexity: O(n) - Single pass through the array
Space Complexity: O(n) - Set can store up to n elements
"""
class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        seen = set()
        
        for num in nums:
            if num in seen:
                return True
            seen.add(num)
        
        return False

# Alternative approach using sorting
class SolutionSorting:
    def containsDuplicate(self, nums: List[int]) -> bool:
        nums.sort()
        
        for i in range(1, len(nums)):
            if nums[i] == nums[i - 1]:
                return True
        
        return False

# Brute force approach (not recommended for large inputs)
class SolutionBruteForce:
    def containsDuplicate(self, nums: List[int]) -> bool:
        for i in range(len(nums)):
            for j in range(i + 1, len(nums)):
                if nums[i] == nums[j]:
                    return True
        return False

# One-liner approach using set length comparison
class SolutionOneLiner:
    def containsDuplicate(self, nums: List[int]) -> bool:
        return len(nums) != len(set(nums))
