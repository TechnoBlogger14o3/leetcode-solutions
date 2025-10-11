/**
 * Time Complexity: O(n + m) - n nodes, m edges
 * Space Complexity: O(n) - Union Find data structure
 */
class Solution {
    public boolean validTree(int n, int[][] edges) {
        // Tree must have exactly n-1 edges
        if (edges.length != n - 1) {
            return false;
        }
        
        UnionFind uf = new UnionFind(n);
        
        // Check for cycles and connectivity
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            if (uf.find(u) == uf.find(v)) {
                return false; // Cycle detected
            }
            
            uf.union(u, v);
        }
        
        // Check if all nodes are connected
        return uf.getComponentCount() == 1;
    }
    
    private static class UnionFind {
        private int[] parent;
        private int[] rank;
        private int componentCount;
        
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            componentCount = n; // Initially, each node is its own component
            
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
                componentCount--; // Decrease component count when merging
            }
        }
        
        public int getComponentCount() {
            return componentCount;
        }
    }
}

// Alternative approach using DFS
class SolutionDFS {
    public boolean validTree(int n, int[][] edges) {
        // Tree must have exactly n-1 edges
        if (edges.length != n - 1) {
            return false;
        }
        
        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        // Check for cycles and connectivity
        boolean[] visited = new boolean[n];
        
        // Check for cycles
        if (hasCycle(graph, visited, 0, -1)) {
            return false;
        }
        
        // Check if all nodes are visited
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean hasCycle(List<List<Integer>> graph, boolean[] visited, int vertex, int parent) {
        visited[vertex] = true;
        
        for (int neighbor : graph.get(vertex)) {
            if (neighbor == parent) {
                continue; // Skip parent
            }
            
            if (visited[neighbor] || hasCycle(graph, visited, neighbor, vertex)) {
                return true;
            }
        }
        
        return false;
    }
}

// Alternative approach using BFS
class SolutionBFS {
    public boolean validTree(int n, int[][] edges) {
        // Tree must have exactly n-1 edges
        if (edges.length != n - 1) {
            return false;
        }
        
        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        // Check for cycles and connectivity using BFS
        boolean[] visited = new boolean[n];
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{0, -1});
        visited[0] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int vertex = current[0];
            int parent = current[1];
            
            for (int neighbor : graph.get(vertex)) {
                if (neighbor == parent) {
                    continue; // Skip parent
                }
                
                if (visited[neighbor]) {
                    return false; // Cycle detected
                }
                
                visited[neighbor] = true;
                queue.offer(new int[]{neighbor, vertex});
            }
        }
        
        // Check if all nodes are visited
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        
        return true;
    }
}

// Alternative approach using iterative DFS with stack
class SolutionIterative {
    public boolean validTree(int n, int[][] edges) {
        // Tree must have exactly n-1 edges
        if (edges.length != n - 1) {
            return false;
        }
        
        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        // Check for cycles and connectivity using iterative DFS
        boolean[] visited = new boolean[n];
        Stack<int[]> stack = new Stack<>();
        
        stack.push(new int[]{0, -1});
        
        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int vertex = current[0];
            int parent = current[1];
            
            if (visited[vertex]) {
                return false; // Cycle detected
            }
            
            visited[vertex] = true;
            
            for (int neighbor : graph.get(vertex)) {
                if (neighbor == parent) {
                    continue; // Skip parent
                }
                
                stack.push(new int[]{neighbor, vertex});
            }
        }
        
        // Check if all nodes are visited
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        
        return true;
    }
}

// More concise version
class SolutionConcise {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        
        int components = n;
        
        for (int[] edge : edges) {
            int root1 = find(parent, edge[0]);
            int root2 = find(parent, edge[1]);
            
            if (root1 == root2) return false; // Cycle detected
            
            parent[root1] = root2;
            components--;
        }
        
        return components == 1; // All nodes connected
    }
    
    private int find(int[] parent, int x) {
        if (parent[x] != x) parent[x] = find(parent, parent[x]);
        return parent[x];
    }
}
