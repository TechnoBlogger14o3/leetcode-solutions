class Solution:
    def maxRotateFunction(self, nums: List[int]) -> int:
        n = len(nums)
        total_sum = sum(nums)
        current_value = sum(i * num for i, num in enumerate(nums))
        max_value = current_value
        
        for k in range(1, n):
            current_value += total_sum - n * nums[n - k]
            max_value = max(max_value, current_value)
        
        return max_value