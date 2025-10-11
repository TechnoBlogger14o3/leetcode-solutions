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
 * Time Complexity: O(n) - Visit each node once
 * Space Complexity: O(h) - Height of tree (recursion stack)
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        // Recursively invert left and right subtrees
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        
        // Swap children
        root.left = right;
        root.right = left;
        
        return root;
    }
}

// Alternative approach using iterative method with queue
class SolutionIterative {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            
            // Swap children
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            
            // Add children to queue
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        
        return root;
    }
}

// Alternative approach using iterative method with stack
class SolutionStack {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            
            // Swap children
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            
            // Add children to stack
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        
        return root;
    }
}

// More concise version
class SolutionConcise {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        
        root.left = right;
        root.right = left;
        
        return root;
    }
}

// Using pre-order traversal
class SolutionPreOrder {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        // Swap children first
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        // Then recursively invert subtrees
        invertTree(root.left);
        invertTree(root.right);
        
        return root;
    }
}
