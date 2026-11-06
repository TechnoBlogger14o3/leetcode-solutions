# Count Zero Request Servers (Medium)

**Problem ID:** 2747  
**Date:** 2026-11-06  
**Link:** https://leetcode.com/problems/count-zero-request-servers/

## Approach

To solve the problem of counting servers that did not receive any requests during specified time intervals, we can follow a systematic approach:

### Main Idea:
The core idea is to efficiently track which servers received requests within given time intervals defined by the queries. For each query, we need to determine how many servers did not receive any requests during that interval.

### Approach:
1. **Data Structuring**:
   - Use a dictionary (or an array) to maintain a list of timestamps for each server. This allows us to quickly access the request times for any server.

2. **Processing Logs**:
   - Iterate through the `logs` array and populate the dictionary where the key is the `server_id` and the value is a list of timestamps when that server received requests.

3. **Handling Queries**:
   - For each query, determine the time interval `[queries[i] - x, queries[i]]`.
   - Create a set to track servers that received requests during this interval.
   - For each server, check its list of request timestamps. If any timestamp falls within the interval, add that server to the set.

4. **Counting Zero Request Servers**:
   - The number of servers that did not receive any requests during the interval can be calculated as:
     \[
     \text{Zero Request Servers} = n - \text{size of the set}
     \]
   - Store the result for each query.

### Data Structures:
- **Dictionary/Array**: To map each server to its list of request timestamps.
- **Set**: To keep track of servers that received requests during the specific query interval.

### Complexity:
- **Time Complexity**: 
  - Constructing the dictionary from logs takes \(O(m)\), where \(m\) is the length of `logs`.
  - Each query involves checking up to \(n\) servers, leading to a worst-case complexity of \(O(n \cdot q)\), where \(q\) is the number of queries. However, since we are only checking timestamps within a limited range, this can be optimized.
  
- **Space Complexity**: 
  - The space used is \(O(n + m)\) for storing the request logs and the dictionary.

### Optimization Consideration:
To improve efficiency, especially for large inputs, consider:
- Sorting the timestamps for each server and using binary search to quickly find relevant timestamps within the query interval.
- Preprocessing the logs to create a more efficient structure for range queries.

By following this structured approach, we can efficiently determine the number of servers that did not receive requests during specified intervals across multiple queries.
