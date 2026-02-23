# Check If a String Contains All Binary Codes of Size K (Medium)

**Problem ID:** 1461  
**Date:** 2026-02-23  
**Link:** https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/

## Approach

To solve the problem of checking if a binary string contains all binary codes of size \( k \), we can follow a systematic approach:

### Main Idea:
The task requires us to verify if every possible binary string of length \( k \) (which are \( 2^k \) combinations) appears as a substring in the given binary string \( s \). This can be efficiently done by generating all possible substrings of length \( k \) from \( s \) and checking if they cover all combinations.

### Steps:
1. **Calculate Required Combinations**: Determine the total number of unique binary codes of length \( k \), which is \( 2^k \). If the length of \( s \) is less than \( k \), immediately return `false` since it's impossible to find any substring of that length.

2. **Use a Set for Tracking**: Utilize a set to track the unique substrings of length \( k \) found in \( s \). A set is chosen because it allows for efficient insertion and membership checking.

3. **Iterate Over the String**: Loop through the string \( s \) and extract all possible substrings of length \( k \). For each substring, add it to the set.

4. **Check Completeness**: After processing the string, check if the size of the set equals \( 2^k \). If it does, return `true`, indicating that all binary codes of length \( k \) are present; otherwise, return `false`.

### Data Structures:
- **Set**: To store unique substrings of length \( k \) found in \( s \).

### Complexity:
- **Time Complexity**: The time complexity is \( O(n) \), where \( n \) is the length of the string \( s \). This is because we make a single pass through the string to extract substrings.
- **Space Complexity**: The space complexity is \( O(2^k) \) in the worst case, as we may need to store all possible binary codes of length \( k \) in the set.

This approach efficiently checks for the presence of all binary codes of size \( k \) by leveraging the properties of sets and the manageable size of \( k \) (up to 20).
