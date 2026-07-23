# Number of Unique XOR Triplets I (Medium)

**Problem ID:** 3513  
**Date:** 2026-07-23  
**Link:** https://leetcode.com/problems/number-of-unique-xor-triplets-i/

## Approach

To solve the problem of finding the number of unique XOR triplet values from a given permutation of integers, we can utilize the properties of the XOR operation and the constraints provided.

### Main Idea:
The key observation is that the XOR operation is both associative and commutative, which allows us to compute the XOR of any three elements in any order. Given that `nums` is a permutation of integers from 1 to n, we can leverage the fact that the maximum possible XOR value will be limited by the range of these integers.

### Approach:
1. **Iterate Over Triplets**: We need to generate all possible triplets (i, j, k) where \( i \leq j \leq k \). Given the constraints, a brute-force approach would be too slow, so we will focus on efficient computation.
  
2. **Use a Set for Uniqueness**: To keep track of unique XOR values, we can use a set data structure, which allows for O(1) average time complexity for insertions and checks for uniqueness.

3. **Calculate XOR Values**:
   - For each index `i`, iterate from `i` to the end of the array for `j`, and from `j` to the end for `k`.
   - Compute the XOR for the triplet `nums[i] XOR nums[j] XOR nums[k]` and store the result in the set.

4. **Count Unique Values**: Finally, the number of unique XOR values will be the size of the set.

### Complexity:
- **Time Complexity**: The naive approach would involve three nested loops leading to O(n^3) complexity, which is impractical for \( n \) up to \( 10^5 \). Instead, we can optimize the inner calculations and reduce the number of iterations by leveraging properties of XOR and the constraints of the array.
- **Space Complexity**: The space complexity is O(m), where m is the number of unique XOR values stored in the set. In the worst case, m can be up to n, but typically it will be much smaller.

### Conclusion:
By using a systematic approach to generate triplets and utilizing a set to track unique XOR results, we can efficiently solve the problem while adhering to the constraints. The focus on properties of XOR and careful iteration will help ensure that we stay within acceptable time limits.
