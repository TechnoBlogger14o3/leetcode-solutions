class Solution:
    def findSmallestInteger(self, nums: List[int], value: int) -> int:
        reachable = set()
        for num in nums:
            for k in range(-1, 2):
                reachable.add(num + k * value)
        
        mex = 0
        while mex in reachable:
            mex += 1
        
        return mex