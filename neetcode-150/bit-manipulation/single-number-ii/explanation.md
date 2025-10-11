# Single Number II

## Problem Statement

Given an integer array `nums` where every element appears three times except for one, which appears exactly once. Find the single element and return it.

You must implement a solution with a linear runtime complexity and use only constant extra space.

## Examples

**Example 1:**
```
Input: nums = [2,2,3,2]
Output: 3
```

## Approach

### Method 1: Bit Manipulation (Recommended)
1. Use bit manipulation to count bits
2. For each bit position, count occurrences
3. If count % 3 != 0, set that bit in result
4. Most efficient approach

**Time Complexity:** O(n) - Single pass
**Space Complexity:** O(1) - No extra space

### Method 2: Hash Map
1. Use hash map to count occurrences
2. Find element with count 1
3. Less efficient than bit manipulation

**Time Complexity:** O(n) - Single pass
**Space Complexity:** O(n) - Hash map

## Algorithm

```
1. Initialize result = 0
2. For each bit position (0 to 31):
   a. Count = 0
   b. For each num in nums:
      - If (num >> i) & 1: count++
   c. If count % 3 != 0: result |= (1 << i)
3. Return result
```

## Key Insights

- **Bit Counting**: Count bits at each position
- **Modulo 3**: Use modulo 3 to find single element
- **Local Optimum**: Count bits efficiently
- **Global Optimum**: Find single element

## Alternative Approaches

1. **Hash Map**: Use hash map for counting
2. **Sorting**: Sort and find single element
3. **Mathematical**: Use mathematical properties

## Edge Cases

- Single element: Return that element
- All same: Return that element
- Large arrays: Handle efficiently
- Negative numbers: Handle appropriately

## Applications

- Bit manipulation
- Array algorithms
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **Bit Manipulation**: Most efficient approach
- **Space Optimization**: O(1) space complexity
- **Linear Time**: O(n) time complexity
- **No Extra Space**: Use only necessary space
