/**
 * Time Complexity: O(C) - C total characters
 * Space Complexity: O(1) - At most 26 characters
 */
class Solution {
    public String alienOrder(String[] words) {
        // Build graph from word comparisons
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        
        // Initialize all characters
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                inDegree.putIfAbsent(c, 0);
            }
        }
        
        // Compare adjacent words to build graph
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            
            // Check if word1 is prefix of word2
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return ""; // Invalid input
            }
            
            // Find first different character
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                
                if (c1 != c2) {
                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        inDegree.put(c2, inDegree.get(c2) + 1);
                    }
                    break;
                }
            }
        }
        
        // Topological sort using BFS
        Queue<Character> queue = new LinkedList<>();
        for (char c : inDegree.keySet()) {
            if (inDegree.get(c) == 0) {
                queue.offer(c);
            }
        }
        
        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            char current = queue.poll();
            result.append(current);
            
            for (char neighbor : graph.get(current)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        // Check if all characters are included
        return result.length() == inDegree.size() ? result.toString() : "";
    }
}

// Alternative approach using DFS
class SolutionDFS {
    public String alienOrder(String[] words) {
        // Build graph from word comparisons
        Map<Character, Set<Character>> graph = new HashMap<>();
        Set<Character> allChars = new HashSet<>();
        
        // Initialize all characters
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                allChars.add(c);
            }
        }
        
        // Compare adjacent words to build graph
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            
            // Check if word1 is prefix of word2
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return ""; // Invalid input
            }
            
            // Find first different character
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                
                if (c1 != c2) {
                    graph.get(c1).add(c2);
                    break;
                }
            }
        }
        
        // DFS for topological sort
        Map<Character, Integer> state = new HashMap<>(); // 0: unvisited, 1: visiting, 2: visited
        for (char c : allChars) {
            state.put(c, 0);
        }
        
        List<Character> result = new ArrayList<>();
        
        for (char c : allChars) {
            if (state.get(c) == 0) {
                if (hasCycle(graph, state, result, c)) {
                    return ""; // Cycle detected
                }
            }
        }
        
        // Reverse result to get topological order
        Collections.reverse(result);
        return result.stream().map(String::valueOf).collect(Collectors.joining());
    }
    
    private boolean hasCycle(Map<Character, Set<Character>> graph, 
                            Map<Character, Integer> state, 
                            List<Character> result, char vertex) {
        state.put(vertex, 1); // Mark as visiting
        
        for (char neighbor : graph.get(vertex)) {
            if (state.get(neighbor) == 1) {
                return true; // Cycle detected
            }
            if (state.get(neighbor) == 0 && hasCycle(graph, state, result, neighbor)) {
                return true;
            }
        }
        
        state.put(vertex, 2); // Mark as visited
        result.add(vertex);
        return false;
    }
}

// Alternative approach using iterative DFS
class SolutionIterative {
    public String alienOrder(String[] words) {
        // Build graph from word comparisons
        Map<Character, Set<Character>> graph = new HashMap<>();
        Set<Character> allChars = new HashSet<>();
        
        // Initialize all characters
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                allChars.add(c);
            }
        }
        
        // Compare adjacent words to build graph
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                
                if (c1 != c2) {
                    graph.get(c1).add(c2);
                    break;
                }
            }
        }
        
        // Iterative DFS for topological sort
        Map<Character, Integer> state = new HashMap<>();
        for (char c : allChars) {
            state.put(c, 0);
        }
        
        Stack<Character> stack = new Stack<>();
        List<Character> result = new ArrayList<>();
        
        for (char c : allChars) {
            if (state.get(c) == 0) {
                stack.push(c);
                
                while (!stack.isEmpty()) {
                    char vertex = stack.peek();
                    
                    if (state.get(vertex) == 0) {
                        state.put(vertex, 1);
                    } else if (state.get(vertex) == 1) {
                        state.put(vertex, 2);
                        result.add(vertex);
                        stack.pop();
                        continue;
                    } else {
                        stack.pop();
                        continue;
                    }
                    
                    for (char neighbor : graph.get(vertex)) {
                        if (state.get(neighbor) == 1) {
                            return ""; // Cycle detected
                        }
                        if (state.get(neighbor) == 0) {
                            stack.push(neighbor);
                        }
                    }
                }
            }
        }
        
        Collections.reverse(result);
        return result.stream().map(String::valueOf).collect(Collectors.joining());
    }
}

// More concise version
class SolutionConcise {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                inDegree.putIfAbsent(c, 0);
            }
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            if (w1.length() > w2.length() && w1.startsWith(w2)) return "";
            
            for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
                char c1 = w1.charAt(j), c2 = w2.charAt(j);
                if (c1 != c2) {
                    if (graph.get(c1).add(c2)) inDegree.put(c2, inDegree.get(c2) + 1);
                    break;
                }
            }
        }
        
        Queue<Character> queue = new LinkedList<>();
        for (char c : inDegree.keySet()) {
            if (inDegree.get(c) == 0) queue.offer(c);
        }
        
        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            char curr = queue.poll();
            result.append(curr);
            for (char neighbor : graph.get(curr)) {
                if (inDegree.put(neighbor, inDegree.get(neighbor) - 1) == 1) {
                    queue.offer(neighbor);
                }
            }
        }
        
        return result.length() == inDegree.size() ? result.toString() : "";
    }
}
