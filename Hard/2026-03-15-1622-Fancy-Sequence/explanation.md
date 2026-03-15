# Fancy Sequence (Hard)

**Problem ID:** 1622  
**Date:** 2026-03-15  
**Link:** https://leetcode.com/problems/fancy-sequence/

## Approach

To solve the "Fancy Sequence" problem, we need to efficiently manage a sequence of integers while supporting operations that modify the entire sequence. The main challenge is to handle the operations `addAll` and `multAll` without directly applying them to every element in the sequence, as this could lead to inefficient time complexity.

### Main Idea:
The key idea is to maintain the sequence in a way that allows us to apply the effects of `addAll` and `multAll` operations in a lazy manner. Instead of updating all elements immediately, we can track the cumulative effects of these operations using two variables: `add` for the total increment and `mult` for the total multiplier. 

### Data Structures:
1. **List/Array**: To store the actual values of the sequence.
2. **Two integers**: 
   - `add`: This keeps track of the total amount added to each element since the last multiplication.
   - `mult`: This keeps track of the total multiplier applied since the last multiplication.

### Operations:
1. **append(val)**: When appending a new value, we adjust it based on the current `add` and `mult`. The value is stored as `(val - add) / mult` to account for previous operations.
  
2. **addAll(inc)**: Instead of updating all elements, we simply increment `add` by `inc`. This means that all future values will reflect this addition when retrieved.

3. **multAll(m)**: Similar to `addAll`, instead of updating all elements, we multiply the current `mult` by `m` and adjust `add` accordingly. Specifically, we update `add` to account for the previous additions scaled by `m`.

4. **getIndex(idx)**: To retrieve the value at a specific index, we first check if the index is valid. If valid, we compute the effective value using the stored value and apply the cumulative effects of `add` and `mult` to get the current value.

### Complexity:
- **Time Complexity**: Each operation (`append`, `addAll`, `multAll`, `getIndex`) runs in O(1) time, making the overall complexity O(1) per operation.
- **Space Complexity**: The space complexity is O(n) for storing the sequence, where n is the number of elements appended.

This approach ensures that we can handle up to 100,000 operations efficiently while maintaining the integrity of the sequence through lazy updates.
