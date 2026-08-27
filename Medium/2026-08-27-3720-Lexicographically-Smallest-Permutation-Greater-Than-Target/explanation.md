# Lexicographically Smallest Permutation Greater Than Target (Medium)

**Problem ID:** 3720  
**Date:** 2026-08-27  
**Link:** https://leetcode.com/problems/lexicographically-smallest-permutation-greater-than-target/

## Approach

To solve the problem of finding the lexicographically smallest permutation of string `s` that is strictly greater than `target`, we can follow a systematic approach:

### Approach:

1. **Sorting and Permutation Generation**:
   - Start by generating all unique permutations of the string `s`. This can be efficiently achieved by sorting `s` and using a backtracking approach to generate permutations, ensuring that duplicates are avoided.

2. **Comparison with Target**:
   - As we generate each permutation, we can compare it directly with the `target` string. Our goal is to find the smallest permutation that is strictly greater than `target`.

3. **Early Stopping**:
   - Since we are generating permutations in lexicographical order (due to the initial sorting), we can stop as soon as we find the first permutation that meets the criteria of being greater than `target`. This avoids unnecessary comparisons and improves efficiency.

4. **Return Result**:
   - If we find such a permutation, we return it. If no permutation is found that is greater than `target`, we return an empty string.

### Data Structures:
- A list or array can be used to store the characters of `s` for permutation generation.
- A set may be utilized to keep track of unique permutations if duplicates are possible.

### Complexity:
- The time complexity primarily depends on the number of permutations generated, which is O(n!), where `n` is the length of `s`. However, since we stop early upon finding a valid permutation, the average case may be better than this worst-case scenario.
- The space complexity is O(n) for storing the characters of `s` and potentially O(n!) for storing all unique permutations, although this is typically not realized in practice due to early stopping.

### Conclusion:
This approach efficiently finds the required permutation by leveraging sorting and systematic generation of permutations, ensuring that we minimize unnecessary computations through early stopping upon finding the first valid result.
