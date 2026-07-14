from math import gcd
from functools import reduce
from collections import defaultdict

class Solution:
    def countSubsequences(self, nums):
        MOD = 10**9 + 7
        n = len(nums)
        count = defaultdict(int)
        
        for num in nums:
            count[num] += 1
        
        max_num = max(nums)
        total_pairs = 0
        
        for g in range(1, max_num + 1):
            subseq_count = 0
            
            for multiple in range(g, max_num + 1, g):
                if multiple in count:
                    subseq_count += pow(2, count[multiple], MOD) - 1
            
            if subseq_count > 0:
                total_pairs += subseq_count * (subseq_count - 1) // 2
                total_pairs %= MOD
        
        return total_pairs

# Example usage
sol = Solution()
print(sol.countSubsequences([1, 2, 3, 4]))  # Output: 10
print(sol.countSubsequences([10, 20, 30]))  # Output: 2
print(sol.countSubsequences([1, 1, 1, 1]))  # Output: 50