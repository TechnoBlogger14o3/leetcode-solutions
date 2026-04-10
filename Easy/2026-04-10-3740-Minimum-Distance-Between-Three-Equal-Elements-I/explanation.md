# Minimum Distance Between Three Equal Elements I (Easy)

**Problem ID:** 3740  
**Date:** 2026-04-10  
**Link:** https://leetcode.com/problems/minimum-distance-between-three-equal-elements-i/

## Approach

To solve the problem of finding the minimum distance between three equal elements in an integer array, we can adopt the following approach:

### Approach:

1. **Data Structure**: Use a dictionary (or hashmap) to store the indices of each unique element in the array. The keys will be the elements from the array, and the values will be lists of indices where each element appears.

2. **Populate the Dictionary**: Iterate through the `nums` array and populate the dictionary with the indices of each element. This will allow us to quickly access the positions of any given number.

3. **Calculate Distances**: For each element in the dictionary that has at least three occurrences, consider the list of indices. We need to calculate the distance for every combination of three distinct indices (i, j, k) from this list. The distance is computed using the formula: 
   \[
   \text{distance} = |i - j| + |j - k| + |k - i|
   \]
   This can be simplified to:
   \[
   \text{distance} = 2 \times (\text{max}(i, j, k) - \text{min}(i, j, k))
   \]
   This means we only need to find the maximum and minimum indices among the three chosen indices to compute the distance efficiently.

4. **Track Minimum Distance**: Maintain a variable to track the minimum distance found across all valid tuples. Initialize it to a large value (infinity) and update it whenever a smaller distance is found.

5. **Return Result**: After checking all elements, if we have found a valid minimum distance, return it. Otherwise, return -1 if no good tuples exist.

### Complexity:
- **Time Complexity**: The overall time complexity is O(n), where n is the length of the array. This is because we traverse the array once to build the dictionary and then check each list of indices for elements that appear at least three times. The maximum number of indices we check for any element is limited, making the operations efficient.
- **Space Complexity**: The space complexity is O(n) in the worst case, where all elements are unique and stored in the dictionary.

This approach effectively leverages the properties of the problem, ensuring we efficiently find the minimum distance while adhering to the constraints provided.
