# Copy List With Random Pointer

## Problem Statement

A linked list of length `n` is given such that each node contains an additional random pointer, which could point to any node in the list, or `null`.

Construct a **deep copy** of the list. The deep copy should consist of exactly `n` brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the `next` and `random` pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

Return the head of the copied linked list.

## Examples

**Example 1:**
```
Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
```

**Example 2:**
```
Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]
```

## Approach

### Method 1: HashMap (Recommended)
1. First pass: Create all new nodes and store mapping
2. Second pass: Set next and random pointers using mapping

**Time Complexity:** O(n) - Two passes through list
**Space Complexity:** O(n) - Store mapping of all nodes

### Method 2: In-place
1. Insert new nodes between original nodes
2. Set random pointers
3. Separate original and copied lists

**Time Complexity:** O(n) - Three passes through list
**Space Complexity:** O(1) - Only uses constant extra space

## Algorithm

```
1. First pass: Create new nodes and store mapping
2. Second pass: Set next and random pointers
3. Return head of copied list
```

## Key Insights

- **Deep Copy**: Create completely new nodes
- **Random Pointers**: Handle random pointer mapping
- **Two Passes**: First create nodes, then set pointers
- **HashMap**: Store mapping between original and new nodes

## Alternative Approaches

1. **In-place**: Insert new nodes between original nodes
2. **Recursive**: Use recursion for copying
3. **Stack**: Use stack for processing

## Edge Cases

- Empty list: Return null
- Single node: Handle appropriately
- Random pointer to null: Handle null case
- Random pointer to self: Handle self-reference

## Applications

- Deep copying
- Linked list manipulation
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **HashMap**: Most straightforward approach
- **In-place**: O(1) space complexity
- **Two Passes**: O(n) time complexity
- **Memory Efficient**: Choose appropriate approach
