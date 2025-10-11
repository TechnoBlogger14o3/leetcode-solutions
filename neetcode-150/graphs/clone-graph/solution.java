/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

/**
 * Time Complexity: O(n) - Visit each node once
 * Space Complexity: O(n) - HashMap and recursion stack
 */
class Solution {
    private Map<Node, Node> visited = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        
        // If node already cloned, return cloned node
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        
        // Create cloned node
        Node clonedNode = new Node(node.val);
        visited.put(node, clonedNode);
        
        // Clone all neighbors
        for (Node neighbor : node.neighbors) {
            clonedNode.neighbors.add(cloneGraph(neighbor));
        }
        
        return clonedNode;
    }
}

// Alternative approach using BFS
class SolutionBFS {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        
        Map<Node, Node> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        
        // Create cloned node for start node
        Node clonedNode = new Node(node.val);
        visited.put(node, clonedNode);
        queue.offer(node);
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            
            for (Node neighbor : current.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    // Create cloned neighbor
                    Node clonedNeighbor = new Node(neighbor.val);
                    visited.put(neighbor, clonedNeighbor);
                    queue.offer(neighbor);
                }
                
                // Add cloned neighbor to cloned current node
                visited.get(current).neighbors.add(visited.get(neighbor));
            }
        }
        
        return clonedNode;
    }
}

// Alternative approach using iterative DFS with stack
class SolutionIterative {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        
        Map<Node, Node> visited = new HashMap<>();
        Stack<Node> stack = new Stack<>();
        
        // Create cloned node for start node
        Node clonedNode = new Node(node.val);
        visited.put(node, clonedNode);
        stack.push(node);
        
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            
            for (Node neighbor : current.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    // Create cloned neighbor
                    Node clonedNeighbor = new Node(neighbor.val);
                    visited.put(neighbor, clonedNeighbor);
                    stack.push(neighbor);
                }
                
                // Add cloned neighbor to cloned current node
                visited.get(current).neighbors.add(visited.get(neighbor));
            }
        }
        
        return clonedNode;
    }
}

// Alternative approach using two-pass method
class SolutionTwoPass {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        
        Map<Node, Node> visited = new HashMap<>();
        
        // First pass: create all nodes
        dfsCreateNodes(node, visited);
        
        // Second pass: connect neighbors
        dfsConnectNeighbors(node, visited);
        
        return visited.get(node);
    }
    
    private void dfsCreateNodes(Node node, Map<Node, Node> visited) {
        if (visited.containsKey(node)) {
            return;
        }
        
        Node clonedNode = new Node(node.val);
        visited.put(node, clonedNode);
        
        for (Node neighbor : node.neighbors) {
            dfsCreateNodes(neighbor, visited);
        }
    }
    
    private void dfsConnectNeighbors(Node node, Map<Node, Node> visited) {
        Node clonedNode = visited.get(node);
        
        if (clonedNode.neighbors.size() > 0) {
            return; // Already connected
        }
        
        for (Node neighbor : node.neighbors) {
            clonedNode.neighbors.add(visited.get(neighbor));
            dfsConnectNeighbors(neighbor, visited);
        }
    }
}

// More concise version
class SolutionConcise {
    private Map<Node, Node> map = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);
        
        Node cloned = new Node(node.val);
        map.put(node, cloned);
        
        for (Node neighbor : node.neighbors) {
            cloned.neighbors.add(cloneGraph(neighbor));
        }
        
        return cloned;
    }
}

// Using array for visited tracking (if node values are small)
class SolutionArray {
    private Node[] visited = new Node[101]; // Assuming node values are 1-100
    
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (visited[node.val] != null) return visited[node.val];
        
        Node cloned = new Node(node.val);
        visited[node.val] = cloned;
        
        for (Node neighbor : node.neighbors) {
            cloned.neighbors.add(cloneGraph(neighbor));
        }
        
        return cloned;
    }
}
