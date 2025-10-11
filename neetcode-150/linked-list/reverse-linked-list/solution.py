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
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        prev = None
        current = head
        
        while current:
            next_node = current.next
            current.next = prev
            prev = current
            current = next_node
        
        return prev

# Alternative approach using recursive method
class SolutionRecursive:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head
        
        new_head = self.reverseList(head.next)
        head.next.next = head
        head.next = None
        
        return new_head

# Alternative approach using stack
class SolutionStack:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return None
        
        stack = []
        current = head
        
        while current:
            stack.append(current)
            current = current.next
        
        new_head = stack.pop()
        current = new_head
        
        while stack:
            current.next = stack.pop()
            current = current.next
        
        current.next = None
        return new_head

# More concise version
class SolutionConcise:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        prev, current = None, head
        
        while current:
            current.next, prev, current = prev, current, current.next
        
        return prev

# Using dummy node approach
class SolutionDummy:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(0)
        current = head
        
        while current:
            next_node = current.next
            current.next = dummy.next
            dummy.next = current
            current = next_node
        
        return dummy.next

# Using list comprehension (not efficient but concise)
class SolutionListComp:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return None
        
        nodes = []
        current = head
        
        while current:
            nodes.append(current)
            current = current.next
        
        for i in range(len(nodes) - 1, 0, -1):
            nodes[i].next = nodes[i - 1]
        
        nodes[0].next = None
        return nodes[-1]

# Using deque for stack operations
from collections import deque

class SolutionDeque:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return None
        
        stack = deque()
        current = head
        
        while current:
            stack.append(current)
            current = current.next
        
        new_head = stack.pop()
        current = new_head
        
        while stack:
            current.next = stack.pop()
            current = current.next
        
        current.next = None
        return new_head
