from collections import Counter
from typing import List

class Solution:
    def xSum(self, subarray: List[int], x: int) -> int:
        count = Counter(subarray)
        most_common = count.most_common(x)
        return sum(val for num, val in most_common)

    def xSumOfAllKLongSubarrays(self, nums: List[int], k: int, x: int) -> List[int]:
        n = len(nums)
        if k == x:
            return [sum(nums[i:i + k]) for i in range(n - k + 1)]
        
        result = []
        current_window = nums[:k]
        result.append(self.xSum(current_window, x))
        
        for i in range(1, n - k + 1):
            current_window = current_window[1:] + [nums[i + k - 1]]
            result.append(self.xSum(current_window, x))
        
        return result

# Example usage:
# sol = Solution()
# print(sol.xSumOfAllKLongSubarrays([1,1,2,2,3,4,2,3], 6, 2))
# print(sol.xSumOfAllKLongSubarrays([3,8,7,8,7,5], 2, 2))