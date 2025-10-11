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
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        // Find meeting point
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                break;
            }
        }
        
        // No cycle found
        if (fast == null || fast.next == null) {
            return null;
        }
        
        // Reset one pointer to head
        slow = head;
        
        // Move both pointers one step until they meet
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
}

// Alternative approach using HashSet
class SolutionHashSet {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        ListNode current = head;
        
        while (current != null) {
            if (visited.contains(current)) {
                return current;
            }
            visited.add(current);
            current = current.next;
        }
        
        return null;
    }
}

// Alternative approach using marking
class SolutionMarking {
    public ListNode detectCycle(ListNode head) {
        ListNode current = head;
        
        while (current != null) {
            if (current.val == Integer.MIN_VALUE) {
                return current;
            }
            current.val = Integer.MIN_VALUE;
            current = current.next;
        }
        
        return null;
    }
}

// More concise version
class SolutionConcise {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        
        // Find meeting point
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        
        if (fast == null || fast.next == null) return null;
        
        // Reset and find cycle start
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
}

// Using bit manipulation for marking
class SolutionBitManipulation {
    public ListNode detectCycle(ListNode head) {
        ListNode current = head;
        
        while (current != null) {
            if (current.val < 0) {
                return current;
            }
            current.val = -current.val;
            current = current.next;
        }
        
        return null;
    }
}
