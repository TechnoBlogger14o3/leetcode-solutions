# Count the Number of Special Characters II (Medium)

**Problem ID:** 3121  
**Date:** 2026-05-27  
**Link:** https://leetcode.com/problems/count-the-number-of-special-characters-ii/

## Approach

To solve the problem of counting special characters in a given string, we can adopt the following approach:

### Main Idea:
The goal is to identify characters that appear both in lowercase and uppercase forms while ensuring that all lowercase occurrences appear before the first uppercase occurrence of that character. 

### Steps:
1. **Data Structures**: 
   - Use a dictionary (or hashmap) to keep track of the counts of lowercase and uppercase occurrences for each character.
   - Use a set to maintain characters that have been identified as special.

2. **Iterate Through the String**: 
   - Traverse the string character by character. For each character:
     - If it's a lowercase letter, increment its count in the dictionary and mark it as seen.
     - If it's an uppercase letter, check if its corresponding lowercase letter has been seen. If it has, ensure that all lowercase occurrences are before the first uppercase occurrence. If these conditions are satisfied, add the character to the set of special characters.

3. **Count Special Characters**: 
   - After processing the string, the size of the set will give the count of special characters.

### Complexity:
- **Time Complexity**: O(n), where n is the length of the string. We make a single pass through the string, and operations on the dictionary and set are average O(1).
- **Space Complexity**: O(1) in terms of character tracking, since there are a fixed number of English letters (52 possible characters).

This approach efficiently counts the special characters by leveraging a single pass through the string and using a dictionary for quick lookups and counts, ensuring that we meet the problem's constraints effectively.
