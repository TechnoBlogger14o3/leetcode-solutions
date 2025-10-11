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
 * Time Complexity: O(n) - Three passes through list
 * Space Complexity: O(1) - Only uses constant extra space
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        
        // Step 1: Find middle
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Step 2: Reverse second half
        ListNode second = reverseList(slow.next);
        slow.next = null;
        
        // Step 3: Merge two halves
        ListNode first = head;
        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            
            first.next = second;
            second.next = temp1;
            
            first = temp1;
            second = temp2;
        }
    }
    
    private ListNode reverseList(ListNode head) {
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

// Alternative approach using array
class SolutionArray {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        
        List<ListNode> nodes = new ArrayList<>();
        ListNode current = head;
        
        while (current != null) {
            nodes.add(current);
            current = current.next;
        }
        
        int left = 0;
        int right = nodes.size() - 1;
        
        while (left < right) {
            nodes.get(left).next = nodes.get(right);
            left++;
            
            if (left < right) {
                nodes.get(right).next = nodes.get(left);
                right--;
            }
        }
        
        nodes.get(left).next = null;
    }
}

// Alternative approach using stack
class SolutionStack {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        
        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;
        
        while (current != null) {
            stack.push(current);
            current = current.next;
        }
        
        current = head;
        int count = stack.size();
        
        for (int i = 0; i < count / 2; i++) {
            ListNode next = current.next;
            ListNode last = stack.pop();
            
            current.next = last;
            last.next = next;
            current = next;
        }
        
        current.next = null;
    }
}

// More concise version
class SolutionConcise {
    public void reorderList(ListNode head) {
        if (!head || !head.next) return;
        
        // Find middle
        ListNode slow = head, fast = head;
        while (fast.next && fast.next.next) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse second half
        ListNode second = reverse(slow.next);
        slow.next = null;
        
        // Merge
        ListNode first = head;
        while (second) {
            ListNode temp1 = first.next, temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null, current = head;
        while (current) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
