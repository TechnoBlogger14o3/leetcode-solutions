class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Calculate the length of the list
        ListNode current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }

        // Connect the tail to the head to make it circular
        current.next = head;

        // Find the new tail: (length - k % length - 1)th node
        k = k % length;
        int newTailIndex = length - k - 1;
        ListNode newTail = head;
        for (int i = 0; i < newTailIndex; i++) {
            newTail = newTail.next;
        }

        // The new head is the next of the new tail
        ListNode newHead = newTail.next;
        // Break the circular link
        newTail.next = null;

        return newHead;
    }
}