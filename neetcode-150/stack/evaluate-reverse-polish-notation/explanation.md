# Evaluate Reverse Polish Notation

## Problem Statement

You are given an array of strings `tokens` that represents an arithmetic expression in a **Reverse Polish Notation**.

Evaluate the expression. Return an integer that represents the value of the expression.

**Note that:**
- The valid operators are `'+'`, `'-'`, `'*'`, and `'/'`.
- Each operand may be an integer or another expression.
- The division between two integers always **truncates toward zero**.
- There will not be any division by zero operation.
- The input represents a valid arithmetic expression in a reverse polish notation.
- The answer and all the intermediate calculations can be represented in a **32-bit integer**.

## Examples

**Example 1:**
```
Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
```

**Example 2:**
```
Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
```

## Approach

### Method 1: Stack (Recommended)
1. Use stack to store operands
2. For each token:
   - If number: push to stack
   - If operator: pop two operands, compute, push result
3. Return final result from stack

**Time Complexity:** O(n) - Single pass through tokens
**Space Complexity:** O(n) - Stack can hold all operands

### Method 2: Recursive
1. Process tokens recursively
2. More complex implementation

**Time Complexity:** O(n)
**Space Complexity:** O(n) - Recursion stack

## Algorithm

```
1. Initialize empty stack
2. For each token in tokens:
   a. If token is number: push to stack
   b. If token is operator:
      - Pop second operand
      - Pop first operand
      - Compute result
      - Push result to stack
3. Return top of stack
```

## Key Insights

- **Stack LIFO**: Last two operands are used for operation
- **Operator Order**: Pop second operand first, then first operand
- **Division Truncation**: Use integer division
- **Valid Expression**: Input guaranteed to be valid

## Alternative Approaches

1. **Recursive**: Process tokens recursively
2. **Iterative with Index**: Use index instead of stack
3. **Functional**: Use reduce operations

## Edge Cases

- Single number: Return that number
- All same operator: Handle multiple operations
- Large numbers: Handle 32-bit integer overflow
- Division by zero: Not possible per problem statement

## Applications

- Expression evaluation
- Calculator implementation
- Compiler design
- Algorithm design patterns
- Interview preparation

## Optimization Opportunities

- **Stack**: Most efficient approach
- **Early Validation**: Check token validity
- **Memory Efficient**: Only store necessary operands
- **Error Handling**: Validate input format
