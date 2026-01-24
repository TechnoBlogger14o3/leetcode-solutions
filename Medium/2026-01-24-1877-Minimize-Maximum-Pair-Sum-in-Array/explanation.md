# Minimize Maximum Pair Sum in Array (Medium)

**Problem ID:** 1877  
**Date:** 2026-01-24  
**Link:** https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/

## Approach

To solve the problem of minimizing the maximum pair sum in an array, we can adopt a greedy approach that focuses on pairing the smallest and largest elements together. Here’s a concise breakdown of the approach:

### Main Idea
The key observation is that to minimize the maximum pair sum, we should pair the smallest available number with the largest available number. This strategy helps balance the sums and prevents any single pair from becoming too large. By pairing the extremes, we effectively reduce the potential maximum sum that can occur.

### Steps to Solve the Problem
1. **Sort the Array**: Start by sorting the input array. This allows us to easily access the smallest and largest elements.
  
2. **Pair Elements**: After sorting, pair the first element (smallest) with the last element (largest), the second element with the second last, and so on. This can be done by iterating from the start of the sorted array to the midpoint.

3. **Calculate Pair Sums**: For each of these pairs, calculate the sum and track the maximum sum encountered.

4. **Return the Result**: The maximum sum found during the pairing process is the minimized maximum pair sum.

### Data Structures
- **Array**: We primarily use an array to hold the input values and a sorted version of it.
- **Integer Variables**: Use a few integer variables to keep track of the maximum pair sum during the iteration.

### Complexity
- **Time Complexity**: The sorting step dominates the overall complexity, making it O(n log n), where n is the number of elements in the input array. The subsequent pairing and sum calculation is O(n).
- **Space Complexity**: The space complexity is O(1) if we consider the output storage as not included, or O(n) if we count the space for the sorted array.

This approach efficiently minimizes the maximum pair sum by leveraging sorting and strategic pairing, ensuring that the solution is both optimal and easy to implement.
