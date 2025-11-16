# Number of Substrings With Only 1s (Medium)

**Problem ID:** 1513  
**Date:** 2025-11-16  
**Link:** https://leetcode.com/problems/number-of-substrings-with-only-1s/

## Approach

To solve the problem of counting the number of substrings consisting solely of '1's in a given binary string, we can adopt a straightforward approach that leverages the properties of contiguous segments of '1's.

### Approach:

1. **Identify Segments of '1's**: 
   - Traverse the binary string and count the lengths of contiguous segments of '1's. Each time we encounter a '0', we can conclude the current segment of '1's and start counting a new segment if we find another '1'.

2. **Count Substrings for Each Segment**:
   - For a segment of length `k` (i.e., `k` consecutive '1's), the number of substrings that can be formed is given by the formula:
     \[
     \text{Number of substrings} = \frac{k \times (k + 1)}{2}
     \]
   - This formula arises because:
     - There are `k` substrings of length 1 (each individual '1'),
     - `k-1` substrings of length 2 (each pair of consecutive '1's),
     - and so forth, up to 1 substring of length `k` (the entire segment).

3. **Aggregate the Counts**:
   - As we identify each segment of '1's, we compute the number of substrings for that segment using the formula above and maintain a running total.

4. **Handle Large Numbers**:
   - Since the result can be very large, we take the total modulo \(10^9 + 7\) at each step to ensure we do not encounter overflow and adhere to the problem's requirements.

### Data Structures:
- We primarily use simple integer variables to track the current segment length and the total count of substrings. No complex data structures are necessary.

### Complexity:
- **Time Complexity**: O(n), where n is the length of the binary string. We make a single pass through the string to count segments and compute the number of substrings.
- **Space Complexity**: O(1), as we use a constant amount of extra space regardless of the input size.

This approach is efficient and straightforward, ensuring that we can handle the upper limits of the input constraints effectively.
