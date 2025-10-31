# The Two Sneaky Numbers of Digitville (Easy)

**Problem ID:** 3289  
**Date:** 2025-10-31  
**Link:** https://leetcode.com/problems/the-two-sneaky-numbers-of-digitville/

## Approach

To solve the problem of identifying the two sneaky numbers in the list `nums`, we can utilize a straightforward approach based on counting occurrences of each number.

### Approach:

1. **Understanding the Input**: The input list `nums` contains integers from `0` to `n-1`, where each integer is supposed to appear exactly once, except for two integers that appear twice. The length of `nums` is `n + 2`, which indicates that exactly two numbers are duplicated.

2. **Data Structure**: We can use a hash set to track the numbers we encounter as we iterate through the list. This allows us to efficiently check if a number has already been seen.

3. **Iterative Check**: As we traverse the `nums` list:
   - For each number, check if it is already in the hash set.
   - If it is, it means this number is one of the sneaky numbers, so we add it to our result list.
   - If it is not in the set, we add it to the set for future reference.

4. **Stopping Condition**: Since we know there are exactly two duplicates, we can stop once we have found both sneaky numbers.

### Complexity:
- **Time Complexity**: O(n), where n is the length of the input list `nums`, since we are making a single pass through the list.
- **Space Complexity**: O(n) in the worst case for the hash set, although in practice, since we only need to store unique numbers, the space will be limited to the number of unique integers (which is `n`).

### Conclusion:
This approach is efficient and straightforward, leveraging a hash set for quick lookups and insertions to identify the two sneaky numbers in linear time. The algorithm is robust given the constraints and guarantees provided in the problem statement.
