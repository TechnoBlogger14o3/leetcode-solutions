import java.util.*;

class Solution {
    public int minimumCost(int n, int[][] edges) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0}); // cost, node, used switch
        
        int[][] dist = new int[n][2];
        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0], node = curr[1], usedSwitch = curr[2];
            
            if (node == n - 1) {
                return cost;
            }
            
            if (cost > dist[node][usedSwitch]) {
                continue;
            }
            
            // Traverse normal edges
            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0], edgeCost = neighbor[1];
                if (cost + edgeCost < dist[nextNode][usedSwitch]) {
                    dist[nextNode][usedSwitch] = cost + edgeCost;
                    pq.offer(new int[]{dist[nextNode][usedSwitch], nextNode, usedSwitch});
                }
            }
            
            // Use switch to reverse edges
            if (usedSwitch == 0) {
                for (int[] edge : edges) {
                    if (edge[1] == node) {
                        int nextNode = edge[0], edgeCost = edge[2];
                        if (cost + 2 * edgeCost < dist[nextNode][1]) {
                            dist[nextNode][1] = cost + 2 * edgeCost;
                            pq.offer(new int[]{dist[nextNode][1], nextNode, 1});
                        }
                    }
                }
            }
        }
        
        return -1;
    }
}