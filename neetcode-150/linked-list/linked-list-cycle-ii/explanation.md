# Linked List Cycle II

## Problem Statement

Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return `null`.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the `next` pointer. Internally, `pos` is used to denote the index of the node that tail's `next` pointer is connected to. **Note that `pos` is not passed as a parameter.**

Notice that you **should not modify** the linked list.

## Examples

**Example 1:**
```
Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the 1st node (0-indexed).
```

**Example 2:**
```
Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the 0th node.
```

## Approach

### Method 1: Floyd's Cycle Detection (Two Pointers) (Recommended)
1. Use two pointers: slow and fast
2. Find meeting point (cycle detection)
3. Reset one pointer to head
4. Move both pointers one step until they meet

**Time Complexity:** O(n) - Linear time
**Space Complexity:** O(1) - Only uses constant extra space

### Method 2: Hash Set
1. Use HashSet to store visited nodes
2. If we encounter a node already in set, cycle exists
3. Return the first repeated node

**Time Complexity:** O(n) - Linear time
**Space Complexity:** O(n) - Store all nodes

## Algorithm

```
1. Find meeting point using slow/fast pointers
2. If no meeting point, return null
3. Reset one pointer to head
4. Move both pointers one step until they meet
5. Return meeting point (cycle start)
```

## Key Insights

- **Two Pointers**: Slow and fast pointer technique
- **Cycle Detection**: Find meeting point first
- **Mathematical Proof**: Distance from head to cycle start
- **Reset Pointer**: Reset one pointer to head

## Alternative Approaches

1. **Hash Set**: Store visited nodes
2. **Marking**: Mark visited nodes
3. **Length Calculation**: Calculate cycle length

## Edge Cases

- No cycle: Return null
- Cycle at head: Handle appropriately
- Single node: Return null
- Two nodes: Handle appropriately

## Applications

- Cycle detection algorithms
- Algorithm design patterns
- Interview preparation
- Data structure analysis
- System design

## Optimization Opportunities

- **Floyd's Algorithm**: Most efficient approach
- **Two Pointers**: O(1) space complexity
- **Single Pass**: O(n) time complexity
- **Memory Efficient**: No extra data structures
