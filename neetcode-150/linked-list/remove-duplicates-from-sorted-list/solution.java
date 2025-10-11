/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/**
 * Time Complexity: O(n) - Single pass through list
 * Space Complexity: O(1) - Only uses constant extra space
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        
        return head;
    }
}

// Alternative approach using recursive method
class SolutionRecursive {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        if (head.val == head.next.val) {
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }
}

// Alternative approach using dummy node
class SolutionDummy {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        
        while (current.next != null && current.next.next != null) {
            if (current.next.val == current.next.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        
        return dummy.next;
    }
}

// More concise version
class SolutionConcise {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        
        return head;
    }
}

// Using HashSet approach (not efficient for sorted list)
class SolutionHashSet {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        
        Set<Integer> seen = new HashSet<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        
        while (current.next != null) {
            if (seen.contains(current.next.val)) {
                current.next = current.next.next;
            } else {
                seen.add(current.next.val);
                current = current.next;
            }
        }
        
        return dummy.next;
    }
}
