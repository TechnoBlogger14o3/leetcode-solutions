class Solution:
    def findMissingElements(self, nums: List[int]) -> List[int]:
        min_num = min(nums)
        max_num = max(nums)
        full_range = set(range(min_num, max_num + 1))
        missing_elements = sorted(full_range - set(nums))
        return missing_elements