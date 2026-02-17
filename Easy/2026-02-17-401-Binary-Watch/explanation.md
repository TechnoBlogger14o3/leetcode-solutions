# Binary Watch (Easy)

**Problem ID:** 401  
**Date:** 2026-02-17  
**Link:** https://leetcode.com/problems/binary-watch/

## Approach

To solve the "Binary Watch" problem, we need to generate all possible valid times that can be represented by a binary watch given a specific number of LEDs that are turned on. The watch has 4 LEDs for hours (0-11) and 6 LEDs for minutes (0-59).

### Approach:

1. **Understanding the Representation**:
   - The binary watch consists of 4 bits for hours and 6 bits for minutes.
   - We need to determine how many bits are set (turned on) in total, which is given by the `turnedOn` parameter.

2. **Brute Force Combination**:
   - We can iterate through all possible combinations of hours and minutes.
   - For hours, we can iterate from 0 to 11 (inclusive).
   - For minutes, we can iterate from 0 to 59 (inclusive).

3. **Counting Bits**:
   - For each combination of hours and minutes, we need to count the number of bits that are set to 1 (i.e., the number of LEDs that are on).
   - This can be efficiently done using a helper function that counts the number of 1s in the binary representation of a number.

4. **Validation**:
   - After generating a combination of hours and minutes, we check if the total number of bits turned on (from both hours and minutes) equals `turnedOn`.
   - If it matches, we format the time correctly (ensuring minutes are always two digits) and add it to the result list.

5. **Result Compilation**:
   - Finally, we return the list of valid times.

### Data Structures:
- A list or array to store the valid time strings.

### Complexity:
- The time complexity is O(1) because the number of combinations (12 hours * 60 minutes = 720) is constant and does not depend on the input size.
- The space complexity is also O(1) in terms of additional space used, as we only store the valid time strings, which is limited by the number of valid combinations.

In summary, the solution involves generating all possible hour and minute combinations, counting the bits, and checking against the `turnedOn` parameter to compile a list of valid time representations.
