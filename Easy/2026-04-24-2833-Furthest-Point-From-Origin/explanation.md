# Furthest Point From Origin (Easy)

**Problem ID:** 2833  
**Date:** 2026-04-24  
**Link:** https://leetcode.com/problems/furthest-point-from-origin/

## Approach

To solve the problem of finding the furthest point from the origin based on the given movement string, we can follow a straightforward approach that involves counting possible moves in both directions.

### Problem Breakdown
1. **Understanding Moves**:
   - The string consists of three types of characters:
     - 'L': Move left.
     - 'R': Move right.
     - '_': Move either left or right (flexible move).
   
2. **Goal**:
   - We want to maximize the distance from the origin (0) after interpreting the moves.

### Approach
1. **Count Moves**:
   - Traverse the string and count the occurrences of 'L', 'R', and '_'.
   - Let:
     - `countL` = number of 'L'
     - `countR` = number of 'R'
     - `countUnderscore` = number of '_'

2. **Calculate Maximum Distance**:
   - The furthest point can be calculated as:
     - Move all 'L' left, which contributes `-countL` to the position.
     - Move all 'R' right, which contributes `+countR` to the position.
     - Use all '_' to extend either left or right.
   - The furthest distance from the origin can be expressed as:
     - `maxDistance = countL + countR + countUnderscore`
   - This formula accounts for moving all possible characters to maximize the distance from the origin.

### Complexity
- **Time Complexity**: O(n), where n is the length of the string. We perform a single pass through the string to count the characters.
- **Space Complexity**: O(1), as we are using a constant amount of space for counters.

### Conclusion
By counting the moves and utilizing the flexible moves represented by '_', we can efficiently compute the maximum distance achievable from the origin. This approach ensures that we consider all possible configurations of moves while maintaining optimal performance.
