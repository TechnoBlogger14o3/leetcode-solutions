# Find Unique Binary String (Medium)

**Problem ID:** 1980  
**Date:** 2026-03-08  
**Link:** https://leetcode.com/problems/find-unique-binary-string/

## Approach

To solve the problem of finding a unique binary string of length `n` that does not appear in the given array `nums`, we can employ a straightforward and efficient approach based on the properties of binary strings and the constraints provided.

### Problem Understanding
Given that `nums` contains `n` unique binary strings of length `n`, we need to construct a binary string of the same length that is guaranteed not to be in `nums`. The uniqueness of the strings in `nums` and their fixed length allows us to leverage a simple diagonalization technique.

### Approach
1. **Diagonalization Technique**: The core idea is to create a new binary string by examining the `i-th` character of the `i-th` string in `nums`. Specifically, for each index `i` from `0` to `n-1`, we can choose a character that is different from the `i-th` character of `nums[i]`. This guarantees that the resulting string will differ from each string in `nums` at least at one position, ensuring its uniqueness.

2. **Construction of the Result**:
   - Initialize an empty result string.
   - Iterate through each index `i` from `0` to `n-1`.
   - If `nums[i][i]` is `0`, append `1` to the result; if it is `1`, append `0`.
   - This creates a binary string that is guaranteed not to match any string in `nums`.

### Data Structures
- We primarily use a simple string to construct the result. The input `nums` is already structured as an array of strings, which allows for straightforward indexing.

### Complexity
- **Time Complexity**: O(n), where `n` is the length of the binary strings. We make a single pass through the `nums` array to construct the result.
- **Space Complexity**: O(n) for storing the resultant binary string.

### Conclusion
This approach is efficient and leverages the constraints of the problem effectively. By using a diagonalization method, we ensure that the generated binary string is unique and meets the requirements of the problem. This guarantees a valid solution without the need to check against all existing strings in `nums`, making it optimal for the given constraints.
