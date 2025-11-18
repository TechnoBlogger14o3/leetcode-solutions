# 1-bit and 2-bit Characters (Easy)

**Problem ID:** 717  
**Date:** 2025-11-18  
**Link:** https://leetcode.com/problems/1-bit-and-2-bit-characters/

## Approach

To solve the problem of determining whether the last character in a binary array can be a one-bit character, we can use a straightforward approach by iterating through the array from the end towards the beginning. The key points of the solution are as follows:

### Main Idea:
1. **Understanding Character Representation**: We know that:
   - A one-bit character is represented by `0`.
   - A two-bit character is represented by either `10` or `11`.
   - The array always ends with `0`, which means the last character is guaranteed to be a one-bit character if it is not preceded by a valid two-bit character.

2. **Iterative Backtracking**: Starting from the second last element of the array (since the last element is always `0`):
   - If we encounter a `1`, it indicates the start of a two-bit character. We then skip the next bit (i.e., move back two positions).
   - If we encounter a `0`, it indicates the end of a one-bit character, and we move back one position.
   - Continue this process until we either reach the beginning of the array or determine the nature of the last character.

3. **Decision Point**: If we finish the iteration and the pointer is at a position that allows for a one-bit character (i.e., we are at the start of the array or have only a `0` left), we can conclude that the last character must be a one-bit character.

### Data Structures:
- We primarily use a simple integer variable to track our position in the array, and no additional data structures are required.

### Complexity:
- **Time Complexity**: O(n), where n is the length of the input array. In the worst case, we might need to traverse the entire array once.
- **Space Complexity**: O(1), as we only use a constant amount of extra space for our pointer.

This approach efficiently determines whether the last character is a one-bit character by leveraging the properties of the binary representation and iterating through the array in a linear fashion.
