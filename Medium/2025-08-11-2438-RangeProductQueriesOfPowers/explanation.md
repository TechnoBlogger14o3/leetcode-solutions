# Range Product Queries of Powers - Problem #2438

## Problem Statement
Given a positive integer `n`, there exists a 0-indexed array of powers `powers` where `powers[i] = 2^i` for all `0 <= i <= 30`.

You are also given a 0-indexed 2D integer array `queries`, where `queries[i] = [lefti, righti]`. Each query computes the product of all powers[j] for `lefti <= j <= righti`.

Return an array `answer` such that `answer[i]` is the answer to the `ith` query. Since the answer can be very large, return each answer modulo `10^9 + 7`.

## Examples
```
Input: n = 15, queries = [[0,1],[2,2],[0,3]]
Output: [2,4,64]

Explanation:
powers = [1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,131072,262144,524288,1048576,2097152,4194304,8388608,16777216,33554432,67108864,134217728,268435456,536870912,1073741824]
- queries[0] = [0,1]: powers[0] * powers[1] = 1 * 2 = 2
- queries[1] = [2,2]: powers[2] = 4
- queries[0] = [0,3]: powers[0] * powers[1] * powers[2] * powers[3] = 1 * 2 * 4 * 8 = 64
```

## Approach
**Key Insight**: The problem involves computing products of consecutive powers of 2, which can be optimized using:
1. **Prefix Product**: Precompute products of powers from index 0 to each position.
2. **Modular Arithmetic**: Use modulo `10^9 + 7` to handle large numbers.
3. **Binary Exponentiation**: Efficiently compute powers of 2.

**Algorithm**:
1. Generate the powers array: `[2^0, 2^1, 2^2, ..., 2^30]`.
2. Compute prefix products: `prefix[i] = powers[0] * powers[1] * ... * powers[i]`.
3. For each query `[left, right]`:
   - If `left == 0`, answer is `prefix[right]`.
   - Otherwise, answer is `prefix[right] / prefix[left-1]` (using modular multiplicative inverse).

## Complexity
- **Time**: O(n + q) where n is the number of powers (31) and q is the number of queries.
- **Space**: O(n) for storing powers and prefix products.

## Alternative Approaches
1. **Direct Computation**: For each query, multiply powers directly - O(q * (right-left+1)) time.
2. **Segment Tree**: Build a segment tree for range product queries - O(n) build time, O(log n) per query.

## Edge Cases
- `left == right`: Single element product.
- `left == 0`: Product from beginning to right.
- Large numbers: Use modular arithmetic to prevent overflow.

## Solutions

### Java
```java
class Solution {
    private static final int MOD = 1000000007;
    
    public int[] productQueries(int n, int[][] queries) {
        // Generate powers array
        List<Integer> powers = new ArrayList<>();
        for (int i = 0; i < 31; i++) {
            if ((n & (1 << i)) != 0) {
                powers.add(1 << i);
            }
        }
        
        // Compute prefix products
        int[] prefix = new int[powers.size()];
        prefix[0] = powers.get(0);
        for (int i = 1; i < powers.size(); i++) {
            prefix[i] = (int)((long)prefix[i-1] * powers.get(i) % MOD);
        }
        
        // Process queries
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            
            if (left == 0) {
                answer[i] = prefix[right];
            } else {
                answer[i] = (int)((long)prefix[right] * modInverse(prefix[left-1]) % MOD);
            }
        }
        
        return answer;
    }
    
    private int modInverse(int a) {
        return modPow(a, MOD - 2);
    }
    
    private int modPow(int base, int exp) {
        long result = 1;
        long b = base;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * b) % MOD;
            }
            b = (b * b) % MOD;
            exp >>= 1;
        }
        return (int)result;
    }
}
```

### JavaScript
```javascript
/**
 * @param {number} n
 * @param {number[][]} queries
 * @return {number[]}
 */
var productQueries = function(n, queries) {
    const MOD = 1000000007;
    
    // Generate powers array
    const powers = [];
    for (let i = 0; i < 31; i++) {
        if ((n & (1 << i)) !== 0) {
            powers.push(1 << i);
        }
    }
    
    // Compute prefix products
    const prefix = new Array(powers.length);
    prefix[0] = powers[0];
    for (let i = 1; i < powers.length; i++) {
        prefix[i] = (prefix[i-1] * powers[i]) % MOD;
    }
    
    // Process queries
    const answer = new Array(queries.length);
    for (let i = 0; i < queries.length; i++) {
        const [left, right] = queries[i];
        
        if (left === 0) {
            answer[i] = prefix[right];
        } else {
            answer[i] = (prefix[right] * modInverse(prefix[left-1], MOD)) % MOD;
        }
    }
    
    return answer;
};

function modInverse(a, m) {
    return modPow(a, m - 2, m);
}

function modPow(base, exp, m) {
    let result = 1;
    let b = base;
    while (exp > 0) {
        if (exp & 1) {
            result = (result * b) % m;
        }
        b = (b * b) % m;
        exp >>= 1;
    }
    return result;
}
```

### Python
```python
class Solution:
    def productQueries(self, n: int, queries: List[List[int]]) -> List[int]:
        MOD = 10**9 + 7
        
        # Generate powers array
        powers = []
        for i in range(31):
            if n & (1 << i):
                powers.append(1 << i)
        
        # Compute prefix products
        prefix = [1] * len(powers)
        if powers:
            prefix[0] = powers[0]
            for i in range(1, len(powers)):
                prefix[i] = (prefix[i-1] * powers[i]) % MOD
        
        # Process queries
        answer = []
        for left, right in queries:
            if left == 0:
                answer.append(prefix[right])
            else:
                # Use pow with modulo for efficient inverse
                inverse = pow(prefix[left-1], -1, MOD)
                answer.append((prefix[right] * inverse) % MOD)
        
        return answer
```
