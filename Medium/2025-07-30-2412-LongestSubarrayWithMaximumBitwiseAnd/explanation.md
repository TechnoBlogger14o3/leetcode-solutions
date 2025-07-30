# Longest Subarray with Maximum Bitwise AND - Problem #2412

## Problem Statement
You are given an array `nums` of non-negative integers.

We define the bitwise AND of a subarray as the bitwise AND of all the numbers in the subarray.

For example, the bitwise AND of the subarray `[3,5,2,1]` is equal to `3 & 5 & 2 & 1 = 0`.

A subarray is a contiguous part of an array.

Return the length of the longest subarray with bitwise AND equal to `k`.

Note that subarrays of length 1 have a bitwise AND equal to the single element.

## Examples
```
Input: nums = [1,2,3,3,2,2], k = 2
Output: 3
Explanation: The subarray [3,3,2] has bitwise AND equal to 2.

Input: nums = [1,2,3,4], k = 1
Output: 1
Explanation: The subarray [1] has bitwise AND equal to 1.

Input: nums = [1,2,3,4], k = 0
Output: 4
Explanation: The bitwise AND of the entire array [1,2,3,4] is 0.
```

## Approach
**Key Insight**: The bitwise AND of a subarray can never be greater than the minimum element in that subarray. This is because bitwise AND preserves the minimum value among all elements.

**Algorithm**:
1. For each starting position in the array, compute the bitwise AND of all possible subarrays starting from that position
2. Keep track of the longest subarray where the bitwise AND equals `k`
3. Use a sliding window approach to efficiently compute bitwise AND values

**Why this works**:
- We need to find the longest contiguous sequence where the bitwise AND of all elements equals `k`
- We can use a sliding window approach where we maintain the current bitwise AND value
- When we add a new element, we update the bitwise AND by performing AND with the new element

## Complexity Analysis
- **Time Complexity**: O(n²) - We need to check all possible subarrays
- **Space Complexity**: O(1) - Only using a few variables

## Key Insights
- Bitwise AND of a subarray ≤ minimum element in that subarray
- We need to actually compute the bitwise AND of subarrays, not just check element values
- The longest subarray with bitwise AND = k will be the longest contiguous sequence where the computed bitwise AND equals k

## Alternative Approaches
1. **Brute Force**: Check all possible subarrays - O(n²) time
2. **Optimized Sliding Window**: Can be optimized further but still O(n²) in worst case

## Solutions in Different Languages

### Java
```java
// See solution.java
class Solution {
    public int longestSubarray(int[] nums, int k) {
        int maxLength = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int currentAnd = nums[i];
            if (currentAnd == k) {
                maxLength = Math.max(maxLength, 1);
            }
            
            for (int j = i + 1; j < nums.length; j++) {
                currentAnd &= nums[j];
                if (currentAnd == k) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        
        return maxLength;
    }
}
```

### JavaScript
```javascript
// See solution.js
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var longestSubarray = function(nums, k) {
    let maxLength = 0;
    
    for (let i = 0; i < nums.length; i++) {
        let currentAnd = nums[i];
        if (currentAnd === k) {
            maxLength = Math.max(maxLength, 1);
        }
        
        for (let j = i + 1; j < nums.length; j++) {
            currentAnd &= nums[j];
            if (currentAnd === k) {
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }
    }
    
    return maxLength;
};
```
