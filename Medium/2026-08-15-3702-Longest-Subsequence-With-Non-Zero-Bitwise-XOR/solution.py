class Solution:
    def longestSubsequence(self, nums: List[int]) -> int:
        if all(num == 0 for num in nums):
            return 0
        return len(nums)