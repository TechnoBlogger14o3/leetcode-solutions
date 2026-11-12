class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 0:
            return 0
        
        max_length = 1
        current_length = 1
        
        # Check for increasing and decreasing subarrays
        for i in range(1, n):
            if nums[i] > nums[i - 1]:
                current_length += 1
            else:
                max_length = max(max_length, current_length)
                current_length = 1
            
            if nums[i] < nums[i - 1]:
                current_length += 1
            else:
                max_length = max(max_length, current_length)
                current_length = 1
        
        max_length = max(max_length, current_length)
        
        return max_length