# Sort Integers by The Number of 1 Bits (Easy)

**Problem ID:** 1356  
**Date:** 2026-02-25  
**Link:** https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/

## Approach

To solve the problem of sorting integers by the number of 1 bits in their binary representation, we can follow a structured approach that involves counting bits and utilizing sorting techniques.

### Approach:

1. **Count the Number of 1 Bits**:
   For each integer in the array, we need to determine how many 1 bits are present in its binary representation. This can be efficiently achieved using Python’s built-in function `bin(x).count('1')`, which converts the integer to its binary form and counts the '1's.

2. **Create a Sort Key**:
   We will create a sort key for each integer that consists of two components:
   - The count of 1 bits (primary sorting criterion).
   - The integer value itself (secondary sorting criterion, to handle ties in the number of 1 bits).

3. **Sorting**:
   Using Python's built-in sorting capabilities, we can sort the array based on the tuples generated from the previous step. The sort function will first sort by the number of 1 bits and then by the integer value in ascending order.

### Data Structures:
- An array (or list) to hold the integers.
- A tuple for sorting, which contains the count of 1 bits and the integer itself.

### Complexity:
- **Time Complexity**: The overall time complexity is O(n log n) due to the sorting step, where n is the number of integers in the input array. Counting the number of 1 bits for each integer takes O(k) time, where k is the number of bits in the integer (at most 14 for values up to 10,000). Thus, the counting step is O(n * k), but since k is constant, it can be considered O(n).
- **Space Complexity**: O(n) for storing the sorted output.

### Summary:
The main idea is to create a composite key for sorting based on the number of 1 bits and the integer values themselves. By leveraging efficient counting and sorting mechanisms, we can achieve the desired output in a straightforward manner.
