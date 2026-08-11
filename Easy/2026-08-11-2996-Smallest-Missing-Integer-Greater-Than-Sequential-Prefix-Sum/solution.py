class Solution:
    def smallestMissingInteger(self, nums: List[int]) -> int:
        n = len(nums)
        longest_prefix_sum = 0
        current_sum = 0
        
        for i in range(n):
            if i == 0 or nums[i] == nums[i - 1] + 1:
                current_sum += nums[i]
                longest_prefix_sum = current_sum
            else:
                break
        
        missing = longest_prefix_sum
        while missing in nums:
            missing += 1
        
        return missing