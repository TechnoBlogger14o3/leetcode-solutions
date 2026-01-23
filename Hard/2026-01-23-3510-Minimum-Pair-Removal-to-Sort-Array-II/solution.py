class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        operations = 0
        while True:
            min_sum = float('inf')
            min_index = -1
            
            for i in range(len(nums) - 1):
                if nums[i] + nums[i + 1] < min_sum:
                    min_sum = nums[i] + nums[i + 1]
                    min_index = i
            
            if min_index == -1 or (min_index > 0 and nums[min_index - 1] > nums[min_index] + nums[min_index + 1]) or (min_index < len(nums) - 2 and nums[min_index] + nums[min_index + 1] > nums[min_index + 2]):
                break
            
            nums[min_index] = nums[min_index] + nums[min_index + 1]
            del nums[min_index + 1]
            operations += 1
        
        return operations