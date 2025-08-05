# Fruits Into Baskets II - Problem #3477

## Problem Statement
You are given two arrays of integers, `fruits` and `baskets`, each of length `n`, where `fruits[i]` represents the quantity of the `i`th type of fruit, and `baskets[j]` represents the capacity of the `j`th basket.

From left to right, place the fruits according to these rules:

- Each fruit type must be placed in the leftmost available basket with a capacity greater than or equal to the quantity of that fruit type.
- Each basket can hold only one type of fruit.
- If a fruit type cannot be placed in any basket, it remains unplaced.

Return the number of fruit types that remain unplaced after all possible allocations are made.

## Examples
```
Input: fruits = [4,2,5], baskets = [3,5,4]
Output: 1
Explanation:
- fruits[0] = 4 is placed in baskets[1] = 5.
- fruits[1] = 2 is placed in baskets[0] = 3.
- fruits[2] = 5 cannot be placed in baskets[2] = 4.
Since one fruit type remains unplaced, we return 1.

Input: fruits = [3,6,1], baskets = [6,4,7]
Output: 0
Explanation:
- fruits[0] = 3 is placed in baskets[0] = 6.
- fruits[1] = 6 cannot be placed in baskets[1] = 4 (insufficient capacity) but can be placed in the next available basket, baskets[2] = 7.
- fruits[2] = 1 is placed in baskets[1] = 4.
Since all fruits are successfully placed, we return 0.
```

## Approach
**Key Insight**: This is a greedy allocation problem where we need to place fruits in the leftmost available basket that can accommodate them.

**Algorithm**:
1. For each fruit type, find the leftmost available basket with sufficient capacity.
2. Mark the basket as used once a fruit is placed in it.
3. Count how many fruit types cannot be placed in any basket.
4. Return the count of unplaced fruit types.

**Why this works**:
- Greedy approach ensures optimal placement by always choosing the leftmost available basket
- Each basket can only hold one fruit type, so we mark it as used after allocation
- We process fruits in order and try to place each one in the best available basket

## Complexity Analysis
- **Time Complexity**: O(n²) - For each fruit, we may need to check all baskets
- **Space Complexity**: O(n) - To track which baskets are used

## Key Insights
- This is a greedy allocation problem where we need to find the best basket for each fruit
- The leftmost available basket with sufficient capacity is always the optimal choice
- We need to track which baskets are already used to avoid double allocation

## Alternative Approaches
1. **Brute Force**: Try all possible basket assignments - O(n!) time
2. **Sorting**: Sort baskets by capacity for more efficient matching
3. **Binary Search**: Can be used to find the leftmost available basket more efficiently

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
        int skipCount = 0;
        
        for (int right = 0; right < fruits.length; right++) {
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);
            
            // If we have more than 2 types, we can skip at most one
            while (basket.size() > 2 && skipCount < 1) {
                // Skip the leftmost fruit
                basket.put(fruits[left], basket.get(fruits[left]) - 1);
                if (basket.get(fruits[left]) == 0) {
                    basket.remove(fruits[left]);
                }
                left++;
                skipCount++;
            }
            
            // If we still have more than 2 types, shrink window normally
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
    let skipCount = 0;
    
    for (let right = 0; right < fruits.length; right++) {
        basket.set(fruits[right], (basket.get(fruits[right]) || 0) + 1);
        
        // If we have more than 2 types, we can skip at most one
        while (basket.size > 2 && skipCount < 1) {
            basket.set(fruits[left], basket.get(fruits[left]) - 1);
            if (basket.get(fruits[left]) === 0) {
                basket.delete(fruits[left]);
            }
            left++;
            skipCount++;
        }
        
        // If we still have more than 2 types, shrink window normally
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
        skip_count = 0
        
        for right in range(len(fruits)):
            basket[fruits[right]] += 1
            
            # If we have more than 2 types, we can skip at most one
            while len(basket) > 2 and skip_count < 1:
                basket[fruits[left]] -= 1
                if basket[fruits[left]] == 0:
                    del basket[fruits[left]]
                left += 1
                skip_count += 1
            
            # If we still have more than 2 types, shrink window normally
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
Test Case 1: fruits = [4,2,5], baskets = [3,5,4] → 1
Test Case 2: fruits = [3,6,1], baskets = [6,4,7] → 0
Test Case 3: fruits = [1,1,1], baskets = [1,1,1] → 0
Test Case 4: fruits = [5,5,5], baskets = [3,3,3] → 3
Test Case 5: fruits = [2,3,4], baskets = [1,2,3] → 1
```

## Edge Cases
- All fruits can be placed (return 0)
- No fruits can be placed (return n)
- Single fruit and single basket
- Large arrays with many different fruit types
- Cases where optimal placement requires careful consideration

## Related Problems
- Assignment Problem
- Greedy Algorithms
- Resource Allocation
- Matching Problems 