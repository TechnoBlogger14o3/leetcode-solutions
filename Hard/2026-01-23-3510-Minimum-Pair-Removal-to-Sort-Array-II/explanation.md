# Minimum Pair Removal to Sort Array II (Hard)

**Problem ID:** 3510  
**Date:** 2026-01-23  
**Link:** https://leetcode.com/problems/minimum-pair-removal-to-sort-array-ii/

## Approach

To solve the problem of determining the minimum number of operations needed to make an array non-decreasing via adjacent pair removal, we can follow these steps:

### Problem Understanding
The goal is to repeatedly replace adjacent pairs with their sum until the array is non-decreasing. The key challenge is to select the pair with the minimum sum efficiently and ensure that the resultant array is sorted.

### Approach
1. **Identify Non-Decreasing Pairs**: First, we need to identify pairs in the array that, when summed, will not disrupt the non-decreasing order. If a pair (nums[i], nums[i+1]) is such that nums[i] > nums[i+1], we need to consider replacing it.

2. **Priority Queue**: Use a min-heap (priority queue) to efficiently track pairs based on their sums. This allows us to always access the pair with the minimum sum quickly. The heap will store pairs along with their indices for easy retrieval.

3. **Operation Simulation**: 
   - While the heap is not empty, extract the pair with the minimum sum.
   - Replace the extracted pair in the array with their sum.
   - After the replacement, check the new adjacent pairs to see if they now form a valid pair that can be summed in future operations.
   - Increment the operation count each time a replacement is made.

4. **Termination**: The process continues until no more pairs need to be replaced to achieve a non-decreasing order.

### Data Structures
- **Min-Heap**: To maintain pairs and their sums efficiently.
- **Array**: To hold the current state of the numbers as we perform operations.

### Complexity
- **Time Complexity**: The overall complexity is O(n log n) due to the heap operations, where n is the length of the input array. Each operation involves inserting and removing elements from the heap.
- **Space Complexity**: O(n) for storing the heap and potentially the modified array.

### Conclusion
This approach effectively reduces the problem to a series of controlled operations based on the properties of the array and the sums of adjacent pairs, leveraging a priority queue for efficiency. By focusing on the minimum sum pairs, we ensure that each operation is optimal toward achieving a non-decreasing order in the least number of steps.
