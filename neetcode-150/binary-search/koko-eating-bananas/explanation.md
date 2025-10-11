# Koko Eating Bananas

## Problem Statement

Koko loves to eat bananas. There are `n` piles of bananas, the `ith` pile has `piles[i]` bananas. The guards have gone and will come back in `h` hours.

Koko can decide her bananas-per-hour eating speed of `k`. Each hour, she chooses some pile of bananas and eats `k` bananas from that pile. If the pile has less than `k` bananas, she eats all of them instead and will not eat from any other pile during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards come back.

Return the minimum integer `k` such that she can eat all the bananas within `h` hours.

## Examples

**Example 1:**
```
Input: piles = [3,6,7,11], h = 8
Output: 4
```

**Example 2:**
```
Input: piles = [30,11,23,4,20], h = 5
Output: 30
```

## Approach

### Method 1: Binary Search on Answer (Recommended)
1. Binary search on possible eating speeds
2. For each speed, check if it's possible to finish in h hours
3. Use binary search to find minimum valid speed
4. Speed range: 1 to max(piles)

**Time Complexity:** O(n * log(max(piles))) - Binary search + validation
**Space Complexity:** O(1) - Only uses constant extra space

### Method 2: Linear Search
1. Try each speed from 1 to max(piles)
2. Check if it's possible to finish in h hours
3. Return first valid speed

**Time Complexity:** O(n * max(piles)) - Linear search + validation
**Space Complexity:** O(1) - Only uses constant extra space

## Algorithm

```
1. Initialize left = 1, right = max(piles)
2. While left < right:
   a. Calculate mid = left + (right - left) / 2
   b. If canFinish(piles, mid, h): right = mid
   c. Else: left = mid + 1
3. Return left

canFinish(piles, speed, h):
1. Calculate total hours needed
2. Return total <= h
```

## Key Insights

- **Binary Search on Answer**: Search for minimum valid speed
- **Validation Function**: Check if speed allows finishing in time
- **Speed Range**: From 1 to maximum pile size
- **Optimization**: Find minimum valid speed

## Alternative Approaches

1. **Linear Search**: Try each speed sequentially
2. **Mathematical**: Calculate optimal speed directly
3. **Greedy**: Use greedy approach for validation

## Edge Cases

- Single pile: Return pile size
- All same size: Return pile size
- Very large piles: Handle overflow
- Single hour: Return sum of all piles
- Empty piles: Return 0

## Applications

- Optimization problems
- Binary search on answer
- Algorithm design patterns
- Interview preparation
- Resource allocation

## Optimization Opportunities

- **Binary Search**: Most efficient approach
- **Validation Function**: Efficient time calculation
- **Early Termination**: Stop when found
- **Memory Efficient**: O(1) space complexity
