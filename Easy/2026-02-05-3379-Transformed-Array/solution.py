class Solution:
    def transformedArray(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = [0] * n
        
        for i in range(n):
            if nums[i] > 0:
                result[i] = nums[(i + nums[i]) % n]
            elif nums[i] < 0:
                result[i] = nums[(i + nums[i]) % n]
            else:
                result[i] = 0
        
        return result