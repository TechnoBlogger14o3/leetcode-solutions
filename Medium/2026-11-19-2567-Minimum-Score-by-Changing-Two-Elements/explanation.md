# Minimum Score by Changing Two Elements (Medium)

**Problem ID:** 2567  
**Date:** 2026-11-19  
**Link:** https://leetcode.com/problems/minimum-score-by-changing-two-elements/

## Approach

To solve the problem of finding the minimum score by changing two elements in the array `nums`, we can break down the approach into several key steps:

### Problem Understanding
1. **Definitions**:
   - **Low Score**: The minimum absolute difference between any two elements in `nums`.
   - **High Score**: The maximum absolute difference between any two elements in `nums`.
   - **Score**: The sum of the low and high scores.

2. **Objective**: We need to minimize the score after changing two elements in the array.

### Approach
1. **Initial Calculation**:
   - Start by calculating the current low score and high score of the original array. This can be done by:
     - Finding the minimum (`min_val`) and maximum (`max_val`) values in the array.
     - The low score is determined by the smallest difference between adjacent sorted elements, while the high score is simply `max_val - min_val`.

2. **Changing Elements**:
   - Since we can change any two elements, we can explore the effects of changing elements to the minimum or maximum values in the array.
   - Specifically, we can consider changing:
     - Two elements to the minimum value (`min_val`).
     - Two elements to the maximum value (`max_val`).
     - One element to `min_val` and one to `max_val`.

3. **Recalculating Scores**:
   - For each of the above scenarios, recalculate the low and high scores:
     - If both elements are changed to `min_val`, the low score becomes `0` (as all elements can be the same), and the high score will be the difference between the new maximum and `min_val`.
     - If both are changed to `max_val`, similarly, the low score becomes `0`, and the high score will be the difference between `max_val` and the new minimum.
     - If one is changed to `min_val` and the other to `max_val`, the low score will still be `0`, and the high score will be `max_val - min_val`.

4. **Final Calculation**:
   - Calculate the scores for all scenarios and take the minimum score from these calculations.

### Data Structures
- A simple array is sufficient to store the input.
- Sorting may be necessary to find the minimum differences efficiently, but in practice, we can often derive these directly from the min and max values without sorting.

### Complexity
- The time complexity primarily involves finding the minimum and maximum values, which is \(O(n)\), where \(n\) is the length of the array. The overall complexity remains linear, \(O(n)\), since we perform a constant amount of work after finding the min and max.

By following this structured approach, we can efficiently determine the minimum score after changing two elements in the array.
