# Trionic Array II (Hard)

**Problem ID:** 3640  
**Date:** 2026-02-04  
**Link:** https://leetcode.com/problems/trionic-array-ii/

## Approach

To solve the "Trionic Array II" problem, we need to identify and calculate the maximum sum of trionic subarrays within the given integer array. A trionic subarray is defined by three segments: a strictly increasing segment, a strictly decreasing segment, and another strictly increasing segment.

### Approach:

1. **Segmentation**: 
   - We will traverse the array to identify segments that are strictly increasing or strictly decreasing. We can maintain two lists: one for the sums of increasing segments and another for the sums of decreasing segments.

2. **Identify Increasing and Decreasing Segments**:
   - As we iterate through the array, we can keep track of the current segment type (increasing or decreasing) and its sum. When we encounter a change in the trend (from increasing to decreasing or vice versa), we will finalize the current segment and start a new one.
   - For example, while traversing, if we find that `nums[i] < nums[i+1]`, we continue adding to the increasing segment sum. If we find `nums[i] > nums[i+1]`, we finalize the increasing segment and start a decreasing segment.

3. **Store Segment Sums**:
   - We will store the sums of all identified segments in separate lists. After processing the entire array, we will have a list of sums for increasing segments and a list for decreasing segments.

4. **Combine Segments**:
   - To find trionic subarrays, we need to combine these segments. For each decreasing segment, we can look for adjacent increasing segments before and after it. The key is to ensure that the indices are valid (i.e., the segments are contiguous and follow the trionic pattern).

5. **Calculate Maximum Sum**:
   - For each valid trionic combination (increasing segment before, decreasing segment, and increasing segment after), we calculate the total sum and keep track of the maximum sum encountered.

### Data Structures:
- Two lists to store the sums of increasing and decreasing segments.
- Variables to keep track of current segment sums and types during the traversal.

### Complexity:
- **Time Complexity**: O(n), where n is the length of the input array. We make a single pass through the array to identify segments and another pass to calculate the maximum sum.
- **Space Complexity**: O(n) in the worst case for storing segment sums, though we can optimize this by using a constant amount of space if we only keep track of the necessary sums without storing all segments.

This approach efficiently identifies and computes the maximum sum of trionic subarrays by leveraging the properties of increasing and decreasing sequences, ensuring that we adhere to the problem's constraints and requirements.
