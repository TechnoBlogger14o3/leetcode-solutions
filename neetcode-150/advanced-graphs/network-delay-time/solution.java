/**
 * Time Complexity: O((V + E) log V) - V vertices, E edges
 * Space Complexity: O(V + E) - Adjacency list and heap
 */
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Build adjacency list
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] time : times) {
            int from = time[0];
            int to = time[1];
            int weight = time[2];
            graph.get(from).add(new int[]{to, weight});
        }
        
        // Dijkstra's algorithm
        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[k] = 0;
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.offer(new int[]{k, 0});
        
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int node = current[0];
            int dist = current[1];
            
            if (dist > distances[node]) {
                continue; // Skip if we've already found a shorter path
            }
            
            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                int newDist = dist + weight;
                
                if (newDist < distances[nextNode]) {
                    distances[nextNode] = newDist;
                    minHeap.offer(new int[]{nextNode, newDist});
                }
            }
        }
        
        // Find maximum distance
        int maxDistance = 0;
        for (int i = 1; i <= n; i++) {
            if (distances[i] == Integer.MAX_VALUE) {
                return -1; // Unreachable node
            }
            maxDistance = Math.max(maxDistance, distances[i]);
        }
        
        return maxDistance;
    }
}

// Alternative approach using Bellman-Ford Algorithm
class SolutionBellmanFord {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[k] = 0;
        
        // Relax edges n-1 times
        for (int i = 0; i < n - 1; i++) {
            boolean relaxed = false;
            
            for (int[] time : times) {
                int from = time[0];
                int to = time[1];
                int weight = time[2];
                
                if (distances[from] != Integer.MAX_VALUE && 
                    distances[from] + weight < distances[to]) {
                    distances[to] = distances[from] + weight;
                    relaxed = true;
                }
            }
            
            if (!relaxed) {
                break; // No more relaxations possible
            }
        }
        
        // Find maximum distance
        int maxDistance = 0;
        for (int i = 1; i <= n; i++) {
            if (distances[i] == Integer.MAX_VALUE) {
                return -1; // Unreachable node
            }
            maxDistance = Math.max(maxDistance, distances[i]);
        }
        
        return maxDistance;
    }
}

// Alternative approach using optimized Dijkstra's
class SolutionDijkstraOptimized {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Build adjacency list
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.computeIfAbsent(time[0], k1 -> new ArrayList<>())
                 .add(new int[]{time[1], time[2]});
        }
        
        // Dijkstra's algorithm
        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[k] = 0;
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.offer(new int[]{k, 0});
        
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int node = current[0];
            int dist = current[1];
            
            if (dist > distances[node]) {
                continue;
            }
            
            List<int[]> neighbors = graph.get(node);
            if (neighbors != null) {
                for (int[] neighbor : neighbors) {
                    int nextNode = neighbor[0];
                    int weight = neighbor[1];
                    int newDist = dist + weight;
                    
                    if (newDist < distances[nextNode]) {
                        distances[nextNode] = newDist;
                        minHeap.offer(new int[]{nextNode, newDist});
                    }
                }
            }
        }
        
        // Find maximum distance
        int maxDistance = 0;
        for (int i = 1; i <= n; i++) {
            if (distances[i] == Integer.MAX_VALUE) {
                return -1;
            }
            maxDistance = Math.max(maxDistance, distances[i]);
        }
        
        return maxDistance;
    }
}

// Alternative approach using BFS for unweighted graph
class SolutionBFS {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] time : times) {
            graph.get(time[0]).add(time[1]);
        }
        
        // BFS
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        int[] distances = new int[n + 1];
        Arrays.fill(distances, -1);
        
        queue.offer(k);
        visited[k] = true;
        distances[k] = 0;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distances[neighbor] = distances[node] + 1;
                    queue.offer(neighbor);
                }
            }
        }
        
        // Check if all nodes are reachable
        for (int i = 1; i <= n; i++) {
            if (distances[i] == -1) {
                return -1;
            }
        }
        
        // Find maximum distance
        int maxDistance = 0;
        for (int i = 1; i <= n; i++) {
            maxDistance = Math.max(maxDistance, distances[i]);
        }
        
        return maxDistance;
    }
}

// More concise version
class SolutionConcise {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        
        for (int[] time : times) {
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        heap.offer(new int[]{k, 0});
        
        while (!heap.isEmpty()) {
            int[] curr = heap.poll();
            int node = curr[0], d = curr[1];
            
            if (d > dist[node]) continue;
            
            for (int[] neighbor : graph.get(node)) {
                int next = neighbor[0], weight = neighbor[1];
                if (d + weight < dist[next]) {
                    dist[next] = d + weight;
                    heap.offer(new int[]{next, dist[next]});
                }
            }
        }
        
        int maxDist = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            maxDist = Math.max(maxDist, dist[i]);
        }
        
        return maxDist;
    }
}
