# Maximum Number of Balloons (Easy)

**Problem ID:** 1189  
**Date:** 2026-06-22  
**Link:** https://leetcode.com/problems/maximum-number-of-balloons/

## Approach

To solve the problem of determining the maximum number of instances of the word "balloon" that can be formed from a given string `text`, we can follow a systematic approach:

### Approach:

1. **Character Frequency Count**:
   - First, we need to count the occurrences of each character in the input string `text`. This can be efficiently done using a dictionary (or a frequency array) where the keys (or indices) represent characters and the values represent their counts.

2. **Identify Required Characters**:
   - The word "balloon" consists of the characters: 'b', 'a', 'l', 'o', and 'n'. Specifically, it requires:
     - 1 'b'
     - 1 'a'
     - 2 'l'
     - 2 'o'
     - 1 'n'

3. **Calculate Maximum Instances**:
   - For each required character, calculate how many complete sets of "balloon" can be formed based on the counts from the frequency dictionary. This is done by dividing the count of each required character by its needed frequency:
     - For 'b': `count['b'] // 1`
     - For 'a': `count['a'] // 1`
     - For 'l': `count['l'] // 2`
     - For 'o': `count['o'] // 2`
     - For 'n': `count['n'] // 1`
   - The maximum number of instances of "balloon" that can be formed will be the minimum of these values, as forming one instance requires all these characters in the specified quantities.

### Data Structures:
- A dictionary (or a simple array of size 26 for lowercase letters) is used to store the frequency of characters in the input string.

### Complexity:
- **Time Complexity**: O(n), where n is the length of the input string `text`, since we need to traverse the string once to build the frequency count.
- **Space Complexity**: O(1), since the frequency dictionary will have a constant size (at most 26 entries for lowercase English letters).

This approach ensures that we efficiently calculate the maximum instances of the word "balloon" using basic operations on character counts.
