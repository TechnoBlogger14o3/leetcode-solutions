# Stone Game IX (Medium)

**Problem ID:** 2029  
**Date:** 2026-08-16  
**Link:** https://leetcode.com/problems/stone-game-ix/

## Approach

To solve the problem "Stone Game IX," we need to determine if Alice can win given both players play optimally. The main idea revolves around the sum of the values of the stones removed and its divisibility by 3.

### Approach:

1. **Count Remainders**: First, we categorize the stones based on their values modulo 3. Specifically, we count how many stones have values that yield a remainder of 0, 1, and 2 when divided by 3. This gives us three counts: `count0`, `count1`, and `count2`.

2. **Game Dynamics**:
   - The game revolves around the sum of removed stones. If at any point the sum of removed stones is divisible by 3, the player who made that move loses.
   - Alice starts first, and if she can force Bob into a losing position, she wins.

3. **Winning Conditions**:
   - If `count0` (the number of stones with value divisible by 3) is greater than 1, Alice cannot avoid losing because she will eventually have to remove a stone that leads to a sum divisible by 3.
   - If `count0` is 0, Alice can win if either `count1` or `count2` is greater than 0, as she can always manipulate the game to avoid a losing sum.
   - If `count0` is exactly 1, the winning strategy depends on the counts of `count1` and `count2`. Alice can win if the larger group (either `count1` or `count2`) has an odd number of stones, allowing her to control the game flow.

### Data Structures:
- We primarily use integer counters to keep track of the counts of stones based on their remainders when divided by 3.

### Complexity:
- The time complexity is O(n), where n is the number of stones, as we need to iterate through the list to count the remainders.
- The space complexity is O(1) since we are only using a fixed number of counters regardless of the input size.

In summary, the solution leverages the properties of modular arithmetic to determine the optimal moves for Alice and Bob, focusing on the counts of stones based on their values modulo 3 to derive winning strategies.
