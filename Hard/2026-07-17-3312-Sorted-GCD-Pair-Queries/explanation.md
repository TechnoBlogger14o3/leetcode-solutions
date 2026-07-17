# Sorted GCD Pair Queries (Hard)

**Problem ID:** 3312  
**Date:** 2026-07-17  
**Link:** https://leetcode.com/problems/sorted-gcd-pair-queries/

## Approach

To solve the "Sorted GCD Pair Queries" problem, we need to efficiently compute the GCD of all possible pairs from the `nums` array, sort these GCD values, and then answer the queries based on the sorted results.

### Approach:

1. **Understand the Problem**: We need to find the GCD for every unique pair `(nums[i], nums[j])` where `0 <= i < j < n`, then sort these GCD values, and finally retrieve values based on the indices specified in the `queries` array.

2. **Calculate GCD Pairs**:
   - Iterate through all unique pairs `(i, j)` using two nested loops. For each pair, compute the GCD using the built-in GCD function.
   - Store the computed GCDs in a list.

3. **Sorting**:
   - Once all GCDs are collected, sort the list in ascending order. This is necessary because the queries require us to return values based on sorted indices.

4. **Answering Queries**:
   - For each query, simply access the sorted GCD list using the index provided in the `queries` array. This can be done in constant time for each query.

### Data Structures:
- A list (or array) to store the GCD values.
- The sorted list of GCD values will also be a list.

### Complexity Analysis:
- **Time Complexity**:
  - The GCD computation for each pair takes constant time, and since there are `n(n-1)/2` pairs, the total time for this step is O(n^2).
  - Sorting the GCD list will take O(k log k), where `k` is the number of GCDs computed (which is `n(n-1)/2`).
  - Answering the queries takes O(m) where `m` is the number of queries.
  
  Overall, the dominant factor is O(n^2) due to pairwise GCD computation, which is feasible for smaller values of `n` but may be inefficient for the upper limit (n = 10^5).

- **Space Complexity**:
  - We use O(k) space for storing the GCD values, where `k` is the number of pairs, leading to O(n^2) space in the worst case.

### Optimization Considerations:
Given the constraints, a naive approach may not be efficient enough for the upper limits. To optimize:
- Consider using frequency counts of the numbers to reduce the number of GCD computations.
- Use mathematical properties of GCD to limit the pairs that need to be computed or leverage data structures that can handle GCD queries more efficiently.

This approach provides a structured way to tackle the problem, ensuring that we can compute the necessary values and respond to queries effectively.
