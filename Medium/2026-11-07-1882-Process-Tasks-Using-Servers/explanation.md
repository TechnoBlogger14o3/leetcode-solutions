# Process Tasks Using Servers (Medium)

**Problem ID:** 1882  
**Date:** 2026-11-07  
**Link:** https://leetcode.com/problems/process-tasks-using-servers/

## Approach

To solve the problem of processing tasks using servers, we can adopt a simulation approach that efficiently manages the allocation of tasks to servers based on their availability and weight. Here's a concise breakdown of the solution approach:

### Main Idea:
We need to simulate the task assignment to servers as tasks arrive over time. The key is to maintain a priority on server selection based on weight and index, while also managing the timing of when servers become available.

### Data Structures:
1. **Min-Heap (Priority Queue)**: 
   - For free servers, to efficiently retrieve the server with the smallest weight (and smallest index in case of ties). This allows us to quickly find the best server for each incoming task.
  
2. **Min-Heap (Priority Queue)**: 
   - For busy servers, to track when each server will become free. This helps us efficiently manage the timing of task assignment when all servers are busy.
  
3. **Result Array**: 
   - An array to store the server index assigned to each task.

### Approach:
1. **Initialization**: Populate the free server heap with all servers, indexed by their weights and indices. Also, prepare a busy server heap to manage the timing of server availability.

2. **Task Processing**:
   - For each task, at time `j`, check if any servers are free. If so, assign the task to the free server with the smallest weight and index, update the server's next free time, and move it to the busy server heap.
   - If no servers are free, wait until the earliest server becomes free. Once a server is available, assign the next task from the queue to it. Continue this process until all tasks are processed.

3. **Handling Server Availability**:
   - When processing tasks, if a server becomes free, check if there are any pending tasks in the queue and assign them accordingly, respecting the priority of server selection.

### Complexity:
- **Time Complexity**: O((n + m) log n), where `n` is the number of servers and `m` is the number of tasks. Each task and server operation (insert, remove, or update) involves logarithmic time complexity due to the heap operations.
- **Space Complexity**: O(n + m) for storing the heaps and the result array.

This approach efficiently handles the constraints of the problem, ensuring that tasks are assigned optimally based on server availability and weight while maintaining the order of task processing.
