class Solution:
    def canDetectAdjacentIncreasingSubarrays(self, nums: List[int], k: int) -> bool:
        def is_strictly_increasing(start: int) -> bool:
            for i in range(start, start + k - 1):
                if nums[i] >= nums[i + 1]:
                    return False
            return True
        
        n = len(nums)
        for i in range(n - 2 * k + 1):
            if is_strictly_increasing(i) and is_strictly_increasing(i + k):
                return True
        return False