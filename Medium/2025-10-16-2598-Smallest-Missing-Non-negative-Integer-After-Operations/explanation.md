# Smallest Missing Non-negative Integer After Operations (Medium)

**Problem ID:** 2598  
**Date:** 2025-10-16  
**Link:** https://leetcode.com/problems/smallest-missing-non-negative-integer-after-operations/

## Approach

To solve the problem of finding the maximum MEX (minimum excluded value) after performing operations on the given array `nums`, we can follow a systematic approach:

### Main Idea
The core idea is to leverage the operations allowed (adding or subtracting a fixed `value` from any element) to manipulate the elements of `nums` such that we can cover as many consecutive non-negative integers starting from 0 as possible. The goal is to find the largest integer that cannot be formed after these operations.

### Steps to Approach
1. **Normalization**: Since the operations can move numbers up or down by `value`, we can transform each number in `nums` into a representative form that reflects their potential to contribute to the MEX. Specifically, we can calculate the equivalent non-negative integers for each number by taking modulo `value`:
   - For each `num` in `nums`, compute `num % value`. If `num` is negative, adjust it to ensure it falls within the range [0, value-1].

2. **Set Representation**: Use a set to track which non-negative integers can be achieved through the operations. This set will help in quickly checking which integers are present after normalization.

3. **MEX Calculation**: Iterate through the integers starting from 0 and check for the smallest integer that is not present in the set. This integer will be the MEX.

### Data Structures
- **Set**: A set is used to store the normalized values derived from `nums`. This allows for O(1) average time complexity for membership checking when determining the MEX.

### Complexity
- **Time Complexity**: O(n), where n is the length of the `nums` array. This is due to a single pass to normalize the numbers and another pass to find the MEX.
- **Space Complexity**: O(value), as we are storing at most `value` unique normalized integers in the set.

### Conclusion
By normalizing the elements of `nums` and utilizing a set to track achievable integers, we can efficiently compute the maximum MEX after performing the allowed operations. This approach ensures that we cover all possible transformations and systematically find the smallest missing non-negative integer.
