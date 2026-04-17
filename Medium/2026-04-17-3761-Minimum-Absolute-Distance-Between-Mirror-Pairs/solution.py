class Solution:
    def minimumAbsDistance(self, nums: List[int]) -> int:
        def reverse(x):
            return int(str(x)[::-1])
        
        index_map = {}
        min_distance = float('inf')
        
        for i, num in enumerate(nums):
            rev_num = reverse(num)
            if rev_num in index_map:
                min_distance = min(min_distance, i - index_map[rev_num])
            index_map[num] = i
        
        return min_distance if min_distance != float('inf') else -1