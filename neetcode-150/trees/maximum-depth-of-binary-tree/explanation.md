# Maximum Depth of Binary Tree

## Problem Statement

Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

## Examples

**Example 1:**
```
Input: root = [3,9,20,null,null,15,7]
Output: 3
```

**Example 2:**
```
Input: root = [1,null,2]
Output: 2
```

## Approach

### Method 1: Recursive DFS (Recommended)
1. Base case: if root is null, return 0
2. Recursively calculate depth of left and right subtrees
3. Return 1 + maximum of left and right depths

**Time Complexity:** O(n) - Visit each node once
**Space Complexity:** O(h) - Height of tree (recursion stack)

### Method 2: Iterative BFS
1. Use queue for level-order traversal
2. Count levels as we traverse
3. Return level count

**Time Complexity:** O(n) - Visit each node once
**Space Complexity:** O(w) - Maximum width of tree

## Algorithm

```
1. If root is null: return 0
2. Calculate left depth = maxDepth(root.left)
3. Calculate right depth = maxDepth(root.right)
4. Return 1 + max(left depth, right depth)
```

## Key Insights

- **Recursive**: Natural approach for tree problems
- **Post-order**: Process children before parent
- **Base Case**: Handle null nodes
- **Maximum**: Take maximum of left and right depths

## Alternative Approaches

1. **BFS**: Use queue for level-order traversal
2. **DFS**: Use stack for iterative depth-first
3. **Morris**: Use Morris traversal

## Edge Cases

- Empty tree: Return 0
- Single node: Return 1
- Left-skewed tree: Handle appropriately
- Right-skewed tree: Handle appropriately

## Applications

- Tree analysis
- Algorithm design patterns
- Interview preparation
- Data structure operations
- System design

## Optimization Opportunities

- **Recursive**: Most intuitive approach
- **In-place**: O(1) extra space per node
- **Single Pass**: O(n) time complexity
- **Memory Efficient**: Only recursion stack
