class Solution:
    def longestBalancedSubarray(self, nums: List[int]) -> int:
        left = 0
        even_count = {}
        odd_count = {}
        max_length = 0
        
        for right in range(len(nums)):
            if nums[right] % 2 == 0:
                even_count[nums[right]] = even_count.get(nums[right], 0) + 1
            else:
                odd_count[nums[right]] = odd_count.get(nums[right], 0) + 1
            
            while len(even_count) != len(odd_count):
                if nums[left] % 2 == 0:
                    even_count[nums[left]] -= 1
                    if even_count[nums[left]] == 0:
                        del even_count[nums[left]]
                else:
                    odd_count[nums[left]] -= 1
                    if odd_count[nums[left]] == 0:
                        del odd_count[nums[left]]
                left += 1
            
            if len(even_count) == len(odd_count):
                max_length = max(max_length, right - left + 1)
        
        return max_length