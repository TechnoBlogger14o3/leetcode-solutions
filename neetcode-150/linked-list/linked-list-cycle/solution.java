/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/**
 * Time Complexity: O(n) - Linear time
 * Space Complexity: O(1) - Only uses constant extra space
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                return true;
            }
        }
        
        return false;
    }
}

// Alternative approach using HashSet
class SolutionHashSet {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        ListNode current = head;
        
        while (current != null) {
            if (visited.contains(current)) {
                return true;
            }
            visited.add(current);
            current = current.next;
        }
        
        return false;
    }
}

// Alternative approach using marking
class SolutionMarking {
    public boolean hasCycle(ListNode head) {
        ListNode current = head;
        
        while (current != null) {
            if (current.val == Integer.MIN_VALUE) {
                return true;
            }
            current.val = Integer.MIN_VALUE;
            current = current.next;
        }
        
        return false;
    }
}

// More concise version
class SolutionConcise {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        
        return false;
    }
}

// Using bit manipulation for marking
class SolutionBitManipulation {
    public boolean hasCycle(ListNode head) {
        ListNode current = head;
        
        while (current != null) {
            if (current.val < 0) {
                return true;
            }
            current.val = -current.val;
            current = current.next;
        }
        
        return false;
    }
}
