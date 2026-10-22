class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        n = len(nums)
        sorted_nums = sorted(nums)
        
        if nums == sorted_nums:
            return 0
        
        # Check if we can sort the array
        if nums[0] == sorted_nums[-1] and nums[-1] == sorted_nums[0]:
            return -1
        
        # Count the number of segments that are already sorted
        segments = 0
        for i in range(n):
            if nums[i] != sorted_nums[i]:
                segments += 1
        
        # If the number of segments is 1, we can sort it with one operation
        if segments == 1:
            return 1
        
        # Otherwise, we need at least 2 operations
        return 2