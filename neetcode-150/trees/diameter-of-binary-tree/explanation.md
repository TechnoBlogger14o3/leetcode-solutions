# Diameter of Binary Tree

## Problem Statement

Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

## Examples

**Example 1:**
```
Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
```

**Example 2:**
```
Input: root = [1,2]
Output: 1
```

## Approach

### Method 1: DFS with Global Variable (Recommended)
1. Use DFS to calculate height of each node
2. For each node, calculate diameter passing through it
3. Update global maximum diameter
4. Return height of current node

**Time Complexity:** O(n) - Visit each node once
**Space Complexity:** O(h) - Height of tree (recursion stack)

### Method 2: Return Both Height and Diameter
1. Return both height and diameter from each recursive call
2. Calculate diameter for each node
3. Return maximum diameter

**Time Complexity:** O(n) - Visit each node once
**Space Complexity:** O(h) - Height of tree (recursion stack)

## Algorithm

```
1. Initialize global maxDiameter = 0
2. DFS function:
   a. If node is null: return 0
   b. Calculate left height = DFS(node.left)
   c. Calculate right height = DFS(node.right)
   d. Update maxDiameter = max(maxDiameter, left + right)
   e. Return 1 + max(left, right)
```

## Key Insights

- **Global Variable**: Track maximum diameter across all nodes
- **Height Calculation**: Calculate height of each subtree
- **Diameter**: Sum of left and right heights
- **Post-order**: Process children before parent

## Alternative Approaches

1. **Return Both**: Return height and diameter from each call
2. **Two Passes**: First pass for heights, second for diameter
3. **Iterative**: Use iterative approach with stack

## Edge Cases

- Empty tree: Return 0
- Single node: Return 0
- Linear tree: Handle appropriately
- Balanced tree: Handle appropriately

## Applications

- Tree analysis
- Algorithm design patterns
- Interview preparation
- Data structure operations
- System design

## Optimization Opportunities

- **DFS**: Most efficient approach
- **Global Variable**: Simple tracking
- **Single Pass**: O(n) time complexity
- **Memory Efficient**: Only recursion stack
