# Successful Pairs of Spells and Potions (Medium)

**Problem ID:** 2300  
**Date:** 2025-10-08  
**Link:** https://leetcode.com/problems/successful-pairs-of-spells-and-potions/

## Approach

To solve the problem of finding successful pairs of spells and potions, we can utilize an efficient approach that leverages sorting and binary search. Here’s a concise breakdown of the solution approach:

### Main Idea:
The goal is to determine how many potions can form a successful pair with each spell based on the condition that the product of their strengths must be at least equal to a given threshold (`success`). Instead of checking each spell against all potions (which would be inefficient), we can preprocess the potions for faster lookups.

### Steps:
1. **Sort the Potions**: First, sort the `potions` array. This allows us to efficiently find the number of potions that can form a successful pair with any given spell using binary search.

2. **Iterate Over Spells**: For each spell, calculate the minimum potion strength required to achieve the desired product:
   \[
   \text{min\_required\_potion} = \lceil \frac{\text{success}}{\text{spell}[i]} \rceil
   \]
   This can be computed using integer arithmetic to avoid floating-point operations.

3. **Binary Search**: Use binary search (e.g., with `bisect_left` in Python) to find the index of the first potion that meets or exceeds this `min_required_potion`. The number of successful potions for that spell can then be calculated as:
   \[
   \text{successful\_count} = \text{length of potions} - \text{index}
   \]

4. **Store Results**: Store the count of successful potions for each spell in an output array.

### Data Structures:
- An array for `potions` to allow sorting and efficient searching.
- An output array to store the results for each spell.

### Complexity:
- Sorting the `potions` array takes \(O(m \log m)\).
- For each spell (total \(n\) spells), performing a binary search on the sorted potions takes \(O(\log m)\). Thus, the total complexity for processing all spells is \(O(n \log m)\).
- The overall time complexity of the solution is \(O(m \log m + n \log m)\), which is efficient given the constraints \(n, m \leq 10^5\).

This approach is efficient and scales well with the input size, making it suitable for the problem's constraints.
