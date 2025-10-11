"""
Time Complexity: O(n log n) - Sorting
Space Complexity: O(n) - Stack and sorting
"""
class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        n = len(position)
        cars = []
        
        # Create pairs of (position, time to reach target)
        for i in range(n):
            cars.append([position[i], (target - position[i]) / speed[i]])
        
        # Sort by position (closest to target first)
        cars.sort(key=lambda x: x[0])
        
        stack = []
        
        # Process cars from right to left
        for i in range(n - 1, -1, -1):
            time = cars[i][1]
            
            # If stack is empty or current car reaches target after stack top
            if not stack or time > stack[-1]:
                stack.append(time)
        
        return len(stack)

# Alternative approach using zip
class SolutionZip:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        cars = [(pos, (target - pos) / spd) for pos, spd in zip(position, speed)]
        cars.sort(key=lambda x: x[0])
        
        stack = []
        for _, time in reversed(cars):
            if not stack or time > stack[-1]:
                stack.append(time)
        
        return len(stack)

# More concise version
class SolutionConcise:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        cars = sorted(zip(position, speed), key=lambda x: x[0])
        stack = []
        
        for pos, spd in reversed(cars):
            time = (target - pos) / spd
            if not stack or time > stack[-1]:
                stack.append(time)
        
        return len(stack)

# Using list comprehension
class SolutionListComp:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        cars = sorted([(pos, (target - pos) / spd) for pos, spd in zip(position, speed)])
        stack = []
        
        for _, time in reversed(cars):
            if not stack or time > stack[-1]:
                stack.append(time)
        
        return len(stack)

# Using deque for better performance
from collections import deque

class SolutionDeque:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        cars = [(pos, (target - pos) / spd) for pos, spd in zip(position, speed)]
        cars.sort(key=lambda x: x[0])
        
        stack = deque()
        for _, time in reversed(cars):
            if not stack or time > stack[-1]:
                stack.append(time)
        
        return len(stack)
