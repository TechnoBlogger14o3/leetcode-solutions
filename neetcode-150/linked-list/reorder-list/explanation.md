# Reorder List

## Problem Statement

You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln

Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

You may not modify the values in the list's nodes. Only nodes themselves may be changed.

## Examples

**Example 1:**
```
Input: head = [1,2,3,4]
Output: [1,4,2,3]
```

**Example 2:**
```
Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]
```

## Approach

### Method 1: Three Steps (Recommended)
1. Find middle of list using slow/fast pointers
2. Reverse second half of list
3. Merge two halves alternately

**Time Complexity:** O(n) - Three passes through list
**Space Complexity:** O(1) - Only uses constant extra space

### Method 2: Array
1. Convert list to array
2. Reorder array elements
3. Rebuild list from array

**Time Complexity:** O(n) - Single pass through list
**Space Complexity:** O(n) - Store all nodes

## Algorithm

```
1. Find middle using slow/fast pointers
2. Reverse second half
3. Merge two halves alternately:
   a. Link first half node
   b. Link second half node
   c. Move to next nodes
```

## Key Insights

- **Three Steps**: Find middle, reverse, merge
- **Slow/Fast Pointers**: Find middle efficiently
- **Reverse**: Reverse second half
- **Merge**: Alternate between halves

## Alternative Approaches

1. **Array**: Convert to array, reorder, rebuild
2. **Stack**: Use stack for second half
3. **Recursive**: Use recursion for merging

## Edge Cases

- Empty list: Return null
- Single node: Return that node
- Two nodes: Return as is
- Odd length: Handle middle node

## Applications

- Linked list manipulation
- Algorithm design patterns
- Interview preparation
- Data structure operations
- System design

## Optimization Opportunities

- **Three Steps**: Most efficient approach
- **In-place**: O(1) space complexity
- **Single Pass**: O(n) time complexity
- **Memory Efficient**: No extra data structures
