# Coupon Code Validator (Easy)

**Problem ID:** 3606  
**Date:** 2025-12-13  
**Link:** https://leetcode.com/problems/coupon-code-validator/

## Approach

To solve the "Coupon Code Validator" problem, we can follow a structured approach that involves filtering and sorting the coupons based on the given criteria.

### Main Idea:
1. **Validation**: We need to check each coupon against three conditions:
   - The `code` must be non-empty and contain only alphanumeric characters and underscores.
   - The `businessLine` must be one of the specified valid categories: "electronics", "grocery", "pharmacy", or "restaurant".
   - The `isActive` status must be `true`.

2. **Sorting**: After identifying valid coupons, we need to sort them first by their `businessLine` in a specified order and then by their `code` in lexicographical order.

### Steps:
1. **Iterate through the coupons**: Using a loop, we can check each coupon's properties based on the three validation criteria outlined above. For this, we can use a helper function to validate the `code`.

2. **Store valid coupons**: For each coupon that meets all the criteria, we can store its `code` in a list.

3. **Sorting**: Once we have the list of valid coupon codes, we will sort this list. To facilitate the custom sorting of the `businessLine`, we can create a mapping of business categories to their respective order, which will help in sorting the coupons based on their `businessLine` first.

### Data Structures:
- **List**: To hold the valid coupon codes.
- **Dictionary**: To map the business categories to their respective sort order for efficient sorting.

### Complexity:
- **Time Complexity**: The overall time complexity is O(n log n) due to the sorting step, where n is the number of coupons. The validation step runs in O(n), making the sorting the most time-consuming operation.
- **Space Complexity**: O(n) is required to store the valid coupon codes.

By following this approach, we ensure that we efficiently validate and sort the coupons according to the specified requirements, leading to a clear and concise solution.
