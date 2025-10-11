# Two Sum II - Input Array Is Sorted

## Problem Statement

Given a 1-indexed array of integers `numbers` that is already **sorted in non-decreasing order**, find two numbers such that they add up to a specific `target` number. Let these two numbers be `numbers[index1]` and `numbers[index2]` where `1 <= index1 < index2 <= numbers.length`.

Return the indices of the two numbers, `index1` and `index2`, added by one as an integer array `[index1, index2]` of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.

## Examples

**Example 1:**
```
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
```

**Example 2:**
```
Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
```

## Approach

### Method 1: Two Pointers (Recommended)
1. Use two pointers starting from both ends
2. If sum equals target, return indices
3. If sum is less than target, move left pointer right
4. If sum is greater than target, move right pointer left

**Time Complexity:** O(n) - Single pass through the array
**Space Complexity:** O(1) - Only using two pointers

### Method 2: Binary Search
1. For each element, binary search for complement
2. More complex but still efficient

**Time Complexity:** O(n log n) - Binary search for each element
**Space Complexity:** O(1) - No extra space

## Algorithm

```
1. Initialize left = 0, right = numbers.length - 1
2. While left < right:
   a. Calculate sum = numbers[left] + numbers[right]
   b. If sum == target:
      - Return [left + 1, right + 1]
   c. Else if sum < target:
      - left++
   d. Else:
      - right--
3. Return empty array (should not reach here)
```

## Key Insights

- **Sorted Array**: Leverage sorted property for efficient solution
- **Two Pointers**: Move pointers based on sum comparison
- **1-indexed**: Return indices + 1
- **Constant Space**: No extra data structures needed

## Alternative Approaches

1. **Binary Search**: For each element, search for complement
2. **HashMap**: Similar to Two Sum I (but not optimal for sorted array)
3. **Brute Force**: Check all pairs (not recommended)

## Edge Cases

- Exactly one solution guaranteed
- Cannot use same element twice
- 1-indexed return values
- Sorted array property
- No negative numbers constraint

## Applications

- Search algorithms
- Data analysis
- Financial calculations
- Algorithm design patterns
- Interview preparation

## Optimization Opportunities

- **Early Exit**: Return immediately when solution found
- **Sorted Property**: Leverage sorting for efficient search
- **Memory Efficient**: O(1) space solution
- **Single Pass**: Most efficient approach
