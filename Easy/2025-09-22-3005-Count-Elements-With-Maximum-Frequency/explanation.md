# Count Elements With Maximum Frequency (Easy)

**Problem ID:** 3005  
**Date:** 2025-09-22  
**Link:** https://leetcode.com/problems/count-elements-with-maximum-frequency/

## Approach

To solve the problem of counting elements with maximum frequency in an array, we can follow a systematic approach:

### Main Idea:
The goal is to determine the frequency of each element in the array and then identify the elements that have the highest frequency. Finally, we sum the occurrences of these elements to get the desired result.

### Steps:
1. **Count Frequencies**: Use a hash map (or dictionary) to count the occurrences of each element in the array. The keys will be the elements, and the values will be their corresponding counts.

2. **Determine Maximum Frequency**: Iterate through the hash map to find the maximum frequency among the counted elements.

3. **Sum Frequencies of Maximum Frequency Elements**: Iterate through the hash map again to sum the counts of all elements that have the maximum frequency.

### Data Structures:
- A hash map (or dictionary) is used to store the frequency of each element. This allows for efficient counting and retrieval of frequencies.

### Complexity:
- **Time Complexity**: O(n), where n is the number of elements in the input array. This is because we traverse the array to count frequencies and then traverse the hash map to find the maximum frequency and sum the counts.
- **Space Complexity**: O(k), where k is the number of unique elements in the array. In the worst case, this could be O(n) if all elements are unique.

By following this approach, we can efficiently determine the total frequencies of elements with maximum frequency in the given array.
