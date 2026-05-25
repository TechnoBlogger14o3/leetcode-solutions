# Jump Game VII (Medium)

**Problem ID:** 1871  
**Date:** 2026-05-25  
**Link:** https://leetcode.com/problems/jump-game-vii/

## Approach

To solve the "Jump Game VII" problem, we can utilize a breadth-first search (BFS) approach, leveraging a queue to explore possible jumps while maintaining efficiency.

### Problem Breakdown
1. **Initial Setup**: We start at index 0 and need to determine if we can reach the last index of the binary string `s`. The valid jumps are constrained by `minJump` and `maxJump`, and we can only land on indices where `s[j]` is '0'.

2. **BFS Approach**: 
   - We can treat the problem as a graph traversal where each index is a node and valid jumps represent edges to other nodes.
   - Use a queue to keep track of indices we can explore. We start by enqueueing index 0.

3. **Tracking Reachability**: 
   - Maintain a variable to track the farthest index we can reach (`farthest`). This helps us avoid unnecessary checks and ensures we only consider valid jumps.
   - As we process each index, we calculate the range of indices we can jump to, from `i + minJump` to `min(i + maxJump, s.length - 1)`.
   - For each valid jump, check if the target index is '0' and hasn't been visited yet. If so, enqueue it and update `farthest`.

4. **Termination**: 
   - If at any point we can enqueue the last index (`s.length - 1`), we return `true`.
   - If we exhaust the queue without reaching the last index, we return `false`.

### Data Structures
- **Queue**: To facilitate BFS traversal of indices.
- **Integer Variable**: To keep track of the farthest index reached.

### Complexity Analysis
- **Time Complexity**: O(n), where n is the length of the string `s`. Each index is processed at most once.
- **Space Complexity**: O(n) in the worst case for the queue, although typically it will be much less since we only enqueue valid indices.

This approach efficiently explores all possible paths while adhering to the constraints, ensuring we can determine if reaching the last index is feasible.
