class Solution:
    def numOfWays(self, nums: List[int]) -> int:
        MOD = 10**9 + 7
        
        def comb(n, k):
            if k > n:
                return 0
            if k == 0 or k == n:
                return 1
            num = den = 1
            for i in range(k):
                num = num * (n - i) % MOD
                den = den * (i + 1) % MOD
            return num * pow(den, MOD - 2, MOD) % MOD
        
        def count_ways(nums):
            if len(nums) <= 2:
                return 1
            root = nums[0]
            left = [x for x in nums[1:] if x < root]
            right = [x for x in nums[1:] if x > root]
            left_size = len(left)
            right_size = len(right)
            return (comb(left_size + right_size, left_size) * count_ways(left) % MOD * count_ways(right) % MOD) % MOD
        
        return (count_ways(nums) - 1) % MOD