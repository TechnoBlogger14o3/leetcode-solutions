# N-Repeated Element in Size 2N Array (Easy)

**Problem ID:** 961  
**Date:** 2026-01-02  
**Link:** https://leetcode.com/problems/n-repeated-element-in-size-2n-array/

## Approach

To solve the problem of finding the N-repeated element in a size 2N array, we can utilize a straightforward approach leveraging a set or a dictionary to track occurrences of elements.

### Approach:

1. **Understanding the Problem**: The array `nums` has a length of `2N` and contains `N + 1` unique elements, with exactly one element appearing `N` times. Our goal is to identify this repeated element.

2. **Data Structure**: We can use a dictionary (or a hash map) to count occurrences of each element as we iterate through the array. This allows us to efficiently check how many times each element appears.

3. **Iterating through the Array**: As we traverse the `nums` array:
   - For each element, we check if it already exists in our dictionary.
   - If it does, we increment its count.
   - If it doesn't, we add it to the dictionary with a count of 1.

4. **Finding the N-Repeated Element**: After populating the dictionary, we can simply iterate through its entries to find the element whose count equals `N`.

### Complexity:
- **Time Complexity**: O(N), where N is the number of unique elements (which is at most 5000). This is because we make a single pass through the array to populate the dictionary and potentially another pass through the dictionary to find the repeated element.
- **Space Complexity**: O(N) in the worst case, as we may store up to `N + 1` unique elements in our dictionary.

This approach is efficient and straightforward, leveraging the properties of hash maps for quick lookups and insertions, making it well-suited for this problem.
