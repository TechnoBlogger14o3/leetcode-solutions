class Solution:
    def jumpGameIX(self, nums: List[int]) -> List[int]:
        n = len(nums)
        ans = [0] * n
        stack = []
        
        for i in range(n):
            while stack and nums[stack[-1]] < nums[i]:
                ans[stack.pop()] = max(ans[stack[-1]], nums[i]) if stack else nums[i]
            stack.append(i)
        
        stack.clear()
        
        for i in range(n - 1, -1, -1):
            while stack and nums[stack[-1]] > nums[i]:
                ans[stack.pop()] = max(ans[stack[-1]], nums[i]) if stack else nums[i]
            stack.append(i)
        
        for i in range(n):
            ans[i] = max(ans[i], nums[i])
        
        return ans