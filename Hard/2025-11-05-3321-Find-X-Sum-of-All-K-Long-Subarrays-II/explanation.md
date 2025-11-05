# Find X-Sum of All K-Long Subarrays II (Hard)

**Problem ID:** 3321  
**Date:** 2025-11-05  
**Link:** https://leetcode.com/problems/find-x-sum-of-all-k-long-subarrays-ii/

## Approach

To solve the problem of finding the X-sum of all K-long subarrays, we can employ a sliding window approach combined with a frequency counting mechanism. Here's a structured breakdown of the solution approach:

### Main Idea:
The goal is to compute the X-sum for each subarray of length K in the given array. The X-sum is defined as the sum of the top X most frequent elements in the subarray, where ties in frequency are resolved by selecting the larger element.

### Steps to Approach:

1. **Sliding Window**:
   - Utilize a sliding window of size K to traverse through the array. For each position `i`, we will examine the subarray `nums[i..i + k - 1]`.

2. **Frequency Counting**:
   - Maintain a frequency dictionary (or hashmap) to count occurrences of each element within the current window. This allows us to efficiently update counts as the window slides.

3. **Heap for Top X Elements**:
   - Use a max-heap (or priority queue) to keep track of the top X most frequent elements. The heap will store elements as tuples of (frequency, value), allowing us to easily retrieve the elements with the highest frequencies and resolve ties by value.

4. **Sum Calculation**:
   - For each window, after determining the top X elements, compute their sum. If the number of distinct elements is less than X, sum all elements in the window instead.

5. **Window Adjustment**:
   - As the window slides right, update the frequency counts by decrementing the count of the element that is removed from the left end of the window and incrementing the count of the new element added to the right end.

### Data Structures:
- A dictionary to maintain the frequency of elements in the current window.
- A max-heap to efficiently retrieve the top X elements based on frequency and value.

### Complexity:
- **Time Complexity**: O(n log x), where n is the length of the array. The log x factor arises from maintaining the heap for the top X elements.
- **Space Complexity**: O(n) for the frequency dictionary and O(x) for the heap.

This approach ensures that we efficiently compute the required sums for each subarray while adhering to the constraints, making it suitable for the given problem size.
