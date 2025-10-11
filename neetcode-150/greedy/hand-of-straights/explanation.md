# Hand of Straights

## Problem Statement

Alice has some number of cards and she wants to rearrange the cards into groups so that each group is size `groupSize`, and consists of consecutive cards.

Given an integer array `hand` where `hand[i]` is the value written on the `ith` card and an integer `groupSize`, return `true` if she can rearrange the cards, or `false` otherwise.

## Examples

**Example 1:**
```
Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
Output: true
Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
```

## Approach

### Method 1: Greedy Algorithm with TreeMap (Recommended)
1. Use TreeMap to count card frequencies
2. For each group, try to form consecutive cards
3. If we can't form a group, return false
4. Most efficient approach

**Time Complexity:** O(n log n) - TreeMap operations
**Space Complexity:** O(n) - TreeMap

### Method 2: Greedy Algorithm with HashMap
1. Use HashMap to count card frequencies
2. Sort the unique cards
3. For each group, try to form consecutive cards
4. Less efficient than TreeMap approach

**Time Complexity:** O(n log n) - Sorting
**Space Complexity:** O(n) - HashMap

## Algorithm

```
1. Count card frequencies using TreeMap
2. While TreeMap is not empty:
   a. Get the smallest card
   b. Try to form a group of consecutive cards
   c. If any card is missing, return false
   d. Decrease frequency of used cards
3. Return true
```

## Key Insights

- **Greedy Choice**: Always start with the smallest available card
- **Local Optimum**: Form groups with consecutive cards
- **Global Optimum**: Can rearrange all cards into groups
- **Frequency Tracking**: Use TreeMap for efficient operations

## Alternative Approaches

1. **HashMap + Sorting**: Use HashMap and sort unique cards
2. **Priority Queue**: Use priority queue for card management
3. **Array**: Use array for frequency counting

## Edge Cases

- Empty hand: Return true
- Single card: Return false if groupSize > 1
- All same cards: Return true if count % groupSize == 0
- No consecutive cards: Return false

## Applications

- Greedy algorithms
- Frequency counting
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **TreeMap**: Most efficient approach
- **Frequency Counting**: O(n) space complexity
- **Logarithmic Operations**: O(n log n) time complexity
- **No Extra Space**: Use only necessary space
