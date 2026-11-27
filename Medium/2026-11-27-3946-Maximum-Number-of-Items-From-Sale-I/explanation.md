# Maximum Number of Items From Sale I (Medium)

**Problem ID:** 3946  
**Date:** 2026-11-27  
**Link:** https://leetcode.com/problems/maximum-number-of-items-from-sale-i/

## Approach

To solve the problem of maximizing the total number of item copies obtained within a given budget, we can follow a structured approach that involves dynamic programming and careful consideration of the relationships between items based on their factors.

### Main Idea:
The core idea is to leverage both the purchases made within the budget and the free items received as a result of those purchases. We want to explore all possible combinations of purchases while keeping track of the free items that can be obtained based on the factors of the items purchased.

### Approach:
1. **Dynamic Programming Setup**: 
   - Create a dynamic programming array `dp` where `dp[b]` represents the maximum number of items that can be obtained with a budget `b`.
   - Initialize `dp[0] = 0` (zero items can be obtained with zero budget) and all other entries to zero.

2. **Iterate Over Items**:
   - For each item, determine how many copies can be bought without exceeding the budget. For each possible purchase count, update the `dp` array.
   - When an item is purchased, calculate the free items that can be obtained based on the divisibility of factors. This requires maintaining a mapping of factors to the items that can be obtained for free.

3. **Free Item Calculation**:
   - For each item purchased, check all other items to see if their factor is divisible by the purchased item's factor. If it is, increment the count of free items that can be obtained.

4. **Update DP Array**:
   - For each budget from high to low (to avoid overwriting values that are still needed), update the `dp` array based on the number of items purchased and the free items received.

5. **Final Result**:
   - The maximum number of items that can be obtained will be the maximum value in the `dp` array after processing all items.

### Data Structures:
- A list or array for the `dp` values to track the maximum items for each budget level.
- A mapping (e.g., a dictionary) to associate factors with their corresponding items for efficient retrieval of free items.

### Complexity:
- **Time Complexity**: O(n * budget), where `n` is the number of items and `budget` is the maximum budget. This is due to iterating over each item and updating the `dp` array for each possible budget.
- **Space Complexity**: O(budget), for storing the `dp` array.

This approach efficiently combines the purchase and free item logic to maximize the total items obtained while adhering to the budget constraints. By systematically updating the `dp` array, we ensure that all combinations of purchases and their respective free items are considered.
