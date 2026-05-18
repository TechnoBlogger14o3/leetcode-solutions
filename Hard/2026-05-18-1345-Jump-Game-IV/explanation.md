# Jump Game IV (Hard)

**Problem ID:** 1345  
**Date:** 2026-05-18  
**Link:** https://leetcode.com/problems/jump-game-iv/

## Approach

To solve the "Jump Game IV" problem, we can utilize a breadth-first search (BFS) approach to find the minimum number of jumps needed to reach the last index of the array. Here’s a concise explanation of the approach:

### Main Idea:
The goal is to explore all possible indices we can jump to from the current index, and we want to do this in the fewest steps possible. We can jump to adjacent indices (i + 1 and i - 1) and to any other index with the same value as the current index. By treating the array as a graph where indices are nodes and valid jumps are edges, we can use BFS to explore the shortest path from the first index to the last index.

### Steps:
1. **Initialization**: 
   - Use a queue to facilitate the BFS, starting with the first index (0).
   - Maintain a set to track visited indices to avoid cycles and redundant processing.
   - Create a mapping (dictionary) of values to their respective indices for efficient jumps to indices with the same value.

2. **BFS Process**:
   - Dequeue an index and check if it is the last index. If so, return the current step count.
   - For each index, enqueue its neighbors:
     - The next index (i + 1) if it exists and hasn't been visited.
     - The previous index (i - 1) if it exists and hasn't been visited.
     - All indices that have the same value as the current index, ensuring they haven't been visited yet.
   - After processing jumps to the same value, clear that list to prevent unnecessary future jumps.

3. **Termination**: 
   - The BFS continues until we either reach the last index or exhaust all possibilities. If we reach the last index, we return the number of steps taken.

### Data Structures:
- **Queue**: To implement the BFS, storing indices and their corresponding step counts.
- **Set**: To track visited indices, preventing reprocessing.
- **Dictionary**: To map values to their indices for quick access when making jumps to the same value.

### Complexity:
- **Time Complexity**: O(N), where N is the length of the array. Each index is processed at most once, and we efficiently handle jumps to indices with the same value.
- **Space Complexity**: O(N) for the queue and the visited set, and O(N) for the dictionary storing indices corresponding to each value.

This approach ensures that we find the minimum number of jumps efficiently while exploring all possible paths in a systematic way.
