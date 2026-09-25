# Brace Expansion II (Hard)

**Problem ID:** 1096  
**Date:** 2026-09-25  
**Link:** https://leetcode.com/problems/brace-expansion-ii/

## Approach

To solve the Brace Expansion II problem, we can use a stack-based approach to handle the nested structure of the input expression. The main idea is to parse the expression character by character, managing the different types of components (letters, sets, and concatenations) as we go. Here's a concise breakdown of the approach:

### Main Idea:
1. **Stack for Nested Structures**: Use a stack to manage the current context of words being built. Each time we encounter an opening brace `{`, we push the current set of words onto the stack and start a new set. When we encounter a closing brace `}`, we pop from the stack and combine the current set of words with the previous set.

2. **Handling Characters and Sets**: 
   - For lowercase letters, we treat them as singleton sets (e.g., `R('a') = {'a'}`).
   - For expressions within braces `{}`, we recursively evaluate the contents to generate the union of the sets defined within.
   - For concatenation, when we encounter a sequence of characters or sets, we compute the Cartesian product of the current set of words with the next set, effectively concatenating them.

3. **Union of Sets**: When processing comma-separated expressions, we combine the results using a set to ensure uniqueness, as the final output should not contain duplicate words.

### Data Structures:
- **Stack**: To manage nested expressions and keep track of the current set of words.
- **Set**: To collect unique words generated from expressions, ensuring no duplicates.

### Complexity:
- **Time Complexity**: O(n * m), where n is the length of the expression and m is the average number of words generated from each set. This accounts for parsing the expression and generating combinations.
- **Space Complexity**: O(m), where m is the number of unique words generated, as we store these in a set.

### Steps:
1. Initialize a stack and an empty set for the current words.
2. Iterate through the expression:
   - If a letter is encountered, add it to the current set.
   - If `{` is encountered, push the current set onto the stack and start a new set.
   - If `}` is encountered, combine the current set with the set popped from the stack.
   - If `,` is encountered, finalize the current set and prepare for the next expression.
3. After processing the entire expression, sort the final set of words and return it as a list.

This structured approach effectively handles the grammar rules and ensures that we generate the correct set of words as specified in the problem statement.
