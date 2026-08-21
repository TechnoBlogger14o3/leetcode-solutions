# Kth Smallest Amount With Single Denomination Combination (Hard)

**Problem ID:** 3116  
**Date:** 2026-08-21  
**Link:** https://leetcode.com/problems/kth-smallest-amount-with-single-denomination-combination/

## Approach

To solve the problem of finding the k-th smallest amount that can be made using an infinite supply of coins of given denominations, we can employ a min-heap (priority queue) approach. Here’s a concise breakdown of the solution strategy:

### Main Idea:
The core idea is to generate amounts using each coin denomination and maintain a sorted order of these amounts. Since we can only use multiples of each coin, we can treat this as a problem of generating a sequence of numbers in a sorted manner.

### Approach:
1. **Min-Heap Initialization**: Start by inserting the smallest multiple of each coin (i.e., the coin itself) into a min-heap. This allows us to always access the smallest current amount efficiently.

2. **Tracking Unique Amounts**: Use a set to keep track of the amounts that have already been added to the heap. This prevents duplicates since different coins can produce the same amount (e.g., both 2 and 5 can produce 10).

3. **Iterative Extraction**: 
   - Extract the smallest amount from the min-heap (this will be the next smallest amount we can form).
   - For each extracted amount, generate the next multiple of the corresponding coin (i.e., if the extracted amount is `x` from coin `c`, push `x + c` back into the heap).
   - Continue this process until we have extracted k amounts.

4. **Return Result**: After extracting k amounts, the k-th extracted amount will be our answer.

### Data Structures:
- **Min-Heap**: To efficiently retrieve the smallest current amount.
- **Set**: To track amounts already seen and prevent duplicates.

### Complexity:
- **Time Complexity**: The overall complexity is O(k log m), where `m` is the number of coin denominations. This is because we perform k extractions from the heap, and each extraction involves log m operations (for maintaining the heap).
- **Space Complexity**: O(m) for the heap and O(n) for the set, where n is the number of unique amounts generated.

This approach efficiently finds the k-th smallest amount while leveraging the properties of heaps and sets to manage the generation of amounts without duplication.
