# Last Stone Weight

## Problem Statement

We have a collection of stones, each with a positive integer weight.

Each turn, we choose the two heaviest stones and smash them together. Suppose the stones have weights `x` and `y` with `x <= y`. The result of this smash is:

- If `x == y`, both stones are totally destroyed;
- If `x != y`, the stone of weight `x` is totally destroyed, and the stone of weight `y` has new weight `y - x`.

At the end, there is at most 1 stone left. Return the weight of this stone (or 0 if there are no stones left.)

## Examples

**Example 1:**
```
Input: stones = [2,7,4,1,8,1]
Output: 1
Explanation: 
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
```

## Approach

### Method 1: Max Heap (Recommended)
1. Use max heap to store all stones
2. Repeatedly extract two largest stones
3. If weights are different, add difference back to heap
4. Continue until heap has at most one stone

**Time Complexity:** O(n log n) - n operations, each O(log n)
**Space Complexity:** O(n) - Heap size

### Method 2: Sorting
1. Sort stones in descending order
2. Repeatedly smash two largest stones
3. Insert result back in sorted position
4. Less efficient than heap

**Time Complexity:** O(n² log n) - n operations, each O(n log n)
**Space Complexity:** O(1) - In-place sorting

## Algorithm

```
1. Add all stones to max heap
2. While heap size > 1:
   a. Extract two largest stones
   b. If weights are different, add difference to heap
3. Return remaining stone weight (or 0 if empty)
```

## Key Insights

- **Max Heap**: Efficiently get two largest elements
- **Smashing Logic**: Handle equal and different weights
- **Iterative Process**: Continue until at most one stone
- **Efficient**: O(n log n) time complexity

## Alternative Approaches

1. **Sorting**: Use sorting with insertion
2. **Priority Queue**: Use priority queue
3. **Simulation**: Simulate the process step by step

## Edge Cases

- Single stone: Return that stone's weight
- Two equal stones: Return 0
- All stones equal: Return 0
- Empty array: Return 0

## Applications

- Game simulation
- Algorithm design patterns
- Interview preparation
- Data structure operations
- System design

## Optimization Opportunities

- **Max Heap**: Most efficient approach
- **Logarithmic Operations**: O(log n) per operation
- **Single Pass**: Process all stones once
- **Memory Efficient**: O(n) space complexity
