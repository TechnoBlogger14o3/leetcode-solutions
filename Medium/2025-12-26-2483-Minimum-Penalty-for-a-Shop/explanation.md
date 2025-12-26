# Minimum Penalty for a Shop (Medium)

**Problem ID:** 2483  
**Date:** 2025-12-26  
**Link:** https://leetcode.com/problems/minimum-penalty-for-a-shop/

## Approach

To solve the problem of determining the earliest hour to close a shop while incurring the minimum penalty based on customer visits, we can adopt a straightforward approach that involves calculating penalties for each possible closing hour in a single pass through the customer log.

### Main Idea:
The penalty is calculated based on two conditions:
1. For each hour the shop is open (from hour 0 to hour j-1) and no customers come ('N'), the penalty increases by 1.
2. For each hour the shop is closed (from hour j to the end) and customers come ('Y'), the penalty also increases by 1.

### Approach:
1. **Initialize Penalty Calculation**: Start by calculating the penalty if the shop were to close at hour 0. This means the shop is open for the entire first hour, and the penalty will be equal to the number of 'N's in the entire string since all hours contribute to the penalty if they are 'N'.

2. **Iterate Through Each Hour**: As we iterate through the string, we will:
   - Track the number of 'N's encountered so far (which contributes to the penalty when the shop is open).
   - Track the number of 'Y's encountered from the current hour onward (which contributes to the penalty when the shop is closed).
   - Update the penalty for closing at each hour based on the two contributions.

3. **Update Minimum Penalty**: For each hour, compare the current penalty with the minimum penalty found so far. If the current penalty is less, update the minimum penalty and record the hour.

4. **Return the Earliest Hour**: After iterating through all possible closing hours, return the hour that resulted in the minimum penalty.

### Data Structures:
- A simple integer variable to keep track of the current penalty.
- Two counters: one for 'N's (open penalty) and one for 'Y's (closed penalty) as we iterate through the string.

### Complexity:
- **Time Complexity**: O(n), where n is the length of the `customers` string. This is because we make a single pass through the string to compute the penalties.
- **Space Complexity**: O(1), as we only use a few integer variables for tracking counts and penalties, regardless of the input size.

This approach ensures that we efficiently determine the optimal closing hour while minimizing penalties, adhering to the constraints provided in the problem statement.
