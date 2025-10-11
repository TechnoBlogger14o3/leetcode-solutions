# Single Number

## Problem Statement

Given a non-empty array of integers `nums`, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

## Examples

**Example 1:**
```
Input: nums = [2,2,1]
Output: 1
```

## Approach

### Method 1: XOR Operation (Recommended)
1. Use XOR properties: a ^ a = 0, a ^ 0 = a
2. XOR all elements in the array
3. Result is the single number
4. Most efficient approach

**Time Complexity:** O(n) - Single pass
**Space Complexity:** O(1) - No extra space

### Method 2: Hash Set
1. Use hash set to track seen numbers
2. Remove when seen twice
3. Less efficient than XOR approach

**Time Complexity:** O(n) - Single pass
**Space Complexity:** O(n) - Hash set

## Algorithm

```
1. Initialize result = 0
2. For each num in nums:
   a. result = result ^ num
3. Return result
```

## Key Insights

- **XOR Properties**: a ^ a = 0, a ^ 0 = a
- **Local Optimum**: XOR all elements efficiently
- **Global Optimum**: Find single number
- **Space Optimization**: Use only necessary space

## Alternative Approaches

1. **Hash Set**: Use hash set for tracking
2. **Mathematical**: Use sum properties
3. **Sorting**: Sort and find single number

## Edge Cases

- Single element: Return that element
- Two elements: Return the single one
- Large arrays: Handle efficiently
- Negative numbers: Handle appropriately

## Applications

- Bit manipulation
- Array algorithms
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **XOR Operation**: Most efficient approach
- **Space Optimization**: O(1) space complexity
- **Linear Time**: O(n) time complexity
- **No Extra Space**: Use only necessary space
