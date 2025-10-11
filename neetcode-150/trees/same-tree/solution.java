/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/**
 * Time Complexity: O(min(m,n)) - Visit each node once
 * Space Complexity: O(min(m,n)) - Height of smaller tree
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Both null
        if (p == null && q == null) {
            return true;
        }
        
        // One null, other not
        if (p == null || q == null) {
            return false;
        }
        
        // Values different
        if (p.val != q.val) {
            return false;
        }
        
        // Recursively check left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

// Alternative approach using iterative BFS
class SolutionBFS {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.offer(new TreeNode[]{p, q});
        
        while (!queue.isEmpty()) {
            TreeNode[] nodes = queue.poll();
            TreeNode node1 = nodes[0];
            TreeNode node2 = nodes[1];
            
            // Both null
            if (node1 == null && node2 == null) {
                continue;
            }
            
            // One null, other not
            if (node1 == null || node2 == null) {
                return false;
            }
            
            // Values different
            if (node1.val != node2.val) {
                return false;
            }
            
            // Add children to queue
            queue.offer(new TreeNode[]{node1.left, node2.left});
            queue.offer(new TreeNode[]{node1.right, node2.right});
        }
        
        return true;
    }
}

// Alternative approach using iterative DFS with stack
class SolutionDFS {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{p, q});
        
        while (!stack.isEmpty()) {
            TreeNode[] nodes = stack.pop();
            TreeNode node1 = nodes[0];
            TreeNode node2 = nodes[1];
            
            // Both null
            if (node1 == null && node2 == null) {
                continue;
            }
            
            // One null, other not
            if (node1 == null || node2 == null) {
                return false;
            }
            
            // Values different
            if (node1.val != node2.val) {
                return false;
            }
            
            // Add children to stack
            stack.push(new TreeNode[]{node1.left, node2.left});
            stack.push(new TreeNode[]{node1.right, node2.right});
        }
        
        return true;
    }
}

// More concise version
class SolutionConcise {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

// Using ternary operator
class SolutionTernary {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return (p == null && q == null) || 
               (p != null && q != null && 
                p.val == q.val && 
                isSameTree(p.left, q.left) && 
                isSameTree(p.right, q.right));
    }
}
