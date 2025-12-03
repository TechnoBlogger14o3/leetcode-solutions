# Count Number of Trapezoids II (Hard)

**Problem ID:** 3625  
**Date:** 2025-12-03  
**Link:** https://leetcode.com/problems/count-number-of-trapezoids-ii/

## Approach

To solve the problem of counting unique trapezoids that can be formed from a set of points on a Cartesian plane, we can follow a systematic approach based on the properties of trapezoids and the concept of slopes.

### Main Idea:
A trapezoid is defined as a convex quadrilateral with at least one pair of parallel sides. To identify trapezoids from a set of points, we can leverage the fact that two sides are parallel if they have the same slope. Therefore, the key steps involve calculating the slopes between pairs of points and grouping points that share the same slope.

### Approach:
1. **Calculate Slopes**: For each pair of points, compute the slope. The slope between two points \((x_1, y_1)\) and \((x_2, y_2)\) can be represented as a fraction \((y_2 - y_1) / (x_2 - x_1)\). To avoid floating-point inaccuracies and division by zero, we can represent slopes as pairs of integers (dy, dx) reduced to their simplest form using the greatest common divisor (GCD).

2. **Group Points by Slopes**: Use a dictionary to group points that share the same slope. For each point, maintain a mapping of slopes to the list of points that can be reached from it with that slope.

3. **Count Trapezoids**: For each unique slope group, if there are \(n\) points that share the same slope, we can choose any two points from these \(n\) points to form one pair of parallel sides. The number of ways to choose 2 points from \(n\) is given by \(\binom{n}{2} = n(n-1)/2\). For each pair of parallel sides, we need to find points from the other slope groups to form the remaining two sides of the trapezoid.

4. **Combine Results**: For each combination of two pairs of parallel sides (from different slope groups), check if they can form a trapezoid and count them.

### Data Structures:
- A dictionary (or hashmap) to store slopes as keys and lists of points as values.
- A set to keep track of unique trapezoids to avoid counting duplicates.

### Complexity:
- **Time Complexity**: The algorithm primarily involves iterating through pairs of points to calculate slopes, leading to a time complexity of \(O(n^2)\), where \(n\) is the number of points. The subsequent operations to count trapezoids depend on the number of unique slopes and points associated with them.
- **Space Complexity**: The space complexity is \(O(n)\) for storing the points in the slope dictionary.

This approach effectively reduces the problem to manageable components by focusing on the geometric properties of trapezoids and utilizing combinatorial counting, thus allowing us to efficiently count the number of unique trapezoids formed by the given points.
