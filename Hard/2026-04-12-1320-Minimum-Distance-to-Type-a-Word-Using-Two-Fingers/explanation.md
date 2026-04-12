# Minimum Distance to Type a Word Using Two Fingers (Hard)

**Problem ID:** 1320  
**Date:** 2026-04-12  
**Link:** https://leetcode.com/problems/minimum-distance-to-type-a-word-using-two-fingers/

## Approach

To solve the problem of finding the minimum distance to type a word using two fingers on a keyboard represented in a 2D plane, we can adopt a dynamic programming approach. Here’s a concise breakdown of the solution:

### Main Idea:
The goal is to minimize the total distance traveled by two fingers as they type out the given word, where the distance between two letters is defined by their Manhattan distance on the keyboard layout. We will use dynamic programming to keep track of the minimum distances for typing each letter in the word while considering the positions of both fingers.

### Data Structures:
1. **Distance Matrix**: Precompute the distances between all pairs of letters based on their coordinates on the keyboard. This will allow us to quickly look up the distance between any two letters.
2. **Dynamic Programming Table**: Use a 3D DP table `dp[i][j][k]`, where:
   - `i` represents the index of the current letter in the word.
   - `j` represents the position of the first finger (the last letter typed by finger 1).
   - `k` represents the position of the second finger (the last letter typed by finger 2).
   The value `dp[i][j][k]` will store the minimum distance required to type the first `i` letters of the word with finger 1 on letter `j` and finger 2 on letter `k`.

### Approach:
1. **Initialization**: Start by initializing the DP table for the first letter of the word, allowing both fingers to start on any letter without any initial cost.
2. **Transition**: For each letter in the word (from the second letter onward):
   - Iterate through all possible positions of the two fingers (from the previous letter).
   - Calculate the cost of moving either finger to the current letter and update the DP table accordingly.
   - The transition will consider moving either finger to the current letter and accumulating the distance based on the previous positions of both fingers.
3. **Final Computation**: After processing all letters, the answer will be the minimum value in the last layer of the DP table, which corresponds to typing the entire word.

### Complexity:
- **Time Complexity**: O(n * 26 * 26), where `n` is the length of the word (up to 300) and 26 represents the number of uppercase English letters. This is because for each letter, we consider all pairs of finger positions.
- **Space Complexity**: O(n * 26 * 26) for the DP table, although optimizations can be made to reduce space usage by only storing the last two layers of the DP table.

This approach ensures that we systematically explore all possible configurations of finger placements while efficiently calculating the minimum distance required to type the word.
