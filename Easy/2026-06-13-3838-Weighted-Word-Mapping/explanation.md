# Weighted Word Mapping (Easy)

**Problem ID:** 3838  
**Date:** 2026-06-13  
**Link:** https://leetcode.com/problems/weighted-word-mapping/

## Approach

To solve the "Weighted Word Mapping" problem, we can follow a straightforward approach that involves calculating the weight of each word based on the provided weights for each character, applying a modulo operation, and mapping the result to a corresponding letter.

### Approach:

1. **Weight Calculation**:
   - For each word in the input array, initialize a weight sum to zero.
   - Iterate through each character in the word, convert the character to its corresponding index (0 for 'a', 1 for 'b', ..., 25 for 'z'), and add the weight of that character (from the weights array) to the weight sum.

2. **Modulo Operation**:
   - After calculating the total weight for the word, compute the weight modulo 26. This gives us a value between 0 and 25.

3. **Character Mapping**:
   - To map the modulo result to a character, we use the reverse alphabetical order: 
     - For a result of 0, the corresponding character is 'z', for 1 it is 'y', ..., and for 25 it is 'a'.
     - This can be achieved by calculating the character as `chr(122 - modulo_result)`, where 122 is the ASCII value of 'z'.

4. **Concatenation**:
   - Collect the mapped characters for each word into a result string.

5. **Return the Result**:
   - Finally, return the concatenated string of mapped characters.

### Data Structures:
- A simple list can be used to store the mapped characters for each word, which can then be joined to form the final result string.

### Complexity:
- **Time Complexity**: O(n * m), where n is the number of words (up to 100) and m is the maximum length of a word (up to 10). This results in a maximum of 1000 character evaluations.
- **Space Complexity**: O(n) for storing the resulting characters, where n is the number of words.

This approach is efficient given the constraints and ensures that we accurately compute the desired output by leveraging basic string and arithmetic operations.
