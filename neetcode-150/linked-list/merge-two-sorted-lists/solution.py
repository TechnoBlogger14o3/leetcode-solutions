"""
Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
"""

"""
Time Complexity: O(m+n) - Process all nodes
Space Complexity: O(1) - Only uses constant extra space
"""
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(0)
        current = dummy
        
        while list1 and list2:
            if list1.val <= list2.val:
                current.next = list1
                list1 = list1.next
            else:
                current.next = list2
                list2 = list2.next
            current = current.next
        
        # Link remaining nodes
        current.next = list1 or list2
        
        return dummy.next

# Alternative approach using recursive method
class SolutionRecursive:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        if not list1:
            return list2
        if not list2:
            return list1
        
        if list1.val <= list2.val:
            list1.next = self.mergeTwoLists(list1.next, list2)
            return list1
        else:
            list2.next = self.mergeTwoLists(list1, list2.next)
            return list2

# Alternative approach without dummy node
class SolutionNoDummy:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        if not list1:
            return list2
        if not list2:
            return list1
        
        head = list1 if list1.val <= list2.val else list2
        current = head
        
        if list1.val <= list2.val:
            list1 = list1.next
        else:
            list2 = list2.next
        
        while list1 and list2:
            if list1.val <= list2.val:
                current.next = list1
                list1 = list1.next
            else:
                current.next = list2
                list2 = list2.next
            current = current.next
        
        current.next = list1 or list2
        return head

# More concise version
class SolutionConcise:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        dummy = current = ListNode(0)
        
        while list1 and list2:
            if list1.val <= list2.val:
                current.next = list1
                list1 = list1.next
            else:
                current.next = list2
                list2 = list2.next
            current = current.next
        
        current.next = list1 or list2
        return dummy.next

# Using ternary operator for cleaner code
class SolutionTernary:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(0)
        current = dummy
        
        while list1 and list2:
            current.next = list1 if list1.val <= list2.val else list2
            if list1.val <= list2.val:
                list1 = list1.next
            else:
                list2 = list2.next
            current = current.next
        
        current.next = list1 or list2
        return dummy.next

# Using list comprehension (not efficient but concise)
class SolutionListComp:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        def to_list(node):
            result = []
            while node:
                result.append(node.val)
                node = node.next
            return result
        
        def to_linked_list(values):
            if not values:
                return None
            head = ListNode(values[0])
            current = head
            for val in values[1:]:
                current.next = ListNode(val)
                current = current.next
            return head
        
        list1_vals = to_list(list1)
        list2_vals = to_list(list2)
        merged_vals = sorted(list1_vals + list2_vals)
        
        return to_linked_list(merged_vals)
