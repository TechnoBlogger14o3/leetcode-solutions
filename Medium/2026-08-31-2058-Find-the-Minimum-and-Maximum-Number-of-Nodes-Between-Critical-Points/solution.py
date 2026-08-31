class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def nodesBetweenCriticalPoints(self, head: ListNode) -> List[int]:
        critical_points = []
        index = 0
        prev = head
        curr = head.next
        next_node = curr.next if curr else None
        
        while next_node:
            if (prev.val < curr.val > next_node.val) or (prev.val > curr.val < next_node.val):
                critical_points.append(index + 1)
            index += 1
            prev = curr
            curr = next_node
            next_node = next_node.next
        
        if len(critical_points) < 2:
            return [-1, -1]
        
        min_distance = float('inf')
        max_distance = critical_points[-1] - critical_points[0]
        
        for i in range(1, len(critical_points)):
            min_distance = min(min_distance, critical_points[i] - critical_points[i - 1])
        
        return [min_distance, max_distance]