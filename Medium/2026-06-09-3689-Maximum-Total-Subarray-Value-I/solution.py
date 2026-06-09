class Solution:
    def maximumTotalValue(self, nums: List[int], k: int) -> int:
        max_value = max(nums)
        min_value = min(nums)
        total_value = (max_value - min_value) * k
        return total_value