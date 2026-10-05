# Score of Parentheses (Medium)

**Problem ID:** 856  
**Date:** 2026-10-05  
**Link:** https://leetcode.com/problems/score-of-parentheses/

## Approach

To solve the "Score of Parentheses" problem, we can use a stack-based approach or a counter-based approach to efficiently compute the score of a balanced parentheses string. 

### Main Idea:
The core idea is to leverage the properties of balanced parentheses and the scoring rules provided. We can interpret the string as a series of nested or concatenated structures, where:
- Each pair of parentheses "()" contributes a score of 1.
- Nested structures such as "(A)" double the score of the contained structure A.
- Concatenated structures like "AB" sum their scores.

### Approach:
1. **Stack-Based Approach**:
   - Initialize a stack to keep track of scores.
   - Traverse the string character by character:
     - For each opening parenthesis '(', push a marker (like 0) onto the stack to indicate the start of a new score context.
     - For each closing parenthesis ')':
       - Pop from the stack until you find the corresponding opening parenthesis. Calculate the score for the enclosed structure:
         - If the top of the stack is a marker (0), it means we have a direct "()", so we add 1.
         - If there are scores accumulated in the stack, sum them and multiply by 2 for the enclosing parentheses.
       - Push the calculated score back onto the stack.
   - At the end of the traversal, the stack will contain the total score.

2. **Counter-Based Approach**:
   - Use a single integer variable to keep track of the current score and a depth counter to track how deep we are in nested parentheses.
   - Traverse the string:
     - Increment the depth for each '(', and when encountering ')', calculate the score based on the current depth:
       - If depth is 1 (indicating a direct pair "()" at the top level), add 1 to the score.
       - For deeper levels, add \(2^{(depth-1)}\) to the score to account for the nested structure.
     - Decrement the depth after processing each ')'.
   - The final score will be the accumulated value after processing the entire string.

### Data Structures:
- **Stack**: Used to manage scores and track the depth of nested structures.
- **Integer**: For the counter-based approach to maintain the current score and depth.

### Complexity:
- **Time Complexity**: O(n), where n is the length of the string. Each character is processed once.
- **Space Complexity**: O(n) in the worst case for the stack approach, but O(1) for the counter-based approach since it only uses a few integer variables.

This structured approach allows us to efficiently compute the score of the balanced parentheses string while maintaining clarity and adherence to the problem's rules.
