# Subarrays Distinct Element Sum of Squares II (Hard)

**Problem ID:** 2916  
**Date:** 2026-10-16  
**Link:** https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-ii/

## Approach

To solve the problem of calculating the sum of the squares of distinct counts of all subarrays in the given array `nums`, we can use an efficient two-pointer (or sliding window) technique combined with a hash map to maintain the count of distinct elements.

### Approach:

1. **Understanding Subarrays and Distinct Counts**:
   - A subarray is defined by its starting and ending indices. The distinct count for a subarray is the number of unique elements within that range.
   - For each subarray, we need to compute the square of its distinct count and sum these values across all possible subarrays.

2. **Two-Pointer Technique**:
   - Use two pointers, `left` and `right`, to represent the current subarray's bounds. The `right` pointer expands the window to include new elements, while the `left` pointer contracts it when necessary.
   - Maintain a hash map (or dictionary) to count occurrences of elements in the current window. This allows us to efficiently track how many distinct elements are present.

3. **Updating Distinct Counts**:
   - As you expand the `right` pointer, add the element at `nums[right]` to the hash map. If this element is being added for the first time, increment the distinct count.
   - For each position of `right`, calculate the square of the current distinct count and add it to a running total.
   - If the distinct count exceeds a certain limit (though in this case, it won’t since we are just counting distinct elements), you can move the `left` pointer to shrink the window until the distinct count is valid again.

4. **Complexity**:
   - The overall time complexity of this approach is O(n), where `n` is the length of the input array. This is because each element is processed at most twice (once by the `right` pointer and once by the `left` pointer).
   - The space complexity is O(m), where `m` is the number of distinct elements in the array, which can be at most `n`.

5. **Modulo Operation**:
   - Given the potential for large numbers, ensure that all additions to the sum are taken modulo \(10^9 + 7\) to prevent overflow and meet the problem's requirements.

### Summary:
By using a sliding window approach with a hash map to track distinct elements, we can efficiently compute the sum of the squares of distinct counts for all subarrays in linear time. This method leverages the properties of contiguous subarrays and the efficiency of hash maps for counting, making it suitable for the problem's constraints.
