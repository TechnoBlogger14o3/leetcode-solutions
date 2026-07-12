# Rank Transform of an Array (Easy)

**Problem ID:** 1331  
**Date:** 2026-07-12  
**Link:** https://leetcode.com/problems/rank-transform-of-an-array/

## Approach

To solve the "Rank Transform of an Array" problem, we can follow a systematic approach that leverages sorting and mapping. Here’s the breakdown of the solution:

### Main Idea
The goal is to replace each element in the input array with its rank based on its value. The rank is determined such that the smallest element has a rank of 1, and equal elements share the same rank. 

### Steps to Approach
1. **Create a Unique Sorted List**: First, we need to create a sorted list of the unique elements from the original array. This will allow us to easily determine the rank of each element based on its position in the sorted list.

2. **Map Elements to Ranks**: After sorting the unique elements, we can create a mapping from each unique element to its corresponding rank. The rank can be assigned based on the index of the element in the sorted list (index + 1).

3. **Transform the Original Array**: Finally, we iterate through the original array and replace each element with its corresponding rank using the mapping created in the previous step.

### Data Structures
- A list (or array) to hold the unique elements.
- A dictionary (or hashmap) to map each unique element to its rank.
- The original array for transformation.

### Complexity
- **Time Complexity**: The overall time complexity is O(n log n), where n is the number of elements in the input array. This is primarily due to the sorting step. The subsequent mapping and transformation steps are O(n).
- **Space Complexity**: The space complexity is O(n) due to the storage of the unique elements and the rank mapping.

### Summary
By using sorting and a hashmap for rank mapping, we efficiently transform the input array into its rank representation while ensuring that the constraints of the problem are met. This approach is optimal given the problem's requirements and the potential size of the input.
