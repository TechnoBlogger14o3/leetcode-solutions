# Binary Gap (Easy)

**Problem ID:** 868  
**Date:** 2026-02-22  
**Link:** https://leetcode.com/problems/binary-gap/

## Approach

To solve the "Binary Gap" problem, we need to find the longest distance between any two adjacent '1's in the binary representation of a given positive integer \( n \).

### Approach:

1. **Binary Representation**: First, we convert the integer \( n \) into its binary form. This can be done using built-in functions or bit manipulation.

2. **Track Positions of '1's**: As we traverse the binary string, we will keep track of the positions (indices) of each '1' encountered. This can be done using a simple list or array to store the indices.

3. **Calculate Distances**: Once we have the positions of all '1's, we can calculate the distances between each pair of adjacent '1's. The distance between two '1's at positions \( i \) and \( j \) is given by \( j - i \).

4. **Find Maximum Distance**: As we compute the distances, we maintain a variable to track the maximum distance found. If there are no adjacent '1's (i.e., less than two '1's in the binary representation), we return 0.

### Data Structures:
- A list (or array) to store the indices of '1's in the binary representation.

### Complexity:
- **Time Complexity**: The time complexity is \( O(\log n) \) because the number of bits in the binary representation of \( n \) is \( \log_2(n) \).
- **Space Complexity**: The space complexity is also \( O(\log n) \) due to storing the indices of '1's.

This approach efficiently calculates the desired distance by leveraging the properties of binary numbers and simple list operations, ensuring that we meet the problem's constraints.
