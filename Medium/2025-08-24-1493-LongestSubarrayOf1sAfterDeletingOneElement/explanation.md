# Longest Subarray of 1's After Deleting One Element - Problem #1493

## Problem Description
Given a binary array `nums`, you should delete one element from it.

Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.

## Examples
```
Input: nums = [1,1,0,1]
Output: 3
Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.

Input: nums = [0,1,1,1,0,1,1,0,1]
Output: 5
Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] has longest subarray of length 5.

Input: nums = [1,1,1]
Output: 2
Explanation: You must delete one element.
```

## Approach
This is a sliding window problem that requires finding the longest subarray with at most one 0. The key insight is to use a sliding window approach where we can have at most one 0 in our window.

## Algorithm
1. **Initialize sliding window**: Use two pointers (left and right) to maintain a window
2. **Expand window**: Move right pointer to include more elements
3. **Handle zeros**: When we encounter a 0, we can include it in our window (since we can delete one element)
4. **Shrink window**: If we encounter a second 0, shrink the window from the left until we have at most one 0
5. **Track maximum**: Keep track of the maximum window size seen

## Key Implementation Details
- **Sliding Window**: Use two pointers to maintain a valid window
- **Zero Counter**: Track the number of zeros in the current window
- **Window Shrinking**: When we have more than one 0, shrink from left until we have at most one 0
- **Result Calculation**: The answer is the maximum window size minus 1 (since we must delete one element)

## Mathematical Intuition
The longest subarray after deleting one element is equivalent to finding the longest subarray that contains at most one 0. This is because:
- If we have no 0's, we can delete any 1 and get length - 1
- If we have one 0, we can delete that 0 and get the full length
- If we have more than one 0, we can't get a valid subarray of all 1's

## Time Complexity
- **Time**: O(n) where n is the length of the array
- **Space**: O(1) - only using constant extra space

## Example Walkthrough
For input `[0,1,1,1,0,1,1,0,1]`:
- Window [0,1,1,1,0] has 2 zeros → shrink to [1,1,1,0]
- Window [1,1,1,0,1,1] has 1 zero → valid, length = 6
- Window [1,1,1,0,1,1,0] has 2 zeros → shrink to [1,1,0,1,1]
- Maximum valid window: [1,1,1,0,1,1] with length 6
- After deleting one element: length 5

## Key Insights
- **Sliding Window**: Use two pointers to efficiently find the longest valid subarray
- **Zero Tolerance**: Allow at most one 0 in the window
- **Element Deletion**: The answer is always window size - 1
- **Edge Cases**: Handle arrays with no 1's, all 1's, or single elements

## Alternative Approaches
- **Prefix Sum**: Calculate prefix sums and find longest range with at most one 0
- **Dynamic Programming**: Use DP to track longest valid subarray ending at each position
- **Binary Search**: Binary search on the answer length
- **Two Pointers**: Similar to sliding window but with different logic

## Edge Cases
- **Empty Array**: Return 0
- **All Zeros**: Return 0
- **All Ones**: Return length - 1
- **Single Element**: Return 0
- **No Valid Subarray**: Return 0

## Applications
- **Signal Processing**: Find longest continuous signal segments
- **Data Analysis**: Identify longest sequences with minimal noise
- **Network Analysis**: Find longest stable connection periods
- **Quality Control**: Identify longest production runs with minimal defects
- **Image Processing**: Find longest continuous regions

## Optimization Opportunities
- **Early Termination**: Stop when remaining elements can't improve the answer
- **Memory Access**: Optimize array access patterns
- **Branch Prediction**: Minimize conditional branches in the loop
- **SIMD Operations**: Use vectorized operations for large arrays

## Related Problems
- **Maximum Consecutive Ones**: Find longest subarray of consecutive 1's
- **Longest Subarray with At Most K Distinct Elements**: Similar sliding window approach
- **Minimum Size Subarray Sum**: Find minimum subarray with given sum
- **Sliding Window Maximum**: Find maximum in sliding window
