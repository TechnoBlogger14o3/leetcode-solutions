from math import gcd
from itertools import combinations
from bisect import bisect_left

class Solution:
    def sortedGcdPairs(self, nums: List[int], queries: List[int]) -> List[int]:
        n = len(nums)
        gcdPairs = []
        
        for i, j in combinations(range(n), 2):
            gcdPairs.append(gcd(nums[i], nums[j]))
        
        gcdPairs.sort()
        
        return [gcdPairs[q] for q in queries]