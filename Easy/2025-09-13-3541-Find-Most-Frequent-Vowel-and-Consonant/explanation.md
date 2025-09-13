# Find Most Frequent Vowel and Consonant (Easy)

**Problem ID:** 3541  
**Date:** 2025-09-13  
**Link:** https://leetcode.com/problems/find-most-frequent-vowel-and-consonant/

## Approach

To solve the problem of finding the most frequent vowel and consonant in a given string, we can follow a systematic approach:

### Problem Breakdown
1. **Identify Vowels and Consonants**: Vowels are defined as the characters 'a', 'e', 'i', 'o', 'u'. All other lowercase English letters are considered consonants.

2. **Count Frequencies**: We need to count the frequency of each character in the string. This can be efficiently done using a dictionary (or a list of size 26, indexed by character).

3. **Determine Maximum Frequencies**: After counting the frequencies, we will need to determine the maximum frequency for vowels and consonants separately.

4. **Calculate the Result**: The final result is the sum of the maximum frequencies of vowels and consonants.

### Approach
1. **Data Structures**: 
   - Use a dictionary to store the frequency of each character in the string.
   - Alternatively, a list of size 26 could be used where the index corresponds to the character's position in the alphabet.

2. **Iterate Through the String**: Loop through each character in the string:
   - If the character is a vowel, update its count in the vowel frequency tracker.
   - If it is a consonant, update its count in the consonant frequency tracker.

3. **Find Maximum Frequencies**: After populating the frequency counts:
   - Iterate through the vowel counts to find the maximum frequency.
   - Similarly, iterate through the consonant counts for the maximum frequency.

4. **Edge Cases**: Handle cases where there are no vowels or consonants by initializing their maximum frequencies to zero and checking if they remain unchanged.

### Complexity
- **Time Complexity**: O(n), where n is the length of the string. We only pass through the string a couple of times (once for counting and once for finding maximums).
- **Space Complexity**: O(1) in terms of additional space since the size of the frequency dictionary/list is constant (26 letters).

### Summary
This approach efficiently counts the frequency of vowels and consonants, determines their maximum frequencies, and computes the required sum in linear time. The use of dictionaries or fixed-size arrays ensures that the solution is both time-efficient and space-efficient for the constraints provided.
