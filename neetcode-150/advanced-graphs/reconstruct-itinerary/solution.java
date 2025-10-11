/**
 * Time Complexity: O(E log E) - E edges, sorting
 * Space Complexity: O(E) - Adjacency list
 */
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        // Build adjacency list with sorted destinations
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
        }
        
        // Sort destinations for lexicographical order
        for (List<String> destinations : graph.values()) {
            Collections.sort(destinations);
        }
        
        List<String> result = new ArrayList<>();
        dfs(graph, "JFK", result);
        
        // Reverse result to get correct order
        Collections.reverse(result);
        return result;
    }
    
    private void dfs(Map<String, List<String>> graph, String current, List<String> result) {
        List<String> destinations = graph.get(current);
        
        while (destinations != null && !destinations.isEmpty()) {
            String next = destinations.remove(0); // Remove first destination
            dfs(graph, next, result);
        }
        
        result.add(current); // Add current airport to result
    }
}

// Alternative approach using backtracking
class SolutionBacktracking {
    public List<String> findItinerary(List<List<String>> tickets) {
        // Build adjacency list
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
        }
        
        // Sort destinations for lexicographical order
        for (List<String> destinations : graph.values()) {
            Collections.sort(destinations);
        }
        
        List<String> path = new ArrayList<>();
        path.add("JFK");
        
        if (dfs(graph, "JFK", path, tickets.size())) {
            return path;
        }
        
        return new ArrayList<>();
    }
    
    private boolean dfs(Map<String, List<String>> graph, String current, List<String> path, int remainingTickets) {
        if (remainingTickets == 0) {
            return true; // All tickets used
        }
        
        List<String> destinations = graph.get(current);
        if (destinations == null || destinations.isEmpty()) {
            return false; // No more destinations
        }
        
        // Try each destination
        for (int i = 0; i < destinations.size(); i++) {
            String next = destinations.remove(i);
            path.add(next);
            
            if (dfs(graph, next, path, remainingTickets - 1)) {
                return true;
            }
            
            // Backtrack
            path.remove(path.size() - 1);
            destinations.add(i, next);
        }
        
        return false;
    }
}

// Alternative approach using iterative DFS with stack
class SolutionIterative {
    public List<String> findItinerary(List<List<String>> tickets) {
        // Build adjacency list with sorted destinations
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
        }
        
        // Sort destinations for lexicographical order
        for (List<String> destinations : graph.values()) {
            Collections.sort(destinations);
        }
        
        Stack<String> stack = new Stack<>();
        List<String> result = new ArrayList<>();
        
        stack.push("JFK");
        
        while (!stack.isEmpty()) {
            String current = stack.peek();
            List<String> destinations = graph.get(current);
            
            if (destinations != null && !destinations.isEmpty()) {
                String next = destinations.remove(0);
                stack.push(next);
            } else {
                result.add(stack.pop());
            }
        }
        
        // Reverse result to get correct order
        Collections.reverse(result);
        return result;
    }
}

// Alternative approach using PriorityQueue
class SolutionPriorityQueue {
    public List<String> findItinerary(List<List<String>> tickets) {
        // Build adjacency list with PriorityQueue for automatic sorting
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.computeIfAbsent(from, k -> new PriorityQueue<>()).offer(to);
        }
        
        List<String> result = new ArrayList<>();
        dfs(graph, "JFK", result);
        
        // Reverse result to get correct order
        Collections.reverse(result);
        return result;
    }
    
    private void dfs(Map<String, PriorityQueue<String>> graph, String current, List<String> result) {
        PriorityQueue<String> destinations = graph.get(current);
        
        while (destinations != null && !destinations.isEmpty()) {
            String next = destinations.poll();
            dfs(graph, next, result);
        }
        
        result.add(current);
    }
}

// More concise version
class SolutionConcise {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            graph.computeIfAbsent(ticket.get(0), k -> new ArrayList<>()).add(ticket.get(1));
        }
        
        for (List<String> destinations : graph.values()) {
            Collections.sort(destinations);
        }
        
        List<String> result = new ArrayList<>();
        dfs(graph, "JFK", result);
        Collections.reverse(result);
        return result;
    }
    
    private void dfs(Map<String, List<String>> graph, String current, List<String> result) {
        List<String> destinations = graph.get(current);
        while (destinations != null && !destinations.isEmpty()) {
            dfs(graph, destinations.remove(0), result);
        }
        result.add(current);
    }
}
