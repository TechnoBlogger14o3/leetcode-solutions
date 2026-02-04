class Solution:
    def maxTrionicSum(self, nums: List[int]) -> int:
        n = len(nums)
        max_sum = float('-inf')

        for p in range(1, n - 2):
            left_sum = 0
            for l in range(p):
                if nums[l] < nums[l + 1]:
                    left_sum += nums[l]
                else:
                    break
            if left_sum == 0:
                continue
            
            right_sum = 0
            for r in range(p + 2, n):
                if nums[r - 1] > nums[r]:
                    right_sum += nums[r]
                else:
                    break
            
            if right_sum == 0:
                continue
            
            for q in range(p + 1, n - 1):
                if nums[q] < nums[q + 1]:
                    current_sum = left_sum + nums[p] + nums[q] + right_sum
                    max_sum = max(max_sum, current_sum)

        return max_sum