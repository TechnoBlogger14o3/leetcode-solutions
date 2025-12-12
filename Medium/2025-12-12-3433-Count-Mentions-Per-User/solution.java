import java.util.*;

public class Solution {
    public int[] countMentions(int numberOfUsers, String[][] events) {
        int[] mentions = new int[numberOfUsers];
        boolean[] online = new boolean[numberOfUsers];
        Arrays.fill(online, true);
        Map<Integer, Integer> offlineUntil = new HashMap<>();

        for (String[] event : events) {
            String type = event[0];
            int timestamp = Integer.parseInt(event[1]);

            if (type.equals("OFFLINE")) {
                int userId = Integer.parseInt(event[2]);
                online[userId] = false;
                offlineUntil.put(userId, timestamp + 60);
            } else if (type.equals("MESSAGE")) {
                String mentionsString = event[2];
                List<Integer> mentionedUsers = new ArrayList<>();

                if (mentionsString.equals("ALL")) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        mentionedUsers.add(i);
                    }
                } else if (mentionsString.equals("HERE")) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        if (online[i]) {
                            mentionedUsers.add(i);
                        }
                    }
                } else {
                    String[] ids = mentionsString.split(" ");
                    for (String id : ids) {
                        if (id.startsWith("id")) {
                            int userId = Integer.parseInt(id.substring(2));
                            mentionedUsers.add(userId);
                        }
                    }
                }

                for (int userId : mentionedUsers) {
                    if (online[userId]) {
                        mentions[userId] += Collections.frequency(Arrays.asList(mentionsString.split(" ")), "id" + userId);
                    }
                }
            }

            // Process offline users
            for (Map.Entry<Integer, Integer> entry : offlineUntil.entrySet()) {
                if (entry.getValue() <= timestamp) {
                    online[entry.getKey()] = true;
                }
            }
        }

        return mentions;
    }
}