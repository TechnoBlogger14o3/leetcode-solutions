class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def deleteNodes(self, head: ListNode, nums: List[int]) -> ListNode:
        nums_set = set(nums)
        dummy = ListNode(0)
        current = dummy
        
        while head:
            if head.val not in nums_set:
                current.next = head
                current = current.next
            head = head.next
        
        current.next = None
        return dummy.next