# Calculate Money in Leetcode Bank (Easy)

**Problem ID:** 1716  
**Date:** 2025-10-25  
**Link:** https://leetcode.com/problems/calculate-money-in-leetcode-bank/

## Approach

To solve the problem of calculating the total amount of money Hercy will have in the Leetcode bank by the end of the nth day, we can break down the approach as follows:

### Main Idea
Hercy deposits money in a systematic manner based on the day of the week. He starts with $1 on Monday and increases his deposit by $1 each subsequent day until Sunday. On the next Monday, he increases his deposit by $1 compared to the previous Monday. The task is to compute the total savings after n days.

### Approach
1. **Identify Weekly Cycles**: The deposits follow a weekly pattern (Monday to Sunday). Each week has a total of 7 days, and the deposits for these days can be represented as:
   - Week 1: 1, 2, 3, 4, 5, 6, 7 (Total = 28)
   - Week 2: 2, 3, 4, 5, 6, 7, 8 (Total = 35)
   - Week 3: 3, 4, 5, 6, 7, 8, 9 (Total = 42)
   - And so forth.

2. **Calculate Full Weeks**: Determine how many complete weeks fit into n days using integer division (`n // 7`). For each complete week, we can calculate the total deposits using the formula for the sum of an arithmetic series.

3. **Handle Remaining Days**: After accounting for complete weeks, there may be some remaining days (from `n % 7`). For these remaining days, we can compute the deposits based on the current week number.

4. **Sum Up Deposits**: The total deposits will be the sum from the complete weeks plus the deposits from the remaining days.

### Data Structures
No complex data structures are needed for this problem. We can use simple integer variables to keep track of the total amount, week count, and remaining days.

### Complexity
- **Time Complexity**: O(1), since the calculations involve a fixed number of arithmetic operations regardless of the value of n (up to 1000).
- **Space Complexity**: O(1), as we are using a constant amount of space for variables.

By following this structured approach, we can efficiently compute the total savings Hercy will have after n days without iterating through each day explicitly.
