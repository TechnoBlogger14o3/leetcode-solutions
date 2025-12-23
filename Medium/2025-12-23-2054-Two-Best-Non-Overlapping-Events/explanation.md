# Two Best Non-Overlapping Events (Medium)

**Problem ID:** 2054  
**Date:** 2025-12-23  
**Link:** https://leetcode.com/problems/two-best-non-overlapping-events/

## Approach

To solve the problem of maximizing the sum of values from two non-overlapping events, we can follow a structured approach:

### Main Idea:
The core idea is to utilize sorting and a dynamic programming-like strategy to evaluate the best possible combination of two events that do not overlap. We need to ensure that when selecting two events, the second event starts after the first event ends.

### Steps to Approach:

1. **Sorting Events**:
   - First, sort the events based on their end times. This allows us to easily find non-overlapping events since once we pick an event, we can quickly find the next possible event that starts after it ends.

2. **Dynamic Programming Array**:
   - Create an array `maxValue` where `maxValue[i]` holds the maximum value obtainable by attending events from the start up to the `i-th` event. This helps in quickly determining the best value we can get before the current event.

3. **Binary Search for Non-Overlapping Events**:
   - For each event `i`, use binary search to find the last event `j` that ends before the current event `i` starts. This allows us to efficiently check which previous event can be combined with the current event without overlap.

4. **Maximize the Value**:
   - For each event `i`, calculate the potential maximum value by either:
     - Taking only the current event's value.
     - Adding the current event's value to the best value from the previous non-overlapping event (found using binary search).
   - Update the `maxValue` array accordingly.

5. **Final Calculation**:
   - The result will be the maximum value obtained from considering each event as a potential second event in a pair. This can be done by iterating through the `maxValue` array to find the best combination of two non-overlapping events.

### Data Structures:
- A sorted list of events to facilitate the binary search.
- An array to store maximum values for dynamic programming.

### Complexity:
- The sorting step takes \(O(n \log n)\), where \(n\) is the number of events.
- Each event is processed in \(O(\log n)\) time due to binary search, leading to an overall complexity of \(O(n \log n)\).
- The space complexity is \(O(n)\) for storing the `maxValue` array.

By following this structured approach, we ensure that we efficiently find the optimal solution to the problem while respecting the constraints of non-overlapping events.
