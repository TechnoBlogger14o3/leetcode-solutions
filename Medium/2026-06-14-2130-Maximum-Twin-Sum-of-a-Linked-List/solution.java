class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head;
        // Find the middle of the linked list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse the second half of the linked list
        ListNode prev = null;
        while (slow != null) {
            ListNode nextNode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextNode;
        }
        
        // Calculate the maximum twin sum
        int maxTwinSum = 0;
        ListNode firstHalf = head;
        ListNode secondHalf = prev;
        
        while (secondHalf != null) {
            maxTwinSum = Math.max(maxTwinSum, firstHalf.val + secondHalf.val);
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        
        return maxTwinSum;
    }
}