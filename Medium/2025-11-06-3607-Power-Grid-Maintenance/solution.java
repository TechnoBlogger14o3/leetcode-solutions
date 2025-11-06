import java.util.*;

public class Solution {
    public int[] maintenanceCheck(int c, int[][] connections, int[][] queries) {
        List<Integer>[] graph = new List[c + 1];
        for (int i = 1; i <= c; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] conn : connections) {
            graph[conn[0]].add(conn[1]);
            graph[conn[1]].add(conn[0]);
        }
        
        boolean[] online = new boolean[c + 1];
        Arrays.fill(online, true);
        
        int[] result = new int[queries.length];
        int index = 0;
        
        for (int[] query : queries) {
            int type = query[0];
            int x = query[1];
            
            if (type == 1) {
                if (online[x]) {
                    result[index++] = x;
                } else {
                    int minId = Integer.MAX_VALUE;
                    boolean found = false;
                    Queue<Integer> queue = new LinkedList<>();
                    boolean[] visited = new boolean[c + 1];
                    queue.add(x);
                    visited[x] = true;
                    
                    while (!queue.isEmpty()) {
                        int node = queue.poll();
                        if (online[node]) {
                            minId = Math.min(minId, node);
                            found = true;
                        }
                        for (int neighbor : graph[node]) {
                            if (!visited[neighbor]) {
                                visited[neighbor] = true;
                                queue.add(neighbor);
                            }
                        }
                    }
                    result[index++] = found ? minId : -1;
                }
            } else if (type == 2) {
                online[x] = false;
            }
        }
        
        return Arrays.copyOf(result, index);
    }
}