# Sort Vowels in a String (Medium)

**Problem ID:** 2785  
**Date:** 2025-09-11  
**Link:** https://leetcode.com/problems/sort-vowels-in-a-string/

## Approach

To solve the problem of sorting vowels in a string while keeping consonants in their original positions, we can follow a systematic approach:

### Approach:

1. **Identify Vowels and Consonants**:
   - Traverse the input string `s` and identify the positions of vowels. We can define vowels as the characters 'a', 'e', 'i', 'o', 'u' (both lowercase and uppercase).
   - Store the vowels in a separate list, which will allow us to sort them easily.

2. **Sort the Vowels**:
   - Once we have collected all the vowels, sort this list. Since the problem requires vowels to be in nondecreasing order based on their ASCII values, a simple sort operation will suffice.

3. **Reconstruct the String**:
   - Create a new list or array to build the result string `t`. Iterate through the original string `s` again:
     - If the current character is a consonant, place it in the corresponding position in `t`.
     - If the current character is a vowel, replace it with the next vowel from the sorted list, ensuring that we maintain the order of vowels.

4. **Return the Result**:
   - Finally, join the characters in the list `t` to form the resulting string and return it.

### Data Structures:
- Use a list to store the vowels for sorting.
- Use another list (or array) to construct the final result string, which allows for efficient placement of characters.

### Complexity:
- The time complexity of this approach is O(n log n), where n is the length of the string. This is due to the sorting step for the vowels.
- The space complexity is O(n) as we store the vowels and the result string separately.

This method efficiently sorts the vowels while preserving the positions of consonants, ensuring that we meet the problem's requirements.
