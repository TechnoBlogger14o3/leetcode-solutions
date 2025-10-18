class Solution:
    def maximumDistinctElements(self, nums: List[int], k: int) -> int:
        nums = sorted(set(nums))
        distinct_count = len(nums)
        
        for i in range(distinct_count):
            if nums[i] - k + i >= 0:
                nums[i] -= k - i
            else:
                nums[i] = 0
        
        return len(set(nums))