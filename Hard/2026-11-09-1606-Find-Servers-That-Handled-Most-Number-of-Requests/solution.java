import java.util.*;

public class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] busyUntil = new int[k];
        int[] requestCount = new int[k];
        int n = arrival.length;
        TreeSet<Integer> availableServers = new TreeSet<>();
        
        for (int i = 0; i < k; i++) {
            availableServers.add(i);
        }
        
        for (int i = 0; i < n; i++) {
            int currentTime = arrival[i];
            // Free up servers that are done processing requests
            while (!availableServers.isEmpty() && busyUntil[availableServers.first()] <= currentTime) {
                availableServers.add(availableServers.pollFirst());
            }
            
            if (availableServers.isEmpty()) {
                continue; // All servers are busy, drop the request
            }
            
            int serverIndex = (i % k);
            Integer assignedServer = availableServers.ceiling(serverIndex);
            if (assignedServer == null) {
                assignedServer = availableServers.first(); // Wrap around
            }
            
            // Assign the request to the server
            busyUntil[assignedServer] = currentTime + load[i];
            requestCount[assignedServer]++;
            availableServers.remove(assignedServer);
        }
        
        int maxRequests = 0;
        for (int count : requestCount) {
            maxRequests = Math.max(maxRequests, count);
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (requestCount[i] == maxRequests) {
                result.add(i);
            }
        }
        
        return result;
    }
}