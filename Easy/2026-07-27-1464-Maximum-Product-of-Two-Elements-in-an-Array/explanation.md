# Maximum Product of Two Elements in an Array (Easy)

**Problem ID:** 1464  
**Date:** 2026-07-27  
**Link:** https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/

## Approach

To solve the problem of finding the maximum product of two elements in an array, specifically the expression \((nums[i]-1)*(nums[j]-1)\) for different indices \(i\) and \(j\), we can follow a straightforward approach based on identifying the two largest values in the array.

### Problem-Solving Approach:

1. **Understanding the Expression**: The expression can be rewritten as:
   \[
   (nums[i]-1)*(nums[j]-1) = nums[i]*nums[j] - nums[i] - nums[j] + 1
   \]
   This shows that maximizing the product is closely tied to maximizing the values of \(nums[i]\) and \(nums[j]\).

2. **Identify the Two Largest Elements**: The maximum product will be obtained by selecting the two largest distinct elements from the array. Thus, the main idea is to find the two largest numbers in the array.

3. **Data Structures**: We can simply use two variables to keep track of the largest and the second largest numbers as we iterate through the array. This avoids the need for additional data structures and keeps the solution efficient.

4. **Iterate Through the Array**: As we traverse the array:
   - Compare each element with the current largest and second largest values.
   - Update these values accordingly.

5. **Calculate the Result**: Once we have the two largest numbers, say `max1` and `max2`, we can compute the result using:
   \[
   (max1 - 1) * (max2 - 1)
   \]

### Complexity Analysis:
- **Time Complexity**: The algorithm runs in \(O(n)\), where \(n\) is the length of the input array. This is because we only make a single pass through the array to find the two largest elements.
- **Space Complexity**: The space complexity is \(O(1)\) since we are using a constant amount of space for the two variables to store the largest values.

In summary, by focusing on finding the two largest distinct elements in the array, we can efficiently compute the maximum product of the expression while adhering to the constraints provided.
