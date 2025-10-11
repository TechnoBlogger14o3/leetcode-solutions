"""
Time Complexity: O(n) - Single pass through the array
Space Complexity: O(1) - Only using two pointers
"""
class Solution:
    def maxArea(self, height: List[int]) -> int:
        left = 0
        right = len(height) - 1
        max_area = 0
        
        while left < right:
            # Calculate area
            area = min(height[left], height[right]) * (right - left)
            max_area = max(max_area, area)
            
            # Move pointer with smaller height
            if height[left] < height[right]:
                left += 1
            else:
                right -= 1
        
        return max_area

# Alternative approach using brute force
class SolutionBruteForce:
    def maxArea(self, height: List[int]) -> int:
        max_area = 0
        
        for i in range(len(height)):
            for j in range(i + 1, len(height)):
                area = min(height[i], height[j]) * (j - i)
                max_area = max(max_area, area)
        
        return max_area

# More concise version
class SolutionConcise:
    def maxArea(self, height: List[int]) -> int:
        max_area = 0
        left, right = 0, len(height) - 1
        
        while left < right:
            max_area = max(max_area, 
                min(height[left], height[right]) * (right - left))
            
            if height[left] < height[right]:
                left += 1
            else:
                right -= 1
        
        return max_area

# Using list comprehension (not efficient but concise)
class SolutionListComp:
    def maxArea(self, height: List[int]) -> int:
        return max(min(height[i], height[j]) * (j - i) 
                  for i in range(len(height)) 
                  for j in range(i + 1, len(height)))
