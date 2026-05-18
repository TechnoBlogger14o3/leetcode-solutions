from collections import defaultdict, deque

class Solution:
    def minJumps(self, arr: List[int]) -> int:
        if len(arr) <= 1:
            return 0
        
        graph = defaultdict(list)
        for i in range(len(arr)):
            graph[arr[i]].append(i)
        
        queue = deque([0])
        visited = {0}
        steps = 0
        
        while queue:
            for _ in range(len(queue)):
                index = queue.popleft()
                if index == len(arr) - 1:
                    return steps
                
                # Check the next index
                if index + 1 < len(arr) and index + 1 not in visited:
                    visited.add(index + 1)
                    queue.append(index + 1)
                
                # Check the previous index
                if index - 1 >= 0 and index - 1 not in visited:
                    visited.add(index - 1)
                    queue.append(index - 1)
                
                # Check all indices with the same value
                for neighbor in graph[arr[index]]:
                    if neighbor not in visited:
                        visited.add(neighbor)
                        queue.append(neighbor)
                
                # Clear the list to prevent future unnecessary checks
                graph[arr[index]].clear()
            
            steps += 1
        
        return -1