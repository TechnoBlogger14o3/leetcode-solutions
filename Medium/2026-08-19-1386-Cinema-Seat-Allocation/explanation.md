# Cinema Seat Allocation (Medium)

**Problem ID:** 1386  
**Date:** 2026-08-19  
**Link:** https://leetcode.com/problems/cinema-seat-allocation/

## Approach

To solve the "Cinema Seat Allocation" problem, we need to maximize the number of four-person groups that can be seated together in a cinema, given certain reserved seats. Here's a concise explanation of the approach:

### Main Idea
The main idea is to analyze each row independently and check for available blocks of four contiguous seats that can accommodate a group. The valid blocks are:
1. Seats 2, 3, 4, 5
2. Seats 4, 5, 6, 7
3. Seats 6, 7, 8, 9

We will iterate through the reserved seats to determine which blocks are available in each row.

### Steps
1. **Data Structure**: Use a set to store reserved seats for quick lookup. This allows us to efficiently check if specific seats are reserved.
   
2. **Iterate through Rows**: For each row from 1 to n, check the availability of the three blocks:
   - For each block, check if none of the seats in that block are reserved.
   - If a block is available, increment the count of groups that can be seated in that row.

3. **Count Groups**: Keep a running total of the number of groups that can be seated across all rows.

### Complexity
- **Time Complexity**: O(m), where m is the number of reserved seats. This is efficient because we only need to check the reserved seats for the rows that have reservations.
- **Space Complexity**: O(m) for storing reserved seats in a set, which allows for O(1) average time complexity for seat availability checks.

### Conclusion
By leveraging a set for reserved seats and systematically checking each row for available blocks, we can efficiently determine the maximum number of four-person groups that can be seated in the cinema. This approach ensures that we respect the constraints and optimize for the maximum seating arrangement.
