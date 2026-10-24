# Count Days Spent Together (Easy)

**Problem ID:** 2409  
**Date:** 2026-10-24  
**Link:** https://leetcode.com/problems/count-days-spent-together/

## Approach

To solve the problem of counting the days Alice and Bob spend together in Rome, we can follow a straightforward approach using a few key steps:

### Main Idea
The goal is to determine the overlapping days between Alice's and Bob's stay in Rome. This can be achieved by identifying the latest arrival date and the earliest departure date for both individuals. The overlap can then be calculated based on these two dates.

### Steps
1. **Convert Dates**: First, we need to convert the string dates from the format "MM-DD" into a numerical format that allows for easy comparison. This can be done by calculating the day of the year for each date. For instance, "01-01" corresponds to day 1, "02-01" to day 32, and so on, using the number of days in each month.

2. **Determine Overlap**: 
   - Calculate the latest arrival date by taking the maximum of Alice's and Bob's arrival dates.
   - Calculate the earliest departure date by taking the minimum of Alice's and Bob's departure dates.
   - If the latest arrival date is less than or equal to the earliest departure date, there is an overlap.

3. **Count Overlapping Days**: 
   - If there is an overlap, the number of overlapping days can be calculated as:
     \[
     \text{overlap\_days} = \text{earliest\_departure} - \text{latest\_arrival} + 1
     \]
   - If there is no overlap, the result is 0.

### Data Structures
- We will primarily use integer variables to store the converted day of the year for each date.
- No complex data structures are necessary, as we are only performing a few comparisons and arithmetic operations.

### Complexity
- The time complexity of this approach is O(1) since the number of operations does not depend on the input size; we are only processing a fixed number of dates.
- The space complexity is also O(1) as we are using a constant amount of space for our calculations.

This approach efficiently determines the number of days Alice and Bob are in Rome together by focusing on the overlap between their stay periods, ensuring clarity and simplicity in implementation.
