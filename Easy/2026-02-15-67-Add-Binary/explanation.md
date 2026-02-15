# Add Binary (Easy)

**Problem ID:** 67  
**Date:** 2026-02-15  
**Link:** https://leetcode.com/problems/add-binary/

## Approach

To solve the "Add Binary" problem, we can use a straightforward approach that simulates the binary addition process, similar to how we perform addition manually. 

### Approach:

1. **Initialization**: Start with two pointers, one for each binary string `a` and `b`, initialized to the last index of each string. Also, maintain a variable `carry` to handle the overflow from adding two bits.

2. **Iterate Backwards**: Loop through both strings from the end to the beginning. In each iteration:
   - Retrieve the current bits from both strings using the pointers. If a pointer goes out of bounds (i.e., less than 0), treat the corresponding bit as `0`.
   - Convert the retrieved characters ('0' or '1') to integers and calculate the sum of these bits along with the `carry`.
   - Determine the new bit to append to the result by taking the sum modulo 2 (i.e., `sum % 2`), and update the `carry` for the next iteration by performing integer division by 2 (i.e., `sum // 2`).

3. **Build the Result**: Store the resulting bits in a list or string. Since we are constructing the result from the least significant bit to the most significant, we should reverse the final result at the end.

4. **Handle Remaining Carry**: After the loop, if there is any leftover `carry`, append it to the result.

5. **Output**: Finally, convert the list of characters to a string and return it.

### Data Structures:
- Use a list to accumulate the result bits, which allows for efficient appending.
- The carry variable is an integer.

### Complexity:
- **Time Complexity**: O(max(n, m)), where `n` and `m` are the lengths of the binary strings `a` and `b`, respectively. This is because we iterate through both strings once.
- **Space Complexity**: O(max(n, m)) for the result storage, which can be as long as the longer of the two input strings.

This approach efficiently handles the addition of binary strings while ensuring clarity and correctness by simulating the manual addition process.
