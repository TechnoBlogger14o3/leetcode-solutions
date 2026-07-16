# Sum of GCD of Formed Pairs (Medium)

**Problem ID:** 3867  
**Date:** 2026-07-16  
**Link:** https://leetcode.com/problems/sum-of-gcd-of-formed-pairs/

## Approach

To solve the problem of calculating the sum of GCDs of formed pairs from the `prefixGcd` array, we can follow a structured approach:

### Problem Breakdown
1. **Construct the `prefixGcd` Array**:
   - For each index `i` in the input array `nums`, compute the maximum value `mx[i]` from the start of the array to index `i`.
   - Calculate `prefixGcd[i]` as the GCD of `nums[i]` and `mx[i]`.

2. **Sort the `prefixGcd` Array**:
   - Once the `prefixGcd` array is constructed, sort it in non-decreasing order.

3. **Form Pairs**:
   - Pair the smallest unpaired element with the largest unpaired element. Continue this until no more pairs can be formed.
   - If the length of the `prefixGcd` array is odd, the middle element will remain unpaired and should be ignored.

4. **Calculate the GCD of Each Pair**:
   - For each formed pair, compute the GCD and accumulate the results to get the final sum.

### Data Structures
- An array (or list) to hold the `prefixGcd` values.
- A sorting algorithm to arrange the `prefixGcd` array.
- Simple integer variables to keep track of indices for pairing.

### Complexity Analysis
- **Time Complexity**:
  - Constructing the `prefixGcd` array involves a single pass through `nums`, which is O(n).
  - Sorting the `prefixGcd` array takes O(n log n).
  - Pairing and calculating GCDs for at most `n/2` pairs is O(n).
  - Overall, the time complexity is O(n log n) due to the sorting step.

- **Space Complexity**:
  - The space complexity is O(n) for storing the `prefixGcd` array.

### Summary
The main idea is to first derive the `prefixGcd` values based on the maximum values encountered so far, sort the results, and then compute the GCDs of pairs formed from the sorted array. This structured approach ensures we efficiently handle the constraints while achieving the desired results.
