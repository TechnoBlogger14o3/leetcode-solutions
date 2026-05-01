# Rotate Function (Medium)

**Problem ID:** 396  
**Date:** 2026-05-01  
**Link:** https://leetcode.com/problems/rotate-function/

## Approach

To solve the "Rotate Function" problem efficiently, we can leverage the relationship between the values of the rotation function \( F(k) \) for consecutive rotations rather than recalculating each from scratch.

### Problem Breakdown:
1. **Understanding \( F(k) \)**: 
   The function \( F(k) \) computes a weighted sum of the elements in the array based on their rotated positions. Specifically, for an array \( \text{nums} \) of length \( n \):
   \[
   F(k) = 0 \cdot \text{nums}[(0 + k) \mod n] + 1 \cdot \text{nums}[(1 + k) \mod n] + \ldots + (n-1) \cdot \text{nums}[(n-1 + k) \mod n]
   \]

2. **Recursive Relation**:
   We can derive \( F(k) \) from \( F(k-1) \) using the following relation:
   \[
   F(k) = F(k-1) + \text{sum} - n \cdot \text{nums}[n-k]
   \]
   where \( \text{sum} \) is the total sum of the elements in the array, and \( \text{nums}[n-k] \) is the element that gets moved to the front in the rotation.

3. **Initialization**:
   Start by calculating \( F(0) \) directly using the formula:
   \[
   F(0) = 0 \cdot \text{nums}[0] + 1 \cdot \text{nums}[1] + \ldots + (n-1) \cdot \text{nums}[n-1]
   \]
   Also, compute the total sum of the array elements.

4. **Iterative Calculation**:
   Using the recursive relation, compute \( F(k) \) for \( k = 1 \) to \( n-1 \) iteratively. Keep track of the maximum value encountered.

### Data Structures:
- **Array**: To store the input numbers.
- **Variables**: To hold values for \( F(k) \), the total sum, and the maximum value.

### Complexity:
- **Time Complexity**: \( O(n) \) since we compute \( F(0) \) and iterate through the array \( n-1 \) times to compute the subsequent values.
- **Space Complexity**: \( O(1) \) as we only use a constant amount of extra space for variables.

### Conclusion:
This approach efficiently computes the maximum value of the rotation function by utilizing the relationship between consecutive rotations, thus avoiding the need for a full recalculation for each \( k \). This results in a linear time complexity, making it suitable for large inputs up to the constraint limits.
