class Solution:
    def minSubarray(self, nums: List[int], p: int) -> int:
        total_sum = sum(nums)
        remainder = total_sum % p
        
        if remainder == 0:
            return 0
        
        n = len(nums)
        min_length = float('inf')
        prefix_sum = 0
        prefix_map = {0: -1}
        
        for i in range(n):
            prefix_sum += nums[i]
            current_remainder = prefix_sum % p
            
            target_remainder = (current_remainder - remainder + p) % p
            
            if target_remainder in prefix_map:
                min_length = min(min_length, i - prefix_map[target_remainder])
            
            prefix_map[current_remainder] = i
        
        return min_length if min_length != float('inf') else -1