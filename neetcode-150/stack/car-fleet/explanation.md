# Car Fleet

## Problem Statement

There are `n` cars going to the same destination along a one-lane road. The destination is `target` miles away.

You are given two integer arrays `position` and `speed`, both of length `n`, where `position[i]` is the position of the `ith` car and `speed[i]` is the speed of the `ith` car (in miles per hour).

A car can never pass another car ahead of it, but it can catch up to it and drive bumper to bumper at the same speed. The faster car will slow down to match the slower car's speed. The distance between these two cars is ignored (i.e., they are assumed to have the same position).

A **car fleet** is some non-empty set of cars driving at the same position and same speed. Note that a single car is also a car fleet.

If a car catches up to a car fleet right at the destination point, it will still be considered as one car fleet.

Return the number of car fleets that will arrive at the destination.

## Examples

**Example 1:**
```
Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
Output: 3
Explanation:
The cars starting at 10 and 8 become a fleet, meeting up at 12.
The car starting at 0 doesn't catch up to any other car, so it is a fleet by itself.
The cars starting at 5 and 3 become a fleet, meeting up at 6.
The 3 fleets are the cars at positions (10,8), (0), and (5,3).
```

## Approach

### Method 1: Stack (Recommended)
1. Sort cars by position (closest to target first)
2. Calculate time to reach target for each car
3. Use stack to track fleet leaders
4. If current car reaches target before stack top, it forms new fleet

**Time Complexity:** O(n log n) - Sorting
**Space Complexity:** O(n) - Stack and sorting

### Method 2: Monotonic Stack
1. Process cars from right to left
2. Use stack to maintain fleet leaders
3. More efficient for certain cases

**Time Complexity:** O(n log n) - Sorting
**Space Complexity:** O(n) - Stack

## Algorithm

```
1. Create pairs of (position, speed) and sort by position
2. Calculate time to reach target for each car
3. Use stack to track fleet leaders
4. For each car (right to left):
   a. If stack empty or current time > stack top time:
      - Push current time to stack
5. Return stack size
```

## Key Insights

- **Sorting**: Process cars by position
- **Time Calculation**: time = (target - position) / speed
- **Fleet Formation**: Cars form fleets when they meet
- **Stack Tracking**: Track fleet leaders by arrival time

## Alternative Approaches

1. **Two Pass**: First pass to calculate times, second to count fleets
2. **Greedy**: Process cars in order
3. **Simulation**: Simulate car movements

## Edge Cases

- Single car: Return 1
- All same speed: Depends on positions
- All same position: Return 1
- Cars at target: Handle zero speed

## Applications

- Traffic simulation
- Algorithm design patterns
- Interview preparation
- System design
- Performance analysis

## Optimization Opportunities

- **Stack**: Most efficient approach
- **Sorting**: Essential for correct order
- **Time Calculation**: Simple arithmetic
- **Memory Efficient**: Only store necessary data
