# Find Servers That Handled Most Number of Requests (Hard)

**Problem ID:** 1606  
**Date:** 2026-11-09  
**Link:** https://leetcode.com/problems/find-servers-that-handled-most-number-of-requests/

## Approach

To solve the problem of finding the busiest servers that handled the most requests, we can adopt a simulation approach using a priority queue (min-heap) to efficiently manage server availability and a few additional data structures to track request handling.

### Approach:

1. **Initialization**:
   - Create an array `busyUntil` of size `k` to track when each server will be free (initially all set to 0).
   - Create an array `requestCount` of size `k` to count the number of requests handled by each server.
   - Use a min-heap (priority queue) to keep track of available servers based on their indices.

2. **Processing Requests**:
   - Iterate through each request using its index. For each request, check the current time (from the `arrival` array) and the load (from the `load` array).
   - For each request:
     - First, release servers that are no longer busy (i.e., their `busyUntil` time is less than or equal to the current request's arrival time).
     - Attempt to assign the request to the server at index `i % k`. If that server is busy, check subsequent servers (wrapping around using modulo) until an available server is found or all servers are checked.
     - If a server is found, update its `busyUntil` time (current time + load) and increment its `requestCount`.

3. **Handling Dropped Requests**:
   - If all servers are busy when a new request arrives, it is simply dropped and not counted.

4. **Finding the Busiest Servers**:
   - After processing all requests, determine the maximum value in `requestCount` to identify the busiest servers. Collect all server indices that match this maximum count.

### Data Structures:
- **Array `busyUntil`**: To track when each server will be free.
- **Array `requestCount`**: To count the number of requests handled by each server.
- **Min-Heap**: To efficiently manage and retrieve available servers.

### Complexity:
- **Time Complexity**: O(n * k) in the worst case, where `n` is the number of requests and `k` is the number of servers. However, since each request can potentially check all servers, this could be optimized by managing the availability more effectively.
- **Space Complexity**: O(k) for the `busyUntil` and `requestCount` arrays, plus the space used by the heap.

This approach efficiently simulates the request handling process while ensuring that we can quickly find available servers and track their usage, leading to the identification of the busiest servers at the end.
