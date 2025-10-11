# Word Search

## Problem Statement

Given an `m x n` grid of characters `board` and a string `word`, return `true` if `word` exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

## Examples

**Example 1:**
```
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
```

**Example 2:**
```
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
```

## Approach

### Method 1: Backtracking with DFS (Recommended)
1. Use DFS to explore all possible paths from each cell
2. Use backtracking to mark and unmark visited cells
3. Check all four directions (up, down, left, right)
4. Return true if word is found, false otherwise

**Time Complexity:** O(m*n*4^L) - L is length of word
**Space Complexity:** O(L) - Recursion stack depth

### Method 2: Iterative with Stack
1. Use stack to simulate DFS
2. Store current position and word index
3. Process all possible paths iteratively

**Time Complexity:** O(m*n*4^L) - L is length of word
**Space Complexity:** O(L) - Stack size

## Algorithm

```
1. For each cell on board:
   a. Start DFS from that cell
   b. If current character matches word[index]:
      - Mark cell as visited
      - Recursively check all four directions
      - Unmark cell (backtrack)
      - Return true if word found
2. Return false if no path found
```

## Key Insights

- **DFS**: Explore all possible paths
- **Backtracking**: Mark and unmark visited cells
- **Four Directions**: Check up, down, left, right
- **Early Termination**: Return true when word found

## Alternative Approaches

1. **Iterative**: Use stack for DFS
2. **BFS**: Use queue for BFS
3. **Trie**: Use Trie for multiple word search

## Edge Cases

- Empty board: Return false
- Empty word: Return true
- Single cell: Handle appropriately
- No valid path: Return false

## Applications

- Word games
- Pattern matching
- Search algorithms
- Text processing
- Game development

## Optimization Opportunities

- **DFS**: Most intuitive approach
- **Backtracking**: Efficient state management
- **Early Termination**: Stop when word found
- **Memory Efficient**: O(L) space for recursion
