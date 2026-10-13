class Solution:
    def maximumAlternatingSum(self, nums: List[int]) -> int:
        nums.sort(reverse=True)
        score = 0
        for i in range(len(nums)):
            if i % 2 == 0:
                score += nums[i] ** 2
            else:
                score -= nums[i] ** 2
        return score