# Permutation in String

## Problem Statement

Given two strings `s1` and `s2`, return `true` if `s2` contains a permutation of `s1`.

In other words, one of `s1`'s permutations is the substring of `s2`.

## Examples

**Example 1:**
```
Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
```

**Example 2:**
```
Input: s1 = "ab", s2 = "eidboaoo"
Output: false
```

## Approach

### Method 1: Sliding Window (Recommended)
1. Create frequency map for s1
2. Use sliding window of size s1.length in s2
3. Compare frequency maps
4. Slide window and update frequencies

**Time Complexity:** O(n) - Where n is length of s2
**Space Complexity:** O(1) - At most 26 characters

## Algorithm

```
1. Create frequency map for s1
2. Initialize window with first s1.length characters of s2
3. Compare frequency maps
4. For each position in s2:
   a. Remove leftmost character
   b. Add rightmost character
   c. Compare frequency maps
   d. Return true if match found
5. Return false
```

## Key Insights

- **Sliding Window**: Fixed size window equal to s1.length
- **Frequency Comparison**: Compare character frequencies
- **Window Update**: Remove left, add right character
- **Early Exit**: Return true as soon as match found

## Alternative Approaches

1. **Sorting**: Sort both strings and compare - O(n log n) time
2. **Brute Force**: Check all substrings - O(n²) time
3. **HashSet**: Use set operations

## Edge Cases

- s1 longer than s2: Return false
- Empty strings: Handle appropriately
- Single character: Simple comparison
- All same characters: Check frequency

## Applications

- String matching
- Pattern recognition
- Algorithm design patterns
- Interview preparation
- Text processing

## Optimization Opportunities

- **Sliding Window**: Most efficient approach
- **Frequency Tracking**: O(1) updates
- **Early Exit**: Stop when match found
- **Memory Efficient**: Constant space
