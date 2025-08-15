# Largest 3-Same-Digit Number in String

## Problem Description
Given a string `num` representing a large integer, return the largest **good integer** as a string. A **good integer** is a substring of `num` with exactly 3 consecutive digits that are the same.

If no such integer exists, return an empty string `""`.

## Approach

### Method 1: Simple Iteration
The most straightforward approach is to iterate through the string and check for 3 consecutive same digits.

**Algorithm:**
1. Initialize an empty result string
2. Iterate through the string from index 0 to `length - 3`
3. For each position, check if the current digit and next two digits are the same
4. If found, extract the substring and update result if it's larger lexicographically
5. Return the result

**Time Complexity:** O(n) - where n is the length of the string
**Space Complexity:** O(1) - constant extra space

### Method 2: Sliding Window
A more explicit approach using a sliding window of size 3.

**Algorithm:**
1. Initialize an empty result string
2. Use a sliding window of size 3 to check consecutive digits
3. Compare all three characters in the window
4. If they're the same, form the substring and update result if larger
5. Return the result

**Time Complexity:** O(n) - where n is the length of the string
**Space Complexity:** O(1) - constant extra space

## Key Insights
1. **Consecutive Check**: We need exactly 3 consecutive same digits, not just 3 occurrences
2. **Lexicographical Order**: String comparison works naturally for digits (e.g., "999" > "888")
3. **Empty String**: Return empty string if no good integer is found
4. **Boundary Check**: Only iterate up to `length - 3` to avoid index out of bounds

## Examples
- **num = "6777133339"**: 
  - Found "333" at position 5
  - Found "777" at position 1
  - "777" > "333" lexicographically, so return "777"
- **num = "2300019"**: 
  - Found "000" at position 2
  - Only one good integer, so return "000"
- **num = "42352338"**: 
  - No 3 consecutive same digits found
  - Return ""

## Edge Cases
1. **String length < 3**: Return empty string
2. **No good integers**: Return empty string
3. **Multiple good integers**: Return the lexicographically largest
4. **All same digits**: Return the first 3 digits

## Code Structure
Both solutions are clean and efficient:
1. **Simple Iteration**: More straightforward and easier to understand
2. **Sliding Window**: More explicit about the window concept

The sliding window approach makes the logic more clear and can be easily extended to other similar problems that require checking consecutive elements.

## Performance Notes
- Both approaches have the same time and space complexity
- String comparison is efficient for small strings
- The solution handles all edge cases correctly
- No need for complex data structures or algorithms

