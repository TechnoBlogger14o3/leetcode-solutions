# Calculate Digit Sum of a String (Easy)

**Problem ID:** 2243  
**Date:** 2026-11-16  
**Link:** https://leetcode.com/problems/calculate-digit-sum-of-a-string/

## Approach

To solve the problem of calculating the digit sum of a string through multiple rounds, we can follow a systematic approach:

### Problem Breakdown:
1. **Input Parsing**: We are given a string `s` of digits and an integer `k`. Our goal is to repeatedly group the string into segments of size `k`, compute the sum of digits for each group, and form a new string from these sums until the length of the string is less than or equal to `k`.

2. **Grouping**: In each round, we divide the string `s` into groups of size `k`. The last group may contain fewer than `k` characters if the length of `s` is not a perfect multiple of `k`.

3. **Digit Sum Calculation**: For each group, we calculate the sum of its digits. This can be efficiently done using a simple loop or list comprehension.

4. **String Reconstruction**: After computing the sums for all groups, we concatenate these sums to form a new string `s`.

5. **Repetition**: We repeat the above steps until the length of `s` is less than or equal to `k`.

### Data Structures:
- **String**: We primarily work with the string `s` for grouping and reconstruction.
- **List**: We can use a list to temporarily hold the sums of each group before converting it back to a string.

### Complexity Analysis:
- **Time Complexity**: Each round involves iterating through the string `s` to group it and calculate sums. In the worst case, this could take O(n) time for each round, where n is the length of the string. The number of rounds is limited because the length of `s` reduces significantly with each round. Thus, the overall complexity can be approximated as O(n log n) due to the logarithmic reduction in string length.
  
- **Space Complexity**: The space complexity is O(n) in the worst case, where we may need to store the intermediate sums in a list.

### Summary:
The main idea is to iteratively group the string into segments of size `k`, compute the sums of the digits in each segment, and reconstruct the string until its length is less than or equal to `k`. This approach efficiently handles the problem using basic string and list operations, ensuring clarity and simplicity in implementation.
