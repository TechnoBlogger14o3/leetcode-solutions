"""
Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
"""

"""
Time Complexity: O(n) - Single pass through list
Space Complexity: O(1) - Only uses constant extra space
"""
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummy = ListNode(0)
        dummy.next = head
        
        first = dummy
        second = dummy
        
        # Move first pointer n steps ahead
        for i in range(n + 1):
            first = first.next
        
        # Move both pointers until first reaches end
        while first:
            first = first.next
            second = second.next
        
        # Remove node after second pointer
        second.next = second.next.next
        
        return dummy.next

# Alternative approach using two passes
class SolutionTwoPass:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummy = ListNode(0)
        dummy.next = head
        
        # First pass: count total nodes
        count = 0
        current = head
        while current:
            count += 1
            current = current.next
        
        # Second pass: remove (count - n)th node
        current = dummy
        for i in range(count - n):
            current = current.next
        
        current.next = current.next.next
        return dummy.next

# Alternative approach without dummy node
class SolutionNoDummy:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        first = head
        second = head
        
        # Move first pointer n steps ahead
        for i in range(n):
            first = first.next
        
        # If first is None, remove head
        if not first:
            return head.next
        
        # Move both pointers until first reaches end
        while first.next:
            first = first.next
            second = second.next
        
        # Remove node after second pointer
        second.next = second.next.next
        
        return head

# More concise version
class SolutionConcise:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummy = ListNode(0)
        dummy.next = head
        
        first = second = dummy
        
        for i in range(n + 1):
            first = first.next
        
        while first:
            first = first.next
            second = second.next
        
        second.next = second.next.next
        return dummy.next

# Using list approach
class SolutionList:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        nodes = []
        current = head
        
        while current:
            nodes.append(current)
            current = current.next
        
        index_to_remove = len(nodes) - n
        
        if index_to_remove == 0:
            return head.next
        
        nodes[index_to_remove - 1].next = nodes[index_to_remove].next
        return head

# Using deque for stack operations
from collections import deque

class SolutionDeque:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        stack = deque()
        dummy = ListNode(0)
        dummy.next = head
        current = dummy
        
        while current:
            stack.append(current)
            current = current.next
        
        for i in range(n):
            stack.pop()
        
        prev = stack[-1]
        prev.next = prev.next.next
        
        return dummy.next
