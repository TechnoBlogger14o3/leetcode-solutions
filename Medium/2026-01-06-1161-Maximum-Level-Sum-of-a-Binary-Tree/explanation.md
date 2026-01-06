# Maximum Level Sum of a Binary Tree (Medium)

**Problem ID:** 1161  
**Date:** 2026-01-06  
**Link:** https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/

## Approach

To solve the problem of finding the smallest level in a binary tree with the maximum sum of node values, we can utilize a breadth-first search (BFS) approach. Here’s a concise breakdown of the approach:

### Main Idea:
The goal is to traverse the binary tree level by level, calculate the sum of node values at each level, and keep track of the maximum sum encountered. We also need to ensure that if multiple levels have the same maximum sum, we return the smallest level.

### Approach:
1. **BFS Traversal**: Use a queue to perform a level-order traversal of the binary tree. This allows us to process each level of the tree one at a time.
  
2. **Level Sum Calculation**: For each level, initialize a sum variable to zero. As we dequeue nodes from the queue, add their values to this sum. Also, enqueue their children (if they exist) for processing in the next level.

3. **Tracking Maximum Sum**: Maintain variables to track the maximum sum found (`max_sum`) and the corresponding level (`max_level`). After processing each level, compare the current level's sum with `max_sum`. If the current sum exceeds `max_sum`, update both `max_sum` and `max_level`. If it equals `max_sum`, do not update `max_level` since we want the smallest level.

4. **Return Result**: Once all levels are processed, return `max_level`, which will hold the smallest level with the maximum sum.

### Data Structures:
- A queue (FIFO) to facilitate the level-order traversal.
- Variables to store the current level sum, maximum sum, and the level corresponding to the maximum sum.

### Complexity:
- **Time Complexity**: O(N), where N is the number of nodes in the tree. Each node is processed exactly once.
- **Space Complexity**: O(W), where W is the maximum width of the tree. In the worst case, this is O(N) for a completely unbalanced tree, but typically it will be less.

This approach efficiently computes the desired level while ensuring clarity and simplicity in the traversal and summation process.
