# Fruits Into Baskets III - Problem #3478

## Problem Statement
You are given two arrays of integers, `fruits` and `baskets`, each of length `n`, where `fruits[i]` represents the quantity of the `i`th type of fruit, and `baskets[j]` represents the capacity of the `j`th basket.

From left to right, place the fruits according to these rules:

- Each fruit type must be placed in the leftmost available basket with a capacity greater than or equal to the quantity of that fruit type.
- Each basket can hold only one type of fruit.
- If a fruit type cannot be placed in any basket, it remains unplaced.
- You can **skip at most one fruit type** during placement.

Return the number of fruit types that remain unplaced after all possible allocations are made.

## Examples
```
Input: fruits = [4,2,5], baskets = [3,5,4]
Output: 1
Explanation:
- fruits[0] = 4 is placed in baskets[1] = 5.
- fruits[1] = 2 is placed in baskets[0] = 3.
- fruits[2] = 5 cannot be placed in baskets[2] = 4 (insufficient capacity).
Even with skipping, we still have 1 unplaced fruit, so we return 1.

Input: fruits = [3,6,1], baskets = [6,4,7]
Output: 0
Explanation:
- fruits[0] = 3 is placed in baskets[0] = 6.
- fruits[1] = 6 can be skipped.
- fruits[2] = 1 is placed in baskets[1] = 4.
Since we can skip one fruit and place the rest, we return 0.
```

## Approach
**Key Insight**: This is a greedy allocation problem with the ability to skip at most one fruit type. We need to find the optimal placement that minimizes unplaced fruits.

**Algorithm**:
1. Try placing all fruits without skipping any.
2. If that doesn't work, try skipping each fruit type one by one and find the best result.
3. For each attempt, use the greedy approach: place each fruit in the leftmost available basket with sufficient capacity.
4. Return the minimum number of unplaced fruits found.

**Why this works**:
- We can skip at most one fruit type, so we need to try all possibilities
- Greedy placement ensures optimal use of available baskets
- We find the best outcome among all possible skip combinations

## Complexity Analysis
- **Time Complexity**: O(n²) - For each skip possibility, we do O(n²) work
- **Space Complexity**: O(n) - To track which baskets are used

## Key Insights
- This is an extension of the previous problem with skip logic
- We need to try all possible skip combinations to find the optimal solution
- The greedy placement strategy remains the same for each attempt

## Alternative Approaches
1. **Brute Force**: Try all possible skip combinations - O(n!) time
2. **Dynamic Programming**: Can be used but overkill for this problem
3. **Backtracking**: Can be used to find optimal placement

## Solutions in Different Languages

### Java
```java
// See solution.java
class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int minUnplaced = Integer.MAX_VALUE;
        
        // Try placing all fruits without skipping
        minUnplaced = Math.min(minUnplaced, placeFruits(fruits, baskets, -1));
        
        // Try skipping each fruit type
        for (int skipIndex = 0; skipIndex < fruits.length; skipIndex++) {
            minUnplaced = Math.min(minUnplaced, placeFruits(fruits, baskets, skipIndex));
        }
        
        return minUnplaced;
    }
    
    private int placeFruits(int[] fruits, int[] baskets, int skipIndex) {
        boolean[] used = new boolean[baskets.length];
        int unplaced = 0;
        
        for (int i = 0; i < fruits.length; i++) {
            if (i == skipIndex) continue; // Skip this fruit
            
            boolean placed = false;
            
            // Find the leftmost available basket with sufficient capacity
            for (int j = 0; j < baskets.length; j++) {
                if (!used[j] && baskets[j] >= fruits[i]) {
                    used[j] = true;  // Mark basket as used
                    placed = true;
                    break;
                }
            }
            
            if (!placed) {
                unplaced++;
            }
        }
        
        return unplaced;
    }
}
```

### JavaScript
```javascript
// See solution.js
/**
 * @param {number[]} fruits
 * @param {number[]} baskets
 * @return {number}
 */
var numOfUnplacedFruits = function(fruits, baskets) {
    let minUnplaced = Infinity;
    
    // Try placing all fruits without skipping
    minUnplaced = Math.min(minUnplaced, placeFruits(fruits, baskets, -1));
    
    // Try skipping each fruit type
    for (let skipIndex = 0; skipIndex < fruits.length; skipIndex++) {
        minUnplaced = Math.min(minUnplaced, placeFruits(fruits, baskets, skipIndex));
    }
    
    return minUnplaced;
};

function placeFruits(fruits, baskets, skipIndex) {
    const used = new Array(baskets.length).fill(false);
    let unplaced = 0;
    
    for (let i = 0; i < fruits.length; i++) {
        if (i === skipIndex) continue; // Skip this fruit
        
        let placed = false;
        
        // Find the leftmost available basket with sufficient capacity
        for (let j = 0; j < baskets.length; j++) {
            if (!used[j] && baskets[j] >= fruits[i]) {
                used[j] = true;  // Mark basket as used
                placed = true;
                break;
            }
        }
        
        if (!placed) {
            unplaced++;
        }
    }
    
    return unplaced;
}
```

### Python
```python
# See solution.py
from typing import List

class Solution:
    def numOfUnplacedFruits(self, fruits: List[int], baskets: List[int]) -> int:
        min_unplaced = float('inf')
        
        # Try placing all fruits without skipping
        min_unplaced = min(min_unplaced, self.place_fruits(fruits, baskets, -1))
        
        # Try skipping each fruit type
        for skip_index in range(len(fruits)):
            min_unplaced = min(min_unplaced, self.place_fruits(fruits, baskets, skip_index))
        
        return min_unplaced
    
    def place_fruits(self, fruits: List[int], baskets: List[int], skip_index: int) -> int:
        used = [False] * len(baskets)
        unplaced = 0
        
        for i in range(len(fruits)):
            if i == skip_index:
                continue  # Skip this fruit
            
            placed = False
            
            # Find the leftmost available basket with sufficient capacity
            for j in range(len(baskets)):
                if not used[j] and baskets[j] >= fruits[i]:
                    used[j] = True  # Mark basket as used
                    placed = True
                    break
            
            if not placed:
                unplaced += 1
        
        return unplaced
```

## Test Cases
```
Test Case 1: fruits = [4,2,5], baskets = [3,5,4] → 1
Test Case 2: fruits = [3,6,1], baskets = [6,4,7] → 0
Test Case 3: fruits = [1,1,1], baskets = [1,1,1] → 0
Test Case 4: fruits = [5,5,5], baskets = [3,3,3] → 2
Test Case 5: fruits = [2,3,4], baskets = [1,2,3] → 1
```

## Edge Cases
- All fruits can be placed without skipping (return 0)
- No fruits can be placed even with skipping (return n-1)
- Single fruit and single basket
- Large arrays with many different fruit types
- Cases where skipping one fruit makes all others placeable

## Related Problems
- Fruits Into Baskets II (without skip)
- Assignment Problem
- Greedy Algorithms
- Resource Allocation with Constraints 