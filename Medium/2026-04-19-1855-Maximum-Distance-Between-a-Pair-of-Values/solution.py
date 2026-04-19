class Solution:
    def maxDistance(self, nums1: List[int], nums2: List[int]) -> int:
        max_distance = 0
        j = 0
        n1, n2 = len(nums1), len(nums2)

        for i in range(n1):
            while j < n2 and nums1[i] <= nums2[j]:
                j += 1
            max_distance = max(max_distance, j - 1 - i)

        return max_distance