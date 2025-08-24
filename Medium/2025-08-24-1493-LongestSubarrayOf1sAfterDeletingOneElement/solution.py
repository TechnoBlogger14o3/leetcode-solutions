from typing import List

class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        if not nums:
            return 0
        
        left = right = 0
        zero_count = 0
        max_length = 0
        
        # Sliding window approach
        while right < len(nums):
            # If we encounter a 0, increment the zero count
            if nums[right] == 0:
                zero_count += 1
            
            # If we have more than one 0, shrink the window from left
            while zero_count > 1:
                if nums[left] == 0:
                    zero_count -= 1
                left += 1
            
            # Update the maximum length
            # Note: we subtract 1 because we must delete one element
            max_length = max(max_length, right - left + 1)
            
            right += 1
        
        # If the entire array is 1's, we must delete one element
        if max_length == len(nums) and zero_count == 0:
            return max_length - 1
        
        # Otherwise, return max_length - 1 (since we must delete one element)
        return max(0, max_length - 1)
