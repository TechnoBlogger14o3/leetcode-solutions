# Jump Game III (Medium)

**Problem ID:** 1306  
**Date:** 2026-05-17  
**Link:** https://leetcode.com/problems/jump-game-iii/

## Approach

To solve the "Jump Game III" problem, we can employ a breadth-first search (BFS) or depth-first search (DFS) approach to explore reachable indices in the array. The main idea is to traverse the array starting from the given index and check if we can reach any index that contains the value 0.

### Approach:

1. **Initialization**:
   - Use a queue (for BFS) or a stack (for DFS) to keep track of the indices to explore.
   - Maintain a set or an array to record visited indices to prevent cycles and redundant checks.

2. **Traversal**:
   - Start from the `start` index and add it to the queue/stack.
   - While there are indices to explore:
     - Dequeue or pop an index.
     - Check if the value at this index is 0. If it is, return `true`.
     - Calculate the next possible indices to jump to:
       - `i + arr[i]` (forward jump)
       - `i - arr[i]` (backward jump)
     - For each of these indices, check if they are within bounds and have not been visited:
       - If valid, mark them as visited and enqueue/push them for further exploration.

3. **Termination**:
   - If the queue/stack is exhausted and no index with value 0 has been found, return `false`.

### Data Structures:
- **Queue/Stack**: For managing the indices to explore.
- **Set/Array**: To track visited indices.

### Complexity:
- **Time Complexity**: O(n), where n is the length of the array. Each index is processed at most once.
- **Space Complexity**: O(n) in the worst case for the visited set and the queue/stack.

This approach ensures that we efficiently explore all reachable indices and check for the presence of a zero value, adhering to the problem constraints.
