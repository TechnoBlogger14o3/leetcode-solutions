class Solution:
    def findLargestAlmostMissingInteger(self, nums: List[int], k: int) -> int:
        from collections import defaultdict
        
        count = defaultdict(int)
        n = len(nums)
        
        for i in range(n - k + 1):
            unique_elements = set(nums[i:i + k])
            for num in unique_elements:
                count[num] += 1
        
        largest_almost_missing = -1
        for num in count:
            if count[num] == 1:
                largest_almost_missing = max(largest_almost_missing, num)
        
        return largest_almost_missing