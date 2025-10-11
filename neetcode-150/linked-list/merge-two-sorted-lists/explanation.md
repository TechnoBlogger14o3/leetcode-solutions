# Merge Two Sorted Lists

## Problem Statement

You are given the heads of two sorted linked lists `list1` and `list2`.

Merge the two lists in a one **sorted** list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

## Examples

**Example 1:**
```
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
```

**Example 2:**
```
Input: list1 = [], list2 = []
Output: []
```

## Approach

### Method 1: Iterative (Recommended)
1. Use dummy node to simplify edge cases
2. Compare nodes from both lists
3. Link smaller node to result
4. Move pointer of the list with smaller node
5. Link remaining nodes

**Time Complexity:** O(m+n) - Process all nodes
**Space Complexity:** O(1) - Only uses constant extra space

### Method 2: Recursive
1. Use recursion to merge lists
2. Compare first nodes of both lists
3. Recursively merge remaining lists

**Time Complexity:** O(m+n) - Process all nodes
**Space Complexity:** O(m+n) - Recursion stack

## Algorithm

```
1. Create dummy node and current pointer
2. While both lists have nodes:
   a. Compare values of current nodes
   b. Link smaller node to result
   c. Move pointer of the list with smaller node
3. Link remaining nodes from non-empty list
4. Return dummy.next
```

## Key Insights

- **Dummy Node**: Simplifies edge cases
- **Two Pointers**: Track current position in both lists
- **Comparison**: Always choose smaller value
- **Remaining Nodes**: Link remaining nodes directly

## Alternative Approaches

1. **Recursive**: Use recursion for merging
2. **In-place**: Merge without extra space
3. **Array**: Convert to arrays, merge, rebuild

## Edge Cases

- Empty lists: Return empty list
- One empty list: Return other list
- Single nodes: Handle appropriately
- All same values: Handle duplicates

## Applications

- Merge algorithms
- Linked list manipulation
- Algorithm design patterns
- Interview preparation
- Data structure operations

## Optimization Opportunities

- **Iterative**: Most efficient approach
- **Dummy Node**: Simplifies implementation
- **In-place**: O(1) space complexity
- **Single Pass**: O(m+n) time complexity
