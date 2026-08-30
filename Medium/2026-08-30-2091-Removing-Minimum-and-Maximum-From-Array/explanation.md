# Removing Minimum and Maximum From Array (Medium)

**Problem ID:** 2091  
**Date:** 2026-08-30  
**Link:** https://leetcode.com/problems/removing-minimum-and-maximum-from-array/

## Approach

To solve the problem of removing the minimum and maximum elements from the array with the least number of deletions, we can adopt the following approach:

### Problem Breakdown
1. **Identify Minimum and Maximum**: First, we need to find the indices of the minimum and maximum elements in the array. This can be done in a single pass through the array, which will take O(n) time.

2. **Calculate Deletion Scenarios**: Once we have the indices of the minimum and maximum elements, we can compute the number of deletions required for different strategies:
   - **Remove from the front only**: Calculate the maximum index of the two (min_index and max_index) and consider deleting all elements up to and including that index.
   - **Remove from the back only**: Calculate the minimum index of the two and consider deleting all elements from that index to the end of the array.
   - **Remove from both ends**: Consider combinations of removing elements from both the front and the back:
     - Remove the minimum from the front and the maximum from the back.
     - Remove the maximum from the front and the minimum from the back.

3. **Determine Minimum Deletions**: After calculating the number of deletions for all the above strategies, the final step is to take the minimum of these values to determine the least number of deletions required.

### Data Structures
- We primarily use simple integer variables to store the indices of the minimum and maximum elements. No additional complex data structures are necessary since we are only interested in a few indices and their relationships.

### Time Complexity
- The overall time complexity of this approach is O(n) due to the single pass required to find the indices of the minimum and maximum elements, followed by a constant time calculation of the deletions. The space complexity is O(1) because we are using a fixed amount of extra space for a few integer variables.

### Conclusion
By systematically evaluating the different ways to remove the minimum and maximum elements from the array, we can efficiently determine the minimum number of deletions required. This approach ensures that we adhere to the constraints and efficiently handle the maximum input size.
