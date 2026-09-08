# Count Commas in Range (Easy)

**Problem ID:** 3870  
**Date:** 2026-09-08  
**Link:** https://leetcode.com/problems/count-commas-in-range/

## Approach

To solve the problem of counting commas in the range from 1 to n when writing integers in standard formatting, we can adopt a systematic approach based on the properties of numbers and their digit lengths.

### Approach:

1. **Understanding Comma Placement**:
   - Commas are placed after every three digits from the right. Therefore, we need to determine how many digits each number has and when commas will be inserted.
   - Numbers with fewer than 4 digits (1 to 999) do not have any commas, while numbers with 4 digits (1000 to 9999) have 1 comma, and those with 5 digits (10000 to 99999) have 2 commas.

2. **Counting Commas by Ranges**:
   - We can break down the counting process based on ranges of numbers:
     - For numbers from 1 to 999: **0 commas**.
     - For numbers from 1000 to 9999: Each number contributes **1 comma**.
     - For numbers from 10000 to 99999: Each number contributes **2 commas**.
   - We can determine the upper limit of each range based on the value of n.

3. **Calculating Total Commas**:
   - Depending on the value of n:
     - If n < 1000, the total comma count is 0.
     - If n is between 1000 and 9999, the total commas can be calculated as the count of numbers from 1000 to n, which is (n - 1000 + 1).
     - If n is between 10000 and 99999, we first count the commas for numbers from 1000 to 9999, and then add the count for numbers from 10000 to n, which is 2 commas for each of those numbers.

4. **Final Count**:
   - Combine the counts from the relevant ranges to get the total number of commas.

### Complexity:
- The time complexity of this approach is O(1) since we are performing a constant number of arithmetic operations regardless of the input size.
- The space complexity is also O(1) as we are using a fixed amount of additional space for calculations.

### Summary:
This approach efficiently counts commas by leveraging the properties of number formatting and ranges, leading to a solution that is both straightforward and optimal.
