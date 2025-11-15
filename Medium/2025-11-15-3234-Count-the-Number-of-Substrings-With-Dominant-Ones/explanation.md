# Count the Number of Substrings With Dominant Ones (Medium)

**Problem ID:** 3234  
**Date:** 2025-11-15  
**Link:** https://leetcode.com/problems/count-the-number-of-substrings-with-dominant-ones/

## Approach

To solve the problem of counting the number of substrings with dominant ones in a binary string, we can adopt a systematic approach that leverages the properties of the substring counts and the conditions for dominance.

### Main Idea:
A substring is considered to have dominant ones if the number of ones (`count_1`) is greater than or equal to the square of the number of zeros (`count_0`). This can be expressed mathematically as:
\[ count_1 \geq count_0^2 \]

Given this condition, we can derive a way to efficiently count valid substrings by iterating through the string and maintaining a running count of zeros and ones.

### Approach:
1. **Prefix Counts**: As we iterate through the string, we maintain cumulative counts of zeros and ones. This allows us to quickly calculate the number of zeros and ones in any substring defined by indices `i` and `j`.

2. **Two-pointer Technique**: For each starting index `i`, we can use a second pointer `j` to extend the substring while checking the dominance condition. We will increment `j` until the condition fails, keeping track of valid substrings.

3. **Count Valid Substrings**: For each valid starting index `i`, once we find the maximum index `j` where the condition holds, all substrings from `i` to any index up to `j` are valid. Thus, if `j` is the farthest index satisfying the condition, we can add `(j - i + 1)` to our count of dominant substrings.

4. **Complexity Consideration**: The algorithm primarily involves iterating through the string with two pointers, leading to a time complexity of O(n), where n is the length of the string. This is efficient given the constraints.

### Data Structures:
- Two integers to keep track of the cumulative counts of zeros and ones.
- A loop to iterate through the string, with a nested loop (or a two-pointer approach) to find valid substrings.

### Complexity:
- **Time Complexity**: O(n), where n is the length of the string. Each character is processed a limited number of times.
- **Space Complexity**: O(1) for maintaining counts, as we only need a fixed number of variables regardless of input size.

By following this structured approach, we can efficiently count the number of dominant substrings in the binary string provided.
