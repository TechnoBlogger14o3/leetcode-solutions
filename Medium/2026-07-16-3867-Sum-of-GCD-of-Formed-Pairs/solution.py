from math import gcd
from typing import List

class Solution:
    def sumOfGCD(self, nums: List[int]) -> int:
        n = len(nums)
        prefixGcd = [0] * n
        mx = 0
        
        for i in range(n):
            mx = max(mx, nums[i])
            prefixGcd[i] = gcd(nums[i], mx)
        
        prefixGcd.sort()
        total_gcd_sum = 0
        
        for i in range(n // 2):
            total_gcd_sum += gcd(prefixGcd[i], prefixGcd[n - 1 - i])
        
        return total_gcd_sum