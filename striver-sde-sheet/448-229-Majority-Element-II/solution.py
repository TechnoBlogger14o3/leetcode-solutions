from typing import List

class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        if not nums:
            return []
        
        candidate1, candidate2 = None, None
        count1, count2 = 0, 0
        
        for num in nums:
            if num == candidate1:
                count1 += 1
            elif num == candidate2:
                count2 += 1
            elif count1 == 0:
                candidate1, count1 = num, 1
            elif count2 == 0:
                candidate2, count2 = num, 1
            else:
                count1 -= 1
                count2 -= 1
        
        result = []
        threshold = len(nums) // 3
        
        if candidate1 is not None and nums.count(candidate1) > threshold:
            result.append(candidate1)
        if candidate2 is not None and nums.count(candidate2) > threshold:
            result.append(candidate2)
        
        return result
