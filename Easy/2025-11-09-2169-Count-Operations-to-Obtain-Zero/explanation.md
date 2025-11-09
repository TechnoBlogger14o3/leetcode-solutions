# Count Operations to Obtain Zero (Easy)

**Problem ID:** 2169  
**Date:** 2025-11-09  
**Link:** https://leetcode.com/problems/count-operations-to-obtain-zero/

## Approach

To solve the problem of counting operations to obtain zero from two non-negative integers `num1` and `num2`, we can utilize a straightforward iterative approach based on the rules provided.

### Approach:

1. **Understanding Operations**: The operations depend on the relative sizes of `num1` and `num2`. If `num1 >= num2`, we subtract `num2` from `num1`; otherwise, we subtract `num1` from `num2`. This continues until one of the numbers reaches zero.

2. **Count Operations**: We need to keep a count of how many operations we perform. Each time we perform a subtraction, we increment our operation counter.

3. **Optimization Insight**: Instead of performing individual subtractions, we can optimize the process using integer division. When `num1` is greater than or equal to `num2`, the number of times we can subtract `num2` from `num1` in one go is `num1 // num2`. This gives us how many operations we can perform at once, and we can then update `num1` accordingly. The same logic applies when `num2` is greater than `num1`.

4. **Loop Until Zero**: We continue this process until either `num1` or `num2` becomes zero. Each iteration will either reduce one of the numbers significantly or bring them closer to zero.

### Data Structures:
- We only need two integer variables (`num1` and `num2`) and an integer to keep track of the operation count. No complex data structures are required.

### Complexity:
- **Time Complexity**: The approach runs in O(log(max(num1, num2))) time due to the nature of the operations reducing the larger number significantly in each step.
- **Space Complexity**: O(1), as we are using a constant amount of space regardless of the input size.

### Summary:
The main idea is to leverage the properties of division to count multiple operations in one step, significantly reducing the number of iterations needed to reach zero. This efficient approach ensures we handle even the upper limits of the input constraints effectively.
