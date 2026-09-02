class Solution:
    def canConstructArray(self, nums1: List[int]) -> bool:
        odd_count = sum(1 for num in nums1 if num % 2 != 0)
        even_count = len(nums1) - odd_count
        return odd_count == len(nums1) or even_count == len(nums1)