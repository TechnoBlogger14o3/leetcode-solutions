# Word Break II

## Problem Statement

Given a string `s` and a dictionary of strings `wordDict`, add spaces in `s` to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

## Examples

**Example 1:**
```
Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
Output: ["cats and dog","cat sand dog"]
```

## Approach

### Method 1: Dynamic Programming with Backtracking (Recommended)
1. Use DP to check if string can be segmented
2. Use backtracking to generate all possible sentences
3. Combine DP optimization with backtracking
4. Most efficient approach

**Time Complexity:** O(2^n) - Exponential in worst case
**Space Complexity:** O(2^n) - Store all sentences

### Method 2: Pure Backtracking
1. Use backtracking to explore all possibilities
2. Less efficient than DP + backtracking
3. More straightforward implementation

**Time Complexity:** O(2^n) - Exponential in worst case
**Space Complexity:** O(2^n) - Store all sentences

## Algorithm

```
1. Use DP to check if s[i:] can be segmented
2. Use backtracking to generate sentences:
   a. For each possible word ending at position i
   b. Recursively generate sentences for remaining string
   c. Combine current word with all possible sentences
3. Return all generated sentences
```

## Key Insights

- **DP Optimization**: Use DP to avoid impossible paths
- **Backtracking**: Generate all possible sentences
- **Word Dictionary**: Use HashSet for O(1) lookup
- **Sentence Generation**: Combine words to form sentences

## Alternative Approaches

1. **Pure Backtracking**: Use only backtracking
2. **Memoization**: Use memoization to avoid recomputation
3. **Iterative**: Use iterative approach

## Edge Cases

- Empty string: Return empty list
- Empty wordDict: Return empty list
- No solution: Return empty list
- Single word: Return that word

## Applications

- Dynamic programming patterns
- String algorithms
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **DP Optimization**: Avoid impossible paths
- **Memoization**: Cache results
- **Early Termination**: Stop if no solution possible
- **Space Efficient**: Use only necessary space
