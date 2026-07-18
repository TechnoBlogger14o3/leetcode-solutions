# Find Greatest Common Divisor of Array (Easy)

**Problem ID:** 1979  
**Date:** 2026-07-18  
**Link:** https://leetcode.com/problems/find-greatest-common-divisor-of-array/

## Approach

To solve the problem of finding the greatest common divisor (GCD) of the smallest and largest numbers in an integer array, we can follow a straightforward approach:

### Approach:

1. **Identify Extremes**: Begin by determining the smallest and largest numbers in the given array. This can be accomplished using simple iteration or built-in functions, depending on the programming language.

2. **Calculate GCD**: Once we have the smallest (`min_val`) and largest (`max_val`) numbers, we compute their GCD. The GCD can be efficiently calculated using the Euclidean algorithm, which is a well-known method for finding the GCD of two integers.

### Steps:

- **Step 1**: Iterate through the array to find `min_val` and `max_val`. This requires a single pass through the array, leading to a time complexity of O(n), where n is the length of the array.
  
- **Step 2**: Use the Euclidean algorithm to compute the GCD of `min_val` and `max_val`. The algorithm works by repeatedly replacing the larger number by its remainder when divided by the smaller number until one of the numbers becomes zero. The other number at that point will be the GCD.

### Data Structures:
- An integer array to hold the input values.
- Two integer variables to store the minimum and maximum values found during the iteration.

### Complexity:
- **Time Complexity**: O(n) for finding the minimum and maximum values plus O(log(min_val + max_val)) for calculating the GCD, leading to an overall complexity of O(n).
- **Space Complexity**: O(1), as we only use a fixed amount of extra space regardless of the input size.

### Conclusion:
This approach efficiently finds the GCD of the smallest and largest numbers in the array using basic array operations and the Euclidean algorithm, making it both simple and effective for the given problem constraints.
