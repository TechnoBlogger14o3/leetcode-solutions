# Valid Anagram

## Problem Statement

Given two strings `s` and `t`, return `true` if `t` is an anagram of `s`, and `false` otherwise.

An **Anagram** is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

## Examples

**Example 1:**
```
Input: s = "anagram", t = "nagaram"
Output: true
```

**Example 2:**
```
Input: s = "rat", t = "car"
Output: false
```

## Approach

### Method 1: Character Frequency Count (Recommended)
1. Check if both strings have the same length
2. Create frequency maps for both strings
3. Compare the frequency maps
4. If they match, return true; otherwise return false

**Time Complexity:** O(n) - Where n is the length of the strings
**Space Complexity:** O(1) - At most 26 characters for lowercase English letters

### Method 2: Sorting
1. Sort both strings
2. Compare the sorted strings
3. If they are equal, return true; otherwise return false

**Time Complexity:** O(n log n) - Due to sorting
**Space Complexity:** O(1) - If sorting in-place

## Algorithm

```
1. If length of s != length of t:
   - Return false
2. Create frequency map for s
3. Create frequency map for t
4. Compare frequency maps:
   - If equal: return true
   - If not equal: return false
```

## Key Insights

- **Length Check**: Anagrams must have the same length
- **Character Frequency**: Anagrams have identical character frequencies
- **Hash Map Efficiency**: O(1) average lookup time for character counting
- **Early Exit**: Different lengths immediately indicate not anagrams

## Alternative Approaches

1. **Sorting**: Sort both strings and compare - O(n log n) time
2. **Array Counter**: Use array instead of HashMap for lowercase letters - O(1) space
3. **Single Pass**: Count characters in one string, decrement in other

## Edge Cases

- Different lengths: Return false immediately
- Empty strings: Both empty strings are anagrams
- Single character: Same character is anagram
- All same characters: Valid anagram
- Case sensitivity: Problem assumes lowercase

## Applications

- Word games and puzzles
- Data validation
- Cryptography
- Text analysis
- Spell checkers

## Optimization Opportunities

- **Array vs HashMap**: Use array for lowercase English letters (26 elements)
- **Single Counter**: Use one counter array, increment for s, decrement for t
- **Early Exit**: Return false as soon as frequency mismatch is found
- **Memory Efficient**: Sorting approach uses O(1) extra space
