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
**Key Insight**: To make both baskets equal, we need to balance the fruits between them. The key optimization is using the minimum value in both baskets to potentially reduce swap costs.

**Algorithm**:
1. Count the frequency of each fruit in both baskets and find the minimum value.
2. For each fruit type, check if the total count is odd (impossible to split equally).
3. Calculate excess fruits for each basket (fruits that need to be moved out).
4. Sort one list in ascending order and the other in descending order for optimal matching.
5. Calculate the minimum cost considering both direct swaps and using the minimum value as an intermediary.

**Why this works**:
- We need to balance the fruits between baskets
- The minimum cost is achieved by matching optimally
- Using the minimum value as an intermediary can sometimes reduce costs (2 * minVal vs direct swap)
- Sorting in opposite directions ensures optimal pairing

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
        int n = basket1.length;

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        int minVal = Integer.MAX_VALUE; 

        for(int i = 0; i < n; i++){
            map1.put(basket1[i], map1.getOrDefault(basket1[i], 0) + 1);
            map2.put(basket2[i], map2.getOrDefault(basket2[i], 0) + 1);
            minVal = Math.min(minVal, basket1[i]);
            minVal = Math.min(minVal, basket2[i]);
        }

        List<Integer> swapList1 = new ArrayList<>();
        for(int key: map1.keySet()){
            int c1 = map1.get(key);
            int c2 = map2.getOrDefault(key, 0);
            if((c1 + c2) % 2 == 1) return -1; 
            if(c1 > c2){
                int addCnt = (c1 - c2) / 2;
                while(addCnt-- > 0){
                    swapList1.add(key);
                }
            }
        }

        List<Integer> swapList2 = new ArrayList<>();
        for(int key: map2.keySet()){
            int c1 = map1.getOrDefault(key, 0);
            int c2 = map2.get(key);
            if((c1 + c2) % 2 == 1) return -1;  
            if(c2 > c1){
                int addCnt = (c2 - c1) / 2;
                while(addCnt-- > 0){
                    swapList2.add(key);
                }
            }
        }

        Collections.sort(swapList1);
        Collections.sort(swapList2, (a, b) -> b - a);

        long res = 0;
        for(int i = 0; i < swapList1.size(); i++){
            res += Math.min(2 * minVal, 
                            Math.min(swapList1.get(i), swapList2.get(i))
                           );
        }

        return res;
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

### Python
```python
# See solution.py
from collections import defaultdict
from typing import List

class Solution:
    def minCost(self, basket1: List[int], basket2: List[int]) -> int:
        n = len(basket1)
        
        map1 = defaultdict(int)
        map2 = defaultdict(int)
        min_val = float('inf')
        
        for i in range(n):
            map1[basket1[i]] += 1
            map2[basket2[i]] += 1
            min_val = min(min_val, basket1[i])
            min_val = min(min_val, basket2[i])
        
        swap_list1 = []
        for key in map1:
            c1 = map1[key]
            c2 = map2.get(key, 0)
            if (c1 + c2) % 2 == 1:
                return -1
            if c1 > c2:
                add_cnt = (c1 - c2) // 2
                for _ in range(add_cnt):
                    swap_list1.append(key)
        
        swap_list2 = []
        for key in map2:
            c1 = map1.get(key, 0)
            c2 = map2[key]
            if (c1 + c2) % 2 == 1:
                return -1
            if c2 > c1:
                add_cnt = (c2 - c1) // 2
                for _ in range(add_cnt):
                    swap_list2.append(key)
        
        swap_list1.sort()
        swap_list2.sort(reverse=True)
        
        res = 0
        for i in range(len(swap_list1)):
            res += min(2 * min_val, 
                      min(swap_list1[i], swap_list2[i]))
        
        return res
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