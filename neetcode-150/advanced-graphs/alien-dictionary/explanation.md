# Alien Dictionary

## Problem Statement

There is a new alien language that uses the English alphabet. However, the order among the letters is unknown to you.

You are given a list of strings `words` from the dictionary, where the words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

## Examples

**Example 1:**
```
Input: words = ["wrt","wrf","er","ett","rftt"]
Output: "wertf"
```

## Approach

### Method 1: Topological Sort (Recommended)
1. Build graph from word comparisons
2. Compare adjacent words to find character order
3. Use topological sort to find valid ordering
4. Handle cycle detection

**Time Complexity:** O(C) - C total characters
**Space Complexity:** O(1) - At most 26 characters

### Method 2: DFS with Cycle Detection
1. Build adjacency list
2. Use DFS to detect cycles
3. Use three states: unvisited, visiting, visited
4. Return topological order

**Time Complexity:** O(C) - C total characters
**Space Complexity:** O(1) - At most 26 characters

## Algorithm

```
1. Compare adjacent words to build graph:
   a. Find first different character
   b. Add edge from first to second
2. Use topological sort:
   a. Calculate in-degree for each character
   b. Start from characters with in-degree 0
   c. Remove characters and update in-degrees
3. Return result or empty string if cycle
```

## Key Insights

- **Word Comparison**: Compare adjacent words to find order
- **Graph Building**: Build directed graph from comparisons
- **Topological Sort**: Find valid character ordering
- **Cycle Detection**: Return empty string if cycle exists

## Alternative Approaches

1. **DFS**: Use DFS for topological sort
2. **BFS**: Use BFS (Kahn's algorithm)
3. **Iterative**: Use iterative approach

## Edge Cases

- Single word: Return any order
- Empty words: Return empty string
- Invalid input: Return empty string
- Cycle in graph: Return empty string

## Applications

- Language processing
- Graph algorithms
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **Topological Sort**: Most efficient approach
- **Graph Building**: O(C) time complexity
- **Cycle Detection**: O(C) time complexity
- **Memory Efficient**: O(1) space complexity
