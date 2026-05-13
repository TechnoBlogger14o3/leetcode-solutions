# Minimum Moves to Make Array Complementary (Medium)

**Problem ID:** 1674  
**Date:** 2026-05-13  
**Link:** https://leetcode.com/problems/minimum-moves-to-make-array-complementary/

## Approach

To solve the problem of finding the minimum number of moves required to make the array `nums` complementary, we can adopt a strategic approach based on counting the necessary changes for pairs of elements.

### Main Idea:
The goal is to ensure that for every index `i`, the sum of `nums[i]` and `nums[n - 1 - i]` equals a constant value `target`. The valid range for `target` is from `2` (when both elements are `1`) to `2 * limit` (when both elements are `limit`). 

### Approach:
1. **Pairing Elements**: Since the array length `n` is even, we can iterate through the first half of the array and pair each element with its corresponding element from the second half. For each pair `(nums[i], nums[n - 1 - i])`, we will determine the potential target sums they can achieve.

2. **Count Changes**: For each pair, we need to calculate how many changes are required to achieve each possible target sum:
   - For a target sum `t`, if `nums[i] + nums[n - 1 - i]` is less than `t`, we might need to increase one or both elements.
   - If it is greater than `t`, we might need to decrease one or both elements.
   - We can maintain a count of how many moves are needed for each possible target sum using a frequency array.

3. **Using a Difference Array**: We can utilize a difference array to efficiently track the number of changes needed for each target. For each pair:
   - Increment the start of the range where changes are needed and decrement the end of the range to mark the boundaries of required changes.

4. **Calculate Moves**: After processing all pairs, we can compute the cumulative changes needed for each target sum, and the minimum value in this cumulative array will give us the least number of moves required to make the array complementary.

### Data Structures:
- A frequency array (or a difference array) to track the number of changes needed for each potential target sum.
- This array will have a size of `2 * limit + 2` to cover all possible target sums.

### Complexity:
- **Time Complexity**: O(n), where `n` is the length of the array, as we are iterating through the array and processing pairs in a single pass.
- **Space Complexity**: O(limit), for the frequency array used to track changes for each target sum.

This approach efficiently determines the minimum moves required while ensuring that we stay within the constraints provided.
