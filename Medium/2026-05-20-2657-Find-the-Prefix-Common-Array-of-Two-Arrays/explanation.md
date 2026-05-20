# Find the Prefix Common Array of Two Arrays (Medium)

**Problem ID:** 2657  
**Date:** 2026-05-20  
**Link:** https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/

## Approach

To solve the problem of finding the prefix common array of two permutations A and B, we can follow a straightforward approach using a set data structure to efficiently track common elements. Here’s a concise breakdown of the solution approach:

### Main Idea:
The goal is to construct an array C where each element C[i] represents the count of numbers that are present at or before the index i in both arrays A and B. Since both A and B are permutations of numbers from 1 to n, we can leverage this property to determine common elements efficiently.

### Approach:
1. **Initialize Data Structures**:
   - Create a set to keep track of the numbers that have been seen in both arrays as we iterate through them.
   - Initialize an array C of the same length as A and B to store the results.

2. **Iterate through the Arrays**:
   - For each index i from 0 to n-1:
     - Add the current element A[i] to the set (indicating it has been seen in A).
     - Add the current element B[i] to the set (indicating it has been seen in B).
     - The size of the set at this point will give the count of unique numbers that have been seen in both A and B up to index i, which will be stored in C[i].

3. **Output the Result**:
   - After processing all indices, the array C will contain the required prefix common counts.

### Data Structures:
- **Set**: Used to store the unique elements encountered from both A and B. The set allows for O(1) average time complexity for insertions and checks for existence, making it efficient for counting unique elements.

### Complexity:
- **Time Complexity**: O(n), where n is the length of the arrays. We make a single pass through both arrays, performing constant time operations for each element.
- **Space Complexity**: O(n) in the worst case for the set, which can store all n elements if all are unique.

This approach efficiently calculates the prefix common array while leveraging the properties of permutations, ensuring that the solution is both optimal and easy to understand.
