from collections import defaultdict
import heapq

class Solution:
    def findAllPeople(self, n: int, meetings: List[List[int]], firstPerson: int) -> List[int]:
        meetings.sort(key=lambda x: x[2])
        graph = defaultdict(list)
        
        for x, y, time in meetings:
            graph[time].append((x, y))
        
        secret_holders = {0, firstPerson}
        last_time = 0
        
        for time in sorted(graph.keys()):
            if time != last_time:
                # If time has changed, we need to process the current secret holders
                if secret_holders:
                    new_holders = set()
                    for x, y in graph[last_time]:
                        if x in secret_holders or y in secret_holders:
                            new_holders.add(x)
                            new_holders.add(y)
                    secret_holders.update(new_holders)
            
            # Update last_time
            last_time = time
            
            # Process current meetings
            for x, y in graph[time]:
                if x in secret_holders or y in secret_holders:
                    secret_holders.add(x)
                    secret_holders.add(y)
        
        return list(secret_holders)