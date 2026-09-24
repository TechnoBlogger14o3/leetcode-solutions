class Solution:
    def smallestEqual(self, nums: List[int]) -> int:
        for i in range(len(nums)):
            if sum(int(digit) for digit in str(nums[i])) == i:
                return i
        return -1