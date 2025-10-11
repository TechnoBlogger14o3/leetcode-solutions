/**
 * Time Complexity: O(E + V log V) - E edges, V vertices
 * Space Complexity: O(V) - Priority queue and distances
 */
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Build adjacency list
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            graph.get(from).add(new int[]{to, price});
        }
        
        // Modified Dijkstra's with stops constraint
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // [cost, city, stops]
        minHeap.offer(new int[]{0, src, 0});
        
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[src] = 0;
        
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int cost = current[0];
            int city = current[1];
            int stops = current[2];
            
            if (city == dst) {
                return cost;
            }
            
            if (stops > k) {
                continue; // Exceeded stops limit
            }
            
            for (int[] neighbor : graph.get(city)) {
                int nextCity = neighbor[0];
                int price = neighbor[1];
                int newCost = cost + price;
                int newStops = stops + 1;
                
                if (newCost < minCost[nextCity] && newStops <= k + 1) {
                    minCost[nextCity] = newCost;
                    minHeap.offer(new int[]{newCost, nextCity, newStops});
                }
            }
        }
        
        return -1;
    }
}

// Alternative approach using Bellman-Ford Algorithm
class SolutionBellmanFord {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prev = new int[n];
        int[] curr = new int[n];
        
        Arrays.fill(prev, Integer.MAX_VALUE);
        Arrays.fill(curr, Integer.MAX_VALUE);
        prev[src] = 0;
        curr[src] = 0;
        
        // Relax edges k+1 times
        for (int i = 0; i <= k; i++) {
            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];
                
                if (prev[from] != Integer.MAX_VALUE) {
                    curr[to] = Math.min(curr[to], prev[from] + price);
                }
            }
            
            // Copy current to previous
            for (int j = 0; j < n; j++) {
                prev[j] = curr[j];
            }
        }
        
        return curr[dst] == Integer.MAX_VALUE ? -1 : curr[dst];
    }
}

// Alternative approach using BFS
class SolutionBFS {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Build adjacency list
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            graph.get(from).add(new int[]{to, price});
        }
        
        // BFS with cost tracking
        Queue<int[]> queue = new LinkedList<>();
        // [city, cost, stops]
        queue.offer(new int[]{src, 0, 0});
        
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[src] = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int city = current[0];
                int cost = current[1];
                int stops = current[2];
                
                if (city == dst) {
                    continue; // Already at destination
                }
                
                if (stops > k) {
                    continue; // Exceeded stops limit
                }
                
                for (int[] neighbor : graph.get(city)) {
                    int nextCity = neighbor[0];
                    int price = neighbor[1];
                    int newCost = cost + price;
                    
                    if (newCost < minCost[nextCity]) {
                        minCost[nextCity] = newCost;
                        queue.offer(new int[]{nextCity, newCost, stops + 1});
                    }
                }
            }
        }
        
        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }
}

// Alternative approach using DFS with memoization
class SolutionDFS {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Build adjacency list
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            graph.get(from).add(new int[]{to, price});
        }
        
        int[][] memo = new int[n][k + 2];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        int result = dfs(graph, src, dst, k + 1, memo);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
    private int dfs(List<List<int[]>> graph, int city, int dst, int stops, int[][] memo) {
        if (city == dst) {
            return 0;
        }
        
        if (stops == 0) {
            return Integer.MAX_VALUE;
        }
        
        if (memo[city][stops] != -1) {
            return memo[city][stops];
        }
        
        int minCost = Integer.MAX_VALUE;
        
        for (int[] neighbor : graph.get(city)) {
            int nextCity = neighbor[0];
            int price = neighbor[1];
            
            int cost = dfs(graph, nextCity, dst, stops - 1, memo);
            if (cost != Integer.MAX_VALUE) {
                minCost = Math.min(minCost, cost + price);
            }
        }
        
        memo[city][stops] = minCost;
        return minCost;
    }
}

// More concise version
class SolutionConcise {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        
        for (int[] flight : flights) {
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        heap.offer(new int[]{0, src, 0});
        
        while (!heap.isEmpty()) {
            int[] curr = heap.poll();
            int cost = curr[0], city = curr[1], stops = curr[2];
            
            if (city == dst) return cost;
            if (stops > k) continue;
            
            for (int[] neighbor : graph.get(city)) {
                heap.offer(new int[]{cost + neighbor[1], neighbor[0], stops + 1});
            }
        }
        
        return -1;
    }
}
