from math import gcd
from typing import List

class Solution:
    def findGCD(self, nums: List[int]) -> int:
        smallest = min(nums)
        largest = max(nums)
        return gcd(smallest, largest)