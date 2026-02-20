# Special Binary String (Hard)

**Problem ID:** 761  
**Date:** 2026-02-20  
**Link:** https://leetcode.com/problems/special-binary-string/

## Approach

To solve the problem of finding the lexicographically largest special binary string, we can leverage the properties of special binary strings and a recursive approach. Here’s a concise breakdown of the approach:

### Problem Understanding
A special binary string has two main properties:
1. Equal numbers of '0's and '1's.
2. Every prefix contains at least as many '1's as '0's.

Given these properties, we can infer that the string can be divided into smaller special binary substrings, and our goal is to rearrange these substrings to form the largest possible string in lexicographical order.

### Approach
1. **Divide and Conquer**: We will recursively break down the string into its constituent special substrings. This can be achieved by maintaining a balance counter while iterating through the string, where we increase the counter for '1' and decrease it for '0'. When the counter returns to zero, we have identified a special substring.

2. **Recursive Extraction**: For each identified special substring, we can recursively apply the same logic to extract further special substrings. This allows us to gather all special substrings from the original string.

3. **Sorting and Rebuilding**: Once we have all the special substrings, we sort them in descending order. This ensures that when we concatenate them back together, we form the lexicographically largest string.

4. **Concatenation**: Finally, we concatenate the sorted substrings to form the result.

### Data Structures
- A list or array to store the special substrings as they are extracted.
- A string to hold the final result after sorting and concatenation.

### Complexity
- **Time Complexity**: The overall time complexity is O(n log n) due to the sorting step, where n is the length of the input string. The extraction of special substrings is linear, O(n).
- **Space Complexity**: O(n) for storing the substrings.

### Summary
The core idea is to recursively extract special substrings, sort them to ensure the largest lexicographical order, and then concatenate them to form the final result. This method efficiently utilizes the properties of special binary strings and ensures that we adhere to the constraints provided in the problem.
