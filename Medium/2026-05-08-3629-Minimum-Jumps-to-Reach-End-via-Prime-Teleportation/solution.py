from collections import defaultdict, deque
import math

class Solution:
    def minJumps(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1:
            return 0
        
        # Function to check if a number is prime
        def is_prime(x):
            if x < 2:
                return False
            for i in range(2, int(math.sqrt(x)) + 1):
                if x % i == 0:
                    return False
            return True
        
        # Create a map of prime numbers to their indices
        prime_map = defaultdict(list)
        for i in range(n):
            if is_prime(nums[i]):
                prime_map[nums[i]].append(i)
        
        # BFS initialization
        queue = deque([0])
        visited = set([0])
        jumps = 0
        
        while queue:
            for _ in range(len(queue)):
                index = queue.popleft()
                
                # Check if we reached the end
                if index == n - 1:
                    return jumps
                
                # Adjacent steps
                for neighbor in (index - 1, index + 1):
                    if 0 <= neighbor < n and neighbor not in visited:
                        visited.add(neighbor)
                        queue.append(neighbor)
                
                # Prime teleportation
                if nums[index] in prime_map:
                    for neighbor in prime_map[nums[index]]:
                        if neighbor != index and neighbor not in visited:
                            visited.add(neighbor)
                            queue.append(neighbor)
                    # Clear the list to prevent future unnecessary checks
                    del prime_map[nums[index]]
            
            jumps += 1
        
        return -1  # In case there's no way to reach the end