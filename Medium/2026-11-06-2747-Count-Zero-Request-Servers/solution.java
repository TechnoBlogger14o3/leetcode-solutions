import java.util.*;

public class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m = queries.length;
        int[] result = new int[m];
        Map<Integer, List<Integer>> serverRequests = new HashMap<>();
        
        for (int[] log : logs) {
            int serverId = log[0];
            int time = log[1];
            serverRequests.putIfAbsent(serverId, new ArrayList<>());
            serverRequests.get(serverId).add(time);
        }
        
        for (int i = 0; i < m; i++) {
            int queryTime = queries[i];
            int startTime = queryTime - x;
            Set<Integer> activeServers = new HashSet<>();
            
            for (Map.Entry<Integer, List<Integer>> entry : serverRequests.entrySet()) {
                int serverId = entry.getKey();
                List<Integer> times = entry.getValue();
                
                for (int time : times) {
                    if (time >= startTime && time <= queryTime) {
                        activeServers.add(serverId);
                        break;
                    }
                }
            }
            
            result[i] = n - activeServers.size();
        }
        
        return result;
    }
}