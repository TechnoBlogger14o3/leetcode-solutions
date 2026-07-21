# Maximize Active Section with Trade I (Medium)

**Problem ID:** 3499  
**Date:** 2026-07-21  
**Link:** https://leetcode.com/problems/maximize-active-section-with-trade-i/

## Approach

To solve the problem "Maximize Active Section with Trade I", we need to maximize the number of active sections ('1's) in a binary string by performing at most one trade. The trade consists of converting a contiguous block of '1's surrounded by '0's into '0's and converting a contiguous block of '0's surrounded by '1's into '1's.

### Approach:

1. **Augmentation of the String**: 
   We treat the string as if it is augmented with '1's at both ends. This helps in simplifying the boundary conditions when analyzing the sections of '1's and '0's.

2. **Identify Sections**:
   We traverse the string to identify contiguous blocks of '1's and '0's. We can maintain two lists:
   - `ones`: to store the lengths of blocks of '1's.
   - `zeros`: to store the lengths of blocks of '0's.

3. **Count Initial Active Sections**:
   The initial count of active sections is simply the number of blocks of '1's, which can be derived from the `ones` list.

4. **Evaluate Trade Options**:
   For each block of '0's that is surrounded by '1's (i.e., for each entry in the `zeros` list), we can consider the potential trade:
   - If we convert the surrounding '1's and the block of '0's, we can increase the count of active sections. Specifically, if we have a block of '0's of length `z` between two blocks of '1's of lengths `o1` and `o2`, the new count of active sections after the trade would be:
     - `new_active_sections = initial_active_sections - 1 + (o1 + o2 + z)`, where we subtract 1 for the block of '1's that is converted to '0's and add back the newly formed blocks of '1's.

5. **Maximize the Count**:
   We iterate through each block of '0's and calculate the potential new active sections after the trade. We keep track of the maximum count encountered during this evaluation.

6. **Complexity**:
   The overall complexity of this approach is O(n), where n is the length of the string. This is because we make a single pass to identify the blocks and another pass to evaluate the trade options.

### Data Structures:
- Two lists (`ones` and `zeros`) to store the lengths of contiguous blocks of '1's and '0's, respectively.

By following this structured approach, we can efficiently determine the maximum number of active sections achievable through a single trade in the binary string.
