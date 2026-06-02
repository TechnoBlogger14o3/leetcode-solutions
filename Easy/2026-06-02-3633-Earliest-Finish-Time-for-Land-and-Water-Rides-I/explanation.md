# Earliest Finish Time for Land and Water Rides I (Easy)

**Problem ID:** 3633  
**Date:** 2026-06-02  
**Link:** https://leetcode.com/problems/earliest-finish-time-for-land-and-water-rides-i/

## Approach

To solve the problem of finding the earliest finish time for a tourist experiencing one land ride and one water ride, we can break down the solution into the following steps:

### Problem Breakdown
1. **Input Representation**: We have two arrays for land rides (`landStartTime` and `landDuration`) and two arrays for water rides (`waterStartTime` and `waterDuration`).
2. **Ride Completion Time Calculation**: For each ride, we can calculate the finish time based on when it starts and its duration. A ride can start at its opening time or later.

### Approach
1. **Iterate Through Rides**: We need to consider all possible combinations of rides:
   - Start with a land ride and then a water ride.
   - Start with a water ride and then a land ride.

2. **Calculate Finish Times**:
   - For each land ride, calculate the finish time and then determine when the water ride can start. The water ride can only start after it has opened and after the land ride has finished.
   - Similarly, for each water ride, calculate the finish time and then determine when the land ride can start.

3. **Determine the Minimum Finish Time**: Keep track of the earliest finish time across all combinations of rides.

### Data Structures
- We primarily use arrays to store the start times and durations of the rides.
- Simple variables to track the minimum finish time.

### Complexity
- The time complexity of this approach is O(n * m), where n is the number of land rides and m is the number of water rides. This is efficient given the constraints (both n and m can go up to 100).
- The space complexity is O(1) since we are using a constant amount of extra space for tracking the minimum finish time.

### Summary
By systematically exploring all combinations of ride sequences and calculating the finish times based on the given constraints, we can efficiently determine the earliest time the tourist can finish both rides. The key is to ensure that we respect the opening times of the rides while calculating possible start times.
