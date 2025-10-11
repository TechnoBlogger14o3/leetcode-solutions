# Binary Tree Level Order Traversal

## Problem Statement

Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

## Examples

**Example 1:**
```
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
```

**Example 2:**
```
Input: root = [1]
Output: [[1]]
```

## Approach

### Method 1: BFS with Queue (Recommended)
1. Use queue to process nodes level by level
2. For each level, process all nodes in that level
3. Add children to queue for next level
4. Store values in result list

**Time Complexity:** O(n) - Visit each node once
**Space Complexity:** O(w) - Maximum width of tree

### Method 2: DFS with Level Tracking
1. Use DFS with level parameter
2. Store values in result list by level
3. Recursively process left and right subtrees

**Time Complexity:** O(n) - Visit each node once
**Space Complexity:** O(h) - Height of tree (recursion stack)

## Algorithm

```
1. Initialize queue with root and result list
2. While queue is not empty:
   a. Get size of current level
   b. Process all nodes in current level
   c. Add children to queue for next level
   d. Store level values in result
3. Return result list
```

## Key Insights

- **BFS**: Natural approach for level-order traversal
- **Queue**: Use queue to maintain level order
- **Level Size**: Track number of nodes in each level
- **Result Structure**: List of lists for each level

## Alternative Approaches

1. **DFS**: Use DFS with level tracking
2. **Two Queues**: Use two queues for current and next level
3. **Recursive**: Use recursion with level parameter

## Edge Cases

- Empty tree: Return empty list
- Single node: Return single level
- Left-skewed tree: Handle appropriately
- Right-skewed tree: Handle appropriately

## Applications

- Tree traversal
- Algorithm design patterns
- Interview preparation
- Data structure operations
- System design

## Optimization Opportunities

- **BFS**: Most efficient approach
- **Single Pass**: O(n) time complexity
- **Queue**: O(w) space complexity
- **Level Tracking**: Efficient level processing
