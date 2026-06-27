# Find the Maximum Number of Elements in Subset (Medium)

**Problem ID:** 3020  
**Date:** 2026-06-27  
**Link:** https://leetcode.com/problems/find-the-maximum-number-of-elements-in-subset/

## Approach

To solve the problem of finding the maximum number of elements in a subset that can be arranged following the specified pattern, we can adopt a systematic approach based on the properties of powers of two.

### Main Idea:
The key observation is that for any number \( x \) in the subset, we can include \( x \) and its powers of two (i.e., \( x, 2x, 4x, \ldots \)) in the subset. The pattern requires that for every \( x \) included, there must be a corresponding \( x \) at the mirrored position in the arrangement. Thus, the problem reduces to counting how many times we can form pairs of \( x \) and \( 2x \) from the input array.

### Approach:
1. **Count Frequencies**: Use a dictionary (or hashmap) to count the occurrences of each number in the input array. This allows us to efficiently track how many of each number we have.

2. **Iterate Over Unique Numbers**: For each unique number in the frequency map, check if it can be paired with its multiples (i.e., \( 2x, 4x, \ldots \)) while ensuring that we do not exceed the available count of each number.

3. **Form Pairs**: For each number \( x \):
   - Start with the count of \( x \).
   - Check if \( 2x \) exists in the map. If it does, pair as many \( x \) with \( 2x \) as possible, reducing the count of \( 2x \) accordingly.
   - Continue this process for \( 4x, 8x, \ldots \) until the multiples exceed the maximum number in the array or are not present in the map.

4. **Calculate Maximum Size**: The total count of elements that can be arranged in the desired pattern is the sum of all valid pairs formed for each unique number.

### Data Structures:
- **HashMap**: To store the frequency of each number, allowing O(1) average time complexity for insertions and lookups.

### Complexity:
- **Time Complexity**: O(n) for counting frequencies and O(m) for processing unique numbers, where \( n \) is the length of the input array and \( m \) is the number of unique numbers. In the worst case, \( m \) can be up to \( n \), leading to an overall complexity of O(n).
- **Space Complexity**: O(n) in the worst case for the frequency map, where all numbers are unique.

This structured approach ensures that we efficiently determine the maximum subset size that adheres to the specified arrangement pattern.
