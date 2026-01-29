# Minimum Cost to Convert String I (Medium)

**Problem ID:** 2976  
**Date:** 2026-01-29  
**Link:** https://leetcode.com/problems/minimum-cost-to-convert-string-i/

## Approach

To solve the problem of converting the `source` string to the `target` string with the minimum cost, we can adopt the following approach:

### Main Idea:
The key idea is to treat the character transformations as a directed graph where each character can be transformed into another with a specific cost. The goal is to find the minimum cost to transform each character in the `source` to the corresponding character in the `target`. If a transformation is not possible, we should return -1.

### Steps:
1. **Build a Transformation Map:** 
   Create a mapping that allows us to quickly look up the cost of transforming one character to another. This can be represented as a dictionary where each key is a character from `original` and the value is a list of tuples containing the target character from `changed` and the associated cost.

2. **Calculate Costs for Each Character:**
   For each character in the `source` string, check what character it needs to be transformed into (from the `target` string). If the transformation is possible (exists in our mapping), we will record the costs. If not, we immediately return -1.

3. **Use a Minimum Cost Calculation:**
   If multiple paths exist to transform a character (e.g., `a` can be transformed to `b` via `c`), we need to consider the minimum cost for each transformation. This can be done using a priority queue (min-heap) or by simply iterating through the possible transformations to find the least expensive path.

4. **Aggregate Costs:**
   Accumulate the costs for all transformations needed to convert the entire `source` to the `target`.

### Data Structures:
- **Dictionary (HashMap):** To store the transformation costs for quick lookups.
- **List of Tuples:** To hold possible transformations and their costs.
- **Priority Queue (optional):** To efficiently manage and retrieve the minimum cost transformations if needed.

### Complexity:
- **Time Complexity:** O(n + m * k), where `n` is the length of the `source` and `target`, `m` is the number of unique characters in `original`, and `k` is the average number of transformations possible per character.
- **Space Complexity:** O(m * k) for storing the transformation map.

This approach ensures that we efficiently compute the minimum cost for converting the `source` to the `target`, while also handling cases where transformations are impossible.
