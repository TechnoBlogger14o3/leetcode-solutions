# Word Ladder

## Problem Statement

A transformation sequence from word `beginWord` to word `endWord` using a dictionary `wordList` is a sequence of words `beginWord -> s1 -> s2 -> ... -> sk` such that:

- Every adjacent pair of words differs by a single letter.
- Every `si` for `1 <= i <= k` is in `wordList`. Note that `beginWord` does not need to be in `wordList`.
- `sk == endWord`

Given two words, `beginWord` and `endWord`, and a dictionary `wordList`, return the number of words in the shortest transformation sequence from `beginWord` to `endWord`, or `0` if no such sequence exists.

## Examples

**Example 1:**
```
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> "cog", which is 5 words long.
```

## Approach

### Method 1: BFS (Recommended)
1. Use BFS to find shortest path
2. Generate all possible one-letter changes
3. Use queue to process level by level
4. Return level count when endWord found

**Time Complexity:** O(M²*N) - M word length, N word count
**Space Complexity:** O(M*N) - Queue and set

### Method 2: Bidirectional BFS
1. Start BFS from both beginWord and endWord
2. Meet in the middle
3. More efficient than single BFS

**Time Complexity:** O(M²*N) - M word length, N word count
**Space Complexity:** O(M*N) - Two queues and sets

## Algorithm

```
1. Add beginWord to queue
2. BFS level by level:
   a. Generate all possible one-letter changes
   b. If change is in wordList: add to next level
   c. If change is endWord: return level count
3. Return 0 if endWord not found
```

## Key Insights

- **BFS**: Find shortest path in unweighted graph
- **One-letter Change**: Generate all possible transformations
- **Level Processing**: Each level represents one transformation
- **Word List**: Use set for O(1) lookup

## Alternative Approaches

1. **Bidirectional BFS**: Start from both ends
2. **DFS**: Less efficient for shortest path
3. **A***: Use heuristic for optimization

## Edge Cases

- endWord not in wordList: Return 0
- beginWord equals endWord: Return 1
- No transformation possible: Return 0
- Single letter words: Handle appropriately

## Applications

- Word games
- Pathfinding algorithms
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **Bidirectional BFS**: Most efficient approach
- **Set Lookup**: O(1) word lookup
- **Level Processing**: Process level by level
- **Memory Efficient**: O(M*N) space complexity
