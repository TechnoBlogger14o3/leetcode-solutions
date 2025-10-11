# Contains Duplicate

## Problem Statement

Given an integer array `nums`, return `true` if any value appears at least twice in the array, and return `false` if every element is distinct.

## Examples

**Example 1:**
```
Input: nums = [1,2,3,1]
Output: true
```

**Example 2:**
```
Input: nums = [1,2,3,4]
Output: false
```

**Example 3:**
```
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
```

## Approach

### Method 1: HashSet (Recommended)
1. Use a HashSet to store elements as we iterate through the array
2. For each element, check if it already exists in the set
3. If it exists, return true (duplicate found)
4. If it doesn't exist, add it to the set
5. If we finish iterating without finding duplicates, return false

**Time Complexity:** O(n) - Single pass through the array
**Space Complexity:** O(n) - HashSet can store up to n elements

### Method 2: Sorting
1. Sort the array
2. Check if any adjacent elements are equal
3. If found, return true; otherwise return false

**Time Complexity:** O(n log n) - Due to sorting
**Space Complexity:** O(1) - If sorting in-place

## Algorithm

```
1. Initialize an empty HashSet
2. For each element in nums:
   a. If element exists in HashSet:
      - Return true
   b. Else:
      - Add element to HashSet
3. Return false (no duplicates found)
```

## Key Insights

- **HashSet Advantage**: O(1) average lookup time makes this approach very efficient
- **Early Termination**: We can return as soon as we find the first duplicate
- **Space Trade-off**: Using extra space for better time complexity
- **Alternative Sorting**: If space is constrained, sorting approach uses O(1) extra space

## Alternative Approaches

1. **Brute Force**: Compare every pair of elements - O(n²) time
2. **Sorting**: Sort and check adjacent elements - O(n log n) time, O(1) space
3. **HashSet**: Use set for O(1) lookup - O(n) time, O(n) space

## Edge Cases

- Empty array: Return false
- Single element: Return false
- All elements same: Return true
- Large array: HashSet approach scales better

## Applications

- Data validation (checking for duplicate entries)
- Database constraint checking
- Memory optimization (removing duplicates)
- Algorithm preprocessing (ensuring unique elements)

## Optimization Opportunities

- **Early Exit**: Return immediately when duplicate is found
- **Memory Efficient**: Use sorting if memory is limited
- **Bit Manipulation**: For small integer ranges, could use bit manipulation
- **Streaming**: For very large datasets, could implement streaming solution
