class Solution:
    def sortableArray(self, nums: List[int]) -> int:
        n = len(nums)
        sorted_nums = sorted(nums)
        total_sum = 0
        
        def is_sortable(k):
            for i in range(0, n, k):
                if sorted(nums[i:i + k]) != sorted_nums[i:i + k]:
                    return False
            return True
        
        for k in range(1, n + 1):
            if n % k == 0 and is_sortable(k):
                total_sum += k
        
        return total_sum