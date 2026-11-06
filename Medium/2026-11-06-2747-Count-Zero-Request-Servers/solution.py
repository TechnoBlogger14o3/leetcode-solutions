from collections import defaultdict
from bisect import bisect_left, bisect_right

class Solution:
    def countServers(self, n: int, logs: List[List[int]], x: int, queries: List[int]) -> List[int]:
        # Step 1: Organize logs by server
        server_requests = defaultdict(list)
        for server_id, time in logs:
            server_requests[server_id].append(time)

        # Step 2: Prepare a list of all request times
        all_times = []
        for times in server_requests.values():
            all_times.extend(times)
        all_times.sort()

        # Step 3: Prepare the result array
        result = []
        
        # Step 4: Process each query
        for query in queries:
            start_time = query - x
            end_time = query
            
            # Count the number of servers that received requests in the interval
            active_servers = set()
            for server_id, times in server_requests.items():
                if any(start_time <= time <= end_time for time in times):
                    active_servers.add(server_id)

            # Calculate the number of servers with zero requests
            zero_request_servers = n - len(active_servers)
            result.append(zero_request_servers)

        return result