# Find the Number of Subsequences With Equal GCD (Hard)

**Problem ID:** 3336  
**Date:** 2026-07-14  
**Link:** https://leetcode.com/problems/find-the-number-of-subsequences-with-equal-gcd/

## Approach

To solve the problem of finding the number of pairs of disjoint subsequences with equal GCD from the given integer array `nums`, we can follow a structured approach:

### Main Idea:
The core idea is to leverage the properties of GCD and the combinatorial nature of subsequences. We will count how many subsequences yield each possible GCD and then compute the valid pairs based on these counts.

### Steps to Approach:

1. **Count Frequency of Elements**: First, we create a frequency array to count how many times each integer from 1 to 200 appears in `nums`. This helps us in efficiently calculating the number of subsequences for each GCD.

2. **Calculate Subsequences for Each GCD**:
   - For each possible GCD `g` (from 1 to 200), we need to find all the multiples of `g` in `nums`. This will allow us to consider only those elements that can contribute to a GCD of `g`.
   - For each multiple `g * k`, we sum the counts of these multiples to get the total count of elements contributing to GCD `g`.
   - The number of non-empty subsequences that can be formed from `c` elements is `2^c - 1` (the total number of subsequences minus the empty subsequence).

3. **Count Valid Pairs**:
   - For each GCD `g`, if there are `count_g` non-empty subsequences that yield GCD `g`, the number of ways to choose two disjoint subsequences from these is given by the combination formula: `count_g * (count_g - 1)`. This counts pairs `(seq1, seq2)` where `seq1` and `seq2` are disjoint.
   - We sum these counts across all possible GCDs.

4. **Modulo Operation**: Since the result can be large, we take all results modulo \(10^9 + 7\).

### Data Structures:
- An array (or list) to maintain the frequency of numbers from 1 to 200.
- An integer variable to accumulate the total count of valid pairs.

### Complexity:
- **Time Complexity**: The algorithm runs in \(O(n + m \log m)\), where \(n\) is the length of `nums` and \(m\) is the maximum value in `nums` (which is 200). The logarithmic factor comes from calculating powers of 2.
- **Space Complexity**: \(O(m)\) for the frequency array.

This structured approach efficiently counts pairs of disjoint subsequences with equal GCD by focusing on the properties of GCD and combinatorial counting, ensuring that we stay within the problem's constraints.
