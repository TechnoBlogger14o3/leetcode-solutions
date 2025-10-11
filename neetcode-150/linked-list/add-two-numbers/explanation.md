# Add Two Numbers

## Problem Statement

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

## Examples

**Example 1:**
```
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
```

**Example 2:**
```
Input: l1 = [0], l2 = [0]
Output: [0]
```

## Approach

### Method 1: Iterative (Recommended)
1. Use dummy node to simplify edge cases
2. Traverse both lists simultaneously
3. Add digits and carry
4. Create new nodes for result

**Time Complexity:** O(max(m,n)) - Process all nodes
**Space Complexity:** O(max(m,n)) - Store result

### Method 2: Recursive
1. Use recursion to add remaining digits
2. Handle carry in recursive calls
3. Create new nodes for result

**Time Complexity:** O(max(m,n)) - Recursive calls
**Space Complexity:** O(max(m,n)) - Recursion stack

## Algorithm

```
1. Create dummy node and current pointer
2. While l1 != null or l2 != null or carry != 0:
   a. Calculate sum = val1 + val2 + carry
   b. Create new node with sum % 10
   c. Update carry = sum / 10
   d. Move pointers
3. Return dummy.next
```

## Key Insights

- **Reverse Order**: Digits stored in reverse order
- **Carry Handling**: Handle carry from addition
- **Dummy Node**: Simplifies edge cases
- **Simultaneous Traversal**: Process both lists together

## Alternative Approaches

1. **Recursive**: Use recursion for addition
2. **Convert to Numbers**: Convert to integers, add, convert back
3. **Stack**: Use stack for processing

## Edge Cases

- Different lengths: Handle shorter list
- Carry at end: Handle final carry
- Empty lists: Handle null cases
- Single digits: Handle appropriately

## Applications

- Big integer arithmetic
- Linked list manipulation
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **Iterative**: Most efficient approach
- **Dummy Node**: Simplifies implementation
- **Single Pass**: O(max(m,n)) time complexity
- **Memory Efficient**: Only store result
