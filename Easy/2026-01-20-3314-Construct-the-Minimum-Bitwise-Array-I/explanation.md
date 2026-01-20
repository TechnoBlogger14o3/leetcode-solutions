# Construct the Minimum Bitwise Array I (Easy)

**Problem ID:** 3314  
**Date:** 2026-01-20  
**Link:** https://leetcode.com/problems/construct-the-minimum-bitwise-array-i/

## Approach

To solve the problem of constructing the minimum bitwise array `ans` such that for each index `i`, the condition `ans[i] OR (ans[i] + 1) == nums[i]` holds true, we can follow a systematic approach:

### Main Idea:
The key insight is to recognize the relationship between the bitwise OR operation and the binary representation of numbers. Specifically, for a prime number `p`, the goal is to find the smallest non-negative integer `x` such that `x OR (x + 1) = p`. 

### Steps to Solve:
1. **Understanding the Condition**: The expression `x OR (x + 1)` essentially sets all bits to 1 from the least significant bit of `x` up to the first 0 bit in `x`. Therefore, to satisfy the condition, `p` must have a specific form in its binary representation.

2. **Iterate Through Each Prime Number**: For each prime number in the input array `nums`, determine the smallest `ans[i]`:
   - If `p` is even (which is only true for 2), it is impossible to find a suitable `ans[i]` since no non-negative integer can satisfy the condition. Thus, set `ans[i] = -1`.
   - For odd primes, we need to find the largest power of two less than or equal to `p`. This can be achieved by using bit manipulation to isolate the highest set bit.

3. **Calculate the Minimum Value**: For each odd prime `p`, the smallest `x` that satisfies the condition can be derived as follows:
   - Let `x` be the largest power of two less than `p`. This can be computed using bit manipulation: `x = p - (p & (p - 1))`.
   - If `x` is valid (i.e., `x < p`), then `ans[i]` can be set to `x`. Otherwise, set `ans[i] = -1`.

### Data Structures:
- An array `ans` of the same length as `nums` to store the results.
- Simple integer variables to hold intermediate calculations.

### Complexity:
- The time complexity is O(n) where n is the length of the input array `nums`, as we need to process each element once.
- The space complexity is O(n) for storing the output array `ans`.

By following this approach, we ensure that we efficiently construct the required output while adhering to the constraints and minimizing each value in the resultant array.
