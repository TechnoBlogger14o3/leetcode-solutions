"""
Time Complexity: O(n) - Each element pushed/popped once
Space Complexity: O(n) - Stack can hold all indices
"""
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n = len(temperatures)
        result = [0] * n
        stack = []
        
        for i in range(n):
            while stack and temperatures[i] > temperatures[stack[-1]]:
                index = stack.pop()
                result[index] = i - index
            stack.append(i)
        
        return result

# Alternative approach using deque
from collections import deque

class SolutionDeque:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n = len(temperatures)
        result = [0] * n
        stack = deque()
        
        for i in range(n):
            while stack and temperatures[i] > temperatures[stack[-1]]:
                index = stack.pop()
                result[index] = i - index
            stack.append(i)
        
        return result

# Brute force approach
class SolutionBruteForce:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n = len(temperatures)
        result = [0] * n
        
        for i in range(n):
            for j in range(i + 1, n):
                if temperatures[j] > temperatures[i]:
                    result[i] = j - i
                    break
        
        return result

# More concise version
class SolutionConcise:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        result = [0] * len(temperatures)
        stack = []
        
        for i, temp in enumerate(temperatures):
            while stack and temp > temperatures[stack[-1]]:
                result[stack.pop()] = i - stack[-1] if stack else i
            stack.append(i)
        
        return result

# Using list comprehension (not efficient but concise)
class SolutionListComp:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        return [next((j - i for j in range(i + 1, len(temperatures)) 
                     if temperatures[j] > temperatures[i]), 0) 
                for i in range(len(temperatures))]

# Using numpy for array operations
import numpy as np

class SolutionNumpy:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        temps = np.array(temperatures)
        result = np.zeros(len(temps), dtype=int)
        stack = []
        
        for i in range(len(temps)):
            while stack and temps[i] > temps[stack[-1]]:
                index = stack.pop()
                result[index] = i - index
            stack.append(i)
        
        return result.tolist()
