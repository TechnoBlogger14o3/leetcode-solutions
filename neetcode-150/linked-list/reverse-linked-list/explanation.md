# Reverse Linked List

## Problem Statement

Given the head of a singly linked list, reverse the list, and return the reversed list.

## Examples

**Example 1:**
```
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
```

**Example 2:**
```
Input: head = [1,2]
Output: [2,1]
```

## Approach

### Method 1: Iterative (Recommended)
1. Use three pointers: prev, current, next
2. Reverse links while traversing
3. Update pointers in each iteration
4. Return new head (prev)

**Time Complexity:** O(n) - Single pass through list
**Space Complexity:** O(1) - Only uses constant extra space

### Method 2: Recursive
1. Use recursion to reverse remaining list
2. Reverse current node's link
3. Return new head

**Time Complexity:** O(n) - Recursive calls
**Space Complexity:** O(n) - Recursion stack

## Algorithm

```
1. Initialize prev = null, current = head
2. While current != null:
   a. Store next = current.next
   b. Reverse link: current.next = prev
   c. Move pointers: prev = current, current = next
3. Return prev (new head)
```

## Key Insights

- **Three Pointers**: prev, current, next for safe reversal
- **Link Reversal**: Change direction of each link
- **Pointer Movement**: Move all pointers forward
- **New Head**: Last node becomes new head

## Alternative Approaches

1. **Recursive**: Use recursion to reverse
2. **Stack**: Use stack to reverse order
3. **Array**: Convert to array, reverse, rebuild

## Edge Cases

- Empty list: Return null
- Single node: Return that node
- Two nodes: Reverse and return
- Long list: Handle efficiently

## Applications

- Linked list manipulation
- Algorithm design patterns
- Interview preparation
- Data structure operations
- System design

## Optimization Opportunities

- **Iterative**: Most efficient approach
- **In-place**: O(1) space complexity
- **Single Pass**: O(n) time complexity
- **Memory Efficient**: No extra data structures
