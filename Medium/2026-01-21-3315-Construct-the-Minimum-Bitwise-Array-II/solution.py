class Solution:
    def minimumBitwiseArray(self, nums: List[int]) -> List[int]:
        ans = []
        for num in nums:
            found = False
            for x in range(num):
                if x | (x + 1) == num:
                    ans.append(x)
                    found = True
                    break
            if not found:
                ans.append(-1)
        return ans