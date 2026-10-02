# Generate Parentheses (Medium)

**Problem ID:** 22  
**Date:** 2026-10-02  
**Link:** https://leetcode.com/problems/generate-parentheses/

## Approach

To solve the "Generate Parentheses" problem, we can use a backtracking approach. The main idea is to build the combinations of parentheses incrementally while ensuring that they remain valid at each step. 

### Approach:

1. **Backtracking**: We will use a recursive function to explore all possible combinations of parentheses. The function will take the current string of parentheses being built, along with two counters: one for the number of opening parentheses used (`open_count`) and one for the closing parentheses used (`close_count`).

2. **Base Case**: The recursion will terminate when the length of the current string equals `2 * n` (since each pair of parentheses contributes two characters). At this point, we add the valid combination to our result list.

3. **Valid Moves**:
   - We can add an opening parenthesis `'('` if `open_count` is less than `n`.
   - We can add a closing parenthesis `')'` if `close_count` is less than `open_count`. This ensures that we never have more closing parentheses than opening ones at any point, maintaining the validity of the parentheses.

4. **Data Structures**: We will use a list to store the valid combinations of parentheses. The recursive function will build strings and track counts using simple integer variables.

### Complexity:
- **Time Complexity**: The time complexity is O(4^n / √n), which is derived from the fact that the number of valid combinations of parentheses grows exponentially with `n`. This complexity reflects the Catalan number sequence.
- **Space Complexity**: The space complexity is O(n) for the recursion stack, plus O(C(n)) for storing the results, where C(n) is the number of valid combinations.

This backtracking approach is efficient and straightforward, allowing us to generate all valid combinations of parentheses for the given `n` pairs.
