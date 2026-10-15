class Solution:
    def distinctCountSumOfSquares(self, nums: List[int]) -> int:
        n = len(nums)
        result = 0
        
        for i in range(n):
            distinct_elements = set()
            for j in range(i, n):
                distinct_elements.add(nums[j])
                result += len(distinct_elements) ** 2
        
        return result