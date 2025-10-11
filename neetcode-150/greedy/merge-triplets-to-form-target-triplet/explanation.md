# Merge Triplets to Form Target Triplet

## Problem Statement

A triplet is an array of three integers. You are given a 2D integer array `triplets`, where `triplets[i] = [ai, bi, ci]` describes the `ith` triplet. You are also given an integer array `target = [x, y, z]` that describes the triplet you want to obtain.

To obtain the `target`, you may apply the following operation any number of times (possibly zero):

- Choose two indices (0-indexed) `i` and `j` (`i != j`) and set `triplets[i][k] = max(triplets[i][k], triplets[j][k])` for all `k` in `[0, 1, 2]`.

Return `true` if it is possible to obtain the `target` triplet, or `false` otherwise.

## Examples

**Example 1:**
```
Input: triplets = [[2,5,3],[1,8,4],[1,7,5]], target = [2,7,5]
Output: true
Explanation: Perform the following operations:
- Choose the first and third triplets [[2,5,3],[1,8,4],[1,7,5]]. Update the third triplet to be [[2,5,3],[1,8,4],[2,7,5]]
- Choose the third and second triplets [[2,5,3],[1,8,4],[2,7,5]]. Update the second triplet to be [[2,5,3],[2,8,5],[2,7,5]]
- Choose the second and first triplets [[2,5,3],[2,8,5],[2,7,5]]. Update the first triplet to be [[2,7,5],[2,8,5],[2,7,5]]
The target triplet [2,7,5] is now [[2,7,5],[2,8,5],[2,7,5]].
```

## Approach

### Method 1: Greedy Algorithm (Recommended)
1. Check if any triplet has values greater than target
2. Check if we can form target by combining triplets
3. Use greedy approach to find valid triplets
4. Most efficient approach

**Time Complexity:** O(n) - Single pass
**Space Complexity:** O(1) - Three variables

### Method 2: Brute Force
1. Try all possible combinations of triplets
2. Check if any combination can form target
3. Less efficient than greedy approach

**Time Complexity:** O(2^n) - Exponential
**Space Complexity:** O(n) - Recursion stack

## Algorithm

```
1. Initialize found = [false, false, false]
2. For each triplet in triplets:
   a. If any value > target: skip this triplet
   b. For each position i:
      c. If triplet[i] == target[i]: found[i] = true
3. Return found[0] && found[1] && found[2]
```

## Key Insights

- **Greedy Choice**: Only use triplets that don't exceed target values
- **Local Optimum**: Check if each position can be achieved
- **Global Optimum**: Can form the target triplet
- **Space Optimization**: Use only three variables

## Alternative Approaches

1. **Brute Force**: Try all possible combinations
2. **Dynamic Programming**: Use DP to track achievable values
3. **Backtracking**: Use backtracking to explore all possibilities

## Edge Cases

- Empty triplets: Return false
- Single triplet: Check if it matches target
- All triplets exceed target: Return false
- Target is [0,0,0]: Handle appropriately

## Applications

- Greedy algorithms
- Array manipulation
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **Greedy Algorithm**: Most efficient approach
- **Space Optimization**: O(1) space complexity
- **Single Pass**: O(n) time complexity
- **No Extra Space**: Use only three variables
