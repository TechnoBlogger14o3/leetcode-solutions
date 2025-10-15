class Solution:
    def maxK(self, nums: List[int]) -> int:
        n = len(nums)
        if n < 2:
            return 0
        
        lengths = [0] * n
        
        for i in range(1, n):
            if nums[i] > nums[i - 1]:
                lengths[i] = lengths[i - 1] + 1
        
        max_k = 0
        
        for i in range(1, n):
            if lengths[i] > 0 and lengths[i - 1] > 0:
                k = min(lengths[i], lengths[i - 1]) + 1
                max_k = max(max_k, k)
        
        return max_k