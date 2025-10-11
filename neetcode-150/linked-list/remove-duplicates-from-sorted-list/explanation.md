# Remove Duplicates From Sorted List

## Problem Statement

Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

## Examples

**Example 1:**
```
Input: head = [1,1,2]
Output: [1,2]
```

**Example 2:**
```
Input: head = [1,1,2,3,3]
Output: [1,2,3]
```

## Approach

### Method 1: Two Pointers (Recommended)
1. Use current pointer to traverse list
2. Compare current node with next node
3. If values are same, skip next node
4. If values are different, move current pointer

**Time Complexity:** O(n) - Single pass through list
**Space Complexity:** O(1) - Only uses constant extra space

### Method 2: Recursive
1. Use recursion to handle remaining list
2. Compare current node with next node
3. Recursively process remaining nodes

**Time Complexity:** O(n) - Recursive calls
**Space Complexity:** O(n) - Recursion stack

## Algorithm

```
1. Initialize current = head
2. While current != null and current.next != null:
   a. If current.val == current.next.val:
      - Skip next node: current.next = current.next.next
   b. Else:
      - Move current: current = current.next
3. Return head
```

## Key Insights

- **Two Pointers**: Current and next pointer technique
- **Sorted List**: Duplicates are adjacent
- **Skip Nodes**: Skip duplicate nodes
- **In-place**: Modify existing list

## Alternative Approaches

1. **Recursive**: Use recursion for processing
2. **Hash Set**: Use set to track seen values
3. **New List**: Create new list without duplicates

## Edge Cases

- Empty list: Return null
- Single node: Return that node
- All same values: Return single node
- No duplicates: Return original list

## Applications

- Data cleaning
- Linked list manipulation
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **Two Pointers**: Most efficient approach
- **In-place**: O(1) space complexity
- **Single Pass**: O(n) time complexity
- **Memory Efficient**: No extra data structures
