# Count the Number of Special Characters I (Easy)

**Problem ID:** 3120  
**Date:** 2026-05-26  
**Link:** https://leetcode.com/problems/count-the-number-of-special-characters-i/

## Approach

To solve the problem of counting the number of special characters in a given string, we can follow these steps:

### Main Idea:
A character is considered "special" if it appears in both its lowercase and uppercase forms in the string. Therefore, the goal is to identify all unique characters in the string and check for each character if both its lowercase and uppercase variants exist.

### Approach:
1. **Data Structures**: 
   - Use two sets: one for lowercase characters and one for uppercase characters. Sets are chosen because they allow for efficient membership testing and ensure uniqueness of characters.

2. **Iterate Through the String**:
   - Traverse each character in the input string.
   - Depending on whether the character is lowercase or uppercase, add it to the corresponding set (lowercase or uppercase).

3. **Count Special Characters**:
   - After populating both sets, iterate through one of the sets (either lowercase or uppercase).
   - For each character in this set, check if its counterpart (lowercase or uppercase) exists in the other set.
   - Maintain a count of such characters that meet the criteria of being special.

### Complexity:
- **Time Complexity**: O(n), where n is the length of the string. We perform a single pass to populate the sets and another pass to count the special characters.
- **Space Complexity**: O(1) in terms of additional space since the maximum number of unique characters (26 lowercase + 26 uppercase) is constant and does not depend on the input size.

### Summary:
By utilizing sets to track the presence of lowercase and uppercase characters, we can efficiently determine the number of special characters in the string by checking for the existence of both forms for each character. This approach is optimal given the constraints and ensures clarity and simplicity in implementation.
