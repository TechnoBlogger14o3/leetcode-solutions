"""
Time Complexity: O(n) - Each element added/removed once
Space Complexity: O(k) - Deque size at most k
"""
from collections import deque

class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        result = []
        dq = deque()
        
        for i in range(n):
            # Remove indices outside current window
            while dq and dq[0] <= i - k:
                dq.popleft()
            
            # Remove indices with smaller values
            while dq and nums[dq[-1]] <= nums[i]:
                dq.pop()
            
            # Add current index
            dq.append(i)
            
            # Add maximum to result when window size is k
            if i >= k - 1:
                result.append(nums[dq[0]])
        
        return result

# Alternative approach using Priority Queue
import heapq

class SolutionPriorityQueue:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        result = []
        max_heap = []
        
        # Initialize first window
        for i in range(k):
            heapq.heappush(max_heap, (-nums[i], i))
        result.append(-max_heap[0][0])
        
        # Slide window
        for i in range(k, n):
            # Remove elements outside window
            while max_heap and max_heap[0][1] <= i - k:
                heapq.heappop(max_heap)
            
            # Add new element
            heapq.heappush(max_heap, (-nums[i], i))
            result.append(-max_heap[0][0])
        
        return result

# More concise version
class SolutionConcise:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        dq = deque()
        result = []
        
        for i in range(len(nums)):
            while dq and dq[0] <= i - k:
                dq.popleft()
            while dq and nums[dq[-1]] <= nums[i]:
                dq.pop()
            dq.append(i)
            if i >= k - 1:
                result.append(nums[dq[0]])
        
        return result

# Using list to simulate deque
class SolutionList:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        result = []
        window = []
        
        for i in range(len(nums)):
            # Remove indices outside current window
            while window and window[0] <= i - k:
                window.pop(0)
            
            # Remove indices with smaller values
            while window and nums[window[-1]] <= nums[i]:
                window.pop()
            
            # Add current index
            window.append(i)
            
            # Add maximum to result when window size is k
            if i >= k - 1:
                result.append(nums[window[0]])
        
        return result
