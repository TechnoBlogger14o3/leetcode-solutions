# Maximum Subarray With Equal Products (Easy)

**Problem ID:** 3411  
**Date:** 2026-11-24  
**Link:** https://leetcode.com/problems/maximum-subarray-with-equal-products/

## Approach

To solve the problem of finding the longest product equivalent subarray, we need to understand the conditions under which an array is considered product equivalent. Specifically, we need to ensure that the product of the elements in the subarray equals the product of the GCD and LCM of the same elements.

### Approach:

1. **Understanding the Mathematical Condition**:
   - For a subarray to be product equivalent, it must satisfy the condition: 
     \[
     \text{prod(arr)} = \text{lcm(arr)} \times \text{gcd(arr)}
     \]
   - The relationship between GCD and LCM can be expressed through the product of the elements:
     \[
     \text{prod(arr)} = \text{gcd(arr)} \times \text{lcm(arr)} \implies \text{lcm(arr)} = \frac{\text{prod(arr)}}{\text{gcd(arr)}}
     \]

2. **Iterating Through Subarrays**:
   - We can use a sliding window or two-pointer technique to explore all possible subarrays. For each subarray, we will compute the GCD and LCM iteratively as we expand the window.

3. **Data Structures**:
   - We will maintain a variable for the current GCD and LCM as we expand our subarray.
   - A hash map or a set can be used to track the lengths of valid subarrays that meet the product equivalence condition.

4. **Computing GCD and LCM**:
   - The GCD can be computed using the Euclidean algorithm.
   - The LCM can be derived from the GCD using the formula:
     \[
     \text{lcm}(a, b) = \frac{|a \times b|}{\text{gcd}(a, b)}
     \]

5. **Complexity**:
   - The time complexity of this approach is O(n^2) in the worst case, where n is the length of the input array. This is due to the nested loops required to check all subarrays.
   - The space complexity is O(1) since we are primarily using a few variables to store the current GCD and LCM.

### Summary:
By leveraging the mathematical properties of GCD and LCM, we can efficiently identify the longest product equivalent subarray through a systematic exploration of all subarrays, updating our GCD and LCM as we go. This approach balances clarity and efficiency, making it suitable given the problem constraints.
