# Keep Multiplying Found Values by Two (Easy)

**Problem ID:** 2154  
**Date:** 2025-11-19  
**Link:** https://leetcode.com/problems/keep-multiplying-found-values-by-two/

## Approach

To solve the problem "Keep Multiplying Found Values by Two," we will adopt a straightforward iterative approach that utilizes a set for efficient lookups.

### Main Idea:
The core idea is to repeatedly check if the current value of `original` exists in the given array `nums`. If it does, we multiply `original` by two and continue checking. If it does not exist, we stop the process and return the current value of `original`.

### Steps:
1. **Convert `nums` to a Set**: Since we need to perform multiple membership checks, converting the list `nums` to a set will allow for O(1) average time complexity for lookups.
  
2. **Iterate Until Not Found**: Initialize a loop that continues as long as `original` is found in the set of `nums`. Inside the loop, if `original` is found, multiply it by two.

3. **Return Result**: Once `original` is no longer found in `nums`, exit the loop and return the final value of `original`.

### Data Structures:
- **Set**: We will use a set to store the elements of `nums` for efficient membership testing.

### Complexity:
- **Time Complexity**: O(n) for converting the list to a set, where n is the length of `nums`. The while loop will run at most log(1000) times (since `original` can double until it exceeds 1000), resulting in an overall time complexity of O(n).
- **Space Complexity**: O(n) for storing the elements of `nums` in a set.

This approach is efficient given the constraints and ensures that we can quickly determine whether to continue multiplying `original`.
