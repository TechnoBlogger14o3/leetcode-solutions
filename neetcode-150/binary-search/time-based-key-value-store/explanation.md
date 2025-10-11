# Time Based Key Value Store

## Problem Statement

Design a time-based key-value data structure that can store multiple values for the same key at different time stamps and retrieve the key's value at a certain timestamp.

Implement the `TimeMap` class:

- `TimeMap()` Initializes the object of the data structure.
- `void set(String key, String value, int timestamp)` Stores the key `key` with the value `value` at the given time `timestamp`.
- `String get(String key, int timestamp)` Returns a value such that `set` was called previously, with `timestamp_prev <= timestamp`. If there are multiple such values, it returns the value associated with the largest `timestamp_prev`. If no values exist for this key, return `""`.

## Examples

**Example 1:**
```
Input
["TimeMap", "set", "get", "get", "set", "get", "get"]
[[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4], ["foo", 5]]

Output
[null, null, "bar", "bar", null, "bar2", "bar2"]

Explanation
TimeMap timeMap = new TimeMap();
timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" with timestamp = 1
timeMap.get("foo", 1);         // return "bar"
timeMap.get("foo", 3);         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" with timestamp = 4
timeMap.get("foo", 4);         // return "bar2"
timeMap.get("foo", 5);         // return "bar2"
```

## Approach

### Method 1: HashMap + Binary Search (Recommended)
1. Use HashMap to store key -> list of (timestamp, value) pairs
2. For get operation, use binary search to find largest timestamp <= target
3. Store timestamps in sorted order for efficient binary search

**Time Complexity:** O(log n) for get, O(1) for set
**Space Complexity:** O(n) - Store all key-value pairs

### Method 2: TreeMap
1. Use TreeMap for each key to store timestamp -> value mapping
2. Use floorKey to find largest timestamp <= target

**Time Complexity:** O(log n) for get, O(log n) for set
**Space Complexity:** O(n) - Store all key-value pairs

## Algorithm

```
Set:
1. Get list for key from HashMap
2. Append (timestamp, value) to list

Get:
1. Get list for key from HashMap
2. If list is empty: return ""
3. Binary search for largest timestamp <= target
4. Return corresponding value
```

## Key Insights

- **HashMap**: Store key -> list of (timestamp, value) pairs
- **Binary Search**: Find largest timestamp <= target
- **Sorted Order**: Maintain timestamps in sorted order
- **Efficient Retrieval**: O(log n) time complexity

## Alternative Approaches

1. **TreeMap**: Use TreeMap for each key
2. **Array**: Use array with binary search
3. **Linked List**: Use linked list with linear search

## Edge Cases

- Empty key: Return empty string
- No values for key: Return empty string
- Single value: Return that value
- All timestamps > target: Return empty string
- Duplicate timestamps: Handle appropriately

## Applications

- Time series data
- Version control systems
- Database systems
- Algorithm design patterns
- Interview preparation

## Optimization Opportunities

- **HashMap + Binary Search**: Most efficient approach
- **Sorted Storage**: Maintain sorted order
- **Efficient Retrieval**: O(log n) time complexity
- **Memory Efficient**: Only store necessary data
