# Minimum Number of Pushes to Type Word I (Easy)

**Problem ID:** 3014  
**Date:** 2026-07-30  
**Link:** https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-i/

## Approach

To solve the problem of finding the minimum number of pushes needed to type a given word using a remapped telephone keypad, we can follow a systematic approach:

### Problem Understanding
The task is to map distinct letters of the input string `word` to keys on a telephone keypad (keys 2 to 9) in such a way that minimizes the total number of key presses required to type the entire word. Each key can be assigned multiple letters, and the number of presses for each letter corresponds to its position on the key (e.g., the first letter requires 1 press, the second requires 2 presses, etc.).

### Approach
1. **Character Count**: Since the input string consists of distinct lowercase letters, we can directly determine how many letters we need to map.

2. **Key Mapping**: The keys can be remapped to hold a varying number of letters. Given that there are 8 usable keys (2 to 9), we can distribute the letters across these keys to minimize presses.

3. **Optimal Distribution**:
   - The optimal way to minimize the number of pushes is to assign the letters such that the most frequently pressed letters (those that require the most pushes) are assigned to keys with fewer letters.
   - For example, if we have `n` letters, we can distribute them such that the first `n // 8` letters are assigned to the first key, the next set to the second key, and so on. Any remaining letters can be assigned to the keys in a round-robin fashion.

4. **Calculating Pushes**:
   - For each letter assigned to a key, calculate the number of pushes required based on its position in the mapping. The first letter on a key requires 1 push, the second requires 2 pushes, and so on.
   - The total number of pushes is the sum of all individual pushes required for each letter.

### Data Structures
- A simple list or array can be used to represent the keys and their assigned letters.
- We can also utilize basic arithmetic to calculate the number of pushes without needing complex data structures.

### Complexity
- The time complexity of this approach is O(n), where n is the length of the word. This is because we are simply iterating through the letters to assign them to keys and calculate the total pushes.
- The space complexity is O(1) since we are not using any additional data structures that scale with input size beyond a fixed number of keys.

### Conclusion
By strategically mapping the letters to the keys and calculating the total pushes based on their positions, we can efficiently determine the minimum number of pushes required to type the word. This approach ensures optimal distribution of letters across the available keys, leading to the desired result.
