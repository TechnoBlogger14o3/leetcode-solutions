class Solution:
    def maximumElementAfterDecreasingAndRearranging(self, arr: List[int]) -> int:
        arr.sort()
        max_elem = 1
        for num in arr:
            if num > max_elem + 1:
                num = max_elem + 1
            max_elem = num
        return max_elem