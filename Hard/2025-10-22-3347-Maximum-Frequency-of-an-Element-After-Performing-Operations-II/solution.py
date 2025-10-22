class Solution:
    def maxFrequency(self, nums: List[int], k: int, numOperations: int) -> int:
        nums.sort()
        left = 0
        total = 0
        max_freq = 0
        
        for right in range(len(nums)):
            total += nums[right]
            while nums[right] * (right - left + 1) - total > k * numOperations:
                total -= nums[left]
                left += 1
            max_freq = max(max_freq, right - left + 1)
        
        return max_freq