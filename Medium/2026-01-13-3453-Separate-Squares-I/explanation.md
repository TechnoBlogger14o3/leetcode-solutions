# Separate Squares I (Medium)

**Problem ID:** 3453  
**Date:** 2026-01-13  
**Link:** https://leetcode.com/problems/separate-squares-i/

## Approach

To solve the problem of finding the minimum y-coordinate value of a horizontal line that separates the total area of squares above and below it, we can follow a systematic approach:

### Main Idea:
The key idea is to utilize a binary search combined with a sweep line technique to efficiently compute the areas above and below a potential horizontal line at various y-coordinates. The goal is to find a y-coordinate where the areas are equal.

### Approach:
1. **Calculate Total Area**: First, calculate the total area of all squares. This will help in determining the target area for both above and below the line.

2. **Binary Search Setup**: Since the y-coordinates can range significantly (up to \(10^9\)), we can use binary search to efficiently find the y-coordinate. Set the initial search bounds from 0 to the maximum y-coordinate of the squares plus their side lengths.

3. **Area Calculation Function**: For a given y-coordinate (midpoint in binary search), compute the areas above and below the line:
   - For each square, determine the portion of its area that lies above and below the line. This can be done by checking the square's y-coordinate and its height against the current midpoint.
   - Accumulate the areas for all squares to get the total area above and below the line.

4. **Adjust Binary Search**: Compare the areas:
   - If the area above the line is greater than the area below, move the search to lower y-coordinates (i.e., adjust the upper bound).
   - If the area below is greater, move to higher y-coordinates (i.e., adjust the lower bound).
   - Continue this process until the search converges to a point where the areas are approximately equal (within the specified tolerance).

5. **Precision Handling**: Since the problem requires the answer to be accurate within \(10^{-5}\), ensure that the binary search continues until the difference between the lower and upper bounds is less than this threshold.

### Data Structures:
- A simple list or array to store the squares and their properties (coordinates and side lengths).
- Variables to track the total area and the areas above and below the line during calculations.

### Complexity:
- The binary search will run in \(O(\log(\text{max\_y}))\), where \(\text{max\_y}\) is the maximum y-coordinate considered.
- For each midpoint in the binary search, calculating the areas involves iterating through all squares, which takes \(O(n)\), where \(n\) is the number of squares.
- Therefore, the overall time complexity is \(O(n \log(\text{max\_y}))\).

This approach efficiently narrows down the potential y-coordinate while ensuring that we accurately compute the areas, handling overlaps as specified in the problem statement.
