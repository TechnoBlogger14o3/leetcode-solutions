# Maximum Distance Between a Pair of Values (Medium)

**Problem ID:** 1855  
**Date:** 2026-04-19  
**Link:** https://leetcode.com/problems/maximum-distance-between-a-pair-of-values/

## Approach

To solve the problem of finding the maximum distance between a pair of values from two non-increasing arrays, we can employ a two-pointer technique. Here’s a concise breakdown of the approach:

### Main Idea:
The goal is to find indices \(i\) and \(j\) such that \(0 \leq i < \text{nums1.length}\), \(0 \leq j < \text{nums2.length}\), \(i \leq j\), and \(\text{nums1}[i] \leq \text{nums2}[j]\). The distance is defined as \(j - i\), and we want to maximize this distance.

### Approach:
1. **Initialization**: Start with two pointers, one for each array. Let \(i\) begin at the start of `nums1` and \(j\) at the start of `nums2`.

2. **Iterate with Two Pointers**:
   - Use a while loop to iterate through the arrays. For each index \(i\) in `nums1`, increment \(j\) in `nums2` as long as the condition \(\text{nums1}[i] \leq \text{nums2}[j]\) holds true. This is possible because both arrays are non-increasing, meaning if \(\text{nums1}[i] \leq \text{nums2}[j]\), then \(\text{nums1}[i] \leq \text{nums2}[j+1]\) will also hold until \(j\) reaches the end of `nums2`.

3. **Calculate Distance**: For every valid pair found (where \(\text{nums1}[i] \leq \text{nums2}[j]\)), calculate the distance \(j - i\) and update the maximum distance found.

4. **Increment \(i\)**: After processing all valid \(j\) for a given \(i\), increment \(i\) to check for the next element in `nums1`.

5. **Termination**: The process continues until all elements in `nums1` have been considered or \(j\) has reached the end of `nums2`.

### Data Structures:
- Two pointers (integers) for indexing `nums1` and `nums2`.

### Complexity:
- **Time Complexity**: \(O(n + m)\), where \(n\) is the length of `nums1` and \(m\) is the length of `nums2`. Each pointer traverses its respective array at most once.
- **Space Complexity**: \(O(1)\), as we are using a constant amount of extra space.

This efficient approach ensures we can handle the upper limits of the input constraints effectively, yielding the maximum distance between valid pairs in linear time.
