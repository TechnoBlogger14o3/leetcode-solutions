# Design Add and Search Words Data Structure

## Problem Statement

Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

- `WordDictionary()` Initializes the object.
- `void addWord(word)` Adds `word` to the data structure, it can be matched later.
- `bool search(word)` Returns `true` if there is any string in the data structure that matches `word` or `false` otherwise. `word` may contain dots `'.'` where dots can be matched with any letter.

## Examples

**Example 1:**
```
Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]

Output
[null,null,null,null,false,true,true,true]
```

## Approach

### Method 1: Trie with DFS (Recommended)
1. Use Trie data structure for efficient word storage
2. For search with dots, use DFS to explore all possible paths
3. Handle dots by checking all children at that level

**Time Complexity:** O(m) for addWord, O(m*26^k) for search with k dots
**Space Complexity:** O(ALPHABET_SIZE * N * M) - N words, M average length

### Method 2: HashMap with Pattern Matching
1. Use HashMap to store words by length
2. For search, check all words of same length
3. Use pattern matching for dots

**Time Complexity:** O(m) for addWord, O(n*m) for search
**Space Complexity:** O(N*M) - N words, M average length

## Algorithm

```
1. TrieNode class:
   - children: array of TrieNode pointers
   - isEnd: boolean flag for end of word

2. AddWord:
   - Traverse trie character by character
   - Create new nodes if needed
   - Mark last node as end of word

3. Search:
   - Use DFS for wildcard matching
   - If character is '.', check all children
   - If character is specific, check that child
   - Return true if any path leads to end of word
```

## Key Insights

- **Trie Structure**: Efficient word storage and prefix matching
- **DFS for Wildcards**: Handle dots by exploring all paths
- **Backtracking**: Use recursion for wildcard matching
- **Pattern Matching**: Dots match any character

## Alternative Approaches

1. **HashMap**: Store words by length and use pattern matching
2. **Regex**: Use regular expressions for pattern matching
3. **Compressed Trie**: Use compressed trie for memory efficiency

## Edge Cases

- Empty string: Handle appropriately
- Single character: Handle appropriately
- All dots: Handle appropriately
- No dots: Handle as regular trie search

## Applications

- Word games
- Autocomplete systems
- Pattern matching
- Search engines
- Text editors

## Optimization Opportunities

- **Trie**: Most efficient for prefix matching
- **DFS**: Handle wildcards efficiently
- **Early Termination**: Stop when no valid paths
- **Memory Efficient**: Only store necessary nodes
