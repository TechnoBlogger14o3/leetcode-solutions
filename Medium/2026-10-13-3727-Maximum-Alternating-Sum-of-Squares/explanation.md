# Maximum Alternating Sum of Squares (Medium)

**Problem ID:** 3727  
**Date:** 2026-10-13  
**Link:** https://leetcode.com/problems/maximum-alternating-sum-of-squares/

## Approach

To solve the problem of finding the maximum alternating sum of squares from a given integer array `nums`, we can leverage the properties of squares and the structure of the alternating sum.

### Main Idea:
The alternating score is calculated as:
\[ \text{score} = arr[0]^2 - arr[1]^2 + arr[2]^2 - arr[3]^2 + \ldots \]
To maximize this score, we should prioritize placing larger squares in the positive positions (even indices) and smaller squares in the negative positions (odd indices). This is because the square function is monotonically increasing, meaning larger numbers yield significantly larger squares.

### Approach:
1. **Sort the Array**: First, sort the array `nums` in descending order. This allows us to easily access the largest elements for the positive contributions to the score.

2. **Calculate the Alternating Sum**: 
   - Iterate through the sorted array and compute the alternating sum:
     - For even indices (0, 2, 4,...), add the square of the element.
     - For odd indices (1, 3, 5,...), subtract the square of the element.
   - This ensures that we are maximizing the score by utilizing the largest available squares in the positive contributions.

### Data Structures:
- A simple array or list to store the sorted elements. Sorting can be efficiently done using built-in sorting algorithms, which typically run in \(O(n \log n)\).

### Complexity:
- **Time Complexity**: \(O(n \log n)\) due to the sorting step, where \(n\) is the length of the input array.
- **Space Complexity**: \(O(1)\) if we sort in place, or \(O(n)\) if we create a new sorted array.

By following this approach, we can efficiently compute the maximum possible alternating score for any given input array.
