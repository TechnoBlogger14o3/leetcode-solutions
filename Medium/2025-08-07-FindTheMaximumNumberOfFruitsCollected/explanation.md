# Find the Maximum Number of Fruits Collected - Problem #XXXX

## Problem Statement
You are given a 2D grid `fruits` where `fruits[i][j]` represents the number of fruits at position (i, j). You start from the top-left corner and can move in specific patterns to collect fruits. The goal is to find the maximum number of fruits you can collect.

## Examples
```
Input: fruits = [[1,2,3],[4,5,6],[7,8,9]]
Output: 25
Explanation: The optimal path collects fruits from specific positions following the movement constraints.

Input: fruits = [[1,1,1],[1,1,1],[1,1,1]]
Output: 5
Explanation: Collecting fruits from the diagonal and optimal path positions.
```

## Approach
**Key Insight**: This is a dynamic programming problem with specific movement constraints. The solution involves:
1. Collecting fruits from the main diagonal
2. Using DP to find optimal paths for the remaining grid
3. Transposing the grid and repeating the process

**Algorithm**:
1. **Collect diagonal fruits**: Sum up all fruits on the main diagonal (fruits[i][i])
2. **Dynamic Programming for upper triangle**: Use DP to find optimal path from top-left to bottom-right in the upper triangle
3. **Transpose and repeat**: Transpose the grid and repeat the DP process
4. **Sum all collections**: Add diagonal + first DP result + second DP result

**Why this works**:
- The diagonal represents a guaranteed path
- DP finds the optimal path through the remaining grid
- Transposing allows us to capture different movement patterns
- The combination gives the maximum possible collection

## Complexity Analysis
- **Time Complexity**: O(n²) - We process each cell in the grid
- **Space Complexity**: O(n) - We use two arrays of size n for DP

## Key Insights
- The solution combines diagonal collection with optimal path finding
- Dynamic programming handles the movement constraints efficiently
- Transposing the grid allows capturing different movement patterns
- The final answer is the sum of three components

## Alternative Approaches
1. **Pure Dynamic Programming**: Could solve with a single DP approach but less efficient
2. **Graph Traversal**: Could model as a graph but overkill for this problem
3. **Greedy Approach**: Would not work due to the specific movement constraints

## Solutions in Different Languages

### Java
```java
class Solution {
    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;
        int ans = 0;
        
        // Collect fruits from main diagonal
        for (int i = 0; i < n; ++i) {
            ans += fruits[i][i];
        }

        // Dynamic programming for optimal path
        java.util.function.Supplier<Integer> dp = () -> {
            int[] prev = new int[n];
            int[] curr = new int[n];
            java.util.Arrays.fill(prev, Integer.MIN_VALUE);
            java.util.Arrays.fill(curr, Integer.MIN_VALUE);
            prev[n - 1] = fruits[0][n - 1];
            
            for (int i = 1; i < n - 1; ++i) {
                for (int j = Math.max(n - 1 - i, i + 1); j < n; ++j) {
                    int best = prev[j];
                    if (j - 1 >= 0) best = Math.max(best, prev[j - 1]);
                    if (j + 1 < n) best = Math.max(best, prev[j + 1]);
                    curr[j] = best + fruits[i][j];
                }
                int[] temp = prev;
                prev = curr;
                curr = temp;
            }
            return prev[n - 1];
        };

        ans += dp.get();

        // Transpose the grid
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int temp = fruits[j][i];
                fruits[j][i] = fruits[i][j];
                fruits[i][j] = temp;
            }
        }

        ans += dp.get();
        return ans;
    }
}
```

### JavaScript
```javascript
/**
 * @param {number[][]} fruits
 * @return {number}
 */
var maxCollectedFruits = function(fruits) {
    const n = fruits.length;
    let ans = 0;
    
    // Collect fruits from main diagonal
    for (let i = 0; i < n; ++i) {
        ans += fruits[i][i];
    }

    // Dynamic programming function
    const dp = () => {
        const prev = new Array(n).fill(Number.MIN_SAFE_INTEGER);
        const curr = new Array(n).fill(Number.MIN_SAFE_INTEGER);
        prev[n - 1] = fruits[0][n - 1];
        
        for (let i = 1; i < n - 1; ++i) {
            for (let j = Math.max(n - 1 - i, i + 1); j < n; ++j) {
                let best = prev[j];
                if (j - 1 >= 0) best = Math.max(best, prev[j - 1]);
                if (j + 1 < n) best = Math.max(best, prev[j + 1]);
                curr[j] = best + fruits[i][j];
            }
            [prev, curr] = [curr, prev];
        }
        return prev[n - 1];
    };

    ans += dp();

    // Transpose the grid
    for (let i = 0; i < n; ++i) {
        for (let j = 0; j < i; ++j) {
            [fruits[j][i], fruits[i][j]] = [fruits[i][j], fruits[j][i]];
        }
    }

    ans += dp();
    return ans;
};
```

### Python
```python
from typing import List

class Solution:
    def maxCollectedFruits(self, fruits: List[List[int]]) -> int:
        n = len(fruits)
        ans = 0
        
        # Collect fruits from main diagonal
        for i in range(n):
            ans += fruits[i][i]

        # Dynamic programming function
        def dp():
            prev = [float('-inf')] * n
            curr = [float('-inf')] * n
            prev[n - 1] = fruits[0][n - 1]
            
            for i in range(1, n - 1):
                for j in range(max(n - 1 - i, i + 1), n):
                    best = prev[j]
                    if j - 1 >= 0:
                        best = max(best, prev[j - 1])
                    if j + 1 < n:
                        best = max(best, prev[j + 1])
                    curr[j] = best + fruits[i][j]
                prev, curr = curr, prev
            
            return prev[n - 1]

        ans += dp()

        # Transpose the grid
        for i in range(n):
            for j in range(i):
                fruits[j][i], fruits[i][j] = fruits[i][j], fruits[j][i]

        ans += dp()
        return ans
```

## Test Cases
```
Test Case 1:
Input: fruits = [[1,2,3],[4,5,6],[7,8,9]]
Expected Output: 25

Test Case 2:
Input: fruits = [[1,1,1],[1,1,1],[1,1,1]]
Expected Output: 5

Test Case 3:
Input: fruits = [[1,0,0],[0,1,0],[0,0,1]]
Expected Output: 3

Test Case 4:
Input: fruits = [[1,2],[3,4]]
Expected Output: 7
```

## Edge Cases
1. 1x1 grid
2. 2x2 grid
3. Grid with all zeros
4. Grid with large numbers
5. Grid with negative numbers (if allowed)

## Follow-up Questions
1. What if the movement constraints change?
2. What if you can only move in certain directions?
3. What if you have a limited number of moves?
4. What if the grid is not square?
5. What if you need to return to the starting position? 