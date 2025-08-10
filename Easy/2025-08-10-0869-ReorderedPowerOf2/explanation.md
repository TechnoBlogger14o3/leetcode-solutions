# Reordered Power of 2 - Problem #869

## Problem Statement
You are given an integer `n`. We reorder the digits in any order (including the original order) such that the leading digit is not zero.

Return `true` if and only if we can do this so that the resulting number is a power of two.

## Examples
```
Input: n = 1
Output: true

Input: n = 10
Output: false

Input: n = 16
Output: true
```

## Approach
**Key Insight**: Instead of generating all possible permutations (which would be expensive), we can:
1. Convert the input number to a digit frequency map.
2. Generate all powers of 2 up to a reasonable limit.
3. For each power of 2, convert it to a digit frequency map and compare with the input.

**Algorithm**:
1. Convert input `n` to a digit frequency map.
2. Generate powers of 2: 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432, 67108864, 134217728, 268435456, 536870912, 1073741824.
3. For each power of 2, convert to digit frequency map and compare with input.
4. Return true if any match is found.

## Complexity
- **Time**: O(log n) - We check a constant number of powers of 2.
- **Space**: O(log n) - To store digit frequency maps.

## Alternative Approaches
1. **Permutation Generation**: Generate all permutations and check each - O(n! * log n) time, impractical for large numbers.
2. **Sorting**: Sort digits of input and each power of 2, then compare - O(log n * log log n) time.

## Edge Cases
- Single digit numbers (1, 2, 4, 8).
- Numbers with leading zeros (invalid).
- Large numbers (up to 10^9).

## Solutions

### Java
```java
import java.util.*;

class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] count = countDigits(n);
        
        for (int i = 0; i < 31; i++) {
            if (Arrays.equals(count, countDigits(1 << i))) {
                return true;
            }
        }
        return false;
    }
    
    private int[] countDigits(int n) {
        int[] count = new int[10];
        while (n > 0) {
            count[n % 10]++;
            n /= 10;
        }
        return count;
    }
}
```

### JavaScript
```javascript
/**
 * @param {number} n
 * @return {boolean}
 */
var reorderedPowerOf2 = function(n) {
    const count = countDigits(n);
    
    for (let i = 0; i < 31; i++) {
        if (arraysEqual(count, countDigits(1 << i))) {
            return true;
        }
    }
    return false;
};

function countDigits(n) {
    const count = new Array(10).fill(0);
    while (n > 0) {
        count[n % 10]++;
        n = Math.floor(n / 10);
    }
    return count;
}

function arraysEqual(a, b) {
    return a.length === b.length && a.every((val, index) => val === b[index]);
}
```

### Python
```python
from collections import Counter

class Solution:
    def reorderedPowerOf2(self, n: int) -> bool:
        count = Counter(str(n))
        
        for i in range(31):
            if count == Counter(str(1 << i)):
                return True
        return False
```
