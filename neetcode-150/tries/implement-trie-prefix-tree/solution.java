/**
 * Time Complexity: O(m) - Length of word/prefix
 * Space Complexity: O(ALPHABET_SIZE * N * M) - N words, M average length
 */
class Trie {
    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
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
        TrieNode current = root;
        
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            
            if (current.children[index] == null) {
                return false;
            }
            
            current = current.children[index];
        }
        
        return current.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            
            if (current.children[index] == null) {
                return false;
            }
            
            current = current.children[index];
        }
        
        return true;
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

// Alternative approach using HashMap
class TrieHashMap {
    private TrieNodeHashMap root;
    
    public TrieHashMap() {
        root = new TrieNodeHashMap();
    }
    
    public void insert(String word) {
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
        TrieNodeHashMap current = root;
        
        for (char c : word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                return false;
            }
            
            current = current.children.get(c);
        }
        
        return current.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNodeHashMap current = root;
        
        for (char c : prefix.toCharArray()) {
            if (!current.children.containsKey(c)) {
                return false;
            }
            
            current = current.children.get(c);
        }
        
        return true;
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

// More concise version
class TrieConcise {
    private TrieNode root = new TrieNode();
    
    public void insert(String word) {
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
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) return false;
            current = current.children[index];
        }
        return current.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) return false;
            current = current.children[index];
        }
        return true;
    }
    
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }
}

// Using ternary operator
class TrieTernary {
    private TrieNode root = new TrieNode();
    
    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            current.children[index] = (current.children[index] == null) ? 
                new TrieNode() : current.children[index];
            current = current.children[index];
        }
        current.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) return false;
            current = current.children[index];
        }
        return current.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) return false;
            current = current.children[index];
        }
        return true;
    }
    
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }
}
