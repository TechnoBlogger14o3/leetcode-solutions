# Implement Trie (Prefix Tree)

## Problem Statement

A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and search strings in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

- `Trie()` Initializes the trie object.
- `void insert(String word)` Inserts the string `word` into the trie.
- `boolean search(String word)` Returns `true` if the string `word` is in the trie (i.e., was inserted before), and `false` otherwise.
- `boolean startsWith(String prefix)` Returns `true` if there is a previously inserted string `word` that has the prefix `prefix`, and `false` otherwise.

## Examples

**Example 1:**
```
Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]

Output
[null, null, true, false, true, null, true]
```

## Approach

### Method 1: TrieNode Class (Recommended)
1. Create TrieNode class with children array and isEnd flag
2. Implement insert, search, and startsWith methods
3. Use array of size 26 for lowercase English letters

**Time Complexity:** O(m) - Length of word/prefix
**Space Complexity:** O(ALPHABET_SIZE * N * M) - N words, M average length

### Method 2: HashMap Implementation
1. Use HashMap instead of array for children
2. More memory efficient for sparse tries
3. Same time complexity

**Time Complexity:** O(m) - Length of word/prefix
**Space Complexity:** O(ALPHABET_SIZE * N * M) - N words, M average length

## Algorithm

```
1. TrieNode class:
   - children: array of TrieNode pointers
   - isEnd: boolean flag for end of word

2. Insert:
   - Traverse trie character by character
   - Create new nodes if needed
   - Mark last node as end of word

3. Search:
   - Traverse trie character by character
   - Return false if path doesn't exist
   - Return isEnd flag of last node

4. StartsWith:
   - Traverse trie character by character
   - Return false if path doesn't exist
   - Return true if path exists
```

## Key Insights

- **TrieNode**: Each node represents a character
- **Children Array**: Array of size 26 for lowercase letters
- **isEnd Flag**: Marks end of complete words
- **Prefix Matching**: Efficient prefix search

## Alternative Approaches

1. **HashMap**: Use HashMap for children
2. **Compressed Trie**: Compress single-child paths
3. **Ternary Search Tree**: Use ternary search tree

## Edge Cases

- Empty string: Handle appropriately
- Single character: Handle appropriately
- Duplicate words: Handle appropriately
- Non-existent words: Handle appropriately

## Applications

- Autocomplete systems
- Spell checkers
- IP routing tables
- String matching algorithms
- Search engines

## Optimization Opportunities

- **Array**: Most efficient for dense tries
- **HashMap**: More memory efficient for sparse tries
- **Compression**: Reduce memory usage
- **Lazy Loading**: Create nodes only when needed
