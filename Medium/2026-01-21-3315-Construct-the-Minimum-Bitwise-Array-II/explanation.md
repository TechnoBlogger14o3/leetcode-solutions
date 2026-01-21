# Construct the Minimum Bitwise Array II (Medium)

**Problem ID:** 3315  
**Date:** 2026-01-21  
**Link:** https://leetcode.com/problems/construct-the-minimum-bitwise-array-ii/

## Approach

To solve the problem of constructing the minimum bitwise array `ans` such that for each index `i`, the condition `ans[i] OR (ans[i] + 1) == nums[i]` holds, we can follow a systematic approach:

### Main Idea:
The key observation is to understand the properties of the bitwise OR operation. For two consecutive integers `x` and `x + 1`, the result of `x OR (x + 1)` will have all bits set to 1 up to the highest set bit in `x`. Therefore, the goal is to find the smallest integer `ans[i]` such that this condition is satisfied for each prime number `nums[i]`.

### Steps to Approach:
1. **Identify the Highest Set Bit**: For each prime number `nums[i]`, determine the highest bit position that is set to 1. This can be done using bit manipulation techniques, such as repeatedly shifting right until the number becomes zero.

2. **Construct `ans[i]`**: Once the highest set bit position is identified, the smallest `ans[i]` can be constructed. The value of `ans[i]` should be:
   - `2^k - 1` where `k` is the position of the highest set bit in `nums[i]`. This ensures that `ans[i] OR (ans[i] + 1)` will yield the desired `nums[i]`.

3. **Check Validity**: If the calculated `ans[i]` does not satisfy the condition `ans[i] OR (ans[i] + 1) == nums[i]`, then set `ans[i]` to `-1`.

4. **Iterate for All Elements**: Repeat the above steps for all elements in the `nums` array to construct the final `ans` array.

### Data Structures:
- An array `ans` of the same length as `nums` to store the results.
- Basic integer variables to hold intermediate results (e.g., for bit manipulation).

### Complexity:
- **Time Complexity**: O(n * log(max(nums))) where `n` is the length of the `nums` array and `log(max(nums))` is due to the bit manipulation needed to find the highest set bit.
- **Space Complexity**: O(n) for the output array `ans`.

This approach efficiently constructs the required array while ensuring that the values are minimized, adhering to the constraints of the problem.
