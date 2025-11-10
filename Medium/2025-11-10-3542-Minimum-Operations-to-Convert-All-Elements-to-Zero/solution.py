class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        unique_nums = set(nums)
        unique_nums.discard(0)
        return len(unique_nums)