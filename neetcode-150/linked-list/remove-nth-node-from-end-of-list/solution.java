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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode first = dummy;
        ListNode second = dummy;
        
        // Move first pointer n steps ahead
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        
        // Move both pointers until first reaches end
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        
        // Remove node after second pointer
        second.next = second.next.next;
        
        return dummy.next;
    }
}

// Alternative approach using two passes
class SolutionTwoPass {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // First pass: count total nodes
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        
        // Second pass: remove (count - n)th node
        current = dummy;
        for (int i = 0; i < count - n; i++) {
            current = current.next;
        }
        
        current.next = current.next.next;
        return dummy.next;
    }
}

// Alternative approach without dummy node
class SolutionNoDummy {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        
        // Move first pointer n steps ahead
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        
        // If first is null, remove head
        if (first == null) {
            return head.next;
        }
        
        // Move both pointers until first reaches end
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        
        // Remove node after second pointer
        second.next = second.next.next;
        
        return head;
    }
}

// More concise version
class SolutionConcise {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode first = dummy, second = dummy;
        
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        
        second.next = second.next.next;
        return dummy.next;
    }
}

// Using stack approach
class SolutionStack {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> stack = new Stack<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        
        while (current != null) {
            stack.push(current);
            current = current.next;
        }
        
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        
        return dummy.next;
    }
}
