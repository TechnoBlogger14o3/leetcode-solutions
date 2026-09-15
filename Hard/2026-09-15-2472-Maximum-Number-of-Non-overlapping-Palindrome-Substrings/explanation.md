# Maximum Number of Non-overlapping Palindrome Substrings (Hard)

**Problem ID:** 2472  
**Date:** 2026-09-15  
**Link:** https://leetcode.com/problems/maximum-number-of-non-overlapping-palindrome-substrings/

## Approach

To solve the problem of finding the maximum number of non-overlapping palindrome substrings of at least length \( k \) in a given string \( s \), we can follow a structured approach:

### Approach:

1. **Identify Palindromic Substrings**:
   - Use a dynamic programming (DP) technique to identify all palindromic substrings in \( s \). We can maintain a 2D boolean array `dp` where `dp[i][j]` is `true` if the substring \( s[i:j+1] \) is a palindrome.
   - Initialize the DP table by marking single characters as palindromes and then expand for substrings of length 2 and greater.

2. **Collect Valid Palindromes**:
   - After populating the DP table, iterate through it to collect all palindromic substrings that have a length of at least \( k \). Store these substrings along with their start and end indices in a list.

3. **Select Non-Overlapping Substrings**:
   - Sort the collected palindromic substrings based on their ending indices. This allows us to efficiently select the maximum number of non-overlapping substrings.
   - Use a greedy approach to select substrings: iterate through the sorted list and keep track of the end of the last added substring. For each substring, if its starting index is greater than the end of the last added substring, include it in the count and update the end.

### Data Structures:
- A 2D boolean array `dp` for dynamic programming to track palindromic substrings.
- A list to store the valid palindromic substrings along with their indices for further processing.

### Complexity:
- **Time Complexity**: The DP approach takes \( O(n^2) \) to fill the DP table, where \( n \) is the length of the string. Collecting valid palindromes and sorting them also takes \( O(n \log n) \) in the worst case. Thus, the overall time complexity is \( O(n^2) \).
- **Space Complexity**: The space complexity is \( O(n^2) \) due to the DP table.

By following this method, we can efficiently determine the maximum number of non-overlapping palindromic substrings of at least length \( k \) in the given string \( s \).
