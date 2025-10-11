# Longest Consecutive Sequence

## Problem Statement

Given an unsorted array of integers `nums`, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

## Examples

**Example 1:**
```
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
```

**Example 2:**
```
Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
```

## Approach

### Method 1: HashSet (Recommended)
1. Add all numbers to a HashSet for O(1) lookup
2. For each number, check if it's the start of a sequence (no num-1 exists)
3. If it's a start, count consecutive numbers by incrementing
4. Keep track of maximum length found

**Time Complexity:** O(n) - Each number visited at most twice
**Space Complexity:** O(n) - For HashSet

### Method 2: Sorting
1. Sort the array
2. Count consecutive sequences
3. Return maximum length

**Time Complexity:** O(n log n) - Due to sorting
**Space Complexity:** O(1) - If sorting in-place

## Algorithm

```
1. Add all numbers to HashSet
2. Initialize maxLength = 0
3. For each number in nums:
   a. If (num - 1) not in HashSet:
      - This is start of sequence
      - currentLength = 1
      - While (num + currentLength) in HashSet:
         - currentLength++
      - maxLength = max(maxLength, currentLength)
4. Return maxLength
```

## Key Insights

- **Sequence Start**: Only count sequences from their starting point
- **HashSet Lookup**: O(1) average time for checking existence
- **Avoid Duplicates**: HashSet automatically handles duplicates
- **Two Passes**: Each number visited at most twice (once as start, once in sequence)

## Alternative Approaches

1. **Sorting**: Sort and count consecutive - O(n log n) time
2. **Union Find**: Use disjoint set data structure
3. **Dynamic Programming**: More complex approach

## Edge Cases

- Empty array: Return 0
- Single element: Return 1
- All same elements: Return 1
- No consecutive elements: Return 1
- Negative numbers: Handle correctly

## Applications

- Data analysis
- Sequence detection
- Pattern recognition
- Database queries
- Time series analysis

## Optimization Opportunities

- **Early Exit**: Stop when remaining elements < current max
- **Memory Efficient**: Use bit manipulation for small ranges
- **Parallel Processing**: For very large datasets
- **Caching**: Cache results for repeated queries
