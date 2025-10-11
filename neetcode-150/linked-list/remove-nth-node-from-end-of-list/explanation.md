# Remove Nth Node From End of List

## Problem Statement

Given the head of a linked list, remove the nth node from the end of the list and return its head.

## Examples

**Example 1:**
```
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
```

**Example 2:**
```
Input: head = [1], n = 1
Output: []
```

## Approach

### Method 1: Two Pointers (Recommended)
1. Use two pointers: first and second
2. Move first pointer n steps ahead
3. Move both pointers until first reaches end
4. Remove node after second pointer

**Time Complexity:** O(n) - Single pass through list
**Space Complexity:** O(1) - Only uses constant extra space

### Method 2: Two Pass
1. First pass: count total nodes
2. Second pass: remove (count - n)th node

**Time Complexity:** O(n) - Two passes through list
**Space Complexity:** O(1) - Only uses constant extra space

## Algorithm

```
1. Create dummy node and point to head
2. Move first pointer n steps ahead
3. Move both pointers until first reaches end
4. Remove node after second pointer
5. Return dummy.next
```

## Key Insights

- **Two Pointers**: First and second pointer technique
- **Dummy Node**: Simplifies edge cases
- **Gap Maintenance**: Maintain n gap between pointers
- **Node Removal**: Remove node after second pointer

## Alternative Approaches

1. **Two Pass**: Count nodes first, then remove
2. **Stack**: Use stack to track nodes
3. **Recursive**: Use recursion to count from end

## Edge Cases

- Remove head node: Handle with dummy node
- Single node: Return null
- Remove last node: Handle appropriately
- n > list length: Handle invalid input

## Applications

- Linked list manipulation
- Algorithm design patterns
- Interview preparation
- Data structure operations
- System design

## Optimization Opportunities

- **Two Pointers**: Most efficient approach
- **Single Pass**: O(n) time complexity
- **Dummy Node**: Simplifies implementation
- **Memory Efficient**: O(1) space complexity
