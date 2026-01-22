class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        operations = 0
        
        while True:
            # Check if the array is non-decreasing
            if all(nums[i] <= nums[i + 1] for i in range(len(nums) - 1)):
                break
            
            # Find the pair with the minimum sum
            min_sum = float('inf')
            min_index = -1
            
            for i in range(len(nums) - 1):
                pair_sum = nums[i] + nums[i + 1]
                if pair_sum < min_sum:
                    min_sum = pair_sum
                    min_index = i
            
            # Replace the pair with their sum
            nums[min_index] = min_sum
            del nums[min_index + 1]
            operations += 1
        
        return operations