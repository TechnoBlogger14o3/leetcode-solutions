"""
Time Complexity: O(n) - Single pass through the array
Space Complexity: O(1) - Only using two pointers
"""
class Solution:
    def trap(self, height: List[int]) -> int:
        if not height:
            return 0
        
        left = 0
        right = len(height) - 1
        max_left = 0
        max_right = 0
        water = 0
        
        while left < right:
            if height[left] < height[right]:
                if height[left] >= max_left:
                    max_left = height[left]
                else:
                    water += max_left - height[left]
                left += 1
            else:
                if height[right] >= max_right:
                    max_right = height[right]
                else:
                    water += max_right - height[right]
                right -= 1
        
        return water

# Alternative approach using dynamic programming
class SolutionDP:
    def trap(self, height: List[int]) -> int:
        if not height:
            return 0
        
        n = len(height)
        left_max = [0] * n
        right_max = [0] * n
        
        # Calculate maximum height from left
        left_max[0] = height[0]
        for i in range(1, n):
            left_max[i] = max(left_max[i - 1], height[i])
        
        # Calculate maximum height from right
        right_max[n - 1] = height[n - 1]
        for i in range(n - 2, -1, -1):
            right_max[i] = max(right_max[i + 1], height[i])
        
        # Calculate trapped water
        water = 0
        for i in range(n):
            water += min(left_max[i], right_max[i]) - height[i]
        
        return water

# Using stack approach
class SolutionStack:
    def trap(self, height: List[int]) -> int:
        if not height:
            return 0
        
        stack = []
        water = 0
        
        for i in range(len(height)):
            while stack and height[i] > height[stack[-1]]:
                top = stack.pop()
                if not stack:
                    break
                
                distance = i - stack[-1] - 1
                bounded_height = min(height[i], height[stack[-1]]) - height[top]
                water += distance * bounded_height
            
            stack.append(i)
        
        return water

# More concise version
class SolutionConcise:
    def trap(self, height: List[int]) -> int:
        if not height:
            return 0
        
        left, right = 0, len(height) - 1
        max_left = max_right = water = 0
        
        while left < right:
            if height[left] < height[right]:
                max_left = max(max_left, height[left])
                water += max_left - height[left]
                left += 1
            else:
                max_right = max(max_right, height[right])
                water += max_right - height[right]
                right -= 1
        
        return water
