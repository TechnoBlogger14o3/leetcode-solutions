from math import gcd
from functools import reduce
from collections import defaultdict

class Solution:
    def lcm(self, a, b):
        return a * b // gcd(a, b)

    def lcm_of_list(self, nums):
        return reduce(self.lcm, nums)

    def maxProductEquivalentSubarray(self, nums):
        n = len(nums)
        max_length = 0
        
        for start in range(n):
            product = 1
            current_gcd = nums[start]
            current_lcm = nums[start]
            for end in range(start, n):
                product *= nums[end]
                current_gcd = gcd(current_gcd, nums[end])
                current_lcm = self.lcm(current_lcm, nums[end])
                
                if product == current_lcm * current_gcd:
                    max_length = max(max_length, end - start + 1)
        
        return max_length