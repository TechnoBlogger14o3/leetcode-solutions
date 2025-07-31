# Bitwise ORs of Subarrays - Problem #898

## Problem Statement
We have an array `arr` of non-negative integers.

For every (contiguous) subarray `sub = [arr[i], arr[i + 1], ..., arr[j]]` (with `i <= j`), we take the bitwise OR of all the numbers in `sub`, obtaining a result `arr[i] | arr[i + 1] | ... | arr[j]`.

Return the number of possible results. Results that occur more than once are only counted once in the final answer.

## Examples
```
Input: arr = [0]
Output: 1
Explanation: There is only one possible result: 0.

Input: arr = [1,1,2]
Output: 3
Explanation: The possible subarrays are [1], [1], [2], [1,1], [1,2], [1,1,2].
These yield the results 1, 1, 2, 1, 3, 3.
There are 3 unique values, so the answer is 3.

Input: arr = [1,2,4]
Output: 6
Explanation: The possible results are 1, 2, 3, 4, 6, and 7.
```

## Approach
**Key Insight**: The number of unique bitwise OR results is much smaller than the number of possible subarrays because:
1. Bitwise OR is monotonic - adding more elements can only increase or keep the same value
2. There are only 32 possible bits in an integer, so the number of unique results is bounded

**Algorithm**:
1. For each position in the array, maintain a set of all possible bitwise OR values that can be achieved by subarrays ending at that position
2. For each new element, compute the bitwise OR with all previous results
3. Use a HashSet to track all unique results across all positions

**Why this works**:
- We don't need to check all possible subarrays explicitly
- We can build the results incrementally by extending subarrays from each position
- The monotonicity of bitwise OR means we can efficiently track all possible values

## Complexity Analysis
- **Time Complexity**: O(n * 32) = O(n) - Each element can contribute at most 32 unique bitwise OR values
- **Space Complexity**: O(32) = O(1) - We only need to store at most 32 unique values at any time

## Key Insights
- Bitwise OR is monotonic: a | b ≥ max(a, b)
- The number of unique bitwise OR results is bounded by the number of bits (32 for integers)
- We can efficiently track all possible results by building them incrementally
- Each new element can only create new results by OR-ing with existing results

## Alternative Approaches
1. **Brute Force**: Check all possible subarrays - O(n²) time, but still efficient due to bounded unique results
2. **Dynamic Programming**: Can be viewed as a DP problem where we track all possible OR values at each position

## Solutions in Different Languages

### Java
```java
// See solution.java
class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> current = new HashSet<>();
        
        for (int num : arr) {
            Set<Integer> next = new HashSet<>();
            next.add(num);
            
            for (int val : current) {
                next.add(val | num);
            }
            
            result.addAll(next);
            current = next;
        }
        
        return result.size();
    }
}
```

### JavaScript
```javascript
// See solution.js
/**
 * @param {number[]} arr
 * @return {number}
 */
var subarrayBitwiseORs = function(arr) {
    const result = new Set();
    let current = new Set();
    
    for (const num of arr) {
        const next = new Set();
        next.add(num);
        
        for (const val of current) {
            next.add(val | num);
        }
        
        for (const val of next) {
            result.add(val);
        }
        
        current = next;
    }
    
    return result.size();
};
```

## Test Cases
```
Test Case 1: [0] → 1
Test Case 2: [1,1,2] → 3
Test Case 3: [1,2,4] → 6
Test Case 4: [1,2,3] → 4
Test Case 5: [1,1,1,1] → 1
```

## Edge Cases
- Single element arrays
- Arrays with all same elements
- Arrays with large numbers
- Empty arrays (though not mentioned in constraints)

## Related Problems
- Subarray Sum Equals K
- Bitwise AND of Numbers Range
- Maximum XOR of Two Numbers in an Array 