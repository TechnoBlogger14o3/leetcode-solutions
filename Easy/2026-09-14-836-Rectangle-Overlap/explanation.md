# Rectangle Overlap (Easy)

**Problem ID:** 836  
**Date:** 2026-09-14  
**Link:** https://leetcode.com/problems/rectangle-overlap/

## Approach

To determine if two axis-aligned rectangles overlap, we can leverage the properties of their coordinates. Each rectangle is defined by two points: the bottom-left corner \((x1, y1)\) and the top-right corner \((x2, y2)\). The rectangles are represented as lists: `rec1 = [x1_1, y1_1, x2_1, y2_1]` and `rec2 = [x1_2, y1_2, x2_2, y2_2]`.

### Main Idea:
Two rectangles overlap if and only if they do not lie completely to the left, right, above, or below each other. This can be expressed using the following conditions:
1. Rectangle 1 is to the left of Rectangle 2: \(x2_1 \leq x1_2\)
2. Rectangle 1 is to the right of Rectangle 2: \(x1_1 \geq x2_2\)
3. Rectangle 1 is above Rectangle 2: \(y1_1 \geq y2_2\)
4. Rectangle 1 is below Rectangle 2: \(y2_1 \leq y1_2\)

If any of these conditions are true, the rectangles do not overlap. Thus, to check for an overlap, we can simply check if none of these conditions hold true.

### Steps:
1. Extract the coordinates of both rectangles.
2. Evaluate the four conditions mentioned above.
3. Return `true` if none of the conditions are satisfied (indicating overlap), otherwise return `false`.

### Data Structures:
The problem primarily involves simple variables to hold the rectangle coordinates, so no complex data structures are needed.

### Complexity:
- **Time Complexity**: O(1) since we are performing a constant number of comparisons regardless of the input size.
- **Space Complexity**: O(1) as we are using a fixed amount of space for the coordinates and conditions.

This approach efficiently determines if two rectangles overlap by focusing on their relative positions with respect to one another.
