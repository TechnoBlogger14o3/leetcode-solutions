import heapq

class Solution:
    def assignTasks(self, servers: List[int], tasks: List[int]) -> List[int]:
        n = len(servers)
        m = len(tasks)
        
        free_servers = [(weight, i) for i, weight in enumerate(servers)]
        busy_servers = []
        ans = [0] * m
        time = 0
        
        heapq.heapify(free_servers)
        
        for j in range(m):
            time = max(time, j)  # Ensure time is at least the current task index
            
            # Free up servers that are done with their tasks
            while busy_servers and busy_servers[0][0] <= time:
                end_time, server_index = heapq.heappop(busy_servers)
                heapq.heappush(free_servers, (servers[server_index], server_index))
            
            # Assign the task if there are free servers
            if free_servers:
                weight, server_index = heapq.heappop(free_servers)
                ans[j] = server_index
                heapq.heappush(busy_servers, (time + tasks[j], server_index))
            else:
                # Wait for the next server to become free
                end_time, server_index = heapq.heappop(busy_servers)
                time = end_time
                ans[j] = server_index
                heapq.heappush(busy_servers, (time + tasks[j], server_index))
        
        return ans