# Unique 3-Digit Even Numbers (Easy)

**Problem ID:** 3483  
**Date:** 2026-09-11  
**Link:** https://leetcode.com/problems/unique-3-digit-even-numbers/

## Approach

To solve the problem of counting distinct three-digit even numbers that can be formed from a given array of digits, we can follow a systematic approach:

### Main Idea:
1. **Identify Even Digits**: Since the number must be even, we need to focus on the digits that can occupy the unit's place. These digits must be even (0, 2, 4, 6, 8).
2. **Construct Three-Digit Numbers**: For each valid even digit selected for the unit's place, we will then select two more digits from the remaining digits to form a three-digit number. The first digit cannot be zero to avoid leading zeros.

### Steps:
1. **Count Occurrences**: Use a frequency array or a dictionary to count occurrences of each digit in the input array. This helps in managing duplicates.
2. **Iterate Over Even Digits**: For each even digit (that can be the last digit), determine how many valid combinations of the first two digits can be formed from the remaining digits.
3. **Select First Digit**: Ensure that the first digit is not zero and is selected from the available digits (taking into account their counts).
4. **Select Second Digit**: The second digit can be any of the remaining digits, including the possibility of selecting the same digit if it appears more than once.
5. **Calculate Combinations**: For each valid configuration, compute the number of distinct three-digit numbers by considering the permutations of the selected digits.

### Data Structures:
- **Frequency Array**: To keep track of how many times each digit appears, which allows efficient checking of available digits.
- **Set or List**: To store unique combinations of three-digit numbers if needed, but counting can be done mathematically without storing them explicitly.

### Complexity:
- **Time Complexity**: The approach runs in O(n^2) in the worst case, where n is the number of unique digits (up to 10). This is due to the nested loops for selecting digits.
- **Space Complexity**: O(1) for the frequency count (constant space for digits 0-9), though additional space may be used for storing combinations if needed.

### Conclusion:
By focusing on the last digit being even and ensuring the first digit is non-zero, we can systematically count the valid three-digit even numbers that can be formed from the given digits. This approach efficiently handles the constraints and ensures we consider distinct combinations without leading zeros.
