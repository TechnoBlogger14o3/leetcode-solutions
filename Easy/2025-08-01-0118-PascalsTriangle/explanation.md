# Pascal's Triangle - Problem #118

## Problem Statement
Given an integer `numRows`, return the first `numRows` of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as follows:

## Examples
```
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

Input: numRows = 1
Output: [[1]]
```

## Approach
**Key Insight**: Each row can be generated based on the previous row. The edges are always 1, and inner elements are the sum of the two elements from the previous row.

**Algorithm**:
1. Initialize a list of lists to store the triangle.
2. For each row from 0 to numRows-1:
   - Create a new list for the current row.
   - Set the first and last elements to 1.
   - For inner positions, set value to sum of previous row's adjacent elements.
3. Return the triangle.

**Why this works**:
- Builds the triangle row by row, using the definition of Pascal's triangle.
- Efficiently computes each element without redundant calculations.

## Complexity Analysis
- **Time Complexity**: O(numRows²) - We iterate through each row and each element in the row.
- **Space Complexity**: O(numRows²) - To store the entire triangle.

## Key Insights
- Pascal's triangle rows are binomial coefficients.
- Can be optimized to O(numRows) space by generating in-place or only keeping previous row.
- Useful in combinatorics and probability.

## Alternative Approaches
1. **Mathematical Formula**: Use binomial coefficients C(n, k) = n! / (k!(n-k)!) for each position - but less efficient due to factorial computations.
2. **Single Row Generation**: Generate each row independently without storing previous ones, but still O(n²) time.

## Solutions in Different Languages

### Java
```java
// See solution.java
import java.util.*;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
                }
            }
            triangle.add(row);
        }
        
        return triangle;
    }
}
```

### JavaScript
```javascript
// See solution.js
/**
 * @param {number} numRows
 * @return {number[][]}
 */
var generate = function(numRows) {
    const triangle = [];
    
    for (let i = 0; i < numRows; i++) {
        const row = [];
        for (let j = 0; j <= i; j++) {
            if (j === 0 || j === i) {
                row.push(1);
            } else {
                row.push(triangle[i - 1][j - 1] + triangle[i - 1][j]);
            }
        }
        triangle.push(row);
    }
    
    return triangle;
};
```

## Test Cases
```
Test Case 1: 5 → [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Test Case 2: 1 → [[1]]
Test Case 3: 0 → []
Test Case 4: 3 → [[1],[1,1],[1,2,1]]
```

## Edge Cases
- numRows = 0 (empty triangle)
- numRows = 1 (single row)
- Large numRows (up to 30 as per constraints, to avoid integer overflow)

## Related Problems
- Pascal's Triangle II (generate single row)
- Binomial Coefficient problems
- Triangle path problems 