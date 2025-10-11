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
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }
    
    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        
        // If any subtree is unbalanced, return -1
        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }
        
        // If height difference > 1, return -1
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        
        return 1 + Math.max(leftHeight, rightHeight);
    }
}

// Alternative approach using top-down method
class SolutionTopDown {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        
        return Math.abs(leftHeight - rightHeight) <= 1 && 
               isBalanced(root.left) && 
               isBalanced(root.right);
    }
    
    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        return 1 + Math.max(height(node.left), height(node.right));
    }
}

// Alternative approach using class to hold result
class SolutionClass {
    public boolean isBalanced(TreeNode root) {
        return isBalancedHelper(root).isBalanced;
    }
    
    private Result isBalancedHelper(TreeNode node) {
        if (node == null) {
            return new Result(true, 0);
        }
        
        Result left = isBalancedHelper(node.left);
        Result right = isBalancedHelper(node.right);
        
        boolean isBalanced = left.isBalanced && right.isBalanced && 
                           Math.abs(left.height - right.height) <= 1;
        
        int height = 1 + Math.max(left.height, right.height);
        
        return new Result(isBalanced, height);
    }
    
    private static class Result {
        boolean isBalanced;
        int height;
        
        Result(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
}

// More concise version
class SolutionConcise {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }
    
    private int height(TreeNode node) {
        if (node == null) return 0;
        
        int left = height(node.left);
        int right = height(node.right);
        
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        
        return 1 + Math.max(left, right);
    }
}

// Using array to return multiple values
class SolutionArray {
    public boolean isBalanced(TreeNode root) {
        int[] result = isBalancedHelper(root);
        return result[0] == 1;
    }
    
    // Returns [isBalanced, height]
    private int[] isBalancedHelper(TreeNode node) {
        if (node == null) {
            return new int[]{1, 0};
        }
        
        int[] left = isBalancedHelper(node.left);
        int[] right = isBalancedHelper(node.right);
        
        boolean isBalanced = left[0] == 1 && right[0] == 1 && 
                           Math.abs(left[1] - right[1]) <= 1;
        
        int height = 1 + Math.max(left[1], right[1]);
        
        return new int[]{isBalanced ? 1 : 0, height};
    }
}
