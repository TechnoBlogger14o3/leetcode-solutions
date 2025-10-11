/**
 * Time Complexity: O(n² log n) - n² edges, sorting
 * Space Complexity: O(n²) - Edge list
 */
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        if (n <= 1) {
            return 0;
        }
        
        // Create list of all edges with weights
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int weight = Math.abs(points[i][0] - points[j][0]) + 
                           Math.abs(points[i][1] - points[j][1]);
                edges.add(new Edge(i, j, weight));
            }
        }
        
        // Sort edges by weight
        Collections.sort(edges, (a, b) -> a.weight - b.weight);
        
        // Use Union Find to build MST
        UnionFind uf = new UnionFind(n);
        int totalCost = 0;
        int edgesAdded = 0;
        
        for (Edge edge : edges) {
            if (uf.find(edge.from) != uf.find(edge.to)) {
                uf.union(edge.from, edge.to);
                totalCost += edge.weight;
                edgesAdded++;
                
                if (edgesAdded == n - 1) {
                    break; // MST complete
                }
            }
        }
        
        return totalCost;
    }
    
    private static class Edge {
        int from, to, weight;
        
        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
    
    private static class UnionFind {
        private int[] parent;
        private int[] rank;
        
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }
        
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            
            if (rootX != rootY) {
                if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }
}

// Alternative approach using Prim's Algorithm
class SolutionPrim {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        if (n <= 1) {
            return 0;
        }
        
        // Build adjacency list
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int weight = Math.abs(points[i][0] - points[j][0]) + 
                           Math.abs(points[i][1] - points[j][1]);
                graph.get(i).add(new int[]{j, weight});
                graph.get(j).add(new int[]{i, weight});
            }
        }
        
        // Prim's Algorithm
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        boolean[] visited = new boolean[n];
        int totalCost = 0;
        int nodesVisited = 0;
        
        // Start from node 0
        minHeap.offer(new int[]{0, 0});
        
        while (!minHeap.isEmpty() && nodesVisited < n) {
            int[] current = minHeap.poll();
            int node = current[0];
            int weight = current[1];
            
            if (visited[node]) {
                continue;
            }
            
            visited[node] = true;
            totalCost += weight;
            nodesVisited++;
            
            // Add all neighbors to heap
            for (int[] neighbor : graph.get(node)) {
                if (!visited[neighbor[0]]) {
                    minHeap.offer(neighbor);
                }
            }
        }
        
        return totalCost;
    }
}

// Alternative approach using optimized Prim's Algorithm
class SolutionPrimOptimized {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        if (n <= 1) {
            return 0;
        }
        
        int[] minDist = new int[n];
        boolean[] visited = new boolean[n];
        
        // Initialize distances
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;
        
        int totalCost = 0;
        
        for (int i = 0; i < n; i++) {
            // Find minimum distance unvisited node
            int minNode = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (minNode == -1 || minDist[j] < minDist[minNode])) {
                    minNode = j;
                }
            }
            
            visited[minNode] = true;
            totalCost += minDist[minNode];
            
            // Update distances to neighbors
            for (int j = 0; j < n; j++) {
                if (!visited[j]) {
                    int dist = Math.abs(points[minNode][0] - points[j][0]) + 
                              Math.abs(points[minNode][1] - points[j][1]);
                    minDist[j] = Math.min(minDist[j], dist);
                }
            }
        }
        
        return totalCost;
    }
}

// Alternative approach using Kruskal's with optimized Union Find
class SolutionKruskalOptimized {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        if (n <= 1) {
            return 0;
        }
        
        // Create edges array
        int[][] edges = new int[n * (n - 1) / 2][3];
        int edgeIndex = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int weight = Math.abs(points[i][0] - points[j][0]) + 
                           Math.abs(points[i][1] - points[j][1]);
                edges[edgeIndex++] = new int[]{i, j, weight};
            }
        }
        
        // Sort edges by weight
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);
        
        // Use Union Find to build MST
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        int totalCost = 0;
        int edgesAdded = 0;
        
        for (int[] edge : edges) {
            int root1 = find(parent, edge[0]);
            int root2 = find(parent, edge[1]);
            
            if (root1 != root2) {
                parent[root1] = root2;
                totalCost += edge[2];
                edgesAdded++;
                
                if (edgesAdded == n - 1) {
                    break;
                }
            }
        }
        
        return totalCost;
    }
    
    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}

// More concise version
class SolutionConcise {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        if (n <= 1) return 0;
        
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int weight = Math.abs(points[i][0] - points[j][0]) + 
                           Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{i, j, weight});
            }
        }
        
        edges.sort((a, b) -> a[2] - b[2]);
        
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        
        int cost = 0, count = 0;
        for (int[] edge : edges) {
            if (find(parent, edge[0]) != find(parent, edge[1])) {
                parent[find(parent, edge[0])] = find(parent, edge[1]);
                cost += edge[2];
                if (++count == n - 1) break;
            }
        }
        
        return cost;
    }
    
    private int find(int[] parent, int x) {
        if (parent[x] != x) parent[x] = find(parent, parent[x]);
        return parent[x];
    }
}
