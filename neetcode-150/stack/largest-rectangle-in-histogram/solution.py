"""
Time Complexity: O(n) - Each bar pushed/popped once
Space Complexity: O(n) - Stack can hold all indices
"""
class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        stack = []
        max_area = 0
        
        for i in range(len(heights) + 1):
            h = 0 if i == len(heights) else heights[i]
            
            while stack and h < heights[stack[-1]]:
                height = heights[stack.pop()]
                width = i if not stack else i - stack[-1] - 1
                max_area = max(max_area, height * width)
            
            stack.append(i)
        
        return max_area

# Alternative approach using deque
from collections import deque

class SolutionDeque:
    def largestRectangleArea(self, heights: List[int]) -> int:
        stack = deque()
        max_area = 0
        
        for i in range(len(heights) + 1):
            h = 0 if i == len(heights) else heights[i]
            
            while stack and h < heights[stack[-1]]:
                height = heights[stack.pop()]
                width = i if not stack else i - stack[-1] - 1
                max_area = max(max_area, height * width)
            
            stack.append(i)
        
        return max_area

# Brute force approach
class SolutionBruteForce:
    def largestRectangleArea(self, heights: List[int]) -> int:
        max_area = 0
        
        for i in range(len(heights)):
            min_height = heights[i]
            
            for j in range(i, len(heights)):
                min_height = min(min_height, heights[j])
                area = min_height * (j - i + 1)
                max_area = max(max_area, area)
        
        return max_area

# More concise version
class SolutionConcise:
    def largestRectangleArea(self, heights: List[int]) -> int:
        stack = []
        max_area = 0
        
        for i in range(len(heights) + 1):
            h = 0 if i == len(heights) else heights[i]
            
            while stack and h < heights[stack[-1]]:
                height = heights[stack.pop()]
                width = i - stack[-1] - 1 if stack else i
                max_area = max(max_area, height * width)
            
            if i < len(heights):
                stack.append(i)
        
        return max_area

# Using list comprehension (not efficient but concise)
class SolutionListComp:
    def largestRectangleArea(self, heights: List[int]) -> int:
        return max([min(heights[i:j+1]) * (j-i+1) 
                   for i in range(len(heights)) 
                   for j in range(i, len(heights))], default=0)

# Using numpy for array operations
import numpy as np

class SolutionNumpy:
    def largestRectangleArea(self, heights: List[int]) -> int:
        heights = np.array(heights)
        stack = []
        max_area = 0
        
        for i in range(len(heights) + 1):
            h = 0 if i == len(heights) else heights[i]
            
            while stack and h < heights[stack[-1]]:
                height = heights[stack.pop()]
                width = i if not stack else i - stack[-1] - 1
                max_area = max(max_area, height * width)
            
            stack.append(i)
        
        return max_area
