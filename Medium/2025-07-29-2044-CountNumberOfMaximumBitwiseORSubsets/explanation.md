# Count Number of Maximum Bitwise OR Subsets - Problem #2044

## Problem Statement
You are given an integer array nums. We call a subset of nums good if its bitwise OR is a maximum value among all possible subsets of nums.

Let size be the number of integers in a good subset.

Return the number of different good subsets of size size.

## Examples
```
Input: nums = [3,1]
Output: 2
Explanation: The maximum possible bitwise OR of a subset is 3. There are 2 subsets with a bitwise OR of 3:
- [3]
- [3,1]

Input: nums = [2,2,2]
Output: 7
Explanation: All non-empty subsets of [2,2,2] have a bitwise OR of 2. There are 2^3 - 1 = 7 total subsets.

Input: nums = [3,2,1,5]
Output: 6
Explanation: The maximum possible bitwise OR of a subset is 7, and the subsets with a bitwise OR of 7 are:
- [3,5]
- [3,1,5]
- [3,2,5]
- [3,2,1,5]
- [1,5]
- [2,1,5]
```

## Approach
**Backtracking with Bitwise OR Tracking:**
1. First, find the maximum possible bitwise OR value among all possible subsets
2. Use backtracking to generate all possible subsets
3. For each subset, calculate its bitwise OR value
4. Count how many subsets achieve the maximum OR value
5. Among those subsets, count how many have the maximum size

**Algorithm Steps:**
1. Calculate the maximum possible OR value by OR-ing all elements
2. Use backtracking to generate all possible subsets
3. For each subset, track its OR value and size
4. Count subsets that achieve maximum OR and have maximum size among those

## Complexity Analysis
- **Time Complexity**: O(2^n) - We generate all possible subsets using backtracking
- **Space Complexity**: O(n) - Recursion stack depth for backtracking

## Key Insights
- The maximum possible OR value is the OR of all elements in the array
- We need to find all subsets that achieve this maximum OR value
- Among those subsets, we count the ones with the maximum size
- Backtracking is efficient for generating all possible subsets
- We can optimize by tracking the maximum size among subsets that achieve the target OR

## Alternative Approaches
1. **Bit Manipulation**: Use bit masks to represent subsets - O(2^n)
2. **Dynamic Programming**: Use DP to track OR values for different subset sizes
3. **Greedy**: Optimize by stopping early when maximum OR is achieved

## Solutions in Different Languages

### Java
```java
class Solution {
    private int maxOR = 0;
    private int maxSize = 0;
    private int count = 0;
    
    public int countMaxOrSubsets(int[] nums) {
        // Calculate the maximum possible OR value
        maxOR = 0;
        for (int num : nums) {
            maxOR |= num;
        }
        
        // Reset counters
        maxSize = 0;
        count = 0;
        
        // Use backtracking to find all subsets
        backtrack(nums, 0, 0, 0);
        
        return count;
    }
    
    private void backtrack(int[] nums, int index, int currentOR, int currentSize) {
        // If we've processed all elements
        if (index == nums.length) {
            // If this subset achieves the maximum OR
            if (currentOR == maxOR) {
                // If this is the first subset with max OR, or same size as current max
                if (currentSize > maxSize) {
                    maxSize = currentSize;
                    count = 1;
                } else if (currentSize == maxSize) {
                    count++;
                }
            }
            return;
        }
        
        // Include the current element
        backtrack(nums, index + 1, currentOR | nums[index], currentSize + 1);
        
        // Exclude the current element
        backtrack(nums, index + 1, currentOR, currentSize);
    }
}
```

### JavaScript
```javascript
var countMaxOrSubsets = function(nums) {
    // Calculate the maximum possible OR value
    let maxOR = 0;
    for (let num of nums) {
        maxOR |= num;
    }
    
    let maxSize = 0;
    let count = 0;
    
    // Use backtracking to find all subsets
    function backtrack(index, currentOR, currentSize) {
        // If we've processed all elements
        if (index === nums.length) {
            // If this subset achieves the maximum OR
            if (currentOR === maxOR) {
                // If this is the first subset with max OR, or same size as current max
                if (currentSize > maxSize) {
                    maxSize = currentSize;
                    count = 1;
                } else if (currentSize === maxSize) {
                    count++;
                }
            }
            return;
        }
        
        // Include the current element
        backtrack(index + 1, currentOR | nums[index], currentSize + 1);
        
        // Exclude the current element
        backtrack(index + 1, currentOR, currentSize);
    }
    
    backtrack(0, 0, 0);
    return count;
};
```
