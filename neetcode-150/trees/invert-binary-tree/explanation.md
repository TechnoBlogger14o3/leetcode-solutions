# Invert Binary Tree

## Problem Statement

Given the root of a binary tree, invert the tree, and return its root.

## Examples

**Example 1:**
```
Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]
```

**Example 2:**
```
Input: root = [2,1,3]
Output: [2,3,1]
```

## Approach

### Method 1: Recursive (Recommended)
1. Base case: if root is null, return null
2. Recursively invert left and right subtrees
3. Swap left and right children
4. Return root

**Time Complexity:** O(n) - Visit each node once
**Space Complexity:** O(h) - Height of tree (recursion stack)

### Method 2: Iterative
1. Use queue to process nodes level by level
2. For each node, swap its children
3. Add children to queue for processing

**Time Complexity:** O(n) - Visit each node once
**Space Complexity:** O(w) - Maximum width of tree

## Algorithm

```
1. If root is null: return null
2. Recursively invert left subtree
3. Recursively invert right subtree
4. Swap left and right children
5. Return root
```

## Key Insights

- **Recursive**: Natural approach for tree problems
- **Swap Children**: Simply swap left and right pointers
- **Post-order**: Process children before parent
- **Base Case**: Handle null nodes

## Alternative Approaches

1. **Iterative**: Use queue for level-order processing
2. **Stack**: Use stack for iterative processing
3. **Morris**: Use Morris traversal

## Edge Cases

- Empty tree: Return null
- Single node: Return that node
- Left-skewed tree: Handle appropriately
- Right-skewed tree: Handle appropriately

## Applications

- Tree manipulation
- Algorithm design patterns
- Interview preparation
- Data structure operations
- System design

## Optimization Opportunities

- **Recursive**: Most intuitive approach
- **In-place**: O(1) extra space per node
- **Single Pass**: O(n) time complexity
- **Memory Efficient**: Only recursion stack
