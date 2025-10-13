# Find Resultant Array After Removing Anagrams (Easy)

**Problem ID:** 2273  
**Date:** 2025-10-13  
**Link:** https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/

## Approach

To solve the problem of finding the resultant array after removing anagrams, we can leverage the properties of anagrams and utilize a simple linear traversal approach.

### Main Idea:
The core idea is to maintain a resultant list of words while iterating through the input list. We will keep track of the last word added to the resultant list and check if the current word is an anagram of that last word. If it is not an anagram, we add it to the resultant list; if it is, we skip adding it.

### Steps:
1. **Initialization**: Start with an empty resultant list.
2. **Iterate through the words**: For each word in the input list:
   - If the resultant list is empty, append the current word.
   - If the resultant list is not empty, compare the current word with the last word in the resultant list.
   - To check if two words are anagrams, sort both words and compare the sorted results. Alternatively, we can use a frequency count of characters (e.g., using a list of size 26 for lowercase letters).
   - If they are not anagrams, append the current word to the resultant list.
3. **Return the resultant list**: After processing all words, return the resultant list.

### Data Structures:
- A list (or array) to store the resultant words.
- Optionally, a character frequency array or a sorted version of the word for quick anagram checks.

### Complexity:
- **Time Complexity**: O(n * m log m), where n is the number of words and m is the average length of the words. This accounts for the sorting of each word for the anagram check. If we use a frequency count instead, the complexity can be reduced to O(n * m).
- **Space Complexity**: O(n) for the resultant list, where n is the number of unique words that remain after removing anagrams.

This approach is efficient given the problem constraints and ensures that we correctly identify and remove adjacent anagrams from the list.
