class Solution:
    def countSubarrays(self, nums: List[int], target: int) -> int:
        n = len(nums)
        count = 0
        
        for i in range(n):
            if nums[i] == target:
                majority_count = 0
                for j in range(i, n):
                    if nums[j] == target:
                        majority_count += 1
                    if majority_count > (j - i + 1) // 2:
                        count += 1
        
        return count