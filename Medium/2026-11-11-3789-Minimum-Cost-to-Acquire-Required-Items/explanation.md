# Minimum Cost to Acquire Required Items (Medium)

**Problem ID:** 3789  
**Date:** 2026-11-11  
**Link:** https://leetcode.com/problems/minimum-cost-to-acquire-required-items/

## Approach

To solve the "Minimum Cost to Acquire Required Items" problem, we can utilize a systematic approach that evaluates different combinations of item purchases while ensuring we meet the required contributions for both types of items.

### Main Idea:
The goal is to minimize the total cost of acquiring items to satisfy the requirements for type 1 (`need1`) and type 2 (`need2`). We have three types of items available, each with different costs and contributions. The key is to determine the optimal combination of these items to minimize costs.

### Approach:
1. **Direct Calculation**: 
   - If both `need1` and `need2` are zero, the cost is immediately zero since no items are needed.
   
2. **Evaluate All Combinations**:
   - We can iterate over the possible number of type 3 items (`x`), which contribute to both requirements. The range for `x` should be from 0 to the minimum of `need1` and `need2` because buying more than that would not be beneficial.
   - For each value of `x`, calculate the remaining requirements:
     - Remaining type 1 requirement: `remainingNeed1 = max(0, need1 - x)`
     - Remaining type 2 requirement: `remainingNeed2 = max(0, need2 - x)`
   - Calculate the cost for this configuration:
     - Total cost = `x * costBoth + remainingNeed1 * cost1 + remainingNeed2 * cost2`
   - Keep track of the minimum cost encountered during these iterations.

3. **Complexity**:
   - The approach involves iterating through all possible values of `x`, which can be at most `min(need1, need2)`. However, since `need1` and `need2` can be as large as \(10^9\), we can limit our iterations to a reasonable number by considering the cost-effectiveness of type 3 items compared to type 1 and type 2 items.
   - The overall time complexity is \(O(\min(need1, need2))\), which is feasible given the constraints.

### Data Structures:
- Simple integer variables to track costs and requirements.
- No complex data structures are necessary as we are primarily performing arithmetic calculations.

### Summary:
By iterating over the possible number of type 3 items and calculating the remaining needs and associated costs, we can efficiently determine the minimum cost to meet the requirements. This method ensures that we explore all viable combinations while keeping the solution straightforward and efficient.
