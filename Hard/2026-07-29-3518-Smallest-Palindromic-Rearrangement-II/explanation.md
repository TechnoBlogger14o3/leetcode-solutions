# Smallest Palindromic Rearrangement II (Hard)

**Problem ID:** 3518  
**Date:** 2026-07-29  
**Link:** https://leetcode.com/problems/smallest-palindromic-rearrangement-ii/

## Approach

To solve the problem of finding the k-th lexicographically smallest palindromic permutation of a given palindromic string `s`, we can follow these steps:

### Main Idea:
1. **Character Frequency Count**: Since `s` is guaranteed to be a palindrome, we can count the frequency of each character. This helps us determine how many of each character we can use to form half of the palindrome.
  
2. **Construct Half Palindrome**: For a string to be palindromic, its first half determines the second half. We can generate the first half of the palindrome using the counted characters. If a character appears an odd number of times, one instance can be used as the middle character in the palindrome.

3. **Generate Permutations**: We need to generate distinct permutations of the half palindrome. To ensure uniqueness, we can use a backtracking approach or a combinatorial method to generate permutations while avoiding duplicates.

4. **Lexicographical Order**: As we generate permutations, we can keep track of the count and stop when we reach the k-th permutation. Since the permutations are generated in lexicographical order, we can directly return the k-th permutation once we reach it.

5. **Handle Edge Cases**: If the total number of distinct palindromic permutations is less than k, we return an empty string.

### Data Structures:
- **Frequency Map**: A dictionary or array to store the frequency of each character.
- **List/Array**: To store the characters that will form the half palindrome.
- **Set**: To track generated permutations and ensure uniqueness (if using a backtracking approach).

### Complexity:
- **Time Complexity**: The time complexity is primarily driven by the generation of permutations. If `n` is the length of the half palindrome, the number of permutations can be up to `O(n!)`, but since we are only interested in the k-th permutation, we can optimize this. The complexity can be approximated as `O(n! / (c1! * c2! * ... * cm!))` where `ci` are the counts of distinct characters.
  
- **Space Complexity**: The space complexity is `O(n)` for storing the half palindrome and the frequency map, plus additional space for storing generated permutations if needed.

By following this structured approach, we can efficiently find the k-th lexicographically smallest palindromic permutation of the input string `s`.
