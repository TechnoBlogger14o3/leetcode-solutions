# Same Tree

## Problem Statement

Given the roots of two binary trees `p` and `q`, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

## Examples

**Example 1:**
```
Input: p = [1,2,3], q = [1,2,3]
Output: true
```

**Example 2:**
```
Input: p = [1,2], q = [1,null,2]
Output: false
```

## Approach

### Method 1: Recursive DFS (Recommended)
1. Base case: if both nodes are null, return true
2. If one is null and other is not, return false
3. If values are different, return false
4. Recursively check left and right subtrees

**Time Complexity:** O(min(m,n)) - Visit each node once
**Space Complexity:** O(min(m,n)) - Height of smaller tree

### Method 2: Iterative BFS
1. Use queue to process nodes level by level
2. Compare nodes at each level
3. Add children to queue for processing

**Time Complexity:** O(min(m,n)) - Visit each node once
**Space Complexity:** O(min(m,n)) - Maximum width of smaller tree

## Algorithm

```
1. If both nodes are null: return true
2. If one is null and other is not: return false
3. If values are different: return false
4. Return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
```

## Key Insights

- **Recursive**: Natural approach for tree problems
- **Base Cases**: Handle null nodes appropriately
- **Value Comparison**: Check node values
- **Structure Check**: Check left and right subtrees

## Alternative Approaches

1. **BFS**: Use queue for level-order traversal
2. **DFS**: Use stack for iterative depth-first
3. **Serialization**: Convert trees to strings and compare

## Edge Cases

- Both null: Return true
- One null: Return false
- Different values: Return false
- Different structures: Return false

## Applications

- Tree comparison
- Algorithm design patterns
- Interview preparation
- Data structure operations
- System design

## Optimization Opportunities

- **Recursive**: Most intuitive approach
- **Early Termination**: Stop when difference found
- **Single Pass**: O(min(m,n)) time complexity
- **Memory Efficient**: Only recursion stack
