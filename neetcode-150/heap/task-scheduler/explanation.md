# Task Scheduler

## Problem Statement

Given a characters array `tasks`, representing the tasks CPU needs to do, where each letter represents a different task. Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.

However, there is a non-negative integer `n` that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least `n` units of time between any two same tasks.

Return the least number of units of times that the CPU will take to finish all the given tasks.

## Examples

**Example 1:**
```
Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B
```

## Approach

### Method 1: Max Heap + Queue (Recommended)
1. Count frequency of each task
2. Use max heap to get most frequent task
3. Use queue to track tasks in cooldown
4. Process tasks in cycles of n+1 time units

**Time Complexity:** O(m) - m is total time units
**Space Complexity:** O(1) - At most 26 tasks

### Method 2: Mathematical Formula
1. Count frequency of each task
2. Find maximum frequency
3. Calculate idle slots
4. Use formula: max(freq) + idle slots

**Time Complexity:** O(n) - n is number of tasks
**Space Complexity:** O(1) - Constant space

## Algorithm

```
1. Count frequency of each task
2. Use max heap to get most frequent task
3. Process tasks in cycles:
   a. Get min(n+1, available tasks) tasks
   b. Decrease frequency of each task
   c. Add tasks back to heap if frequency > 0
   d. Add idle time if needed
4. Return total time
```

## Key Insights

- **Max Heap**: Get most frequent task
- **Cooldown Period**: n units between same tasks
- **Cycle Processing**: Process n+1 tasks per cycle
- **Idle Time**: Add when not enough tasks

## Alternative Approaches

1. **Mathematical**: Use formula for calculation
2. **Greedy**: Always choose most frequent task
3. **Simulation**: Simulate the process

## Edge Cases

- n = 0: No cooldown needed
- Single task: Return task count
- All same tasks: Handle appropriately
- No cooldown: Return task count

## Applications

- CPU scheduling
- Algorithm design patterns
- Interview preparation
- Data structure operations
- System design

## Optimization Opportunities

- **Max Heap**: Most efficient approach
- **Cycle Processing**: Process multiple tasks at once
- **Mathematical**: Use formula for optimization
- **Memory Efficient**: O(1) space complexity
