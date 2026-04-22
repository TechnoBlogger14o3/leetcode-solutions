# Words Within Two Edits of Dictionary (Medium)

**Problem ID:** 2452  
**Date:** 2026-04-22  
**Link:** https://leetcode.com/problems/words-within-two-edits-of-dictionary/

## Approach

To solve the problem of finding words in the `queries` array that can match any word in the `dictionary` with at most two edits, we can follow a systematic approach:

### Main Idea:
The core idea is to determine how many character positions differ between each word in `queries` and each word in `dictionary`. If the number of differing positions (or edits) is 0, 1, or 2, we consider that word from `queries` as a valid match.

### Approach:
1. **Iterate Through Queries**: For each word in the `queries` array, we will check it against all words in the `dictionary`.
  
2. **Character Comparison**: For each pair of words (one from `queries` and one from `dictionary`), we compare their characters position by position:
   - Count the number of positions where the characters differ.
  
3. **Count Edits**: If the count of differing positions is less than or equal to 2, we can consider that word from `queries` as a valid match.

4. **Store Results**: Maintain a list to store all valid matches from `queries` that meet the criteria.

### Data Structures:
- Use a list to store the results of valid matches.
- Use simple integer counters to track the number of differing characters.

### Complexity:
- **Time Complexity**: The approach involves a nested loop where each word in `queries` is compared with each word in `dictionary`. Given that both arrays can have a maximum length of 100 and each word can have a length of up to 100, the worst-case time complexity is O(m * n * k), where:
  - `m` is the number of words in `queries` (up to 100),
  - `n` is the number of words in `dictionary` (up to 100),
  - `k` is the length of each word (up to 100).
  Thus, the maximum operations could be around 1,000,000 character comparisons, which is feasible within typical time limits for competitive programming.

- **Space Complexity**: The space complexity is O(q) for storing the results, where `q` is the number of valid matches found, which is at most the size of the `queries` array.

This approach efficiently determines which words from `queries` can be transformed into words from `dictionary` with at most two edits, ensuring we return the results in the order they appeared in the input.
