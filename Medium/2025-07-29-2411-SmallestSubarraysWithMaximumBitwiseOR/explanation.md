# Smallest Subarrays With Maximum Bitwise OR - Problem #2411

## Problem Statement
You are given a 0-indexed array nums of non-negative integers.

For each index i, you need to find the length of the smallest subarray starting at i such that the bitwise OR of all elements in the subarray is maximum possible among all subarrays starting at i.

Return an array of the same length as nums where answer[i] is the length of the smallest subarray starting at i with maximum bitwise OR.

## Examples
```
Input: nums = [1,0,2,1,3]
Output: [3,3,2,2,1]
Explanation:
- Starting at index 0, the subarray [1,0,2] has bitwise OR 3, which is the maximum possible.
- Starting at index 1, the subarray [0,2,1] has bitwise OR 3, which is the maximum possible.
- Starting at index 2, the subarray [2,1] has bitwise OR 3, which is the maximum possible.
- Starting at index 3, the subarray [1,3] has bitwise OR 3, which is the maximum possible.
- Starting at index 4, the subarray [3] has bitwise OR 3, which is the maximum possible.

Input: nums = [1,2]
Output: [2,1]
Explanation:
- Starting at index 0, the subarray [1,2] has bitwise OR 3, which is the maximum possible.
- Starting at index 1, the subarray [2] has bitwise OR 2, which is the maximum possible.
```

## Approach
**Two-Pass Sliding Window Approach:**
1. For each starting position i, first calculate the maximum possible OR value that can be achieved
2. Then find the smallest subarray starting at i that achieves this maximum OR value
3. Use the monotonic property of bitwise OR: adding more elements can only increase or maintain the OR value

**Algorithm Steps:**
1. For each starting position i:
   - Calculate maxOR by OR-ing all elements from i to the end
   - Find the smallest subarray starting at i that achieves maxOR
   - Record the length of this subarray

## Complexity Analysis
- **Time Complexity**: O(n²) - For each of n starting positions, we may need to scan up to n elements
- **Space Complexity**: O(1) - Only using a constant amount of extra space for variables

## Key Insights
- The bitwise OR operation is monotonic - adding more elements can only increase or maintain the OR value
- For each starting position, we need to find the shortest subarray that achieves the maximum possible OR
- The maximum OR value for a subarray starting at position i is the OR of all elements from i to the end
- Once we achieve the maximum OR value, we can stop expanding the subarray

## Alternative Approaches
1. **Brute Force**: Check all possible subarrays for each starting position - O(n³)
2. **Prefix OR with Binary Search**: Use prefix OR arrays and binary search for optimization - O(n log n)
3. **Sliding Window with Early Termination**: More optimized version that stops as soon as max OR is achieved

## Solutions in Different Languages

### Java
```java
class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // For each starting position
        for (int i = 0; i < n; i++) {
            int currentOR = 0;
            int minLength = 1;
            
            // Calculate the maximum possible OR value starting from position i
            int maxOR = 0;
            for (int j = i; j < n; j++) {
                maxOR |= nums[j];
            }
            
            // Find the smallest subarray that achieves the maximum OR
            currentOR = 0;
            for (int j = i; j < n; j++) {
                currentOR |= nums[j];
                if (currentOR == maxOR) {
                    minLength = j - i + 1;
                    break;
                }
            }
            
            result[i] = minLength;
        }
        
        return result;
    }
}
```

### JavaScript
```javascript
var smallestSubarrays = function(nums) {
    const n = nums.length;
    const result = new Array(n);
    
    // For each starting position
    for (let i = 0; i < n; i++) {
        let currentOR = 0;
        let minLength = 1;
        
        // Calculate the maximum possible OR value starting from position i
        let maxOR = 0;
        for (let j = i; j < n; j++) {
            maxOR |= nums[j];
        }
        
        // Find the smallest subarray that achieves the maximum OR
        currentOR = 0;
        for (let j = i; j < n; j++) {
            currentOR |= nums[j];
            if (currentOR === maxOR) {
                minLength = j - i + 1;
                break;
            }
        }
        
        result[i] = minLength;
    }
    
    return result;
};
```
