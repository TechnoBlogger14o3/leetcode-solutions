/**
 * Time Complexity: O(m) for addWord, O(m*26^k) for search with k dots
 * Space Complexity: O(ALPHABET_SIZE * N * M) - N words, M average length
 */
class WordDictionary {
    private TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
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
    
    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }
    
    private boolean searchHelper(String word, int index, TrieNode node) {
        if (index == word.length()) {
            return node.isEnd;
        }
        
        char c = word.charAt(index);
        
        if (c == '.') {
            // Check all children for wildcard
            for (TrieNode child : node.children) {
                if (child != null && searchHelper(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            // Check specific child
            int childIndex = c - 'a';
            if (node.children[childIndex] == null) {
                return false;
            }
            return searchHelper(word, index + 1, node.children[childIndex]);
        }
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

// Alternative approach using iterative method
class WordDictionaryIterative {
    private TrieNode root;
    
    public WordDictionaryIterative() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
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
    
    public boolean search(String word) {
        Queue<TrieNode> queue = new LinkedList<>();
        queue.offer(root);
        
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int size = queue.size();
            
            for (int j = 0; j < size; j++) {
                TrieNode node = queue.poll();
                
                if (c == '.') {
                    // Add all children for wildcard
                    for (TrieNode child : node.children) {
                        if (child != null) {
                            queue.offer(child);
                        }
                    }
                } else {
                    // Add specific child
                    int index = c - 'a';
                    if (node.children[index] != null) {
                        queue.offer(node.children[index]);
                    }
                }
            }
        }
        
        // Check if any node in queue is end of word
        while (!queue.isEmpty()) {
            if (queue.poll().isEnd) {
                return true;
            }
        }
        
        return false;
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

// More concise version
class WordDictionaryConcise {
    private TrieNode root = new TrieNode();
    
    public void addWord(String word) {
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
    
    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }
    
    private boolean searchHelper(String word, int index, TrieNode node) {
        if (index == word.length()) return node.isEnd;
        
        char c = word.charAt(index);
        
        if (c == '.') {
            for (TrieNode child : node.children) {
                if (child != null && searchHelper(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            int childIndex = c - 'a';
            return node.children[childIndex] != null && 
                   searchHelper(word, index + 1, node.children[childIndex]);
        }
    }
    
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }
}

// Using HashMap for children
class WordDictionaryHashMap {
    private TrieNodeHashMap root;
    
    public WordDictionaryHashMap() {
        root = new TrieNodeHashMap();
    }
    
    public void addWord(String word) {
        TrieNodeHashMap current = root;
        
        for (char c : word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                current.children.put(c, new TrieNodeHashMap());
            }
            
            current = current.children.get(c);
        }
        
        current.isEnd = true;
    }
    
    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }
    
    private boolean searchHelper(String word, int index, TrieNodeHashMap node) {
        if (index == word.length()) {
            return node.isEnd;
        }
        
        char c = word.charAt(index);
        
        if (c == '.') {
            for (TrieNodeHashMap child : node.children.values()) {
                if (searchHelper(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            if (!node.children.containsKey(c)) {
                return false;
            }
            return searchHelper(word, index + 1, node.children.get(c));
        }
    }
    
    private static class TrieNodeHashMap {
        Map<Character, TrieNodeHashMap> children;
        boolean isEnd;
        
        public TrieNodeHashMap() {
            children = new HashMap<>();
            isEnd = false;
        }
    }
}
