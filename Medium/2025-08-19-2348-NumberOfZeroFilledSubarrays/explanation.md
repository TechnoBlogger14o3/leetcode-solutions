# Number of Zero-Filled Subarrays

## Problem Description
Given an integer array `nums`, return the number of subarrays filled with 0. A subarray is a contiguous part of the array.

## Approach
This is a counting problem that requires understanding how to count all possible subarrays within consecutive zero sequences. The key insight is that for a sequence of `n` consecutive zeros, there are `n * (n + 1) / 2` possible subarrays.

## Algorithm
1. **Initialize counters**: `count` for total subarrays, `consecutiveZeros` for current streak
2. **Iterate through array**: For each element:
   - If it's 0: increment `consecutiveZeros` and add current streak to `count`
   - If it's not 0: reset `consecutiveZeros` to 0
3. **Return total count**

## Mathematical Intuition
For a sequence of `n` consecutive zeros:
- **Length 1 subarrays**: n (each individual zero)
- **Length 2 subarrays**: n-1 (pairs of consecutive zeros)
- **Length 3 subarrays**: n-2 (triplets)
- ...
- **Length n subarrays**: 1 (entire sequence)

Total = n + (n-1) + (n-2) + ... + 1 = n * (n + 1) / 2

## Implementation Details
- **Single Pass**: Process array in one iteration
- **Accumulative Counting**: Add current streak length to total at each step
- **Reset Strategy**: Reset streak when encountering non-zero element
- **Data Type**: Use `long` in Java to handle large numbers

## Time Complexity
- **Time**: O(n) where n is the length of the input array
- **Space**: O(1) - only using a constant amount of extra space

## Example
- Input: [1, 3, 0, 0, 2, 0, 0, 0]
- Process: 
  - [0, 0]: 2 + 1 = 3 subarrays
  - [0, 0, 0]: 3 + 2 + 1 = 6 subarrays
- Output: 9

## Key Insights
- **Contiguous Property**: Only consecutive zeros form valid subarrays
- **Incremental Counting**: Count subarrays ending at each position
- **Reset Mechanism**: Non-zero elements break the streak
- **Efficient Formula**: Use mathematical formula instead of nested loops

## Alternative Approaches
- **Brute Force**: Check all possible subarrays (O(n³))
- **Two Pointers**: Track start and end of zero sequences
- **Dynamic Programming**: Build solution incrementally
- **Sliding Window**: Expand window for consecutive zeros

## Edge Cases
- **All zeros**: Array filled with zeros
- **No zeros**: Array with no zero elements
- **Single zeros**: Isolated zero elements
- **Large arrays**: Handle integer overflow with long data type
