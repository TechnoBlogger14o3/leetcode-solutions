class Solution:
    def prefixesDivBy5(self, nums: List[int]) -> List[bool]:
        result = []
        current = 0
        
        for num in nums:
            current = (current << 1) | num
            result.append(current % 5 == 0)
        
        return result