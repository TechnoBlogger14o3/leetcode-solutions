from collections import defaultdict
import heapq

class Solution:
    def busiestServers(self, k: int, arrival: List[int], load: List[int]) -> List[int]:
        n = len(arrival)
        busy = []
        count = [0] * k
        available = list(range(k))
        
        for i in range(n):
            # Free up servers that are done processing
            while busy and busy[0][0] <= arrival[i]:
                _, server_id = heapq.heappop(busy)
                available.append(server_id)
            
            # Determine the server to handle the request
            server_id = i % k
            assigned = False
            
            for j in range(k):
                current_server = (server_id + j) % k
                if current_server in available:
                    available.remove(current_server)
                    count[current_server] += 1
                    heapq.heappush(busy, (arrival[i] + load[i], current_server))
                    assigned = True
                    break
            
            # If no server was available, the request is dropped
            
        max_requests = max(count)
        return [i for i in range(k) if count[i] == max_requests]