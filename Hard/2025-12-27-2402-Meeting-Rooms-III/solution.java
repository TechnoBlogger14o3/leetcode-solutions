import java.util.*;

public class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> freeRooms = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> busyRooms = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[] roomCount = new int[n];
        
        for (int i = 0; i < n; i++) {
            freeRooms.offer(new int[]{0, i}); // {end time, room number}
        }
        
        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            
            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                int[] room = busyRooms.poll();
                freeRooms.offer(room);
            }
            
            if (!freeRooms.isEmpty()) {
                int[] room = freeRooms.poll();
                roomCount[room[1]]++;
                busyRooms.offer(new int[]{end, room[1]});
            } else {
                int[] room = busyRooms.poll();
                int newStart = room[0];
                roomCount[room[1]]++;
                busyRooms.offer(new int[]{newStart + (end - start), room[1]});
            }
        }
        
        int maxMeetings = 0;
        int roomWithMaxMeetings = 0;
        
        for (int i = 0; i < n; i++) {
            if (roomCount[i] > maxMeetings) {
                maxMeetings = roomCount[i];
                roomWithMaxMeetings = i;
            }
        }
        
        return roomWithMaxMeetings;
    }
}