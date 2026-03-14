# The k-th Lexicographical String of All Happy Strings of Length n (Medium)

**Problem ID:** 1415  
**Date:** 2026-03-14  
**Link:** https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/

## Approach

To solve the problem of finding the k-th lexicographical happy string of length n, we can use a backtracking approach to generate all valid happy strings. Here's a concise breakdown of the approach:

### Main Idea:
1. **Definition of Happy String**: A happy string consists of the characters 'a', 'b', and 'c', and must not have consecutive identical characters. 
2. **Backtracking**: We will recursively build strings of length n by appending characters while ensuring the happy string condition is maintained.
3. **Lexicographical Order**: By always trying to append 'a', then 'b', and finally 'c', we naturally generate the strings in lexicographical order.

### Steps:
1. **Recursive Function**: Create a recursive function that takes the current string and its length. If the length equals n, add the string to a list of happy strings.
2. **Character Selection**: For each character in the set ('a', 'b', 'c'), check if it is different from the last character appended to ensure the happy string condition. If valid, append the character and call the function recursively.
3. **Termination**: Once a string of length n is formed, backtrack by removing the last character and trying the next character.
4. **Early Exit**: If at any point the number of happy strings generated reaches k, we can stop further generation since we only need the k-th string.

### Data Structures:
- **List**: To store valid happy strings as they are generated.
- **String**: To build the current happy string during recursion.

### Complexity:
- **Time Complexity**: The time complexity is approximately O(3^n) in the worst case due to the branching factor of 3 (each character can be 'a', 'b', or 'c'). However, due to constraints (n ≤ 10), this is manageable.
- **Space Complexity**: O(n) for the recursion stack and O(m) for storing valid happy strings, where m is the number of happy strings generated.

### Final Output:
After generating the happy strings, if the list contains at least k strings, return the (k-1)th string (0-indexed). If there are fewer than k strings, return an empty string.

This approach efficiently generates the required happy strings and retrieves the k-th one while adhering to the constraints provided.
