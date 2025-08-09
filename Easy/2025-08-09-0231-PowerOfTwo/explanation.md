# Power of Two - Problem #231

## Problem Statement
Given an integer `n`, return `true` if it is a power of two. Otherwise, return `false`.

A number is a power of two if there exists an integer `k` such that `n = 2^k`.

## Examples
```
Input: n = 1
Output: true // 2^0 = 1

Input: n = 16
Output: true // 2^4 = 16

Input: n = 3
Output: false
```

## Approach
**Key Insight**: For powers of two, the binary representation has exactly one bit set. Using the identity:

- For `n > 0`, `n & (n - 1) == 0` if and only if `n` is a power of two.

This works because subtracting 1 flips the lowest set bit to 0 and turns all lower bits to 1. AND-ing clears the only set bit for powers of two, resulting in 0.

### Algorithm
1. If `n <= 0`, return `false`.
2. Return whether `(n & (n - 1)) == 0`.

## Complexity
- **Time**: O(1)
- **Space**: O(1)

## Alternatives
- Count set bits and check it equals 1.
- Repeatedly divide by 2 and check remainder is always 0 until reaching 1.
- Use language/library utilities (e.g., check `n > 0` and `n == 1 << k` for some `k`).

## Edge Cases
- `n <= 0` → `false`.
- Large integers: ensure bitwise operations match integer size expectations for the language.

## Solutions

### Java
```java
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }
}
```

### JavaScript
```javascript
/**
 * @param {number} n
 * @return {boolean}
 */
var isPowerOfTwo = function(n) {
    if (n <= 0) return false;
    return (n & (n - 1)) === 0;
};
```

### Python
```python
class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        return n > 0 and (n & (n - 1)) == 0
```
