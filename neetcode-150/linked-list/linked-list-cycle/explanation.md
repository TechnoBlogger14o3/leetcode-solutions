# Linked List Cycle

## Problem Statement

Given `head`, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the `next` pointer. Internally, `pos` is used to denote the index of the node that tail's `next` pointer is connected to. **Note that `pos` is not passed as a parameter.**

Return `true` if there is a cycle in the linked list. Otherwise, return `false`.

## Examples

**Example 1:**
```
Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
```

**Example 2:**
```
Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
```

## Approach

### Method 1: Floyd's Cycle Detection (Two Pointers) (Recommended)
1. Use two pointers: slow and fast
2. Slow moves one step, fast moves two steps
3. If cycle exists, fast will eventually meet slow
4. If no cycle, fast will reach end

**Time Complexity:** O(n) - Linear time
**Space Complexity:** O(1) - Only uses constant extra space

### Method 2: Hash Set
1. Use HashSet to store visited nodes
2. If we encounter a node already in set, cycle exists
3. If we reach end, no cycle

**Time Complexity:** O(n) - Linear time
**Space Complexity:** O(n) - Store all nodes

## Algorithm

```
1. Initialize slow = head, fast = head
2. While fast != null and fast.next != null:
   a. Move slow one step: slow = slow.next
   b. Move fast two steps: fast = fast.next.next
   c. If slow == fast: return true (cycle found)
3. Return false (no cycle)
```

## Key Insights

- **Two Pointers**: Slow and fast pointer technique
- **Cycle Detection**: Fast pointer catches up to slow pointer
- **Mathematical Proof**: If cycle exists, they will meet
- **Efficient**: O(1) space complexity

## Alternative Approaches

1. **Hash Set**: Store visited nodes
2. **Marking**: Mark visited nodes
3. **Length Calculation**: Calculate cycle length

## Edge Cases

- Empty list: Return false
- Single node: Return false
- Single node with self-cycle: Return true
- No cycle: Return false
- Cycle at beginning: Handle appropriately

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
