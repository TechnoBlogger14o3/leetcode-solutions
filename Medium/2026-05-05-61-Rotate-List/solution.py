class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def rotateRight(self, head: ListNode, k: int) -> ListNode:
        if not head or not head.next or k == 0:
            return head
        
        # Compute the length of the list
        length = 1
        tail = head
        while tail.next:
            tail = tail.next
            length += 1
        
        # Make the list circular
        tail.next = head
        
        # Find the new tail: (length - k % length - 1)th node
        k = k % length
        new_tail = head
        for _ in range(length - k - 1):
            new_tail = new_tail.next
        
        # Set the new head
        new_head = new_tail.next
        new_tail.next = None
        
        return new_head