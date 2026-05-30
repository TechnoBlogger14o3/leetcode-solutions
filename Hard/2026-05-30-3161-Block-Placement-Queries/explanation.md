# Block Placement Queries (Hard)

**Problem ID:** 3161  
**Date:** 2026-05-30  
**Link:** https://leetcode.com/problems/block-placement-queries/

## Approach

To solve the "Block Placement Queries" problem, we need an efficient way to manage obstacles on an infinite number line and check if blocks of given sizes can be placed without intersecting these obstacles.

### Main Idea:
The problem can be approached by maintaining a sorted list of obstacle positions. For each query of type 1, we add the obstacle to this list. For each query of type 2, we check if a block of specified size can fit in the range [0, x] without intersecting any obstacles.

### Data Structures:
1. **Sorted List**: We can use a sorted list (or a balanced binary search tree) to keep track of the positions of obstacles. This allows us to efficiently insert obstacles and perform binary searches to find the relevant positions when checking for block placement.
2. **Binary Search**: For each type 2 query, we can use binary search to quickly find the nearest obstacles to the left and right of the block placement range.

### Approach:
1. **Handling Type 1 Queries**: When we receive a type 1 query `[1, x]`, we insert `x` into our sorted list of obstacles. This operation is O(log n) due to the nature of maintaining a sorted structure.
  
2. **Handling Type 2 Queries**: For a type 2 query `[2, x, sz]`, we need to determine if a block of size `sz` can fit in the range `[0, x]`. 
   - Calculate the leftmost position where the block can start, which is `x - sz`.
   - Use binary search to find the closest obstacle to the left of `x` and the closest obstacle to the right of `x - sz`.
   - Check if the range `[x - sz, x]` is clear of obstacles by ensuring that:
     - The closest obstacle on the left is either less than `x - sz` or exactly at `x - sz` (the block can touch it).
     - The closest obstacle on the right is either greater than `x` or exactly at `x` (the block can touch it).
   - If both conditions are satisfied, the block can be placed; otherwise, it cannot.

### Complexity:
- Insertion of obstacles (type 1 queries) takes O(log n) per query.
- Each type 2 query also takes O(log n) for the binary searches to find the relevant obstacles.
- Thus, the overall time complexity for processing all queries is O(q log n), where `q` is the number of queries and `n` is the number of obstacles.

This approach efficiently manages the dynamic nature of the obstacle placements while allowing quick checks for block placements, making it suitable for the problem's constraints.
