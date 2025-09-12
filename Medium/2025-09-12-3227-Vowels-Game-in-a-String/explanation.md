# Vowels Game in a String (Medium)

**Problem ID:** 3227  
**Date:** 2025-09-12  
**Link:** https://leetcode.com/problems/vowels-game-in-a-string/

## Approach

To solve the "Vowels Game in a String" problem, we need to analyze the conditions under which Alice can win, given that both players play optimally. The key points of the approach are as follows:

### Main Idea:
1. **Understanding Vowel Counts**: Alice can only remove substrings with an odd number of vowels, while Bob can only remove those with an even number of vowels. This creates a dynamic where the total number of vowels in the string determines the possible moves for both players.

2. **Initial Vowel Count**: Calculate the total number of vowels in the string `s`. This count will help us determine the outcome of the game:
   - If the total number of vowels is odd, Alice has a guaranteed first move (since she can remove a substring with an odd number of vowels).
   - If the total number of vowels is even, Alice cannot make a valid move on her first turn (as any substring she could remove would necessarily contain an odd number of vowels).

### Data Structures:
- A simple integer variable to keep track of the total count of vowels in the string is sufficient for this problem. No complex data structures are required.

### Complexity:
- **Time Complexity**: O(n), where n is the length of the string. This is due to the need to traverse the string once to count the vowels.
- **Space Complexity**: O(1), as we only use a constant amount of space for the vowel count.

### Conclusion:
Based on the total vowel count:
- If the count is odd, return `true` (Alice wins).
- If the count is even, return `false` (Alice loses).

This approach effectively reduces the problem to a simple count of vowels, allowing for a quick determination of the game's outcome based on the initial state of the string.
