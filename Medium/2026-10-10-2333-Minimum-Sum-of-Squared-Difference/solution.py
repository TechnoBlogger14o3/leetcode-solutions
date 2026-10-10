class Solution:
    def minSumSquareDiff(self, nums1: List[int], nums2: List[int], k1: int, k2: int) -> int:
        n = len(nums1)
        diffs = [abs(nums1[i] - nums2[i]) for i in range(n)]
        diffs.sort(reverse=True)

        total_moves = k1 + k2
        for i in range(n):
            if total_moves <= 0:
                break
            if diffs[i] == 0:
                continue
            reduce_by = min(diffs[i], total_moves)
            diffs[i] -= reduce_by
            total_moves -= reduce_by

        return sum(d ** 2 for d in diffs)