# Rearranging Fruits - Problem #2857

## Problem Statement
You have two fruit baskets and `n` fruits. You are given two 0-indexed integer arrays `basket1` and `basket2` representing the cost of fruit in basket1 and basket2 respectively. You want to make both baskets equal. To do so, you can use the following operation as many times as you want:

- Chose two indices `i` and `j`, and swap the `i`th fruit of basket1 with the `j`th fruit of basket2. The cost of this operation is `min(basket1[i], basket2[j])`.

Return the minimum cost to make both baskets equal. If it is impossible to make both baskets equal, return `-1`.

## Examples
```
Input: basket1 = [4,2,2,2], basket2 = [1,4,1,2]
Output: 1
Explanation: Swap index 1 of basket1 with index 0 of basket2, which costs 1. Now both baskets have equal sum.

Input: basket1 = [2,3,4,1], basket2 = [3,2,5,1]
Output: -1
Explanation: It can be shown that it is impossible to make both baskets equal.
```

## Approach
**Key Insight**: To make both baskets equal, the total sum of both baskets must be equal. If they're not equal, it's impossible. If they are equal, we need to find the minimum cost to rearrange fruits.

**Algorithm**:
1. Check if the sum of both baskets is equal. If not, return -1.
2. Count the frequency of each fruit in both baskets.
3. For each fruit type, if the total count is odd, return -1 (impossible to split equally).
4. Calculate the excess/deficit for each fruit type.
5. Sort the excess and deficit arrays.
6. Use two pointers to match the smallest excess with the smallest deficit, minimizing the cost.

**Why this works**:
- We need to balance the fruits between baskets
- The minimum cost is achieved by matching the smallest excess with the smallest deficit
- Each swap operation costs the minimum of the two fruits being swapped

## Complexity Analysis
- **Time Complexity**: O(n log n) - Due to sorting the excess and deficit arrays
- **Space Complexity**: O(n) - To store frequency counts and excess/deficit arrays

## Key Insights
- Both baskets must have equal total sum
- Each fruit type must have even total count
- Optimal matching is greedy: smallest excess with smallest deficit
- The cost of a swap is the minimum of the two fruits being swapped

## Alternative Approaches
1. **Brute Force**: Try all possible combinations - O(n!) time, impractical
2. **Dynamic Programming**: Can be used but overkill for this problem
3. **Graph-based**: Model as a matching problem, but greedy approach is simpler

## Solutions in Different Languages

### Java
```java
// See solution.java
import java.util.*;

class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        // Check if sums are equal
        long sum1 = 0, sum2 = 0;
        for (int fruit : basket1) sum1 += fruit;
        for (int fruit : basket2) sum2 += fruit;
        
        if (sum1 != sum2) return -1;
        
        // Count frequencies
        Map<Integer, Integer> freq1 = new HashMap<>();
        Map<Integer, Integer> freq2 = new HashMap<>();
        
        for (int fruit : basket1) freq1.put(fruit, freq1.getOrDefault(fruit, 0) + 1);
        for (int fruit : basket2) freq2.put(fruit, freq2.getOrDefault(fruit, 0) + 1);
        
        // Check if each fruit type has even total count
        Set<Integer> allFruits = new HashSet<>();
        allFruits.addAll(freq1.keySet());
        allFruits.addAll(freq2.keySet());
        
        for (int fruit : allFruits) {
            int total = freq1.getOrDefault(fruit, 0) + freq2.getOrDefault(fruit, 0);
            if (total % 2 != 0) return -1;
        }
        
        // Calculate excess/deficit
        List<Integer> excess = new ArrayList<>();
        List<Integer> deficit = new ArrayList<>();
        
        for (int fruit : allFruits) {
            int count1 = freq1.getOrDefault(fruit, 0);
            int count2 = freq2.getOrDefault(fruit, 0);
            int target = (count1 + count2) / 2;
            
            if (count1 > target) {
                for (int i = 0; i < count1 - target; i++) {
                    excess.add(fruit);
                }
            } else if (count2 > target) {
                for (int i = 0; i < count2 - target; i++) {
                    deficit.add(fruit);
                }
            }
        }
        
        // Sort for optimal matching
        Collections.sort(excess);
        Collections.sort(deficit);
        
        long cost = 0;
        for (int i = 0; i < excess.size(); i++) {
            cost += Math.min(excess.get(i), deficit.get(i));
        }
        
        return cost;
    }
}
```

### JavaScript
```javascript
// See solution.js
/**
 * @param {number[]} basket1
 * @param {number[]} basket2
 * @return {number}
 */
var minCost = function(basket1, basket2) {
    // Check if sums are equal
    const sum1 = basket1.reduce((sum, fruit) => sum + fruit, 0);
    const sum2 = basket2.reduce((sum, fruit) => sum + fruit, 0);
    
    if (sum1 !== sum2) return -1;
    
    // Count frequencies
    const freq1 = new Map();
    const freq2 = new Map();
    
    for (const fruit of basket1) {
        freq1.set(fruit, (freq1.get(fruit) || 0) + 1);
    }
    for (const fruit of basket2) {
        freq2.set(fruit, (freq2.get(fruit) || 0) + 1);
    }
    
    // Check if each fruit type has even total count
    const allFruits = new Set([...freq1.keys(), ...freq2.keys()]);
    
    for (const fruit of allFruits) {
        const total = (freq1.get(fruit) || 0) + (freq2.get(fruit) || 0);
        if (total % 2 !== 0) return -1;
    }
    
    // Calculate excess/deficit
    const excess = [];
    const deficit = [];
    
    for (const fruit of allFruits) {
        const count1 = freq1.get(fruit) || 0;
        const count2 = freq2.get(fruit) || 0;
        const target = (count1 + count2) / 2;
        
        if (count1 > target) {
            for (let i = 0; i < count1 - target; i++) {
                excess.push(fruit);
            }
        } else if (count2 > target) {
            for (let i = 0; i < count2 - target; i++) {
                deficit.push(fruit);
            }
        }
    }
    
    // Sort for optimal matching
    excess.sort((a, b) => a - b);
    deficit.sort((a, b) => a - b);
    
    let cost = 0;
    for (let i = 0; i < excess.length; i++) {
        cost += Math.min(excess[i], deficit[i]);
    }
    
    return cost;
};
```

## Test Cases
```
Test Case 1: basket1 = [4,2,2,2], basket2 = [1,4,1,2] → 1
Test Case 2: basket1 = [2,3,4,1], basket2 = [3,2,5,1] → -1
Test Case 3: basket1 = [1,1,1,1], basket2 = [1,1,1,1] → 0
Test Case 4: basket1 = [1,2,3], basket2 = [1,2,3] → 0
```

## Edge Cases
- Baskets already equal (cost = 0)
- Impossible to make equal (return -1)
- Single fruit in each basket
- All fruits are the same
- Large numbers (use long in Java)

## Related Problems
- Two Sum
- Minimum Swaps to Make Sequences Equal
- Partition Equal Subset Sum 