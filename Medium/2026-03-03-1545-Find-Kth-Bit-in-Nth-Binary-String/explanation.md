# Find Kth Bit in Nth Binary String (Medium)

**Problem ID:** 1545  
**Date:** 2026-03-03  
**Link:** https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/

## Approach

To solve the problem of finding the k-th bit in the n-th binary string \( S_n \), we can utilize the recursive structure of the strings without explicitly constructing them, which would be inefficient for larger values of \( n \).

### Main Idea:
The string \( S_n \) is defined recursively:
- \( S_1 = "0" \)
- For \( n > 1 \), \( S_n = S_{n-1} + "1" + \text{reverse}(\text{invert}(S_{n-1})) \)

This structure allows us to deduce the position of the k-th bit based on its location relative to the components of \( S_n \):
1. The first part \( S_{n-1} \) contributes the first \( 2^{n-1} - 1 \) bits.
2. The middle bit is always "1" (at position \( 2^{n-1} \)).
3. The last part is the inverted and reversed \( S_{n-1} \), which contributes the last \( 2^{n-1} - 1 \) bits.

### Approach:
1. **Determine Length**: For any \( n \), the length of \( S_n \) is \( 2^n - 1 \).
2. **Recursive Search**: 
   - If \( k \) is less than or equal to the length of \( S_{n-1} \), then the k-th bit is in \( S_{n-1} \).
   - If \( k \) equals \( 2^{n-1} \), then the k-th bit is "1".
   - If \( k \) is greater than \( 2^{n-1} \), the k-th bit corresponds to a position in the inverted and reversed \( S_{n-1} \). In this case, calculate the index in the reversed string as \( k - (2^{n-1} + 1) \). The bit at this position will be the inverted value of the corresponding bit in \( S_{n-1} \).

3. **Base Case**: The recursion stops when \( n = 1 \), where the only bit is "0".

### Data Structures:
- No complex data structures are needed; we primarily use integer variables to track the current \( n \) and \( k \).

### Complexity:
- The time complexity is \( O(n) \) due to the depth of the recursive calls, where \( n \) can go up to 20. This is efficient given the constraints.
- The space complexity is \( O(n) \) due to the recursion stack.

This approach allows us to efficiently determine the k-th bit without generating the entire string, leveraging the recursive definition and properties of the binary strings.
