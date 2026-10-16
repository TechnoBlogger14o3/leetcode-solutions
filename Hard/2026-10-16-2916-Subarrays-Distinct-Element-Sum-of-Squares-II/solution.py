class Solution:
    def sumOfSquares(self, nums: List[int]) -> int:
        MOD = 10**9 + 7
        n = len(nums)
        last_seen = {}
        distinct_count = 0
        result = 0
        
        left = 0
        
        for right in range(n):
            if nums[right] not in last_seen:
                distinct_count += 1
            last_seen[nums[right]] = right
            
            while left <= right and (right - left + 1) > distinct_count:
                if last_seen[nums[left]] == left:
                    distinct_count -= 1
                left += 1
            
            result = (result + distinct_count * distinct_count) % MOD
        
        return result