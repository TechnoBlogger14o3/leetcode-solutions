/**
 * Time Complexity: O(V + E) - V vertices, E edges
 * Space Complexity: O(V + E) - Adjacency list and recursion stack
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        
        // 0: unvisited, 1: visiting, 2: visited
        int[] state = new int[numCourses];
        
        // DFS from each unvisited vertex
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (hasCycle(graph, state, i)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean hasCycle(List<List<Integer>> graph, int[] state, int vertex) {
        state[vertex] = 1; // Mark as visiting
        
        for (int neighbor : graph.get(vertex)) {
            if (state[neighbor] == 1) {
                return true; // Cycle detected
            }
            if (state[neighbor] == 0 && hasCycle(graph, state, neighbor)) {
                return true;
            }
        }
        
        state[vertex] = 2; // Mark as visited
        return false;
    }
}

// Alternative approach using BFS (Kahn's Algorithm)
class SolutionBFS {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Build adjacency list and calculate in-degree
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }
        
        // BFS starting from vertices with in-degree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int processed = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            processed++;
            
            for (int neighbor : graph.get(current)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        return processed == numCourses;
    }
}

// Alternative approach using iterative DFS with stack
class SolutionIterative {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        
        // 0: unvisited, 1: visiting, 2: visited
        int[] state = new int[numCourses];
        
        // DFS from each unvisited vertex
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (hasCycleIterative(graph, state, i)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean hasCycleIterative(List<List<Integer>> graph, int[] state, int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        
        while (!stack.isEmpty()) {
            int vertex = stack.peek();
            
            if (state[vertex] == 0) {
                state[vertex] = 1; // Mark as visiting
            } else if (state[vertex] == 1) {
                state[vertex] = 2; // Mark as visited
                stack.pop();
                continue;
            } else {
                stack.pop();
                continue;
            }
            
            for (int neighbor : graph.get(vertex)) {
                if (state[neighbor] == 1) {
                    return true; // Cycle detected
                }
                if (state[neighbor] == 0) {
                    stack.push(neighbor);
                }
            }
        }
        
        return false;
    }
}

// Alternative approach using Union Find
class SolutionUnionFind {
    private int[] parent;
    private int[] rank;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        parent = new int[numCourses];
        rank = new int[numCourses];
        
        // Initialize Union Find
        for (int i = 0; i < numCourses; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        
        // Try to union prerequisites
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            
            if (find(course) == find(prereq)) {
                return false; // Cycle detected
            }
            
            union(course, prereq);
        }
        
        return true;
    }
    
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    private void union(int x, int y) {
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

// More concise version
class SolutionConcise {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        
        for (int[] p : prerequisites) graph.get(p[1]).add(p[0]);
        
        int[] state = new int[numCourses]; // 0: unvisited, 1: visiting, 2: visited
        
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0 && hasCycle(graph, state, i)) return false;
        }
        
        return true;
    }
    
    private boolean hasCycle(List<List<Integer>> graph, int[] state, int v) {
        state[v] = 1;
        
        for (int neighbor : graph.get(v)) {
            if (state[neighbor] == 1 || (state[neighbor] == 0 && hasCycle(graph, state, neighbor))) {
                return true;
            }
        }
        
        state[v] = 2;
        return false;
    }
}
