# Product of the Last K Numbers (Medium)

**Problem ID:** 1352  
**Date:** 2026-11-23  
**Link:** https://leetcode.com/problems/product-of-the-last-k-numbers/

## Approach

To solve the "Product of the Last K Numbers" problem, we need to design a class that efficiently handles a stream of integers, allowing us to compute the product of the last `k` numbers in constant time.

### Approach:

1. **Data Structure**:
   - Use a list (or dynamic array) to maintain the stream of numbers. This allows us to easily append new numbers and access the last `k` numbers.
   - Additionally, maintain a second list to store cumulative products. This list will help us retrieve the product of the last `k` numbers in O(1) time.

2. **Adding Numbers**:
   - When a number is added via the `add(int num)` method:
     - If the number is not zero, compute the product of the current number and the last product stored (if it exists) and append this to the cumulative products list.
     - If the number is zero, append a zero to the cumulative product list, as any product involving zero will also be zero. This will effectively reset the product calculation for subsequent calls.

3. **Getting the Product**:
   - For the `getProduct(int k)` method:
     - If the last `k` numbers include a zero (which can be determined by checking the cumulative products), return 0.
     - Otherwise, return the product of the last `k` numbers using the cumulative products list. The product can be computed as `cumulativeProducts[n] / cumulativeProducts[n-k]`, where `n` is the index of the last number in the cumulative products list.

### Complexity:
- **Time Complexity**:
  - `add(int num)`: O(1) - Appending to a list is constant time.
  - `getProduct(int k)`: O(1) - Retrieving the product using the cumulative products list is constant time.
  
- **Space Complexity**:
  - O(n) - Where `n` is the number of elements added to the stream, as we need to store both the original numbers and their cumulative products.

### Summary:
This approach efficiently handles the requirements of the problem by leveraging cumulative products to allow for constant-time retrieval of the product of the last `k` numbers. The use of a list to store products also simplifies handling the case when zero is encountered in the stream, as it allows us to reset the product calculation seamlessly.
