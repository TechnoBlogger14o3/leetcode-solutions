class Solution:
    def maximumConsecutive(self, nums: List[int]) -> int:
        nums.sort()
        max_count = 0
        left = 0
        
        for right in range(len(nums)):
            while nums[right] - nums[left] > 1:
                left += 1
            max_count = max(max_count, right - left + 1)
        
        return max_count