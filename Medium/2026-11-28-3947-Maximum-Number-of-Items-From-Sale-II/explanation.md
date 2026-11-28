# Maximum Number of Items From Sale II (Medium)

**Problem ID:** 3947  
**Date:** 2026-11-28  
**Link:** https://leetcode.com/problems/maximum-number-of-items-from-sale-ii/

## Approach

To solve the problem of maximizing the total number of items obtained within a given budget, we can break down the approach into several key steps:

### Main Idea
The primary goal is to strategically purchase items in such a way that not only do we maximize the number of purchased items, but we also take full advantage of the free items we can obtain based on the purchase rules. The free items depend on the divisibility of factors among the items.

### Steps to Approach

1. **Sorting Items**: Start by sorting the items based on their prices. This allows us to consider the cheapest items first, maximizing the number of items we can purchase within the budget.

2. **Dynamic Programming / Greedy Selection**:
   - We can use a greedy approach to determine how many copies of each item can be purchased without exceeding the budget.
   - For each item, calculate how many copies can be bought and update the remaining budget accordingly.

3. **Tracking Free Items**: As we purchase items:
   - Maintain a list or a mapping of which items can provide free items based on the divisibility condition. This can be done using a dictionary where the key is the factor and the value is a list of items that can be obtained for free from purchases of that item.
   - For each purchased item, check which free items can be obtained and count them.

4. **Final Count**: After processing all items, sum the total number of purchased items and the free items obtained from those purchases.

### Data Structures
- A list or array for storing items and their prices.
- A dictionary to map factors to the list of items that can be obtained for free.
- Variables to keep track of the total number of items purchased and the remaining budget.

### Complexity
- **Time Complexity**: The sorting step takes \(O(n \log n)\), where \(n\) is the number of items. The subsequent operations for purchasing and counting free items can be done in linear time, resulting in an overall complexity of \(O(n \log n)\).
- **Space Complexity**: The space complexity is \(O(n)\) for storing the items and the mapping of factors to free items.

By following this structured approach, we can efficiently determine the maximum number of items that can be obtained within the budget while leveraging the rules for free items effectively.
