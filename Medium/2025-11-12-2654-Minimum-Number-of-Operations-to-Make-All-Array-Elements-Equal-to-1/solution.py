from math import gcd
from functools import reduce

class Solution:
    def minOperations(self, nums: List[int]) -> int:
        if reduce(gcd, nums) != 1:
            return -1
        
        n = len(nums)
        operations = 0
        
        for i in range(n - 1):
            if gcd(nums[i], nums[i + 1]) == 1:
                operations += 1
        
        return n - 1 if operations == 0 else operations + (n - 1)