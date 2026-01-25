# Minimum Difference Between Highest and Lowest of K Scores (Easy)

**Problem ID:** 1984  
**Date:** 2026-01-25  
**Link:** https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/

## Approach

To solve the problem of finding the minimum difference between the highest and lowest scores of any k students from the given array, we can follow a systematic approach:

### Approach:

1. **Sorting the Array**: The first step is to sort the input array `nums`. By sorting, we can easily access the highest and lowest scores in any contiguous subarray of length k. This is crucial because the minimum difference will always occur between the smallest and largest values in such a subarray.

2. **Sliding Window Technique**: After sorting, we can utilize a sliding window of size k. We will iterate through the sorted array and for each possible starting index `i`, we will compute the difference between the element at index `i + k - 1` (the highest score in the current window) and the element at index `i` (the lowest score in the current window).

3. **Calculating Minimum Difference**: As we slide the window from the start of the sorted array to the position where a full window of size k can still be formed, we will keep track of the minimum difference encountered during these calculations.

### Data Structures:
- **Array**: We primarily use the input array `nums` which is sorted.
- **Variables**: We will use a variable to keep track of the minimum difference.

### Complexity:
- **Time Complexity**: The sorting step takes O(n log n), where n is the number of scores. The subsequent iteration to find the minimum difference takes O(n). Therefore, the overall time complexity is O(n log n).
- **Space Complexity**: The space complexity is O(1) if we do not consider the input array storage, as we are using a constant amount of extra space for variables.

### Conclusion:
By sorting the array and applying a sliding window technique, we efficiently determine the minimum difference between the highest and lowest scores of any k students. This approach leverages the properties of sorted arrays to simplify the problem and ensures that we can find the solution in a reasonable time frame.
