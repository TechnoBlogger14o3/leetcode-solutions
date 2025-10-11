# Product of Array Except Self

## Problem Statement

Given an integer array `nums`, return an array `answer` such that `answer[i]` is equal to the product of all the elements of `nums` except `nums[i]`.

The product of any prefix or suffix of `nums` is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operator.

## Examples

**Example 1:**
```
Input: nums = [1,2,3,4]
Output: [24,12,8,6]
```

**Example 2:**
```
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
```

## Approach

### Method 1: Two Pass (Recommended)
1. First pass: Calculate left products (product of all elements to the left)
2. Second pass: Calculate right products and multiply with left products
3. Use result array to store left products, then multiply with right products

**Time Complexity:** O(n) - Two passes through the array
**Space Complexity:** O(1) - Excluding the output array

### Method 2: Two Arrays
1. Create left products array
2. Create right products array
3. Multiply corresponding elements

**Time Complexity:** O(n) - Three passes
**Space Complexity:** O(n) - For left and right arrays

## Algorithm

```
1. Initialize result array with 1s
2. First pass (left to right):
   a. For each position i:
      - result[i] = product of all elements to the left
3. Second pass (right to left):
   a. Keep track of right product
   b. For each position i:
      - result[i] *= right product
      - Update right product *= nums[i]
4. Return result array
```

## Key Insights

- **No Division**: Cannot use division operator, must use multiplication
- **Two Passes**: Left products + right products = total product
- **Space Optimization**: Use result array for left products
- **Zero Handling**: Special case when array contains zeros

## Alternative Approaches

1. **Two Arrays**: Separate left and right arrays - O(n) space
2. **Brute Force**: For each element, multiply all others - O(n²) time
3. **Division**: If allowed, calculate total product and divide - O(n) time

## Edge Cases

- Array with zeros: Product becomes zero for most positions
- Single zero: Only that position has non-zero product
- All zeros: All products are zero
- Negative numbers: Product can be negative
- Single element: Return array with one element

## Applications

- Mathematical computations
- Signal processing
- Data analysis
- Algorithm design patterns
- Interview preparation

## Optimization Opportunities

- **Single Array**: Use result array for both left and right products
- **In-place**: Modify input array if allowed
- **Early Exit**: Handle zero cases efficiently
- **Memory Efficient**: Minimize extra space usage
