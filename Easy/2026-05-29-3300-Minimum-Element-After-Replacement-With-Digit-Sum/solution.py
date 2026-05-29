class Solution:
    def minimumElement(self, nums: List[int]) -> int:
        def digit_sum(n: int) -> int:
            return sum(int(d) for d in str(n))
        
        return min(digit_sum(num) for num in nums)