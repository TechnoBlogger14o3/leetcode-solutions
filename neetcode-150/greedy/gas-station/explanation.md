# Gas Station

## Problem Statement

There are `n` gas stations along a circular route, where the amount of gas at the `ith` station is `gas[i]`.

You have a car with an unlimited gas tank and it costs `cost[i]` of gas to travel from the `ith` station to its next `(i + 1)th` station. You begin the journey with an empty tank at one of the gas stations.

Given two integer arrays `gas` and `cost`, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return `-1`. If the solution exists, it is guaranteed to be unique.

## Examples

**Example 1:**
```
Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
Output: 3
Explanation:
Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 4. Your tank = 4 - 1 + 5 = 8
Travel to station 0. Your tank = 8 - 2 + 1 = 7
Travel to station 1. Your tank = 7 - 3 + 2 = 6
Travel to station 2. Your tank = 6 - 4 + 3 = 5
Travel to station 3. The cost is 5. Your tank = 5 - 5 = 0
Since your tank >= 0, you can travel around the circuit once.
```

## Approach

### Method 1: Greedy Algorithm (Recommended)
1. Track total gas and total cost
2. If total gas < total cost, return -1
3. Track current tank and starting station
4. If tank becomes negative, reset starting station
5. Most efficient approach

**Time Complexity:** O(n) - Single pass
**Space Complexity:** O(1) - Two variables

### Method 2: Brute Force
1. Try each station as starting point
2. Simulate the journey from each station
3. Less efficient than greedy approach

**Time Complexity:** O(n²) - Nested loops
**Space Complexity:** O(1) - Two variables

## Algorithm

```
1. Initialize totalGas = 0, totalCost = 0, tank = 0, start = 0
2. For i from 0 to n-1:
   a. totalGas += gas[i]
   b. totalCost += cost[i]
   c. tank += gas[i] - cost[i]
   d. If tank < 0:
      e. start = i + 1
      f. tank = 0
3. Return totalGas >= totalCost ? start : -1
```

## Key Insights

- **Greedy Choice**: If tank becomes negative, reset starting station
- **Local Optimum**: Maximum gas at each station
- **Global Optimum**: Can complete the circuit
- **Space Optimization**: Use only two variables

## Alternative Approaches

1. **Brute Force**: Try each station as starting point
2. **Dynamic Programming**: Use DP to track gas at each station
3. **Simulation**: Simulate the journey from each station

## Edge Cases

- Empty arrays: Return -1
- Single station: Return 0 if gas >= cost
- All stations have negative net gas: Return -1
- All stations have positive net gas: Return 0

## Applications

- Greedy algorithms
- Circular array problems
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **Greedy Algorithm**: Most efficient approach
- **Space Optimization**: O(1) space complexity
- **Single Pass**: O(n) time complexity
- **No Extra Space**: Use only two variables
