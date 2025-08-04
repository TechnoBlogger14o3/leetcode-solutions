# Fruit Into Baskets - Problem #904

## Problem Statement
You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array `fruits` where `fruits[i]` is the type of fruit the `i`th tree produces.

You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

- You only have **two baskets**, and each basket can only hold a **single type** of fruit. There is no limit on the amount of fruit each basket can hold.
- Starting from any tree, you must pick **exactly one fruit** from **every** tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
- Once you reach a tree with fruit that cannot fit in your baskets, you must stop.

Given the integer array `fruits`, return the **maximum number of fruits** you can pick.

## Examples
```
Input: fruits = [1,2,1]
Output: 3
Explanation: We can pick from all 3 trees.

Input: fruits = [0,1,2,2]
Output: 3
Explanation: We can pick from trees [1,2,2].
If we started at the first tree, we would only pick from trees [0,1,2].

Input: fruits = [1,2,3,2,2]
Output: 4
Explanation: We can pick from trees [2,3,2,2].
If we started at the first tree, we would only pick from trees [1,2,3,2,2].
```

## Approach
**Key Insight**: This is a classic sliding window problem where we need to find the longest subarray containing at most 2 different types of fruits.

**Algorithm**:
1. Use a sliding window with two pointers (left and right).
2. Use a HashMap to track the count of each fruit type in the current window.
3. Expand the window by moving the right pointer and add fruits to the map.
4. When the window contains more than 2 fruit types, shrink it from the left until it contains at most 2 types.
5. Keep track of the maximum window size found.

**Why this works**:
- We need to find the longest contiguous sequence with at most 2 different fruit types
- Sliding window efficiently maintains the constraint of at most 2 types
- The maximum window size gives us the answer

## Complexity Analysis
- **Time Complexity**: O(n) - Each element is visited at most twice (once by right pointer, once by left pointer)
- **Space Complexity**: O(1) - HashMap will contain at most 2 entries

## Key Insights
- This is essentially finding the longest subarray with at most 2 distinct elements
- Sliding window is the optimal approach for this type of problem
- We can use HashMap to efficiently track fruit type counts

## Alternative Approaches
1. **Brute Force**: Try all possible subarrays - O(n²) time
2. **Two Pointers**: Similar to sliding window but less efficient
3. **Dynamic Programming**: Can be used but overkill for this problem

## Solutions in Different Languages

### Java
```java
// See solution.java
import java.util.*;

class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> basket = new HashMap<>();
        int left = 0;
        int maxFruits = 0;
        
        for (int right = 0; right < fruits.length; right++) {
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);
            
            // Shrink window if we have more than 2 types
            while (basket.size() > 2) {
                basket.put(fruits[left], basket.get(fruits[left]) - 1);
                if (basket.get(fruits[left]) == 0) {
                    basket.remove(fruits[left]);
                }
                left++;
            }
            
            maxFruits = Math.max(maxFruits, right - left + 1);
        }
        
        return maxFruits;
    }
}
```

### JavaScript
```javascript
// See solution.js
/**
 * @param {number[]} fruits
 * @return {number}
 */
var totalFruit = function(fruits) {
    const basket = new Map();
    let left = 0;
    let maxFruits = 0;
    
    for (let right = 0; right < fruits.length; right++) {
        basket.set(fruits[right], (basket.get(fruits[right]) || 0) + 1);
        
        // Shrink window if we have more than 2 types
        while (basket.size > 2) {
            basket.set(fruits[left], basket.get(fruits[left]) - 1);
            if (basket.get(fruits[left]) === 0) {
                basket.delete(fruits[left]);
            }
            left++;
        }
        
        maxFruits = Math.max(maxFruits, right - left + 1);
    }
    
    return maxFruits;
};
```

### Python
```python
# See solution.py
from typing import List
from collections import defaultdict

class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        basket = defaultdict(int)
        left = 0
        max_fruits = 0
        
        for right in range(len(fruits)):
            basket[fruits[right]] += 1
            
            # Shrink window if we have more than 2 types
            while len(basket) > 2:
                basket[fruits[left]] -= 1
                if basket[fruits[left]] == 0:
                    del basket[fruits[left]]
                left += 1
            
            max_fruits = max(max_fruits, right - left + 1)
        
        return max_fruits
```

## Test Cases
```
Test Case 1: [1,2,1] → 3
Test Case 2: [0,1,2,2] → 3
Test Case 3: [1,2,3,2,2] → 4
Test Case 4: [3,3,3,1,2,1,1,2,3,3,4] → 5
Test Case 5: [1,1,1,1] → 4
```

## Edge Cases
- All fruits are the same type
- Only one fruit type
- Empty array
- Large arrays with many different fruit types

## Related Problems
- Longest Substring Without Repeating Characters
- Longest Substring with At Most K Distinct Characters
- Minimum Window Substring 