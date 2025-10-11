# Min Stack

## Problem Statement

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the `MinStack` class:

- `MinStack()` initializes the stack object.
- `void push(int val)` pushes the element `val` onto the stack.
- `void pop()` removes the element on the top of the stack.
- `int top()` gets the top element of the stack.
- `int getMin()` retrieves the minimum element in the stack.

You must implement a solution with `O(1)` time complexity for each function.

## Examples

**Example 1:**
```
Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
```

## Approach

### Method 1: Two Stacks (Recommended)
1. Use main stack for all elements
2. Use min stack to track minimum at each level
3. Push minimum to min stack when new minimum found
4. Pop from both stacks simultaneously

**Time Complexity:** O(1) for all operations
**Space Complexity:** O(n) - Two stacks

### Method 2: Single Stack with Pairs
1. Store pairs of (value, minimum) in single stack
2. Each element knows minimum up to that point
3. More memory efficient but same complexity

**Time Complexity:** O(1) for all operations
**Space Complexity:** O(n) - Single stack with pairs

## Algorithm

```
Push:
1. Push value to main stack
2. If min stack is empty or value <= current minimum:
   - Push value to min stack

Pop:
1. Pop from main stack
2. If popped value equals min stack top:
   - Pop from min stack

Top:
1. Return top of main stack

GetMin:
1. Return top of min stack
```

## Key Insights

- **Two Stacks**: Separate tracking of values and minimums
- **Minimum Tracking**: Only push to min stack when new minimum
- **Constant Time**: All operations O(1)
- **Duplicate Handling**: Handle duplicate minimum values

## Alternative Approaches

1. **Single Stack**: Store pairs (value, min)
2. **Linked List**: Custom node structure
3. **Array**: Use arrays instead of stacks

## Edge Cases

- Empty stack: Handle getMin() and top() on empty stack
- Duplicate minimums: Push duplicates to min stack
- Single element: Minimum is the only element
- All same values: Minimum remains constant

## Applications

- Data structure design
- Algorithm optimization
- Interview preparation
- System design
- Performance-critical applications

## Optimization Opportunities

- **Two Stacks**: Most straightforward approach
- **Memory Efficient**: Single stack with pairs
- **Constant Time**: All operations O(1)
- **Duplicate Handling**: Efficient minimum tracking
