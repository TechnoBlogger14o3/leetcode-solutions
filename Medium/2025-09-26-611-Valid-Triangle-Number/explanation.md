# Valid Triangle Number (Medium)

**Problem ID:** 611  
**Date:** 2025-09-26  
**Link:** https://leetcode.com/problems/valid-triangle-number/

## Approach

To solve the "Valid Triangle Number" problem, we can utilize a combination of sorting and the two-pointer technique. The main idea is based on the triangle inequality theorem, which states that for three sides to form a triangle, the sum of the lengths of any two sides must be greater than the length of the third side.

### Approach:

1. **Sorting the Array**: Start by sorting the input array `nums`. This allows us to easily apply the triangle inequality conditions since for any triplet `(a, b, c)` where `a <= b <= c`, it suffices to check if `a + b > c`.

2. **Iterating Through Triplets**: Use a loop to fix the largest side of the triangle (let’s call it `c`) starting from the third element and moving towards the end of the sorted array. For each fixed `c`, we will find pairs `(a, b)` such that `a + b > c`.

3. **Two-Pointer Technique**: 
   - Initialize two pointers: one (`left`) starting from the beginning of the array and the other (`right`) just before the current `c`.
   - Check if the sum of the elements at these two pointers (`nums[left] + nums[right]`) is greater than `nums[c]`. If it is, then all pairs from `left` to `right` with the current `right` are valid, since the array is sorted and any element between `left` and `right` will also satisfy the condition. Count these pairs and decrement `right`.
   - If the sum is not greater, increment `left` to try a larger sum.

4. **Counting Valid Triplets**: Keep a cumulative count of valid triplet combinations as you iterate through the array.

### Data Structures:
- A sorted array to facilitate the two-pointer approach.
- Simple integer counters to keep track of valid triplet counts.

### Complexity:
- **Time Complexity**: The sorting step takes \(O(n \log n)\), and the two-pointer traversal for each element takes \(O(n)\). Thus, the overall time complexity is \(O(n^2)\).
- **Space Complexity**: The space complexity is \(O(1)\) if we ignore the input storage, as we are using only a constant amount of extra space.

This approach efficiently counts the number of valid triangle triplets in the array, leveraging sorting and the two-pointer technique to minimize unnecessary checks.
