# Find The Duplicate Number

## Problem Statement

Given an array of integers `nums` containing `n + 1` integers where each integer is in the range `[1, n]` inclusive.

There is only **one repeated number** in `nums`, return this repeated number.

You must solve the problem **without** modifying the array `nums` and uses only constant extra space.

## Examples

**Example 1:**
```
Input: nums = [1,3,4,2,2]
Output: 2
```

**Example 2:**
```
Input: nums = [3,1,3,4,2]
Output: 3
```

## Approach

### Method 1: Floyd's Cycle Detection (Two Pointers) (Recommended)
1. Treat array as linked list where nums[i] points to nums[nums[i]]
2. Use slow/fast pointers to find meeting point
3. Reset one pointer to start
4. Move both pointers one step until they meet

**Time Complexity:** O(n) - Linear time
**Space Complexity:** O(1) - Only uses constant extra space

### Method 2: Binary Search
1. Binary search on answer (1 to n)
2. Count numbers <= mid
3. If count > mid, duplicate is in left half

**Time Complexity:** O(n log n) - Binary search + counting
**Space Complexity:** O(1) - Only uses constant extra space

## Algorithm

```
1. Find meeting point using slow/fast pointers
2. Reset one pointer to start
3. Move both pointers one step until they meet
4. Return meeting point (duplicate number)
```

## Key Insights

- **Linked List**: Treat array as linked list
- **Cycle Detection**: Find meeting point first
- **Mathematical Proof**: Distance from start to cycle start
- **Reset Pointer**: Reset one pointer to start

## Alternative Approaches

1. **Binary Search**: Search on answer
2. **Hash Set**: Store seen numbers
3. **Sorting**: Sort and find duplicate

## Edge Cases

- Single duplicate: Handle appropriately
- Multiple duplicates: Only one duplicate exists
- Edge values: Handle 1 and n
- Empty array: Not possible per problem

## Applications

- Cycle detection algorithms
- Algorithm design patterns
- Interview preparation
- Data structure analysis
- System design

## Optimization Opportunities

- **Floyd's Algorithm**: Most efficient approach
- **Two Pointers**: O(1) space complexity
- **Single Pass**: O(n) time complexity
- **Memory Efficient**: No extra data structures
