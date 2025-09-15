# Maximum Number of Words You Can Type (Easy)

**Problem ID:** 1935  
**Date:** 2025-09-15  
**Link:** https://leetcode.com/problems/maximum-number-of-words-you-can-type/

## Approach

To solve the problem of determining the maximum number of words that can be fully typed with a malfunctioning keyboard, we can follow a straightforward approach:

### Approach:

1. **Input Parsing**: Split the input string `text` into individual words using space as a delimiter. This can be easily achieved using the built-in string split function.

2. **Broken Letters Representation**: Convert the string `brokenLetters` into a set for efficient membership checking. This allows us to quickly determine if any character in a word is broken.

3. **Word Validation**: For each word in the list of words obtained from `text`, check if it can be fully typed. This involves iterating through each character of the word and checking if it exists in the set of broken letters. If a character is found in the set, the word cannot be typed.

4. **Counting Valid Words**: Maintain a counter to keep track of the number of words that can be fully typed. Increment this counter for each word that passes the validation check.

5. **Output the Result**: Finally, return the count of valid words.

### Main Idea:
The key idea is to leverage the efficiency of set lookups to quickly determine if any characters in a word are broken. This allows us to validate each word in linear time relative to its length.

### Data Structures:
- **List**: To store the words from the input string `text`.
- **Set**: To store the broken letters for O(1) average time complexity on membership tests.

### Complexity:
- **Time Complexity**: O(n * m), where n is the number of words in `text` and m is the average length of the words. This is because we check each character of each word against the set of broken letters.
- **Space Complexity**: O(k), where k is the number of distinct broken letters (at most 26), for storing the set of broken letters.

This approach is efficient given the constraints and effectively counts the number of words that can be typed with the malfunctioning keyboard.
