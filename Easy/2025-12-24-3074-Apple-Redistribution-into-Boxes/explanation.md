# Apple Redistribution into Boxes (Easy)

**Problem ID:** 3074  
**Date:** 2025-12-24  
**Link:** https://leetcode.com/problems/apple-redistribution-into-boxes/

## Approach

To solve the problem of redistributing apples into boxes with given capacities, we can follow a systematic approach:

### Main Idea:
The goal is to determine the minimum number of boxes needed to accommodate all the apples from the given packs. Since apples from the same pack can be distributed into different boxes, we need to ensure that the total capacity of the selected boxes is sufficient to hold the total number of apples.

### Steps to Approach:
1. **Calculate Total Apples**: First, compute the total number of apples by summing up the elements in the `apple` array. This gives us the total amount of apples that need to be distributed.

2. **Sort Box Capacities**: To efficiently find the minimum number of boxes needed, sort the `capacity` array in descending order. This allows us to utilize the largest boxes first, which helps minimize the number of boxes used.

3. **Select Boxes**: Initialize a counter for the number of boxes used and a variable to keep track of the accumulated capacity. Iterate through the sorted `capacity` array, adding the capacity of each box to the accumulated capacity until it meets or exceeds the total number of apples.

4. **Count Boxes**: Each time you add a box's capacity, increment the box counter. Once the accumulated capacity is sufficient to hold all apples, terminate the loop.

### Data Structures:
- Use an array to store the capacities of the boxes.
- Use basic variables to keep track of the total number of apples, accumulated capacity, and the count of boxes used.

### Complexity:
- **Time Complexity**: The sorting step takes \(O(m \log m)\), where \(m\) is the number of boxes. The subsequent iteration through the sorted capacities takes \(O(m)\). Thus, the overall time complexity is dominated by the sorting step, resulting in \(O(m \log m)\).
- **Space Complexity**: The space complexity is \(O(1)\) if we do not consider the input storage, as we only use a few additional variables.

This approach ensures that we efficiently determine the minimum number of boxes required to redistribute the apples while adhering to the constraints provided in the problem statement.
