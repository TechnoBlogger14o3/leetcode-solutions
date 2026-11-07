import java.util.*;

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length, m = tasks.length;
        int[] ans = new int[m];
        PriorityQueue<int[]> freeServers = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<int[]> busyServers = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        for (int i = 0; i < n; i++) {
            freeServers.offer(new int[]{servers[i], i});
        }
        
        long time = 0;
        for (int j = 0; j < m; j++) {
            time = Math.max(time, j);
            while (!busyServers.isEmpty() && busyServers.peek()[0] <= time) {
                int[] server = busyServers.poll();
                freeServers.offer(new int[]{servers[server[1]], server[1]});
            }
            
            if (freeServers.isEmpty()) {
                time = busyServers.peek()[0];
                while (!busyServers.isEmpty() && busyServers.peek()[0] <= time) {
                    int[] server = busyServers.poll();
                    freeServers.offer(new int[]{servers[server[1]], server[1]});
                }
            }
            
            int[] server = freeServers.poll();
            ans[j] = server[1];
            busyServers.offer(new int[]{(int)(time + tasks[j]), server[1]});
        }
        
        return ans;
    }
}