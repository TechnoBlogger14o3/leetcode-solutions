# Subtree of Another Tree

## Problem Statement

Given the roots of two binary trees `root` and `subRoot`, return `true` if there is a subtree of `root` with the same structure and node values of `subRoot` and `false` otherwise.

A subtree of a binary tree `tree` is a tree that consists of a node in `tree` and all of this node's descendants. The tree `tree` could also be considered as a subtree of itself.

## Examples

**Example 1:**
```
Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true
```

**Example 2:**
```
Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false
```

## Approach

### Method 1: Recursive DFS (Recommended)
1. For each node in root, check if it matches subRoot
2. Use helper function to check if two trees are identical
3. Recursively check left and right subtrees

**Time Complexity:** O(m*n) - For each node in root, check subRoot
**Space Complexity:** O(h) - Height of root tree

### Method 2: Serialization
1. Convert both trees to strings
2. Check if subRoot string is substring of root string
3. Use special markers for null nodes

**Time Complexity:** O(m+n) - Serialize both trees
**Space Complexity:** O(m+n) - Store serialized strings

## Algorithm

```
1. If root is null: return false
2. If isSameTree(root, subRoot): return true
3. Return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
```

## Key Insights

- **Recursive**: Check each node as potential root
- **Same Tree**: Use previous same tree logic
- **OR Logic**: Check left or right subtree
- **Base Case**: Handle null nodes

## Alternative Approaches

1. **Serialization**: Convert to strings and check substring
2. **Iterative**: Use iterative approach with stack
3. **Two Passes**: First pass for potential roots, second for comparison

## Edge Cases

- Empty subRoot: Return true
- Empty root: Return false
- Single node: Handle appropriately
- Identical trees: Handle appropriately

## Applications

- Tree comparison
- Algorithm design patterns
- Interview preparation
- Data structure operations
- System design

## Optimization Opportunities

- **Recursive**: Most intuitive approach
- **Early Termination**: Stop when match found
- **Single Pass**: O(m*n) time complexity
- **Memory Efficient**: Only recursion stack
