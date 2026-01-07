class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def maxProduct(self, root: TreeNode) -> int:
        MOD = 10**9 + 7
        
        def total_sum(node):
            if not node:
                return 0
            return node.val + total_sum(node.left) + total_sum(node.right)
        
        total = total_sum(root)
        max_product = 0
        
        def find_max_product(node):
            nonlocal max_product
            if not node:
                return 0
            left_sum = find_max_product(node.left)
            right_sum = find_max_product(node.right)
            current_sum = node.val + left_sum + right_sum
            
            if left_sum > 0:
                max_product = max(max_product, left_sum * (total - left_sum))
            if right_sum > 0:
                max_product = max(max_product, right_sum * (total - right_sum))
                
            return current_sum
        
        find_max_product(root)
        return max_product % MOD