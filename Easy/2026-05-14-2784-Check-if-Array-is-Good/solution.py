class Solution:
    def isGoodArray(self, nums: List[int]) -> bool:
        n = max(nums)
        if len(nums) != n + 1:
            return False
        count = Counter(nums)
        return count[n] == 2 and all(count[i] == 1 for i in range(1, n))