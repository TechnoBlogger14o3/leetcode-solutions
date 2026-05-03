# Rotate String (Easy)

**Problem ID:** 796  
**Date:** 2026-05-03  
**Link:** https://leetcode.com/problems/rotate-string/

## Approach

To solve the "Rotate String" problem, the key idea is to leverage the properties of string rotations. Specifically, if string `s` can be transformed into string `goal` through a series of left shifts, then `goal` must appear as a substring within the concatenated string `s + s`. 

### Approach:

1. **Concatenation**: Create a new string by concatenating `s` with itself (i.e., `s + s`). This new string contains all possible rotations of `s` as contiguous substrings. For example, if `s = "abcde"`, then `s + s = "abcdeabcde"` will contain all rotations: "abcde", "bcdea", "cdeab", "deabc", and "eabcd".

2. **Substring Check**: Check if `goal` is a substring of the concatenated string `s + s`. If it is, then `s` can be rotated to form `goal`, and we return `true`. If not, we return `false`.

### Data Structures:
- Strings are used to hold the input and the concatenated result. No additional complex data structures are necessary for this approach.

### Complexity:
- **Time Complexity**: The solution primarily involves string concatenation and substring searching. The concatenation takes O(n) time, where n is the length of `s`. The substring search can be done in O(n) time as well, resulting in an overall time complexity of O(n).
- **Space Complexity**: The space complexity is O(n) due to the storage of the concatenated string `s + s`.

### Summary:
This approach is efficient and straightforward, utilizing the properties of string manipulation to determine if one string can be obtained from another through rotations. By checking for the presence of `goal` in the doubled string, we can quickly conclude whether the transformation is possible.
