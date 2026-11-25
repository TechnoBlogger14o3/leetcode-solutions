class Solution:
    def smallestUniqueSubarray(self, nums: List[int]) -> int:
        from collections import defaultdict
        
        n = len(nums)
        count = defaultdict(int)
        unique_subarrays = defaultdict(int)
        
        # Count occurrences of each number
        for num in nums:
            count[num] += 1
        
        # Find all unique subarrays
        for length in range(1, n + 1):
            seen = set()
            for i in range(n - length + 1):
                subarray = tuple(nums[i:i + length])
                if subarray in seen:
                    unique_subarrays[subarray] += 1
                else:
                    seen.add(subarray)
        
        # Check for the smallest unique subarray
        min_length = float('inf')
        for subarray, occurrences in unique_subarrays.items():
            if occurrences == 1:
                min_length = min(min_length, len(subarray))
        
        return min_length if min_length != float('inf') else -1