from typing import List

class Solution:
    def zeroFilledSubarray(self, nums: List[int]) -> int:
        count = 0
        consecutive_zeros = 0
        
        for num in nums:
            if num == 0:
                consecutive_zeros += 1
                # Add the count of all subarrays ending at current position
                count += consecutive_zeros
            else:
                consecutive_zeros = 0
        
        return count
