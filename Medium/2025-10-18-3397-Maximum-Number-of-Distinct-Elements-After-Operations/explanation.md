# Maximum Number of Distinct Elements After Operations (Medium)

**Problem ID:** 3397  
**Date:** 2025-10-18  
**Link:** https://leetcode.com/problems/maximum-number-of-distinct-elements-after-operations/

## Approach

To solve the problem of maximizing the number of distinct elements in the array `nums` after performing allowed operations, we can follow a systematic approach:

### Main Idea:
The core idea is to leverage the range of operations we can perform on each element (adding any integer from `[-k, k]`) to create as many distinct values as possible. The operations can effectively shift the values of `nums` within a certain range, allowing us to fill in gaps between existing numbers or adjust duplicates to create new distinct values.

### Steps to Approach:
1. **Count Frequencies**: First, we count the occurrences of each number in `nums` using a frequency map (or dictionary). This helps us identify duplicates and how many adjustments we need to make.

2. **Sort Unique Elements**: Extract the unique elements from the frequency map and sort them. This allows us to systematically evaluate the potential for creating new distinct values.

3. **Use a Set for Distinct Values**: Utilize a set to keep track of distinct values we can form. Starting from the smallest unique element, we can try to fill in the gaps by applying the operations.

4. **Iterate and Adjust**: For each unique element:
   - If it’s possible to adjust it (i.e., if the element minus `k` is not already in the set of distinct values), we add that new value to our set.
   - If the element is a duplicate, we can also try to adjust it to `element - 1`, `element + 1`, or any other value within the range to ensure it becomes distinct.

5. **Count Distinct Values**: After processing all elements, the size of the set will give us the maximum number of distinct elements we can achieve.

### Data Structures:
- **Frequency Map**: To count occurrences of each element.
- **Sorted List**: To manage and access unique elements in order.
- **Set**: To track distinct values efficiently.

### Complexity Analysis:
- **Time Complexity**: The overall time complexity is O(n log n) due to sorting the unique elements, where n is the length of `nums`. Counting frequencies takes O(n), and iterating through the unique elements is O(u), where u is the number of unique elements.
- **Space Complexity**: The space complexity is O(n) in the worst case for the frequency map and O(u) for the set of distinct values.

By following this structured approach, we can efficiently determine the maximum number of distinct elements that can be formed after performing the allowed operations.
