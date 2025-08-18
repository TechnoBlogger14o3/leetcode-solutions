# 24 Game

## Problem Description
You have 4 cards, each containing a number from 1 to 9. You need to arrange them in a mathematical expression using the operators +, -, *, and / (division) such that the result equals 24. You are allowed to use parentheses to change the order of operations.

Each card must be used exactly once, and division is real division (not integer division).

Return true if you can get 24, and false otherwise.

## Approach
This is a backtracking problem that requires trying all possible combinations of:
1. **Card orderings** (which cards to use first)
2. **Operations** (+, -, *, /)
3. **Parentheses placement** (implicit in the order of operations)

The key insight is that we can systematically try all combinations by:
- Selecting pairs of numbers
- Applying all possible operations to create intermediate results
- Recursively solving the smaller subproblem
- Checking if we can reach 24

## Algorithm
1. **Base Case**: If only one number remains, check if it equals 24
2. **Recursive Case**: 
   - Try all pairs of numbers (i, j)
   - For each pair, try all 6 possible operations:
     - Addition: a + b
     - Subtraction: a - b and b - a
     - Multiplication: a * b
     - Division: a / b and b / a (with division by zero check)
   - Recursively solve the remaining numbers
   - Backtrack by removing the result and trying the next operation

## Key Implementation Details
- **Floating Point Comparison**: Use epsilon (1e-6) for comparing floating point results
- **Division by Zero**: Check if divisor is not zero before division
- **Backtracking**: Remove intermediate results after trying each operation
- **Efficiency**: Try operations in a systematic order to find solutions quickly

## Time Complexity
- **Time**: O(4! × 6³) = O(24 × 216) = O(5,184)
  - 4! ways to order the cards
  - 6 operations for each of the 3 steps
- **Space**: O(4) for the recursion stack

## Example
- Input: [4, 1, 8, 7]
- Process: Try different combinations like (8 - 4) * (7 - 1) = 4 * 6 = 24
- Output: true

## Key Insights
- The problem is about finding the right combination of operations, not just the right order
- Subtraction and division are not commutative, so we need to try both orders
- Backtracking allows us to systematically explore all possibilities
- Early termination when we find a solution improves performance

## Alternative Approaches
- **Brute Force**: Try all possible expressions (less efficient)
- **Memoization**: Cache intermediate results (may not help much due to small input size)
- **Constraint Satisfaction**: Use more sophisticated search algorithms
