# Maximum Building Height (Hard)

**Problem ID:** 1840  
**Date:** 2026-06-20  
**Link:** https://leetcode.com/problems/maximum-building-height/

## Approach

To solve the "Maximum Building Height" problem, the approach involves leveraging the constraints provided by the restrictions and the inherent properties of the building heights. Here’s a step-by-step breakdown of the solution:

### Main Idea:
1. **Understanding Height Constraints**: The first building must be height 0, and adjacent buildings can differ in height by at most 1. This means that the heights of the buildings will form a non-decreasing sequence until a certain point, and then they can decrease as long as they respect the maximum heights imposed by the restrictions.

2. **Incorporating Restrictions**: The restrictions provide specific maximum heights for certain buildings. We need to consider these when determining the maximum possible height for the tallest building.

3. **Sorting and Preparing Data**: Start by including the first building (height 0) in the list of restrictions. Then, sort the restrictions based on the building IDs. This allows us to process the buildings in order.

4. **Iterating Through Restrictions**: As we go through the sorted restrictions:
   - For each building, calculate the maximum possible height it can achieve based on the previous building's height and the current building's restriction.
   - Use the formula: `height[i] = min(height[i-1] + 1, maxHeight[i])` to determine the height of the current building based on the previous building's height and the maximum height restriction.

5. **Calculating Heights Between Restrictions**: After processing the restrictions, check the gaps between the buildings. For each pair of adjacent buildings, calculate the maximum height that can be achieved in the segment between them, considering the height difference constraint.

6. **Final Calculation**: The maximum height of any building is determined by the maximum height found during the iterations and calculations. 

### Data Structures:
- A list to store the restrictions including the first building.
- Sorting the restrictions based on building IDs allows efficient height calculations.
- Simple variables to track the maximum height during iterations.

### Complexity:
- **Time Complexity**: O(k log k) where k is the number of restrictions, due to sorting. The subsequent iteration through the restrictions is O(k).
- **Space Complexity**: O(k) for storing the restrictions.

This approach efficiently determines the maximum height of the tallest building while adhering to the constraints, ensuring that the solution is optimal even for large inputs.
