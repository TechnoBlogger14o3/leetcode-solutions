# Remove Invalid Parentheses (Hard)

**Problem ID:** 301  
**Date:** 2026-10-07  
**Link:** https://leetcode.com/problems/remove-invalid-parentheses/

## Approach

To solve the problem of removing invalid parentheses from a given string, we can employ a breadth-first search (BFS) approach. The main idea is to explore all possible strings that can be formed by removing parentheses, starting from the original string, until we find valid configurations. Here’s a step-by-step breakdown of the approach:

1. **Validation Function**: First, we need a helper function to check if a string has valid parentheses. This can be done using a counter that increments for each '(' and decrements for each ')'. If at any point the counter goes negative or does not return to zero at the end, the string is invalid.

2. **BFS Initialization**: We utilize a queue to perform BFS. The queue will store pairs of the current string and the number of parentheses removed so far. We also maintain a set to track visited strings to avoid processing duplicates.

3. **BFS Execution**: 
   - Start by enqueueing the original string with a removal count of zero.
   - While the queue is not empty, dequeue an element and check if it is valid using the validation function.
   - If the string is valid, add it to a results set (to ensure uniqueness).
   - If the string is not valid, generate all possible strings by removing one parenthesis at a time and enqueue these new strings if they haven't been visited yet. The removal count is incremented for the next level of BFS.

4. **Termination Condition**: The BFS continues until we find valid strings. Since we are exploring all possibilities layer by layer, the first time we find valid strings will correspond to the minimum number of removals.

5. **Output**: Finally, return the results as a list of unique valid strings.

**Data Structures**:
- A queue for BFS operations.
- A set to track visited strings and ensure uniqueness.
- A list or set to store valid results.

**Complexity**:
- The time complexity is O(N * 2^N) in the worst case, where N is the length of the string, due to the generation of all possible strings by removing parentheses.
- The space complexity is also O(N * 2^N) for storing the generated strings and the BFS queue.

This approach efficiently explores all configurations of the string while ensuring that we only return the minimum removals needed to achieve valid parentheses.
