# Maximize Active Section with Trade II (Hard)

**Problem ID:** 3501  
**Date:** 2026-07-22  
**Link:** https://leetcode.com/problems/maximize-active-section-with-trade-ii/

## Approach

To solve the problem of maximizing active sections in the binary string `s` after performing at most one trade, we can follow a structured approach:

### Main Idea:
The core idea is to analyze each query independently, where we treat the substring defined by the query as if it is augmented with '1's on both ends. This allows us to determine the potential impact of converting blocks of '1's to '0's and vice versa. The goal is to maximize the number of active sections (blocks of '1's) after executing the trade optimally.

### Steps to Approach:
1. **Preprocessing**:
   - Identify the boundaries of active sections (blocks of '1's) and inactive sections (blocks of '0's) in the string `s`. This can be done by iterating through the string and counting transitions between '0' and '1'.
   - Store the counts of active sections and their positions, as well as the lengths of inactive sections.

2. **Handling Queries**:
   - For each query `[l, r]`, create an augmented version of the substring `s[l...r]` as `t = '1' + s[l...r] + '1'`.
   - Count the number of active sections in this augmented substring. This will help in determining the initial state before any trades.
   - Identify if there are any blocks of '1's surrounded by '0's within the substring. If such blocks exist, we can consider trading them.

3. **Calculating Maximum Active Sections**:
   - If a trade is possible (i.e., there exists at least one block of '1's surrounded by '0's):
     - Compute the maximum possible active sections by considering the effect of converting a block of '1's to '0's and converting the surrounding '0's to '1's.
     - The new active sections count can be derived from the existing count, adjusting for the trade.
   - If no trade is possible, simply return the count of active sections in the original substring.

### Data Structures:
- Use arrays or lists to store the counts and positions of active and inactive sections for efficient retrieval during query processing.
- Maintain a count of active sections and their boundaries to quickly calculate the effect of potential trades.

### Complexity:
- **Preprocessing**: O(n) to analyze the string and gather information about active and inactive sections.
- **Query Processing**: Each query can be processed in O(1) or O(k) time, where k is the number of active sections in the substring, leading to an overall complexity of O(m) for m queries.
- Thus, the total complexity is O(n + m), which is efficient given the constraints.

By following this structured approach, we can effectively maximize the number of active sections in the binary string `s` for each query while ensuring that the solution is efficient and scalable.
