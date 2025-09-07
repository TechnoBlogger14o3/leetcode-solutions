# Find N Unique Integers Sum up to Zero (Easy)

**Problem ID:** 1304  
**Date:** 2025-09-07  
**Link:** https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/

## Approach

To solve the problem of finding `n` unique integers that sum up to zero, we can leverage the properties of integers and their symmetry around zero.

### Approach:

1. **Understanding the Requirement**: We need to generate `n` unique integers such that their sum equals zero. This means that for every positive integer, there should be a corresponding negative integer to balance it out.

2. **Constructing the Array**:
   - If `n` is odd, we can include `0` as one of the integers. The remaining integers can be paired as positive and negative integers. For example, for `n = 5`, we can use the integers `[-2, -1, 0, 1, 2]`, which sum to zero.
   - If `n` is even, we can simply use pairs of integers without including zero. For instance, for `n = 4`, we can use `[-2, -1, 1, 2]`.

3. **Generating the Integers**:
   - For odd `n`: Generate integers from `-(n//2)` to `n//2`, inclusive. This gives us `n` integers where the middle integer is `0`.
   - For even `n`: Generate integers from `-(n//2)` to `-(n//2) + (n-1)`, skipping zero.

### Data Structures:
The solution can be implemented using a simple list to store the integers. Since the constraints allow for `n` up to `1000`, a straightforward list is efficient enough.

### Complexity:
- **Time Complexity**: O(n), as we are generating `n` integers.
- **Space Complexity**: O(n), for storing the resulting array of integers.

This approach guarantees that the integers are unique and their sum is zero, fulfilling the problem's requirements efficiently.
