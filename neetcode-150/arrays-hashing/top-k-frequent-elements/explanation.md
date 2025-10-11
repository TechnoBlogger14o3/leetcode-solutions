# Top K Frequent Elements

## Problem Statement

Given an integer array `nums` and an integer `k`, return the `k` most frequent elements. You may return the answer in any order.

## Examples

**Example 1:**
```
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
```

**Example 2:**
```
Input: nums = [1], k = 1
Output: [1]
```

## Approach

### Method 1: HashMap + Heap (Recommended)
1. Count frequency of each element using HashMap
2. Use a min-heap of size k to keep track of top k frequent elements
3. Return elements from the heap

**Time Complexity:** O(n log k) - Where n is array length
**Space Complexity:** O(n) - For HashMap and heap

### Method 2: HashMap + Sorting
1. Count frequency of each element
2. Sort elements by frequency in descending order
3. Return first k elements

**Time Complexity:** O(n log n) - Due to sorting
**Space Complexity:** O(n) - For HashMap

### Method 3: Bucket Sort
1. Count frequency of each element
2. Create buckets for each frequency level
3. Collect elements from highest frequency buckets

**Time Complexity:** O(n) - Linear time
**Space Complexity:** O(n) - For buckets

## Algorithm

```
1. Count frequency of each element using HashMap
2. Create min-heap of size k
3. For each element and its frequency:
   a. If heap size < k:
      - Add element to heap
   b. Else if frequency > min frequency in heap:
      - Replace min element with current element
4. Return all elements from heap
```

## Key Insights

- **Frequency Counting**: First step is always counting occurrences
- **Heap Efficiency**: Min-heap keeps only k elements, reducing space
- **Priority Queue**: Natural choice for "top k" problems
- **Bucket Sort**: Most efficient for this specific problem

## Alternative Approaches

1. **Quick Select**: Use quick select algorithm for O(n) average time
2. **Counting Sort**: If numbers are bounded, use counting array
3. **Two Pass**: First pass count, second pass find top k

## Edge Cases

- k equals array length: Return all elements
- All elements same frequency: Return any k elements
- Single element: Return that element
- k = 1: Return most frequent element
- Empty array: Return empty array

## Applications

- Data analysis and statistics
- Recommendation systems
- Log analysis
- Performance monitoring
- Machine learning feature selection

## Optimization Opportunities

- **Bucket Sort**: Most efficient O(n) solution
- **Heap Size**: Keep heap size at k for memory efficiency
- **Early Termination**: Stop when k elements found
- **Memory Efficient**: Use counting array for bounded integers
