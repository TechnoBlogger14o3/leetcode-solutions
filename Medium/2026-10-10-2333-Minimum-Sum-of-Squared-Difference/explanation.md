# Minimum Sum of Squared Difference (Medium)

**Problem ID:** 2333  
**Date:** 2026-10-10  
**Link:** https://leetcode.com/problems/minimum-sum-of-squared-difference/

## Approach

To solve the problem of minimizing the sum of squared differences between two arrays `nums1` and `nums2` after allowed modifications, we can adopt the following approach:

### Problem Breakdown
1. **Understanding the Objective**: The goal is to minimize the expression \( \text{sum}((\text{nums1}[i] - \text{nums2}[i])^2) \) for all indices \( i \). This can be expanded to \( \text{sum}(\text{nums1}[i]^2) - 2 \cdot \text{nums1}[i] \cdot \text{nums2}[i] + \text{nums2}[i]^2 \).

2. **Modifications**: We can modify elements in `nums1` and `nums2` within the limits of `k1` and `k2`. Each modification can either increase or decrease an element by 1.

### Approach
1. **Calculate Initial Differences**: For each index \( i \), compute the initial difference \( d[i] = \text{nums1}[i] - \text{nums2}[i] \). The sum of squared differences can be derived from these differences.

2. **Greedy Strategy**: To minimize the squared differences, we should aim to bring the values of `nums1[i]` and `nums2[i]` closer together. The most impactful modifications will be those that reduce the largest absolute differences first.

3. **Priority Queue**: Use a max-heap (or priority queue) to keep track of the absolute differences \( |d[i]| \). This allows us to efficiently access and modify the largest differences.

4. **Modification Process**:
   - While we have remaining modifications (`k1` and `k2`), extract the largest absolute difference from the heap.
   - Depending on whether we can modify `nums1` or `nums2`, reduce the difference by modifying the respective element.
   - Push the updated difference back into the heap.
   - Continue until we exhaust the allowed modifications.

5. **Final Calculation**: After all possible modifications, compute the final sum of squared differences using the modified differences.

### Data Structures
- **Max-Heap**: To efficiently manage and retrieve the largest absolute differences.
- **Arrays**: To store the original values and modified differences.

### Complexity
- **Time Complexity**: The main operations involve inserting and extracting from the heap, which takes \( O(\log n) \). Given that we may perform at most \( O(n) \) operations (one for each element), the overall time complexity is \( O(n \log n) \).
- **Space Complexity**: The space complexity is \( O(n) \) for storing the differences and the heap.

This approach ensures that we systematically minimize the squared differences while adhering to the constraints of modifications, leading to an efficient and effective solution.
