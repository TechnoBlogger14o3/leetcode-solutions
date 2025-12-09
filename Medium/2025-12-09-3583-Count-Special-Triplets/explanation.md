# Count Special Triplets (Medium)

**Problem ID:** 3583  
**Date:** 2025-12-09  
**Link:** https://leetcode.com/problems/count-special-triplets/

## Approach

To solve the problem of counting special triplets in the given integer array `nums`, we can adopt a systematic approach that leverages counting and efficient iteration instead of brute force, which would be computationally expensive.

### Main Idea:
The essence of the problem lies in identifying triplets `(i, j, k)` such that:
1. `0 <= i < j < k < n`
2. `nums[i] == nums[j] * 2`
3. `nums[k] == nums[j] * 2`

Given that `nums[i]` and `nums[k]` must both equal `2 * nums[j]`, we can simplify our approach by focusing on the middle element `nums[j]` and counting how many valid `i` and `k` indices exist for each `j`.

### Approach:
1. **Count Occurrences**: Use a frequency array to count occurrences of each possible number in `nums`. This helps in quickly determining how many valid `i` and `k` can be formed for each `j`.

2. **Iterate Through `j`**: For each index `j`, calculate the value `target = 2 * nums[j]`. This value represents the numbers we need to find for both `i` and `k`.

3. **Count Valid Indices**:
   - **For `i`**: Count how many indices `i` exist before `j` where `nums[i] == target`. This can be done by maintaining a cumulative count of occurrences as we iterate through the array.
   - **For `k`**: Count how many indices `k` exist after `j` where `nums[k] == target`. This can be achieved by using the frequency array and adjusting counts as we process each `j`.

4. **Calculate Triplets**: For each valid `j`, the number of special triplets can be calculated as the product of the counts of valid `i` and `k`. Sum these products for all valid `j` to get the final result.

5. **Modulo Operation**: Since the result can be large, ensure to take results modulo `10^9 + 7` at each step of accumulation.

### Data Structures:
- A frequency array (or dictionary) to store counts of each number in `nums`.
- A cumulative count array to keep track of how many times each number has been seen as we iterate through `j`.

### Complexity:
- **Time Complexity**: O(n), where n is the length of `nums`. We make a single pass to build the frequency array and then another pass to count triplets.
- **Space Complexity**: O(m), where m is the range of possible values in `nums` (up to 100,000), which is manageable within the problem constraints.

By following this structured approach, we efficiently count the special triplets without the need for nested loops, making the solution scalable for the upper limits of input size.
