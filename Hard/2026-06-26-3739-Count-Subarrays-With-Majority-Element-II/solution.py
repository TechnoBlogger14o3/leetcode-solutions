class Solution:
    def countSubarrays(self, nums: List[int], target: int) -> int:
        count = 0
        n = len(nums)
        target_count = 0
        left = 0
        
        for right in range(n):
            if nums[right] == target:
                target_count += 1
            
            while (right - left + 1) // 2 <= target_count:
                count += right - left + 1
                if nums[left] == target:
                    target_count -= 1
                left += 1
        
        return count