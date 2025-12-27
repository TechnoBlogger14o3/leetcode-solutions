# Meeting Rooms III (Hard)

**Problem ID:** 2402  
**Date:** 2025-12-27  
**Link:** https://leetcode.com/problems/meeting-rooms-iii/

## Approach

To solve the "Meeting Rooms III" problem, we can adopt a simulation-based approach that utilizes a priority queue (min-heap) to manage room availability and meeting scheduling effectively. Here's a concise breakdown of the approach:

### Main Idea:
1. **Event Simulation**: We treat each meeting as an event that needs to be scheduled in the available rooms. If no rooms are available, we delay the meeting until a room becomes free.
2. **Room Management**: We keep track of the end times of meetings in each room to determine when a room becomes available for the next meeting.

### Data Structures:
- **Min-Heap**: This will store the end times of meetings currently occupying each room. The heap allows us to efficiently retrieve the room that will become available the soonest.
- **Array for Meeting Counts**: An array to count how many meetings each room has hosted, ensuring we can easily determine which room hosted the most meetings.

### Steps:
1. **Sort Meetings**: First, sort the meetings based on their start times to handle them in chronological order.
2. **Iterate Over Meetings**: For each meeting:
   - Check if the room with the earliest end time can accommodate the meeting. If the earliest end time is less than or equal to the current meeting's start time, that room can be reused.
   - If a room is available, assign the meeting to that room, update the end time in the min-heap, and increment the meeting count for that room.
   - If no rooms are available, delay the meeting until the earliest room becomes free, adjusting the meeting's end time accordingly.
3. **Count Meetings**: After processing all meetings, determine which room hosted the most meetings by iterating through the meeting counts.

### Complexity:
- **Time Complexity**: O(M log R), where M is the number of meetings and R is the number of rooms. This arises from the need to maintain the min-heap for room availability.
- **Space Complexity**: O(R) for the min-heap and O(R) for the meeting counts array.

This approach efficiently handles the scheduling of meetings while adhering to the constraints of room availability and meeting delays, ensuring that we can determine the room that hosted the most meetings in a clear and structured manner.
