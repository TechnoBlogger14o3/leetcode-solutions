# Valid Parentheses

## Problem Statement

Given a string `s` containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.

An input string is valid if:

1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.
3. Every close bracket has a corresponding open bracket of the same type.

## Examples

**Example 1:**
```
Input: s = "()"
Output: true
```

**Example 2:**
```
Input: s = "()[]{}"
Output: true
```

**Example 3:**
```
Input: s = "(]"
Output: false
```

## Approach

### Method 1: Stack (Recommended)
1. Use stack to track opening brackets
2. For each character:
   - If opening bracket: push to stack
   - If closing bracket: check if matches top of stack
3. Return true if stack is empty at end

**Time Complexity:** O(n) - Single pass through string
**Space Complexity:** O(n) - Stack can hold up to n characters

### Method 2: Counter Approach
1. Use counters for each bracket type
2. Track nesting levels
3. More complex for multiple bracket types

**Time Complexity:** O(n)
**Space Complexity:** O(1) - Only counters

## Algorithm

```
1. Initialize empty stack
2. For each character in s:
   a. If character is opening bracket: push to stack
   b. If character is closing bracket:
      - If stack is empty: return false
      - If top of stack doesn't match: return false
      - Pop from stack
3. Return true if stack is empty
```

## Key Insights

- **Stack LIFO**: Last opened bracket must be first closed
- **Matching Logic**: Use HashMap for bracket pairs
- **Early Exit**: Return false immediately on mismatch
- **Empty Stack**: All brackets must be matched

## Alternative Approaches

1. **Counter Method**: Track counts for each bracket type
2. **Recursive**: Use recursion to validate
3. **Replace Method**: Replace valid pairs iteratively

## Edge Cases

- Empty string: Valid (no brackets)
- Single bracket: Invalid
- Only opening brackets: Invalid
- Only closing brackets: Invalid
- Mixed valid/invalid: Check carefully

## Applications

- Code parsing
- Expression evaluation
- Syntax checking
- Algorithm design patterns
- Interview preparation

## Optimization Opportunities

- **Stack**: Most efficient approach
- **HashMap Lookup**: O(1) bracket matching
- **Early Exit**: Stop on first mismatch
- **Memory Efficient**: Only store unmatched brackets
