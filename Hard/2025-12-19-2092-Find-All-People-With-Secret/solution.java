import java.util.*;

public class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Map<Integer, List<int[]>> timeMap = new HashMap<>();
        for (int[] meeting : meetings) {
            timeMap.computeIfAbsent(meeting[2], k -> new ArrayList<>()).add(new int[]{meeting[0], meeting[1]});
        }

        Set<Integer> secretHolders = new HashSet<>();
        secretHolders.add(0);
        secretHolders.add(firstPerson);

        for (int time : timeMap.keySet()) {
            Set<Integer> currentMeetingAttendees = new HashSet<>();
            for (int[] meeting : timeMap.get(time)) {
                if (secretHolders.contains(meeting[0]) || secretHolders.contains(meeting[1])) {
                    currentMeetingAttendees.add(meeting[0]);
                    currentMeetingAttendees.add(meeting[1]);
                }
            }
            if (!currentMeetingAttendees.isEmpty()) {
                secretHolders.addAll(currentMeetingAttendees);
            }
        }

        return new ArrayList<>(secretHolders);
    }
}