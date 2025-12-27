import heapq
from collections import defaultdict

class Solution:
    def mostBooked(self, n: int, meetings: List[List[int]]) -> int:
        meetings.sort()
        room_count = [0] * n
        free_rooms = list(range(n))
        busy_rooms = []
        
        for start, end in meetings:
            while busy_rooms and busy_rooms[0][0] <= start:
                finish_time, room = heapq.heappop(busy_rooms)
                heapq.heappush(free_rooms, room)
            
            if free_rooms:
                room = heapq.heappop(free_rooms)
                room_count[room] += 1
                heapq.heappush(busy_rooms, (end, room))
            else:
                finish_time, room = heapq.heappop(busy_rooms)
                room_count[room] += 1
                delay = finish_time - start
                new_end = finish_time + (end - start)
                heapq.heappush(busy_rooms, (new_end, room))
        
        return room_count.index(max(room_count))