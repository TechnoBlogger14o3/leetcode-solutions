# Missing Number

## Problem Statement

Given an array `nums` containing `n` distinct numbers in the range `[0, n]`, return the only number in the range that is missing from the array.

## Examples

**Example 1:**
```
Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
```

## Approach

### Method 1: Mathematical Sum (Recommended)
1. Calculate expected sum: n * (n + 1) / 2
2. Calculate actual sum of array
3. Return difference
4. Most efficient approach

**Time Complexity:** O(n) - Single pass
**Space Complexity:** O(1) - No extra space

### Method 2: XOR Operation
1. Use XOR properties: a ^ a = 0, a ^ 0 = a
2. XOR all numbers from 0 to n with array elements
3. Less efficient than mathematical approach

**Time Complexity:** O(n) - Single pass
**Space Complexity:** O(1) - No extra space

## Algorithm

```
1. Calculate expected sum = n * (n + 1) / 2
2. Calculate actual sum = sum of array elements
3. Return expected sum - actual sum
```

## Key Insights

- **Mathematical Sum**: Use arithmetic progression formula
- **Local Optimum**: Calculate sum efficiently
- **Global Optimum**: Find missing number
- **Space Optimization**: Use only necessary space

## Alternative Approaches

1. **XOR Operation**: Use XOR properties
2. **Sorting**: Sort and find missing number
3. **Hash Set**: Use hash set for lookup

## Edge Cases

- Single element: Handle appropriately
- Two elements: Handle appropriately
- Large arrays: Handle efficiently
- Empty array: Handle appropriately

## Applications

- Mathematical algorithms
- Array manipulation
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **Mathematical Sum**: Most efficient approach
- **Space Optimization**: O(1) space complexity
- **Linear Time**: O(n) time complexity
- **No Extra Space**: Use only necessary space
