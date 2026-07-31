# Minimum Number of Pushes to Type Word II (Medium)

**Problem ID:** 3016  
**Date:** 2026-07-31  
**Link:** https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii/

## Approach

To solve the problem of determining the minimum number of pushes needed to type a given word on a remapped telephone keypad, we can follow these steps:

### Problem Analysis
The key insight is that the frequency of each letter in the input word directly influences the number of pushes required. The more frequently a letter appears, the fewer pushes it should take to type it. This is because we can assign letters to keys in a way that minimizes the total push cost.

### Approach
1. **Count Frequency**: First, we need to count the frequency of each letter in the input word. This can be efficiently done using a dictionary or an array of size 26 (for each letter from 'a' to 'z').

2. **Sort Frequencies**: Once we have the frequency of each letter, we will sort these frequencies in descending order. This allows us to assign the letters with the highest frequencies to the keys that require the fewest pushes.

3. **Assign Letters to Keys**: The keys can be thought of as having a push cost that increases with the number of letters assigned to them. Specifically, the first key can have letters that require 1 push, the second key can have letters that require 2 pushes, and so on. Since there are 8 keys (2 to 9), we can assign letters to keys in groups of 8:
   - The first 8 most frequent letters will require 1 push each.
   - The next 8 will require 2 pushes each, and so on.

4. **Calculate Total Pushes**: Iterate through the sorted frequencies and calculate the total number of pushes required based on the push costs determined by their positions in the sorted list.

### Data Structures
- A frequency array (or dictionary) to count occurrences of each letter.
- A list to sort the frequencies.

### Complexity
- **Time Complexity**: O(n + k log k), where n is the length of the word (for counting frequencies) and k is the number of unique letters (at most 26, so sorting is effectively O(1)).
- **Space Complexity**: O(k), which is O(1) in this case since k is bounded by 26.

### Conclusion
By leveraging frequency counts and sorting, we can efficiently determine the optimal mapping of letters to keys to minimize the total number of pushes required to type the word. This approach ensures that we handle the constraints effectively and arrive at the correct solution.
