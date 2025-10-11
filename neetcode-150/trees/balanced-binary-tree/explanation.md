# Balanced Binary Tree

## Problem Statement

Given a binary tree, determine if it is height-balanced.

A height-balanced binary tree is defined as:
- A binary tree in which the left and right subtrees of every node differ in height by no more than 1.

## Examples

**Example 1:**
```
Input: root = [3,9,20,null,null,15,7]
Output: true
```

**Example 2:**
```
Input: root = [1,2,2,3,3,null,null,4,4]
Output: false
```

## Approach

### Method 1: Bottom-up DFS (Recommended)
1. Use DFS to calculate height of each node
2. If height difference > 1, return -1 (unbalanced)
3. Otherwise return actual height
4. Check if final result is -1

**Time Complexity:** O(n) - Visit each node once
**Space Complexity:** O(h) - Height of tree (recursion stack)

### Method 2: Top-down DFS
1. Calculate height of each node
2. Check if current node is balanced
3. Recursively check left and right subtrees

**Time Complexity:** O(n²) - Calculate height for each node
**Space Complexity:** O(h) - Height of tree (recursion stack)

## Algorithm

```
1. DFS function:
   a. If node is null: return 0
   b. Calculate left height = DFS(node.left)
   c. Calculate right height = DFS(node.right)
   d. If left or right is -1: return -1
   e. If |left - right| > 1: return -1
   f. Return 1 + max(left, right)
2. Return DFS(root) != -1
```

## Key Insights

- **Bottom-up**: More efficient than top-down
- **Early Termination**: Return -1 for unbalanced subtrees
- **Height Difference**: Check if difference > 1
- **Single Pass**: Calculate height and check balance together

## Alternative Approaches

1. **Top-down**: Check balance at each node
2. **Iterative**: Use iterative approach with stack
3. **Two Passes**: First pass for heights, second for balance

## Edge Cases

- Empty tree: Return true
- Single node: Return true
- Linear tree: Handle appropriately
- Balanced tree: Handle appropriately

## Applications

- Tree analysis
- Algorithm design patterns
- Interview preparation
- Data structure operations
- System design

## Optimization Opportunities

- **Bottom-up**: Most efficient approach
- **Early Termination**: Stop when unbalanced found
- **Single Pass**: O(n) time complexity
- **Memory Efficient**: Only recursion stack
