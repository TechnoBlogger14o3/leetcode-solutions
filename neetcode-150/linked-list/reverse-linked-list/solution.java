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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
}

// Alternative approach using recursive method
class SolutionRecursive {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        
        return newHead;
    }
}

// Alternative approach using stack
class SolutionStack {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        
        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;
        
        while (current != null) {
            stack.push(current);
            current = current.next;
        }
        
        ListNode newHead = stack.pop();
        current = newHead;
        
        while (!stack.isEmpty()) {
            current.next = stack.pop();
            current = current.next;
        }
        
        current.next = null;
        return newHead;
    }
}

// More concise version
class SolutionConcise {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, current = head;
        
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
}

// Using dummy node approach
class SolutionDummy {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode current = head;
        
        while (current != null) {
            ListNode next = current.next;
            current.next = dummy.next;
            dummy.next = current;
            current = next;
        }
        
        return dummy.next;
    }
}
