# Two Sum - Problem #1

## Problem Statement
Given an array of integers `nums` and an integer `target`, return indices of the two numbers such that they add up to `target`.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

## Examples
```
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Input: nums = [3,2,4], target = 6
Output: [1,2]

Input: nums = [3,3], target = 6
Output: [0,1]
```

## Approach
**Hash Map Approach:**
1. Use a HashMap to store each number and its index
2. For each number, calculate the complement (target - current_number)
3. If complement exists in HashMap, we found our pair
4. Otherwise, add current number and its index to HashMap

## Complexity Analysis
- **Time Complexity**: O(n) - Single pass through the array
- **Space Complexity**: O(n) - HashMap to store numbers and indices

## Key Insights
- Using HashMap allows O(1) lookup time for complements
- Single pass solution is more efficient than nested loops
- Trade-off: extra space for better time complexity

## Alternative Approaches
1. **Brute Force**: O(n²) time, O(1) space
2. **Two Pointers**: Requires sorted array, O(n log n) time

## Solutions in Different Languages

### Java
```java
// See solution.java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            
            map.put(nums[i], i);
        }
        
        return new int[] {}; // No solution found
    }
}
```

### JavaScript
```javascript
// See solution.js
var twoSum = function(nums, target) {
    const map = new Map();
    
    for (let i = 0; i < nums.length; i++) {
        const complement = target - nums[i];
        
        if (map.has(complement)) {
            return [map.get(complement), i];
        }
        
        map.set(nums[i], i);
    }
    
    return []; // No solution found
};
```