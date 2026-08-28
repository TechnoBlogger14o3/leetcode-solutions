# Lexicographically Smallest Palindromic Permutation Greater Than Target (Hard)

**Problem ID:** 3734  
**Date:** 2026-08-28  
**Link:** https://leetcode.com/problems/lexicographically-smallest-palindromic-permutation-greater-than-target/

## Approach

To solve the problem of finding the lexicographically smallest palindromic permutation of a string `s` that is strictly greater than a given `target`, we can follow a systematic approach:

### Approach:

1. **Character Frequency Count**:
   - First, we need to determine if a palindromic permutation is possible. This can be done by counting the frequency of each character in the string `s`. A string can form a palindrome if at most one character has an odd count (for odd-length strings) and all other characters have even counts.

2. **Constructing Half of the Palindrome**:
   - If a palindromic permutation is possible, we can construct half of the palindrome. This is done by taking half of the counts of each character (ignoring the odd character if it exists). The half-string will be used to generate the complete palindrome.

3. **Generating Palindromic Permutations**:
   - Generate all unique permutations of this half-string. Each permutation can be mirrored to form a full palindrome. For example, if the half-string is "abc", the full palindrome would be "abcba".

4. **Finding the Lexicographically Smallest Palindrome Greater Than Target**:
   - Sort the generated palindromic permutations. Iterate through the sorted list to find the first palindrome that is strictly greater than the `target`. 

5. **Return the Result**:
   - If such a palindrome exists, return it. If none of the palindromic permutations are greater than the target, return an empty string.

### Data Structures:
- A frequency dictionary (or array) to count character occurrences.
- A list to store half of the characters for generating permutations.
- A set or list to store unique palindromic permutations.

### Complexity:
- The time complexity is primarily driven by the permutation generation step, which can be factorial in terms of the number of unique characters. Given the constraints, the overall complexity can be approximated as O(n!), where n is the number of unique characters in `s`. However, since we are only generating half of the characters, the effective complexity is reduced.
- The space complexity is O(n) for storing the character counts and the half-string.

This structured approach ensures that we efficiently determine the required palindromic permutation while adhering to the constraints of the problem.
