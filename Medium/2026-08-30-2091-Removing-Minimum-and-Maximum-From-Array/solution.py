class Solution:
    def minimumDeletions(self, nums: List[int]) -> int:
        min_index = nums.index(min(nums))
        max_index = nums.index(max(nums))
        
        left = min(min_index, max_index) + 1
        right = len(nums) - max(min_index, max_index)
        both_ends = min_index + 1 + len(nums) - max_index if min_index < max_index else max_index + 1 + len(nums) - min_index
        
        return min(left, right, both_ends)