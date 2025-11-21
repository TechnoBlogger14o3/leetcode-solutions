# Unique Length-3 Palindromic Subsequences (Medium)

**Problem ID:** 1930  
**Date:** 2025-11-21  
**Link:** https://leetcode.com/problems/unique-length-3-palindromic-subsequences/

## Approach

To solve the problem of counting unique length-3 palindromic subsequences in a string, we can adopt the following approach:

### Main Idea:
A palindromic subsequence of length 3 has the form "aba", where 'a' is the first and last character, and 'b' is the middle character. To find all unique palindromic subsequences of this form, we need to identify pairs of characters that can serve as 'a' and 'b' in the string.

### Approach:
1. **Character Index Tracking**: Use a dictionary to track the indices of each character in the string. This will help us quickly find potential positions for the characters 'a' and 'b'.

2. **Iterate Over Characters**: For each character 'b' in the string (considering it as the middle character of the palindrome):
   - Check for all characters 'a' that appear before 'b' (using the index list from the dictionary).
   - Check for all characters 'a' that appear after 'b'.
   - For each valid pair of indices (one before and one after), we can form the palindrome "aba".

3. **Set for Uniqueness**: Use a set to store the unique palindromic subsequences we find. This ensures that duplicates are automatically handled.

### Data Structures:
- A dictionary (or hashmap) to store the indices of each character.
- A set to store unique palindromic subsequences.

### Complexity:
- **Time Complexity**: O(n^2) in the worst case, where n is the length of the string. This is due to the nested iteration over characters and their indices. However, since we are only considering pairs of indices for each middle character, the average case can be better.
- **Space Complexity**: O(n) for storing the indices of characters in the dictionary and for the set of unique palindromic subsequences.

### Conclusion:
By systematically identifying potential palindromic structures and leveraging data structures for efficient lookups, we can effectively count the unique length-3 palindromic subsequences in the string. This method balances clarity and efficiency, making it suitable for the problem's constraints.
