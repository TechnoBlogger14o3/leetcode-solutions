# Minimum Moves to Equal Array Elements II (Medium)

**Problem ID:** 462  
**Date:** 2026-11-02  
**Link:** https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/

## Approach

To solve the problem of finding the minimum moves required to make all elements in an array equal, we can utilize the concept of the median. The main idea is based on the observation that the median minimizes the sum of absolute deviations from a set of numbers.

### Approach:

1. **Understanding Moves**: Each move consists of incrementing or decrementing an element by 1. Therefore, to minimize the total number of moves, we want to minimize the total distance each element has to move to reach a common value.

2. **Choosing the Target Value**: The optimal target value to which all elements should converge is the median of the array. This is because the median minimizes the sum of absolute differences from all elements in the array.

3. **Steps to Solve**:
   - Sort the array to find the median. If the array has an odd number of elements, the median is the middle element. If it has an even number, any value between the two middle elements will yield the same total moves.
   - Calculate the total number of moves needed to make all elements equal to the median. This can be done by summing the absolute differences between each element and the median.

4. **Data Structures**: We primarily use an array to store the input numbers and a simple variable to accumulate the total moves.

### Complexity:
- **Time Complexity**: The sorting step takes O(n log n), where n is the number of elements in the array. The subsequent calculation of moves takes O(n). Thus, the overall time complexity is O(n log n).
- **Space Complexity**: The space complexity is O(1) if we ignore the input storage, as we only use a few additional variables for calculations.

### Summary:
By leveraging the properties of the median, we can efficiently compute the minimum number of moves required to equalize the array elements with a clear focus on minimizing total absolute differences. This approach ensures we achieve the solution optimally both in terms of time and space.
