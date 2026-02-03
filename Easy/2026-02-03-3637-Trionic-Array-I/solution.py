class Solution:
    def isTrionic(self, nums: List[int]) -> bool:
        n = len(nums)
        
        # Find the first increasing segment
        p = 0
        while p < n - 1 and nums[p] < nums[p + 1]:
            p += 1
        
        # If p is at the start or end, return false
        if p <= 0 or p >= n - 1:
            return False
        
        # Find the decreasing segment
        q = p
        while q < n - 1 and nums[q] > nums[q + 1]:
            q += 1
        
        # If q is at the end, return false
        if q >= n - 1:
            return False
        
        # Check the last increasing segment
        while q < n - 1 and nums[q] < nums[q + 1]:
            q += 1
        
        return q == n - 1