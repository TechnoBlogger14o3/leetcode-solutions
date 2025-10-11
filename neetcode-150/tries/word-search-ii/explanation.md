# Word Search II

## Problem Statement

Given an `m x n` `board` of characters and a list of strings `words`, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

## Examples

**Example 1:**
```
Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]
```

**Example 2:**
```
Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []
```

## Approach

### Method 1: Trie + DFS (Recommended)
1. Build Trie from all words
2. Use DFS to explore board starting from each cell
3. Use Trie to guide search and avoid invalid paths
4. Collect found words and avoid duplicates

**Time Complexity:** O(m*n*4^L) - L is max word length
**Space Complexity:** O(W*L) - W words, L average length

### Method 2: DFS for Each Word
1. For each word, use DFS to find it on board
2. Use backtracking to explore all paths
3. Mark visited cells to avoid cycles

**Time Complexity:** O(W*m*n*4^L) - W words
**Space Complexity:** O(L) - Recursion stack

## Algorithm

```
1. Build Trie from all words
2. For each cell on board:
   a. Start DFS from that cell
   b. Use Trie to guide search
   c. If current path forms a word, add to result
   d. Continue DFS for longer words
3. Return all found words
```

## Key Insights

- **Trie**: Efficiently guide search and avoid invalid paths
- **DFS**: Explore all possible paths from each cell
- **Backtracking**: Mark and unmark visited cells
- **Early Termination**: Stop when no valid paths in Trie

## Alternative Approaches

1. **DFS for Each Word**: Search each word individually
2. **BFS**: Use BFS instead of DFS
3. **Optimized DFS**: Use optimizations to reduce search space

## Edge Cases

- Empty board: Return empty list
- Empty words: Return empty list
- Single cell: Handle appropriately
- No valid words: Return empty list

## Applications

- Word games
- Pattern matching
- Search algorithms
- Text processing
- Game development

## Optimization Opportunities

- **Trie**: Most efficient for multiple word search
- **DFS**: Natural approach for board exploration
- **Early Termination**: Stop when no valid paths
- **Memory Efficient**: Use Trie to reduce search space
