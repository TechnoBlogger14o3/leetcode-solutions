from collections import Counter

class Solution:
    def maximumElements(self, nums: List[int]) -> int:
        count = Counter(nums)
        max_count = 0
        
        for num in sorted(count.keys()):
            if num % 2 == 0:
                half = num // 2
                if half in count:
                    max_count = max(max_count, count[num] + count[half])
                else:
                    max_count = max(max_count, count[num])
            else:
                max_count = max(max_count, count[num])
        
        return max_count