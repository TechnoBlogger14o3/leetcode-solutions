# Minimum Distance Between Three Equal Elements II (Medium)

**Problem ID:** 3741  
**Date:** 2026-04-11  
**Link:** https://leetcode.com/problems/minimum-distance-between-three-equal-elements-ii/

## Approach

To solve the problem of finding the minimum distance between three equal elements in an array, we can adopt the following approach:

### Main Idea
The goal is to find three distinct indices \(i\), \(j\), and \(k\) such that the elements at these indices are equal, and we want to minimize the distance defined as \( \text{abs}(i - j) + \text{abs}(j - k) + \text{abs}(k - i) \). This distance can be simplified to \( \text{max}(i, j, k) - \text{min}(i, j, k) \) multiplied by 2, since the absolute differences can be rearranged.

### Approach
1. **Index Tracking**: Use a dictionary to map each unique number in the array to a list of its indices. This allows us to quickly access the positions of any number.

2. **Distance Calculation**: For each number that appears at least three times (since we need three indices), retrieve its list of indices. We can then calculate the distance for every triplet of indices using a sliding window approach:
   - For a list of indices, iterate through the list and for each triplet of indices \( (i, j, k) \), compute the distance using the formula mentioned above.
   - Since the indices are sorted, we can efficiently compute the distance by just considering the first three indices in the list and sliding through the list.

3. **Minimization**: Track the minimum distance encountered during the iteration. If no valid triplet is found, return -1.

### Data Structures
- A dictionary (or hashmap) to store lists of indices for each unique number.
- A variable to keep track of the minimum distance found.

### Complexity
- **Time Complexity**: The overall time complexity is \(O(n)\) for traversing the array to populate the dictionary and \(O(k)\) for processing each unique number, where \(k\) is the number of unique elements. In the worst case, this is still linear relative to the size of the input.
- **Space Complexity**: The space complexity is \(O(n)\) in the worst case, where all elements are unique and stored in the dictionary.

This approach is efficient and leverages the properties of indices and distances to find the solution without the need for a brute-force search, making it suitable for the problem's constraints.
