/**
 * Time Complexity: O(V + E) - V vertices, E edges
 * Space Complexity: O(V + E) - Adjacency list and queue
 */
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        
        int[] result = new int[numCourses];
        int index = 0;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            result[index++] = current;
            
            for (int neighbor : graph.get(current)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        return index == numCourses ? result : new int[0];
    }
}

// Alternative approach using DFS
class SolutionDFS {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        List<Integer> result = new ArrayList<>();
        
        // DFS from each unvisited vertex
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (hasCycle(graph, state, result, i)) {
                    return new int[0];
                }
            }
        }
        
        // Reverse result to get topological order
        Collections.reverse(result);
        return result.stream().mapToInt(i -> i).toArray();
    }
    
    private boolean hasCycle(List<List<Integer>> graph, int[] state, List<Integer> result, int vertex) {
        state[vertex] = 1; // Mark as visiting
        
        for (int neighbor : graph.get(vertex)) {
            if (state[neighbor] == 1) {
                return true; // Cycle detected
            }
            if (state[neighbor] == 0 && hasCycle(graph, state, result, neighbor)) {
                return true;
            }
        }
        
        state[vertex] = 2; // Mark as visited
        result.add(vertex);
        return false;
    }
}

// Alternative approach using iterative DFS with stack
class SolutionIterative {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        List<Integer> result = new ArrayList<>();
        
        // DFS from each unvisited vertex
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (hasCycleIterative(graph, state, result, i)) {
                    return new int[0];
                }
            }
        }
        
        // Reverse result to get topological order
        Collections.reverse(result);
        return result.stream().mapToInt(j -> j).toArray();
    }
    
    private boolean hasCycleIterative(List<List<Integer>> graph, int[] state, List<Integer> result, int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        
        while (!stack.isEmpty()) {
            int vertex = stack.peek();
            
            if (state[vertex] == 0) {
                state[vertex] = 1; // Mark as visiting
            } else if (state[vertex] == 1) {
                state[vertex] = 2; // Mark as visited
                result.add(vertex);
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

// Alternative approach using two-pass method
class SolutionTwoPass {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // First pass: check if cycle exists
        if (!canFinish(numCourses, prerequisites)) {
            return new int[0];
        }
        
        // Second pass: find topological order
        return findTopologicalOrder(numCourses, prerequisites);
    }
    
    private boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        
        int[] state = new int[numCourses];
        
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
        state[vertex] = 1;
        
        for (int neighbor : graph.get(vertex)) {
            if (state[neighbor] == 1 || (state[neighbor] == 0 && hasCycle(graph, state, neighbor))) {
                return true;
            }
        }
        
        state[vertex] = 2;
        return false;
    }
    
    private int[] findTopologicalOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int[] result = new int[numCourses];
        int index = 0;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            result[index++] = current;
            
            for (int neighbor : graph.get(current)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        return result;
    }
}

// More concise version
class SolutionConcise {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        
        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
            inDegree[p[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }
        
        int[] result = new int[numCourses];
        int index = 0;
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            result[index++] = curr;
            
            for (int neighbor : graph.get(curr)) {
                if (--inDegree[neighbor] == 0) queue.offer(neighbor);
            }
        }
        
        return index == numCourses ? result : new int[0];
    }
}
