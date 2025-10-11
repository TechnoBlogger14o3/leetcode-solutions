"""
Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
"""

"""
Time Complexity: O(n) - Visit each node once
Space Complexity: O(h) - Height of tree (recursion stack)
"""
class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if root is None:
            return None
        
        # Recursively invert left and right subtrees
        left = self.invertTree(root.left)
        right = self.invertTree(root.right)
        
        # Swap children
        root.left = right
        root.right = left
        
        return root

# Alternative approach using iterative method with queue
from collections import deque

class SolutionIterative:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if root is None:
            return None
        
        queue = deque([root])
        
        while queue:
            node = queue.popleft()
            
            # Swap children
            node.left, node.right = node.right, node.left
            
            # Add children to queue
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)
        
        return root

# Alternative approach using iterative method with stack
class SolutionStack:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if root is None:
            return None
        
        stack = [root]
        
        while stack:
            node = stack.pop()
            
            # Swap children
            node.left, node.right = node.right, node.left
            
            # Add children to stack
            if node.left:
                stack.append(node.left)
            if node.right:
                stack.append(node.right)
        
        return root

# More concise version
class SolutionConcise:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root:
            return None
        
        left = self.invertTree(root.left)
        right = self.invertTree(root.right)
        
        root.left = right
        root.right = left
        
        return root

# Using pre-order traversal
class SolutionPreOrder:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if root is None:
            return None
        
        # Swap children first
        root.left, root.right = root.right, root.left
        
        # Then recursively invert subtrees
        self.invertTree(root.left)
        self.invertTree(root.right)
        
        return root

# Using one-liner with tuple unpacking
class SolutionOneLiner:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if root:
            root.left, root.right = self.invertTree(root.right), self.invertTree(root.left)
        return root
