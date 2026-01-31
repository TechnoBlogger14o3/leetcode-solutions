# Find Smallest Letter Greater Than Target (Easy)

**Problem ID:** 744  
**Date:** 2026-01-31  
**Link:** https://leetcode.com/problems/find-smallest-letter-greater-than-target/

## Approach

To solve the problem of finding the smallest letter greater than the target in a sorted array of characters, we can utilize a binary search approach due to the sorted nature of the input array.

### Approach:

1. **Binary Search**: Since the array `letters` is sorted in non-decreasing order, we can efficiently find the smallest character greater than the target using binary search. This will allow us to reduce the time complexity to O(log n), where n is the length of the `letters` array.

2. **Initialization**: Start with two pointers, `left` at the beginning (index 0) and `right` at the end (index `len(letters) - 1`) of the array.

3. **Search Logic**:
   - Calculate the mid-point of the current search range.
   - If the character at the mid-point is less than or equal to the target, move the `left` pointer to `mid + 1` to search the right half.
   - If the character at the mid-point is greater than the target, move the `right` pointer to `mid` to search the left half (including the mid-point since it could be a candidate).
   - Continue this process until `left` equals `right`.

4. **Result Evaluation**: After the binary search loop, `left` will point to the smallest character that is greater than the target. If `left` is equal to the length of the array, it means no character is greater than the target, and we should return the first character in the array (i.e., `letters[0]`).

### Data Structures:
- The primary data structure used is the sorted array `letters`, which allows for efficient searching.

### Complexity:
- **Time Complexity**: O(log n) due to the binary search.
- **Space Complexity**: O(1) since we are using a constant amount of extra space for pointers.

This approach ensures that we efficiently find the desired character while adhering to the constraints provided in the problem statement.
