# Find All People With Secret (Hard)

**Problem ID:** 2092  
**Date:** 2025-12-19  
**Link:** https://leetcode.com/problems/find-all-people-with-secret/

## Approach

To solve the problem of finding all people who know the secret after a series of meetings, we can use a graph-based approach combined with a breadth-first search (BFS) or depth-first search (DFS) strategy. Here's a concise breakdown of the approach:

### Main Idea:
The core idea is to model the meetings as a graph where each person is a node, and each meeting is an edge connecting two nodes (people) at a specific time. The secret spreads through these connections, and we need to track the spread of the secret over time.

### Steps:
1. **Data Structure Setup**:
   - Use a dictionary or a list of sets to represent the adjacency list of meetings for each person, where each entry contains the people they meet and the time of the meeting.
   - Store the meetings in a way that allows easy access by time, such as a list of tuples.

2. **Sort Meetings**:
   - Sort the meetings by time to process them in chronological order. This ensures that we handle the spread of the secret correctly as it occurs at specific times.

3. **Initial Setup**:
   - Start with a set of people who know the secret: initially, this includes person 0 and the `firstPerson`.
   - Use a queue (or stack) for BFS/DFS to explore the spread of the secret.

4. **Process Meetings**:
   - Iterate through the sorted meetings, and for each time frame, check which people currently know the secret.
   - If a person who knows the secret attends a meeting, they share the secret with the other person in that meeting.
   - Use a temporary set to track newly informed individuals during the same time frame to avoid premature sharing within the same time slot.

5. **Final Collection**:
   - After processing all meetings, the set of people who know the secret will contain the final result. Convert this set to a list for output.

### Complexity:
- **Time Complexity**: O(M log M + M + N), where M is the number of meetings (due to sorting) and N is the number of people. The sorting step dominates the time complexity.
- **Space Complexity**: O(N + M) for storing the adjacency list and the set of people who know the secret.

This approach efficiently simulates the spread of the secret through the meetings while ensuring that the sharing happens correctly based on the timing of the meetings.
