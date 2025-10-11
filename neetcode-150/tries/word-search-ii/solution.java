/**
 * Time Complexity: O(m*n*4^L) - L is max word length
 * Space Complexity: O(W*L) - W words, L average length
 */
class Solution {
    private Set<String> result;
    private TrieNode root;
    
    public List<String> findWords(char[][] board, String[] words) {
        result = new HashSet<>();
        root = new TrieNode();
        
        // Build Trie from all words
        for (String word : words) {
            insert(word);
        }
        
        int m = board.length;
        int n = board[0].length;
        
        // DFS from each cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root, new StringBuilder());
            }
        }
        
        return new ArrayList<>(result);
    }
    
    private void dfs(char[][] board, int row, int col, TrieNode node, StringBuilder path) {
        // Check bounds
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }
        
        char c = board[row][col];
        
        // Check if current character exists in Trie
        if (node.children[c - 'a'] == null) {
            return;
        }
        
        // Mark cell as visited
        board[row][col] = '#';
        
        // Add character to path
        path.append(c);
        
        // Move to next node in Trie
        node = node.children[c - 'a'];
        
        // If current path forms a word, add to result
        if (node.isEnd) {
            result.add(path.toString());
        }
        
        // Explore all four directions
        dfs(board, row + 1, col, node, path);
        dfs(board, row - 1, col, node, path);
        dfs(board, row, col + 1, node, path);
        dfs(board, row, col - 1, node, path);
        
        // Backtrack
        path.deleteCharAt(path.length() - 1);
        board[row][col] = c;
    }
    
    private void insert(String word) {
        TrieNode current = root;
        
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            
            current = current.children[index];
        }
        
        current.isEnd = true;
    }
    
    private static class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        
        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }
}

// Alternative approach using DFS for each word
class SolutionDFS {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        
        for (String word : words) {
            if (exist(board, word)) {
                result.add(word);
            }
        }
        
        return result;
    }
    
    private boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int index, int row, int col) {
        if (index == word.length()) {
            return true;
        }
        
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }
        
        if (board[row][col] != word.charAt(index)) {
            return false;
        }
        
        // Mark cell as visited
        char temp = board[row][col];
        board[row][col] = '#';
        
        // Explore all four directions
        boolean found = dfs(board, word, index + 1, row + 1, col) ||
                       dfs(board, word, index + 1, row - 1, col) ||
                       dfs(board, word, index + 1, row, col + 1) ||
                       dfs(board, word, index + 1, row, col - 1);
        
        // Backtrack
        board[row][col] = temp;
        
        return found;
    }
}

// Optimized version with early termination
class SolutionOptimized {
    private Set<String> result;
    private TrieNode root;
    
    public List<String> findWords(char[][] board, String[] words) {
        result = new HashSet<>();
        root = new TrieNode();
        
        // Build Trie from all words
        for (String word : words) {
            insert(word);
        }
        
        int m = board.length;
        int n = board[0].length;
        
        // DFS from each cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root, new StringBuilder());
            }
        }
        
        return new ArrayList<>(result);
    }
    
    private void dfs(char[][] board, int row, int col, TrieNode node, StringBuilder path) {
        // Check bounds
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }
        
        char c = board[row][col];
        
        // Check if current character exists in Trie
        if (node.children[c - 'a'] == null) {
            return;
        }
        
        // Mark cell as visited
        board[row][col] = '#';
        
        // Add character to path
        path.append(c);
        
        // Move to next node in Trie
        node = node.children[c - 'a'];
        
        // If current path forms a word, add to result
        if (node.isEnd) {
            result.add(path.toString());
            // Remove word from Trie to avoid duplicates
            node.isEnd = false;
        }
        
        // Explore all four directions
        dfs(board, row + 1, col, node, path);
        dfs(board, row - 1, col, node, path);
        dfs(board, row, col + 1, node, path);
        dfs(board, row, col - 1, node, path);
        
        // Backtrack
        path.deleteCharAt(path.length() - 1);
        board[row][col] = c;
    }
    
    private void insert(String word) {
        TrieNode current = root;
        
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            
            current = current.children[index];
        }
        
        current.isEnd = true;
    }
    
    private static class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        
        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }
}
