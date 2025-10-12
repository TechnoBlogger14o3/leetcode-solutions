class Solution:
    def findSum(self, m: int, k: int, nums: List[int]) -> int:
        from itertools import combinations
        from functools import reduce
        from operator import mul
        
        MOD = 10**9 + 7
        n = len(nums)
        total_sum = 0
        
        for indices in combinations(range(n), m):
            bit_sum = sum(1 << idx for idx in indices)
            if bin(bit_sum).count('1') == k:
                product = reduce(mul, (nums[idx] for idx in indices), 1)
                total_sum = (total_sum + product) % MOD
        
        return total_sum