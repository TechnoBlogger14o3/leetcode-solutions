class Solution:
    def repeatedNTimes(self, nums: List[int]) -> int:
        count = {}
        n = len(nums) // 2
        for num in nums:
            if num in count:
                count[num] += 1
                if count[num] == n:
                    return num
            else:
                count[num] = 1