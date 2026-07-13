# Sequential Digits (Medium)

**Problem ID:** 1291  
**Date:** 2026-07-13  
**Link:** https://leetcode.com/problems/sequential-digits/

## Approach

To solve the "Sequential Digits" problem, we can adopt a systematic approach that leverages the properties of sequential digits rather than brute-forcing through every number in the given range. Here's a concise explanation of the approach:

### Main Idea
The core idea is to generate all possible sequential digit numbers within the range [10, 123456789] (the largest sequential digit number) and then filter these numbers based on the provided `low` and `high` bounds. 

### Steps
1. **Generate Sequential Digits**: 
   - Sequential digits can be formed by starting from each digit (1 through 9) and appending the next digit (i.e., if starting from 1, the next digit would be 2, then 3, and so on).
   - This can be done using a loop that builds numbers by concatenating digits until the maximum sequential digit (i.e., 123456789) is reached.

2. **Store Valid Numbers**: 
   - As we generate these numbers, we can store them in a list. Since the generation process inherently produces numbers in sorted order, we can maintain this property.

3. **Filter by Range**: 
   - After generating the list of sequential digits, we filter this list to include only those numbers that fall within the specified range [low, high].

### Data Structures
- A simple list (or array) can be used to store the generated sequential digit numbers. This allows for easy appending and subsequent filtering.

### Complexity
- The time complexity of generating sequential digits is O(1) because the maximum number of sequential digits is limited (there are only 36 valid sequential numbers: 12, 23, 34, ..., 123456789).
- The space complexity is also O(1) in terms of the number of sequential digits stored since it does not grow with the input size but remains constant.

### Conclusion
By generating sequential digits directly and filtering them based on the given range, we efficiently solve the problem without needing to iterate through every integer in the range, which would be computationally expensive, especially given the constraints. This method ensures that we only deal with relevant numbers, making the solution both optimal and straightforward.
