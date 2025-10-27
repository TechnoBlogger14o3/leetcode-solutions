# Number of Laser Beams in a Bank (Medium)

**Problem ID:** 2125  
**Date:** 2025-10-27  
**Link:** https://leetcode.com/problems/number-of-laser-beams-in-a-bank/

## Approach

To solve the problem of counting the number of laser beams in a bank represented by a binary string array, we can follow a systematic approach:

### Problem Breakdown
1. **Understanding Laser Beams**: A laser beam exists between two security devices if they are located on different rows, and there are no devices in the rows between them. This means we need to identify pairs of rows that meet these criteria.

2. **Row Analysis**: For each row, we must count the number of security devices ('1's). This will help us determine how many beams can be formed between pairs of rows.

### Approach
1. **Count Security Devices**: Iterate through each row of the bank and count the number of '1's (security devices). Store these counts in a list.

2. **Identify Valid Row Pairs**: As we iterate through the rows:
   - Whenever we encounter a row with security devices, we check the previous row counts (from the last row with devices) to the current row.
   - If there are no security devices in the rows between the last row with devices and the current row, we can compute the number of beams that can be formed using the counts of the two rows.

3. **Beam Calculation**: For each valid pair of rows (r1 and r2) with counts `count[r1]` and `count[r2]`, the number of beams formed is `count[r1] * count[r2]`. We accumulate this product into a total beam count.

### Data Structures
- **List/Array**: To store the count of security devices for each row.
- **Integer Variables**: To keep track of the last row with devices and the total beam count.

### Complexity
- **Time Complexity**: O(m * n), where m is the number of rows and n is the number of columns. This is due to the need to iterate through each cell in the matrix to count the devices.
- **Space Complexity**: O(m), for storing the counts of devices per row.

### Conclusion
By systematically counting the devices and checking the conditions for valid pairs of rows, we can efficiently compute the total number of laser beams in the bank. This approach ensures that we only consider valid configurations while maintaining clarity and efficiency.
