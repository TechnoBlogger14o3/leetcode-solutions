# Minimum Moves to Clean the Classroom (Medium)

**Problem ID:** 3568  
**Date:** 2026-09-01  
**Link:** https://leetcode.com/problems/minimum-moves-to-clean-the-classroom/

## Approach

To solve the problem of finding the minimum moves required for the student to collect all litter in the classroom grid, we can employ a breadth-first search (BFS) strategy combined with bitmasking to efficiently track the state of collected litter.

### Approach:

1. **Representation of State**:
   - We represent the state of the student using a tuple that includes the current position `(x, y)`, the remaining energy, and a bitmask that indicates which litter items have been collected. The bitmask allows us to efficiently track the collection status of up to 10 litter items.

2. **Initialization**:
   - First, parse the grid to identify the starting position of the student (`S`), the positions of all litter (`L`), and any reset areas (`R`). Store the coordinates of litter items in a list for easy access.

3. **BFS Implementation**:
   - Use a queue to explore all possible states starting from the initial position with full energy and no litter collected. Each state will be processed to explore all valid moves (up, down, left, right).
   - For each move, check if the new position is valid (not out of bounds, not an obstacle `X`, and within energy limits). If moving to a litter cell, update the bitmask to reflect the collection of that litter.
   - If the student moves to a reset area `R`, restore their energy to the maximum capacity.

4. **Tracking Visited States**:
   - Maintain a set to track visited states (combination of position, remaining energy, and collected litter bitmask) to avoid reprocessing the same state, which helps in reducing the number of redundant calculations.

5. **Termination**:
   - The BFS continues until all litter is collected (indicated by the bitmask having all bits set corresponding to the collected litter). If the queue is exhausted without collecting all litter, return -1.

### Complexity:
- **Time Complexity**: The time complexity can be approximated as \(O(m \times n \times 2^k)\), where \(m\) and \(n\) are the dimensions of the grid, and \(k\) is the number of litter items. The factor \(2^k\) arises from the possible combinations of collected litter states.
- **Space Complexity**: The space complexity is also \(O(m \times n \times 2^k)\) due to the storage of visited states and the queue used for BFS.

This approach ensures that we explore all possible paths efficiently while keeping track of the necessary states, ultimately leading to the solution for the minimum moves required to clean the classroom or determining that it is impossible.
