import java.util.*;

public class Solution {
    public int maxScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        
        int left = 0, right = Integer.MAX_VALUE, result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canReach(graph, online, k, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    private boolean canReach(List<List<int[]>> graph, boolean[] online, long k, int minCost) {
        int n = online.length;
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (!online[node]) continue;
            
            for (int[] edge : graph.get(node)) {
                int neighbor = edge[0];
                int cost = edge[1];
                
                if (cost < minCost || !online[neighbor]) continue;
                
                if (dist[node] + cost <= k && dist[node] + cost < dist[neighbor]) {
                    dist[neighbor] = dist[node] + cost;
                    queue.offer(neighbor);
                }
            }
        }
        
        return dist[n - 1] != Long.MAX_VALUE;
    }
}