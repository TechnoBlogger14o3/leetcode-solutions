class Solution:
    def minimumRemovals(self, nums: List[int], k: int) -> int:
        nums.sort()
        n = len(nums)
        left = 0
        result = n
        
        for right in range(n):
            while nums[right] > nums[left] * k:
                left += 1
            result = min(result, n - (right - left + 1))
        
        return result