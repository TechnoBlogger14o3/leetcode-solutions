# Valid Palindrome

## Problem Statement

A phrase is a **palindrome** if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward.

Given a string `s`, return `true` if it is a palindrome, or `false` otherwise.

## Examples

**Example 1:**
```
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
```

**Example 2:**
```
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
```

**Example 3:**
```
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
```

## Approach

### Method 1: Two Pointers (Recommended)
1. Use two pointers starting from both ends
2. Skip non-alphanumeric characters
3. Compare characters (case-insensitive)
4. Move pointers inward until they meet

**Time Complexity:** O(n) - Single pass through the string
**Space Complexity:** O(1) - Only using two pointers

### Method 2: Reverse and Compare
1. Clean the string (remove non-alphanumeric, convert to lowercase)
2. Compare with its reverse

**Time Complexity:** O(n) - Two passes
**Space Complexity:** O(n) - For cleaned string

## Algorithm

```
1. Initialize left = 0, right = s.length - 1
2. While left < right:
   a. Skip non-alphanumeric characters from left
   b. Skip non-alphanumeric characters from right
   c. If characters don't match (case-insensitive):
      - Return false
   d. Move pointers inward
3. Return true
```

## Key Insights

- **Two Pointers**: Efficient O(1) space solution
- **Character Validation**: Use helper functions for alphanumeric check
- **Case Insensitive**: Convert to lowercase before comparison
- **Skip Non-Alphanumeric**: Move pointers past invalid characters

## Alternative Approaches

1. **Reverse String**: Clean and reverse, then compare
2. **Stack**: Push first half, pop and compare with second half
3. **Recursive**: Recursive two-pointer approach

## Edge Cases

- Empty string: Valid palindrome
- Single character: Valid palindrome
- Only non-alphanumeric: Valid palindrome
- Mixed case: Handle case-insensitive comparison
- Special characters: Skip punctuation and spaces

## Applications

- Text processing
- Data validation
- String manipulation
- Algorithm design patterns
- Interview preparation

## Optimization Opportunities

- **Early Exit**: Return false as soon as mismatch found
- **Character Functions**: Use built-in character validation
- **Memory Efficient**: Two-pointer approach uses O(1) space
- **Single Pass**: Most efficient approach
