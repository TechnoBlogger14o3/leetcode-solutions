# Encode and Decode Strings

## Problem Statement

Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

Machine 1 (sender) has the function:
```java
string encode(vector<string> strs) {
  // ... your code
  return encoded_string;
}
```

Machine 2 (receiver) has the function:
```java
vector<string> decode(string s) {
  //... your code
  return strs;
}
```

So Machine 1 does:
```java
string encoded_string = encode(strs);
```

And Machine 2 does:
```java
vector<string> strs2 = decode(encoded_string);
```

`strs2` in Machine 2 should be the same as `strs` in Machine 1.

Implement the `encode` and `decode` methods.

You are not allowed to solve the problem using any serialize methods (such as `eval`).

## Examples

**Example 1:**
```
Input: ["Hello","World"]
Output: ["Hello","World"]
Explanation: Machine 1 encodes ["Hello","World"] to "5#Hello5#World"
Machine 2 decodes "5#Hello5#World" to ["Hello","World"]
```

## Approach

### Method 1: Length + Delimiter (Recommended)
1. **Encode**: For each string, prepend its length followed by a delimiter '#'
2. **Decode**: Parse length, then extract the string of that length
3. Use '#' as delimiter to separate length from content

**Time Complexity:** O(n) - Where n is total characters
**Space Complexity:** O(1) - Excluding input/output

### Method 2: Escape Characters
1. Use special escape sequences for delimiters
2. More complex but handles edge cases better

**Time Complexity:** O(n)
**Space Complexity:** O(1)

## Algorithm

### Encode:
```
1. Initialize result string
2. For each string in input:
   a. Append length + "#" + string to result
3. Return result string
```

### Decode:
```
1. Initialize result list and index i = 0
2. While i < encoded string length:
   a. Find next '#' delimiter
   b. Extract length before '#'
   c. Extract string of that length
   d. Add string to result list
   e. Move index past the string
3. Return result list
```

## Key Insights

- **Length Prefix**: Allows knowing exactly how many characters to read
- **Delimiter**: '#' separates length from content
- **No Ambiguity**: Length-based approach avoids delimiter conflicts
- **Simple Parsing**: Easy to implement and understand

## Alternative Approaches

1. **Escape Sequences**: Use backslash to escape special characters
2. **Base64**: Convert to base64 encoding (overkill for this problem)
3. **JSON**: Use JSON format (not allowed in this problem)

## Edge Cases

- Empty strings: Length is 0, encoded as "0#"
- Strings containing '#': Length prefix handles this correctly
- Single string: Works normally
- Very long strings: Length prefix scales
- Special characters: Length-based approach handles all characters

## Applications

- Network communication
- Data serialization
- File format design
- Protocol design
- Data compression

## Optimization Opportunities

- **StringBuilder**: Use StringBuilder for efficient string concatenation
- **Minimal Overhead**: Length prefix adds minimal overhead
- **No Escaping**: Avoids complex escape sequence handling
- **Simple Parsing**: Easy to implement and debug
