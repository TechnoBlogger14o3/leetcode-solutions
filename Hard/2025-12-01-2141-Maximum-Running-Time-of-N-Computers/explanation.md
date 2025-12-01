# Maximum Running Time of N Computers (Hard)

**Problem ID:** 2141  
**Date:** 2025-12-01  
**Link:** https://leetcode.com/problems/maximum-running-time-of-n-computers/

## Approach

To solve the problem of determining the maximum running time for `n` computers using the given batteries, we can employ a binary search approach combined with a greedy strategy.

### Main Idea:
The core idea is to use binary search to find the maximum time `T` for which all `n` computers can run simultaneously. For each candidate time `T`, we need to check if it is feasible to keep all computers running for that duration using the available batteries.

### Steps to Approach:

1. **Binary Search Setup**:
   - Set the lower bound (`low`) to 0 and the upper bound (`high`) to the sum of all battery capacities divided by `n`, which represents the maximum possible time if all batteries were perfectly utilized.

2. **Feasibility Check**:
   - For a mid-point `T` during the binary search, calculate the total energy needed to run `n` computers for `T` minutes, which is `n * T`.
   - Next, calculate the total energy provided by the batteries. For each battery, if its capacity is greater than `T`, it can only contribute `T` minutes to the total. Otherwise, it contributes its full capacity.
   - Sum these contributions to determine if the total energy from the batteries is at least `n * T`.

3. **Binary Search Execution**:
   - If the total energy from batteries is sufficient for `n * T`, then it is feasible to run the computers for `T` minutes, and we can try for a longer duration by moving the `low` pointer up.
   - If not, adjust the `high` pointer down to search for a shorter time.

4. **Termination**:
   - The binary search continues until `low` exceeds `high`, at which point the maximum feasible time found is the answer.

### Data Structures:
- An array to hold the battery capacities.
- Simple integer variables for managing the binary search bounds and calculations.

### Complexity:
- The time complexity is `O(m log T)`, where `m` is the number of batteries and `T` is the maximum time being searched. The binary search runs in `O(log T)` iterations, and each feasibility check involves iterating through the batteries, which takes `O(m)` time.

This approach efficiently narrows down the maximum running time by leveraging the properties of binary search and greedy summation of battery contributions, ensuring that we can handle the upper limits of the input constraints effectively.
