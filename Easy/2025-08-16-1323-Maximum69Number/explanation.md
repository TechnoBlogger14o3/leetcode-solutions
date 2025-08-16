# Maximum 69 Number

## Problem Description
Given a positive integer `num` consisting only of digits 6 and 9, return the maximum number you can get by changing at most one digit (6 to 9, or 9 to 6).

## Approach
The key insight is that to maximize the number, we should change the leftmost 6 to 9. This is because:
- Changing a digit in a higher position (leftmost) has a greater impact on the overall value
- We only need to change one digit, so we should make the most impactful change
- If there are no 6s, the number is already maximum

## Algorithm
1. Convert the number to a string to easily manipulate individual digits
2. Iterate through the digits from left to right
3. Find the first occurrence of '6' and change it to '9'
4. Convert the result back to an integer

## Time Complexity
- **Time**: O(log n) where n is the number of digits in the input number
- **Space**: O(log n) to store the string representation

## Example
- Input: num = 9669
- Process: Change the first '6' to '9' → 9969
- Output: 9969

## Alternative Approach
We could also solve this mathematically by finding the highest power of 10 where the digit is 6, but the string manipulation approach is more straightforward and readable.
