class Solution:
    def maxSumDivThree(self, nums: List[int]) -> int:
        total_sum = sum(nums)
        remainder = total_sum % 3
        
        if remainder == 0:
            return total_sum
        
        min1, min2 = float('inf'), float('inf')
        
        for num in nums:
            if num % 3 == remainder:
                min1 = min(min1, num)
            elif num % 3 == (remainder + 1) % 3:
                min2 = min(min2, num)
        
        if remainder == 1:
            if min1 != float('inf'):
                return total_sum - min1
            if min2 != float('inf'):
                return total_sum - min1 - min2 * 2
        else:
            if min2 != float('inf'):
                return total_sum - min2
            if min1 != float('inf'):
                return total_sum - min1 * 2 - min2
        
        return 0