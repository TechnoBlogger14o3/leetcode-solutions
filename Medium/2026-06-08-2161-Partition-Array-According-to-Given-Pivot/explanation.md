# Partition Array According to Given Pivot (Medium)

**Problem ID:** 2161  
**Date:** 2026-06-08  
**Link:** https://leetcode.com/problems/partition-array-according-to-given-pivot/

## Approach

To solve the problem of partitioning the array according to a given pivot while maintaining the relative order of elements, we can use a straightforward approach leveraging the concept of three separate lists (or arrays). Here's a concise breakdown of the approach:

### Main Idea:
The goal is to rearrange the elements of the array `nums` such that:
1. All elements less than the pivot appear first.
2. All elements equal to the pivot come next.
3. All elements greater than the pivot appear last.
4. The relative order of elements in each of these groups is preserved.

### Approach:
1. **Initialization**: Create three separate lists (or arrays) to hold the elements:
   - `less_than`: for elements less than the pivot.
   - `equal_to`: for elements equal to the pivot.
   - `greater_than`: for elements greater than the pivot.

2. **Iteration**: Traverse through the original array `nums` and classify each element into one of the three lists based on its comparison with the pivot:
   - If an element is less than the pivot, append it to `less_than`.
   - If it is equal to the pivot, append it to `equal_to`.
   - If it is greater than the pivot, append it to `greater_than`.

3. **Concatenation**: After the traversal, concatenate the three lists in the order: `less_than`, `equal_to`, and `greater_than`. This will yield the desired rearrangement of the array.

### Data Structures:
- Three lists (or arrays) to store the categorized elements. This allows for easy appending and preserves the order of elements as they are added.

### Complexity:
- **Time Complexity**: O(n), where n is the length of the array `nums`, since we make a single pass through the array to classify the elements.
- **Space Complexity**: O(n) in the worst case, as we may need to store all elements in the three lists.

This approach is efficient and straightforward, ensuring that the problem constraints are met while maintaining the required order of elements.
