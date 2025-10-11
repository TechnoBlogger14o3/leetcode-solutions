# Lowest Common Ancestor of a Binary Search Tree

## Problem Statement

Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: "The lowest common ancestor is defined between two nodes `p` and `q` as the lowest node in `T` that has both `p` and `q` as descendants (where we allow a node to be a descendant of itself)."

## Examples

**Example 1:**
```
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.
```

**Example 2:**
```
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2.
```

## Approach

### Method 1: BST Property (Recommended)
1. Use BST property: left < root < right
2. If both nodes are smaller, go left
3. If both nodes are larger, go right
4. Otherwise, current node is LCA

**Time Complexity:** O(h) - Height of tree
**Space Complexity:** O(1) - Only uses constant extra space

### Method 2: Recursive DFS
1. Use recursive approach with BST property
2. Base case: if current node is null or equals p or q
3. Recursively search left or right based on values

**Time Complexity:** O(h) - Height of tree
**Space Complexity:** O(h) - Height of tree (recursion stack)

## Algorithm

```
1. While current node is not null:
   a. If both p and q are smaller: go left
   b. If both p and q are larger: go right
   c. Otherwise: return current node
```

## Key Insights

- **BST Property**: Use ordering property of BST
- **Single Path**: Only one path needs to be explored
- **Early Termination**: Stop when LCA found
- **No Backtracking**: No need to backtrack

## Alternative Approaches

1. **Recursive**: Use recursion with BST property
2. **Iterative**: Use iterative approach
3. **Path Finding**: Find paths to both nodes and compare

## Edge Cases

- One node is ancestor of other: Handle appropriately
- Nodes are same: Handle appropriately
- Empty tree: Handle appropriately
- Single node: Handle appropriately

## Applications

- Tree algorithms
- Algorithm design patterns
- Interview preparation
- Data structure operations
- System design

## Optimization Opportunities

- **BST Property**: Most efficient approach
- **Single Path**: O(h) time complexity
- **Constant Space**: O(1) space complexity
- **No Extra Storage**: No need for additional data structures
