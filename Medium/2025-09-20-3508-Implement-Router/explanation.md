# Implement Router (Medium)

**Problem ID:** 3508  
**Date:** 2025-09-20  
**Link:** https://leetcode.com/problems/implement-router/

## Approach

To solve the "Implement Router" problem, we need to design a data structure that efficiently manages packets while adhering to specific constraints, such as memory limits and duplicate handling. The approach can be summarized as follows:

### Main Idea
The router must maintain a collection of packets that allows for:
1. Adding new packets while checking for duplicates.
2. Forwarding packets in FIFO order.
3. Counting packets based on destination and timestamp criteria.

### Data Structures
1. **Queue**: A deque (double-ended queue) will be used to store packets in the order they arrive. This allows for efficient FIFO operations when forwarding packets.
2. **Set**: A hash set will be used to track unique packets, enabling O(1) average time complexity for checking duplicates. Each packet can be represented as a tuple of its attributes (source, destination, timestamp).
3. **Dictionary**: A dictionary can be used to maintain a count of packets for each destination, allowing for efficient retrieval of packet counts within a given timestamp range.

### Operations
1. **addPacket(int source, int destination, int timestamp)**:
   - Check if the packet (source, destination, timestamp) exists in the set. If it does, return `false`.
   - If it’s a new packet, add it to the queue and the set.
   - If adding this packet exceeds the memory limit, remove the oldest packet from the queue and also from the set.
   - Update the dictionary to reflect the addition of the new packet.
   - Return `true` if successfully added.

2. **forwardPacket()**:
   - If the queue is empty, return an empty array.
   - Dequeue the oldest packet, remove it from the set, and return its attributes as an array.

3. **getCount(int destination, int startTime, int endTime)**:
   - Iterate through the packets in the queue and count how many match the specified destination and fall within the timestamp range. This operation can be optimized by maintaining a separate count for each destination, but since packets are stored in FIFO order, a linear scan may suffice depending on the implementation.

### Complexity
- **Time Complexity**:
  - `addPacket`: O(1) on average for checking duplicates and adding to the queue, O(1) for removing the oldest packet if necessary.
  - `forwardPacket`: O(1) for dequeuing the oldest packet.
  - `getCount`: O(n) in the worst case, where n is the number of packets in the router, but can be optimized with a more sophisticated data structure for counting.

- **Space Complexity**: O(m), where m is the memory limit, since we store at most `m` packets in the queue and set.

By using a combination of a queue for FIFO order, a set for duplicate detection, and potentially a dictionary for efficient counting, we can implement the Router class to meet all specified requirements efficiently.
