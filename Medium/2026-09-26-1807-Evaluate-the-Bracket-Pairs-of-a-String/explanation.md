# Evaluate the Bracket Pairs of a String (Medium)

**Problem ID:** 1807  
**Date:** 2026-09-26  
**Link:** https://leetcode.com/problems/evaluate-the-bracket-pairs-of-a-string/

## Approach

To solve the problem of evaluating bracket pairs in a string based on provided key-value pairs, we can follow a systematic approach that utilizes efficient data structures and string manipulation techniques.

### Problem-Solving Approach:

1. **Data Structure for Key-Value Pairs**:
   - Use a hash map (dictionary) to store the key-value pairs from the `knowledge` array. This allows for O(1) average time complexity for lookups when evaluating the keys in the string.

2. **Iterate Through the String**:
   - Traverse the input string `s` character by character. We will maintain a result list to build the final output string efficiently.

3. **Identify Bracket Pairs**:
   - When encountering an opening bracket `(`, start collecting characters until the corresponding closing bracket `)` is found. This will give us the key to evaluate.

4. **Evaluate Keys**:
   - Once a complete key is identified, check if it exists in the hash map:
     - If it exists, append the corresponding value to the result.
     - If it does not exist, append a question mark `?`.

5. **Handle Non-Bracket Characters**:
   - For characters that are not part of any bracket pair, simply append them directly to the result list.

6. **Construct the Final Output**:
   - After processing all characters, join the result list into a single string to form the final output.

### Complexity Analysis:
- **Time Complexity**: O(n), where n is the length of the string `s`. Each character is processed once, and lookups in the hash map are O(1) on average.
- **Space Complexity**: O(m + n), where m is the number of key-value pairs in `knowledge` and n is the length of the result string. The hash map requires space for the keys and values, and the result list requires space proportional to the output size.

By following this approach, we efficiently evaluate the bracket pairs in the string while ensuring that our solution remains scalable for the input constraints provided.
