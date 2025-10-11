"""
Time Complexity: O(n²) - Two nested loops
Space Complexity: O(1) - Excluding output array
"""
class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        result = []
        nums.sort()
        
        for i in range(len(nums) - 2):
            # Skip duplicates for first element
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            
            left = i + 1
            right = len(nums) - 1
            
            while left < right:
                sum_val = nums[i] + nums[left] + nums[right]
                
                if sum_val == 0:
                    result.append([nums[i], nums[left], nums[right]])
                    
                    # Skip duplicates for second element
                    while left < right and nums[left] == nums[left + 1]:
                        left += 1
                    
                    # Skip duplicates for third element
                    while left < right and nums[right] == nums[right - 1]:
                        right -= 1
                    
                    left += 1
                    right -= 1
                elif sum_val < 0:
                    left += 1
                else:
                    right -= 1
        
        return result

# Alternative approach using set
class SolutionSet:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        result = set()
        nums.sort()
        
        for i in range(len(nums) - 2):
            left = i + 1
            right = len(nums) - 1
            
            while left < right:
                sum_val = nums[i] + nums[left] + nums[right]
                
                if sum_val == 0:
                    result.add((nums[i], nums[left], nums[right]))
                    left += 1
                    right -= 1
                elif sum_val < 0:
                    left += 1
                else:
                    right -= 1
        
        return [list(triplet) for triplet in result]

# Optimized version with early exit
class SolutionOptimized:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        result = []
        nums.sort()
        
        for i in range(len(nums) - 2):
            # Early exit if first element is positive
            if nums[i] > 0:
                break
            
            # Skip duplicates for first element
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            
            left = i + 1
            right = len(nums) - 1
            
            while left < right:
                sum_val = nums[i] + nums[left] + nums[right]
                
                if sum_val == 0:
                    result.append([nums[i], nums[left], nums[right]])
                    
                    # Skip duplicates
                    while left < right and nums[left] == nums[left + 1]:
                        left += 1
                    while left < right and nums[right] == nums[right - 1]:
                        right -= 1
                    
                    left += 1
                    right -= 1
                elif sum_val < 0:
                    left += 1
                else:
                    right -= 1
        
        return result
