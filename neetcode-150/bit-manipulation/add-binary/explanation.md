# Add Binary

## Problem Statement

Given two binary strings `a` and `b`, return their sum as a binary string.

## Examples

**Example 1:**
```
Input: a = "11", b = "1"
Output: "100"
```

## Approach

### Method 1: Two Pointers (Recommended)
1. Use two pointers from right to left
2. Add digits with carry
3. Handle carry propagation
4. Most efficient approach

**Time Complexity:** O(max(m, n)) - Where m, n are string lengths
**Space Complexity:** O(max(m, n)) - Result string

### Method 2: Built-in Functions
1. Convert to integers, add, convert back
2. Less efficient for large numbers

**Time Complexity:** O(max(m, n)) - Conversion and addition
**Space Complexity:** O(max(m, n)) - Result string

## Algorithm

```
1. Initialize pointers at end of both strings
2. Initialize carry = 0
3. While pointers valid or carry exists:
   a. Sum = digit1 + digit2 + carry
   b. Result digit = sum % 2
   c. Carry = sum / 2
   d. Move pointers left
4. Reverse result and return
```

## Key Insights

- **Two Pointers**: Process from right to left
- **Carry Handling**: Handle carry propagation
- **Local Optimum**: Add digits efficiently
- **Global Optimum**: Complete binary addition

## Alternative Approaches

1. **Built-in Functions**: Use Integer.parseInt()
2. **String Manipulation**: Use string operations
3. **Recursive**: Use recursive approach

## Edge Cases

- Empty strings: Handle appropriately
- Different lengths: Pad with zeros
- All zeros: Return "0"
- Large numbers: Handle efficiently

## Applications

- Binary arithmetic
- String manipulation
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **Two Pointers**: Most efficient approach
- **Space Optimization**: O(max(m, n)) space complexity
- **Linear Time**: O(max(m, n)) time complexity
- **No Extra Space**: Use only necessary space
