# Minimum Absolute Distance Between Mirror Pairs (Medium)

**Problem ID:** 3761  
**Date:** 2026-04-17  
**Link:** https://leetcode.com/problems/minimum-absolute-distance-between-mirror-pairs/

## Approach

To solve the problem of finding the minimum absolute distance between mirror pairs in the given integer array `nums`, we can follow a systematic approach:

### Main Idea:
The crux of the problem is to identify pairs of indices `(i, j)` such that the reverse of the integer at index `i` equals the integer at index `j`. We need to compute the absolute distance `|i - j|` for all valid mirror pairs and return the minimum distance found.

### Steps to Approach:
1. **Reverse Function**: Create a helper function to reverse the digits of a number. This can be done by converting the number to a string, reversing the string, and converting it back to an integer. This function should also handle leading zeros automatically since converting back to an integer will discard them.

2. **Mapping Reversed Values**: Use a dictionary to map each reversed value to its corresponding index in the original array. This allows us to efficiently check if a reversed number exists in the array and retrieve its index.

3. **Iterate Through the Array**: Loop through each element in the `nums` array:
   - For each element, compute its reversed value.
   - If the reversed value exists in the dictionary, calculate the absolute distance between the current index and the index of the reversed value stored in the dictionary.
   - Keep track of the minimum distance found.

4. **Return Result**: After processing all elements, if a mirror pair was found, return the minimum distance. If no pairs were found, return `-1`.

### Data Structures:
- A dictionary (hash map) is used to store the reversed values and their corresponding indices, allowing for O(1) average time complexity when checking for the existence of a reversed number.

### Complexity:
- **Time Complexity**: O(n), where n is the length of the `nums` array. Each number is processed once to compute its reverse and check against the dictionary.
- **Space Complexity**: O(n) in the worst case, where all reversed values are unique and stored in the dictionary.

By following this structured approach, we can efficiently find the minimum absolute distance between mirror pairs in the array.
