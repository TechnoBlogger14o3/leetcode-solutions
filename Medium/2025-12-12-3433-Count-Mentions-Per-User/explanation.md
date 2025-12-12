# Count Mentions Per User (Medium)

**Problem ID:** 3433  
**Date:** 2025-12-12  
**Link:** https://leetcode.com/problems/count-mentions-per-user/

## Approach

To solve the problem of counting mentions per user based on the given events, we can follow a systematic approach:

### Main Idea:
The solution revolves around maintaining the online status of users and counting mentions accurately based on the type of events processed. We need to handle both "MESSAGE" and "OFFLINE" events while ensuring that mentions are counted correctly, considering the online status of users at the time of each message.

### Approach:
1. **Data Structures**:
   - An array `mentions` of size `numberOfUsers` initialized to zero to keep track of mention counts for each user.
   - A boolean array `online` of size `numberOfUsers` initialized to `true` to track the online status of each user.
   - A timestamp variable to manage the timing of events and ensure that offline status is respected.

2. **Processing Events**:
   - Iterate through the list of events in the order they are provided.
   - For each event:
     - **If it's a "MESSAGE" event**:
       - Parse the timestamp and the mentions string.
       - Update the online status of users if any offline events occurred at the same timestamp.
       - Depending on the mentions string:
         - If it contains specific user IDs (e.g., "id1 id0"), increment their respective counts in the `mentions` array.
         - If it contains "ALL", increment the count for all users, regardless of their online status.
         - If it contains "HERE", increment the count only for users currently marked as online.
     - **If it's an "OFFLINE" event**:
       - Parse the timestamp and the user ID.
       - Mark the user as offline in the `online` array and set a timer for when they will come back online (timestamp + 60).

3. **Handling Timings**:
   - Each time a new event is processed, check if the current timestamp has crossed the return time of any user who went offline. If so, mark them as online again.

### Complexity:
- **Time Complexity**: O(n * m), where n is the number of events and m is the maximum number of mentions in a MESSAGE event. This is because we may need to process each event and potentially check multiple mentions in a MESSAGE event.
- **Space Complexity**: O(u), where u is the number of users (up to 100), for storing the mentions and online status.

This approach ensures that we accurately track mentions while respecting the online status of users at the time of each message event, leading to the correct final counts in the `mentions` array.
