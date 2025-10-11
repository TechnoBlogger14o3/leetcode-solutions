# Group Anagrams

## Problem Statement

Given an array of strings `strs`, group the anagrams together. You can return the answer in any order.

An **Anagram** is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

## Examples

**Example 1:**
```
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
```

**Example 2:**
```
Input: strs = [""]
Output: [[""]]
```

**Example 3:**
```
Input: strs = ["a"]
Output: [["a"]]
```

## Approach

### Method 1: Sort Characters (Recommended)
1. For each string, sort its characters to create a key
2. Use HashMap to group strings with the same sorted key
3. Return all groups as a list

**Time Complexity:** O(n * m log m) - Where n is number of strings, m is average length
**Space Complexity:** O(n * m) - For storing all strings

### Method 2: Character Frequency Count
1. For each string, create a frequency count array
2. Use the frequency array as a key for grouping
3. Group strings with identical frequency patterns

**Time Complexity:** O(n * m) - Where n is number of strings, m is average length
**Space Complexity:** O(n * m) - For storing all strings

## Algorithm

```
1. Initialize HashMap with String key and List<String> value
2. For each string in strs:
   a. Sort characters to create key
   b. If key exists in map:
      - Add string to existing group
   c. Else:
      - Create new group with this string
3. Return all values from HashMap as list
```

## Key Insights

- **Sorted Key**: Anagrams have identical sorted character sequences
- **HashMap Grouping**: Efficient way to group related strings
- **Character Sorting**: O(m log m) per string, but simple to implement
- **Frequency Alternative**: More efficient for longer strings

## Alternative Approaches

1. **Character Frequency**: Use frequency arrays as keys - O(n * m) time
2. **Prime Number Mapping**: Map each character to prime number, multiply for key
3. **Bit Manipulation**: For limited character sets, use bit patterns

## Edge Cases

- Empty string: Valid anagram group
- Single character: Forms its own group
- All strings same: One group with all strings
- No anagrams: Each string in separate group
- Case sensitivity: Problem assumes lowercase

## Applications

- Word games and puzzles
- Text analysis and processing
- Data organization
- Spell checking systems
- Cryptography applications

## Optimization Opportunities

- **Frequency Count**: More efficient for longer strings
- **Prime Mapping**: Unique key generation
- **Early Grouping**: Process strings as they come
- **Memory Efficient**: Use StringBuilder for key construction
