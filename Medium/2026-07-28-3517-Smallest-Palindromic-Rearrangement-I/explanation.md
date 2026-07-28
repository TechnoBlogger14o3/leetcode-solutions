# Smallest Palindromic Rearrangement I (Medium)

**Problem ID:** 3517  
**Date:** 2026-07-28  
**Link:** https://leetcode.com/problems/smallest-palindromic-rearrangement-i/

## Approach

To solve the problem of finding the lexicographically smallest palindromic permutation of a given palindromic string `s`, we can follow a systematic approach:

### Main Idea:
1. **Character Frequency Count**: Since the input string is guaranteed to be a palindrome, its character counts will have specific properties: characters can appear an even number of times, except for at most one character which can appear an odd number of times (this would be the center character in an odd-length palindrome). 
2. **Building the Smallest Palindrome**: To construct the smallest lexicographic palindrome, we will:
   - Count the frequency of each character in the string.
   - Sort the characters based on their lexicographic order.
   - Place half of each character in the first half of the palindrome, and mirror them in the second half.
   - If there is a character with an odd count, place it in the middle.

### Steps:
1. **Count Frequencies**: Use a frequency array or a dictionary to count occurrences of each character in `s`.
2. **Sort Characters**: Extract the characters and sort them to ensure that we can build the smallest permutation.
3. **Construct the Palindrome**:
   - Initialize an empty list for the first half of the palindrome.
   - For each character in the sorted list, append half of its occurrences to the first half.
   - If any character has an odd count, keep track of it to place it in the middle.
   - Construct the second half by reversing the first half.
   - Concatenate the first half, the middle character (if it exists), and the second half to form the final palindrome.

### Data Structures:
- **Frequency Array**: An array of size 26 (for lowercase English letters) to count character occurrences.
- **List**: To build the first half of the palindrome and later concatenate to form the complete palindrome.

### Complexity:
- **Time Complexity**: The overall time complexity is O(n + k log k), where n is the length of the string (for counting characters) and k is the number of distinct characters (for sorting). Since k is at most 26, this can be considered O(n).
- **Space Complexity**: O(1) for the frequency array (since it has a constant size) and O(n) for the resulting palindrome string.

This approach ensures that we efficiently construct the lexicographically smallest palindromic permutation while adhering to the properties of palindromic strings.
