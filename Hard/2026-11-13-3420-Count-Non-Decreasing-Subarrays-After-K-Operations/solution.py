class Solution:
    def countNonDecreasing(self, nums: List[int], k: int) -> int:
        n = len(nums)
        total_count = 0
        left = 0
        current_operations = 0
        
        for right in range(n):
            if right > 0 and nums[right] < nums[right - 1]:
                current_operations += (nums[right - 1] - nums[right])
            
            while current_operations > k:
                current_operations -= (nums[left + 1] - nums[left])
                left += 1
            
            total_count += (right - left + 1)
        
        return total_count