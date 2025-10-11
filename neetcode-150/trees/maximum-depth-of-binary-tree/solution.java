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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        return 1 + Math.max(leftDepth, rightDepth);
    }
}

// Alternative approach using iterative BFS
class SolutionBFS {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        
        return depth;
    }
}

// Alternative approach using iterative DFS with stack
class SolutionDFS {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> depths = new Stack<>();
        
        stack.push(root);
        depths.push(1);
        
        int maxDepth = 0;
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int currentDepth = depths.pop();
            
            maxDepth = Math.max(maxDepth, currentDepth);
            
            if (node.left != null) {
                stack.push(node.left);
                depths.push(currentDepth + 1);
            }
            if (node.right != null) {
                stack.push(node.right);
                depths.push(currentDepth + 1);
            }
        }
        
        return maxDepth;
    }
}

// More concise version
class SolutionConcise {
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

// Using ternary operator
class SolutionTernary {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        return 1 + Math.max(
            root.left != null ? maxDepth(root.left) : 0,
            root.right != null ? maxDepth(root.right) : 0
        );
    }
}
