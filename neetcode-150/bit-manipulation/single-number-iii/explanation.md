# Single Number III

## Problem Statement

Given an integer array `nums`, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.

You must write an algorithm that runs in linear time complexity and uses only constant extra space.

## Examples

**Example 1:**
```
Input: nums = [1,2,1,3,2,5]
Output: [3,5]
Explanation: [5, 3] is also a valid answer.
```

## Approach

### Method 1: Bit Manipulation (Recommended)
1. XOR all elements to get XOR of two single numbers
2. Find rightmost set bit in XOR result
3. Partition array based on that bit
4. XOR each partition to get the two numbers
5. Most efficient approach

**Time Complexity:** O(n) - Two passes
**Space Complexity:** O(1) - No extra space

### Method 2: Hash Map
1. Use hash map to count occurrences
2. Find elements with count 1
3. Less efficient than bit manipulation

**Time Complexity:** O(n) - Single pass
**Space Complexity:** O(n) - Hash map

## Algorithm

```
1. XOR all elements to get XOR of two single numbers
2. Find rightmost set bit in XOR result
3. Partition array based on that bit
4. XOR each partition to get the two numbers
5. Return the two numbers
```

## Key Insights

- **XOR Properties**: XOR of two single numbers
- **Bit Partitioning**: Use rightmost set bit for partitioning
- **Local Optimum**: Partition efficiently
- **Global Optimum**: Find both single numbers

## Alternative Approaches

1. **Hash Map**: Use hash map for counting
2. **Sorting**: Sort and find single elements
3. **Mathematical**: Use mathematical properties

## Edge Cases

- Two elements: Return those elements
- All same: Handle appropriately
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
