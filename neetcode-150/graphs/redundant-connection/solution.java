/**
 * Time Complexity: O(n) - n edges
 * Space Complexity: O(n) - Union Find data structure
 */
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n);
        
        for (int[] edge : edges) {
            int u = edge[0] - 1; // Convert to 0-indexed
            int v = edge[1] - 1;
            
            if (uf.find(u) == uf.find(v)) {
                return edge; // Cycle detected
            }
            
            uf.union(u, v);
        }
        
        return new int[0]; // Should not reach here
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

// Alternative approach using DFS
class SolutionDFS {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            
            // Add edge temporarily
            graph.get(u).add(v);
            graph.get(v).add(u);
            
            // Check if cycle exists
            if (hasCycle(graph, u, -1, new boolean[n])) {
                return edge;
            }
        }
        
        return new int[0];
    }
    
    private boolean hasCycle(List<List<Integer>> graph, int vertex, int parent, boolean[] visited) {
        visited[vertex] = true;
        
        for (int neighbor : graph.get(vertex)) {
            if (neighbor == parent) {
                continue; // Skip parent
            }
            
            if (visited[neighbor] || hasCycle(graph, neighbor, vertex, visited)) {
                return true;
            }
        }
        
        return false;
    }
}

// Alternative approach using BFS
class SolutionBFS {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            
            // Add edge temporarily
            graph.get(u).add(v);
            graph.get(v).add(u);
            
            // Check if cycle exists using BFS
            if (hasCycleBFS(graph, u)) {
                return edge;
            }
        }
        
        return new int[0];
    }
    
    private boolean hasCycleBFS(List<List<Integer>> graph, int start) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.size()];
        
        queue.offer(new int[]{start, -1});
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int vertex = current[0];
            int parent = current[1];
            
            for (int neighbor : graph.get(vertex)) {
                if (neighbor == parent) {
                    continue; // Skip parent
                }
                
                if (visited[neighbor]) {
                    return true; // Cycle detected
                }
                
                visited[neighbor] = true;
                queue.offer(new int[]{neighbor, vertex});
            }
        }
        
        return false;
    }
}

// Alternative approach using iterative DFS with stack
class SolutionIterative {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            
            // Add edge temporarily
            graph.get(u).add(v);
            graph.get(v).add(u);
            
            // Check if cycle exists using iterative DFS
            if (hasCycleIterative(graph, u)) {
                return edge;
            }
        }
        
        return new int[0];
    }
    
    private boolean hasCycleIterative(List<List<Integer>> graph, int start) {
        Stack<int[]> stack = new Stack<>();
        boolean[] visited = new boolean[graph.size()];
        
        stack.push(new int[]{start, -1});
        
        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int vertex = current[0];
            int parent = current[1];
            
            if (visited[vertex]) {
                return true; // Cycle detected
            }
            
            visited[vertex] = true;
            
            for (int neighbor : graph.get(vertex)) {
                if (neighbor == parent) {
                    continue; // Skip parent
                }
                
                stack.push(new int[]{neighbor, vertex});
            }
        }
        
        return false;
    }
}

// More concise version
class SolutionConcise {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        
        for (int[] edge : edges) {
            int u = edge[0] - 1, v = edge[1] - 1;
            
            if (find(parent, u) == find(parent, v)) return edge;
            
            union(parent, u, v);
        }
        
        return new int[0];
    }
    
    private int find(int[] parent, int x) {
        if (parent[x] != x) parent[x] = find(parent, parent[x]);
        return parent[x];
    }
    
    private void union(int[] parent, int x, int y) {
        parent[find(parent, x)] = find(parent, y);
    }
}
