# Maximize Spanning Tree Stability with Upgrades (Hard)

**Problem ID:** 3600  
**Date:** 2026-03-12  
**Link:** https://leetcode.com/problems/maximize-spanning-tree-stability-with-upgrades/

## Approach

To solve the problem of maximizing the stability of a spanning tree with upgrades, we can adopt a binary search approach combined with a union-find (disjoint-set) data structure. Here’s a concise breakdown of the solution approach:

### Main Idea:
The goal is to maximize the minimum strength of the edges in a spanning tree. We can achieve this by determining the highest possible minimum strength (let's call it `X`) that can be maintained while connecting all nodes with the given edges, considering the upgrades allowed.

### Steps:
1. **Binary Search for Stability**: 
   - Perform a binary search on the possible values of `X`, which ranges from 1 to the maximum strength of the edges in the input. The mid-point of this search will represent a candidate for the minimum strength of the edges in the spanning tree.

2. **Union-Find Structure**:
   - For each candidate strength `X`, use a union-find data structure to determine if it's possible to form a spanning tree that includes all nodes. 
   - Start by including all mandatory edges (where `must_i == 1`) and check if they form a cycle. If they do, return -1 as it’s impossible to form a valid spanning tree.
   - Next, consider optional edges (where `must_i == 0`). Include these edges only if their strength is at least `X` and keep track of how many upgrades are used. If the number of upgrades exceeds `k`, discard that candidate.

3. **Validation**:
   - After processing the edges, check if all nodes are connected (i.e., if the number of unique components is one). If they are connected, it means a spanning tree can be formed with the minimum strength of at least `X`.

4. **Iterate**: 
   - Adjust the binary search bounds based on whether a spanning tree was successfully formed. If it was possible for `X`, try for a higher value; if not, lower the target.

### Data Structures:
- **Union-Find**: To efficiently manage and merge node connections while checking for cycles.
- **Binary Search**: To efficiently explore the range of possible minimum strengths.

### Complexity:
- The time complexity is dominated by the binary search, which runs in `O(log(max_strength))`, and for each candidate strength, we perform union-find operations that take nearly linear time, leading to an overall complexity of `O((E + N) log(max_strength))`, where `E` is the number of edges and `N` is the number of nodes.

This approach efficiently narrows down the maximum possible stability of the spanning tree while adhering to the constraints of mandatory edges and limited upgrades.
