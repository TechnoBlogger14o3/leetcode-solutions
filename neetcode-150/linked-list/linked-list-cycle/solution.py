"""
Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None
"""

"""
Time Complexity: O(n) - Linear time
Space Complexity: O(1) - Only uses constant extra space
"""
class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        if not head or not head.next:
            return False
        
        slow = head
        fast = head
        
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            
            if slow == fast:
                return True
        
        return False

# Alternative approach using set
class SolutionSet:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        visited = set()
        current = head
        
        while current:
            if current in visited:
                return True
            visited.add(current)
            current = current.next
        
        return False

# Alternative approach using marking
class SolutionMarking:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        current = head
        
        while current:
            if current.val == 'VISITED':
                return True
            current.val = 'VISITED'
            current = current.next
        
        return False

# More concise version
class SolutionConcise:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        slow = fast = head
        
        while fast and fast.next:
            slow, fast = slow.next, fast.next.next
            if slow == fast:
                return True
        
        return False

# Using dictionary for visited tracking
class SolutionDict:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        visited = {}
        current = head
        
        while current:
            if current in visited:
                return True
            visited[current] = True
            current = current.next
        
        return False

# Using list for visited tracking (not efficient but simple)
class SolutionList:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        visited = []
        current = head
        
        while current:
            if current in visited:
                return True
            visited.append(current)
            current = current.next
        
        return False

# Using id() for object identity
class SolutionId:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        visited_ids = set()
        current = head
        
        while current:
            node_id = id(current)
            if node_id in visited_ids:
                return True
            visited_ids.add(node_id)
            current = current.next
        
        return False
