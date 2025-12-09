class Solution:
    def countTriplets(self, nums: List[int]) -> int:
        count = 0
        mod = 10**9 + 7
        n = len(nums)
        
        # Count occurrences of each number
        freq = Counter(nums)
        
        for j in range(n):
            if nums[j] * 2 in freq:
                count += freq[nums[j] * 2] * (j - sum(1 for i in range(j) if nums[i] == nums[j] * 2))
        
        return count % mod