/**
 * Definition for a Node.
 * class Node {
 *     int val;
 *     Node next;
 *     Node random;
 *
 *     public Node(int val) {
 *         this.val = val;
 *         this.next = null;
 *         this.random = null;
 *     }
 * }
 */

/**
 * Time Complexity: O(n) - Two passes through list
 * Space Complexity: O(n) - Store mapping of all nodes
 */
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        
        Map<Node, Node> map = new HashMap<>();
        
        // First pass: create all new nodes
        Node current = head;
        while (current != null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }
        
        // Second pass: set next and random pointers
        current = head;
        while (current != null) {
            Node newNode = map.get(current);
            newNode.next = map.get(current.next);
            newNode.random = map.get(current.random);
            current = current.next;
        }
        
        return map.get(head);
    }
}

// Alternative approach using in-place method
class SolutionInPlace {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        
        // Step 1: Insert new nodes between original nodes
        Node current = head;
        while (current != null) {
            Node newNode = new Node(current.val);
            newNode.next = current.next;
            current.next = newNode;
            current = newNode.next;
        }
        
        // Step 2: Set random pointers
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }
        
        // Step 3: Separate original and copied lists
        Node dummy = new Node(0);
        Node newCurrent = dummy;
        current = head;
        
        while (current != null) {
            newCurrent.next = current.next;
            current.next = current.next.next;
            newCurrent = newCurrent.next;
            current = current.next;
        }
        
        return dummy.next;
    }
}

// Alternative approach using recursive method
class SolutionRecursive {
    private Map<Node, Node> map = new HashMap<>();
    
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        
        if (map.containsKey(head)) {
            return map.get(head);
        }
        
        Node newNode = new Node(head.val);
        map.put(head, newNode);
        
        newNode.next = copyRandomList(head.next);
        newNode.random = copyRandomList(head.random);
        
        return newNode;
    }
}

// More concise version
class SolutionConcise {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        
        Map<Node, Node> map = new HashMap<>();
        
        // Create all new nodes
        Node current = head;
        while (current != null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }
        
        // Set pointers
        current = head;
        while (current != null) {
            Node newNode = map.get(current);
            newNode.next = map.get(current.next);
            newNode.random = map.get(current.random);
            current = current.next;
        }
        
        return map.get(head);
    }
}

// Using ArrayList for mapping
class SolutionArrayList {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        
        List<Node> originalNodes = new ArrayList<>();
        List<Node> newNodes = new ArrayList<>();
        
        Node current = head;
        while (current != null) {
            originalNodes.add(current);
            newNodes.add(new Node(current.val));
            current = current.next;
        }
        
        for (int i = 0; i < originalNodes.size(); i++) {
            Node original = originalNodes.get(i);
            Node newNode = newNodes.get(i);
            
            if (i < originalNodes.size() - 1) {
                newNode.next = newNodes.get(i + 1);
            }
            
            if (original.random != null) {
                int randomIndex = originalNodes.indexOf(original.random);
                newNode.random = newNodes.get(randomIndex);
            }
        }
        
        return newNodes.get(0);
    }
}
