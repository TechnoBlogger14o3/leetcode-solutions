# Check If All 1's Are at Least Length K Places Away (Easy)

**Problem ID:** 1437  
**Date:** 2025-11-17  
**Link:** https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/

## Approach

To solve the problem of checking if all `1`s in a binary array are at least `k` places away from each other, we can adopt a straightforward linear scan approach. Here’s a concise breakdown of the solution:

### Main Idea:
The core idea is to iterate through the binary array and keep track of the last position where a `1` was found. For each `1` encountered, we check the distance from the last recorded position of `1`. If this distance is less than `k`, we immediately return `false`. If we finish scanning the array without finding any violations, we return `true`.

### Steps:
1. **Initialize a Variable**: Start with a variable to store the index of the last `1` found. Initialize it to a value that indicates no `1` has been found yet (e.g., `-1`).
  
2. **Iterate Through the Array**: Loop through each element of the array using an index:
   - If the current element is `1`, check the distance from the last recorded position of `1`.
   - If the distance is less than `k`, return `false`.
   - If the distance is valid (greater than or equal to `k`), update the last position to the current index.

3. **Return Result**: If the loop completes without finding any violations, return `true`.

### Data Structures:
- We primarily use a simple integer variable to track the last index of `1`. No additional data structures such as arrays or lists are required, which keeps the space complexity minimal.

### Complexity:
- **Time Complexity**: O(n), where n is the length of the input array. We make a single pass through the array.
- **Space Complexity**: O(1), since we only use a fixed amount of extra space regardless of the input size.

This approach is efficient and straightforward, making it suitable for the constraints provided in the problem.
