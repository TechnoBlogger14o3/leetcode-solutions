# Two Sum

## Problem Statement

Given an array of integers `nums` and an integer `target`, return indices of the two numbers such that they add up to `target`.

You may assume that each input would have **exactly one solution**, and you may not use the same element twice.

You can return the answer in any order.

## Examples

**Example 1:**
```
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
```

**Example 2:**
```
Input: nums = [3,2,4], target = 6
Output: [1,2]
```

**Example 3:**
```
Input: nums = [3,3], target = 6
Output: [0,1]
```

## Approach

### Method 1: HashMap (Recommended)
1. Use a HashMap to store each number and its index
2. For each number, calculate the complement (target - current number)
3. Check if the complement exists in the HashMap
4. If found, return the indices; otherwise add current number to HashMap

**Time Complexity:** O(n) - Single pass through the array
**Space Complexity:** O(n) - HashMap can store up to n elements

### Method 2: Brute Force
1. Check every pair of elements
2. Return indices when their sum equals target

**Time Complexity:** O(n²) - Nested loops
**Space Complexity:** O(1) - No extra space used

## Algorithm

```
1. Initialize empty HashMap
2. For each element at index i:
   a. Calculate complement = target - nums[i]
   b. If complement exists in HashMap:
      - Return [map.get(complement), i]
   c. Else:
      - Add (nums[i], i) to HashMap
3. Return empty array (should not reach here)
```

## Key Insights

- **Complement Strategy**: Instead of finding two numbers that sum to target, find one number and its complement
- **HashMap Lookup**: O(1) average time for checking if complement exists
- **Single Pass**: Can solve in one iteration through the array
- **Index Storage**: Store indices in HashMap for easy retrieval

## Alternative Approaches

1. **Brute Force**: Check all pairs - O(n²) time, O(1) space
2. **Sorting**: Sort and use two pointers - O(n log n) time, O(1) space (but loses original indices)
3. **Two Pass**: First pass to build HashMap, second pass to find solution

## Edge Cases

- Exactly one solution guaranteed
- Cannot use same element twice
- Negative numbers allowed
- Zero can be part of solution
- Large numbers possible

## Applications

- Financial calculations (finding pairs that sum to target amount)
- Data analysis (finding complementary values)
- Algorithm design (pattern for many similar problems)
- Interview preparation (fundamental problem)

## Optimization Opportunities

- **Single Pass**: Most efficient approach
- **Early Exit**: Return immediately when solution found
- **Memory Trade-off**: Use extra space for better time complexity
- **Integer Overflow**: Consider if target could cause overflow
