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
    private int maxDiameter = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }
    
    private int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);
        
        // Update maximum diameter
        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);
        
        return 1 + Math.max(leftDepth, rightDepth);
    }
}

// Alternative approach returning both height and diameter
class SolutionReturnBoth {
    public int diameterOfBinaryTree(TreeNode root) {
        return diameterHelper(root)[1];
    }
    
    // Returns [height, diameter]
    private int[] diameterHelper(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        
        int[] left = diameterHelper(node.left);
        int[] right = diameterHelper(node.right);
        
        int height = 1 + Math.max(left[0], right[0]);
        int diameter = Math.max(left[0] + right[0], Math.max(left[1], right[1]));
        
        return new int[]{height, diameter};
    }
}

// Alternative approach using class to hold result
class SolutionClass {
    public int diameterOfBinaryTree(TreeNode root) {
        Result result = diameterHelper(root);
        return result.diameter;
    }
    
    private Result diameterHelper(TreeNode node) {
        if (node == null) {
            return new Result(0, 0);
        }
        
        Result left = diameterHelper(node.left);
        Result right = diameterHelper(node.right);
        
        int height = 1 + Math.max(left.height, right.height);
        int diameter = Math.max(left.height + right.height, Math.max(left.diameter, right.diameter));
        
        return new Result(height, diameter);
    }
    
    private static class Result {
        int height;
        int diameter;
        
        Result(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }
}

// More concise version
class SolutionConcise {
    private int maxDiameter = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }
    
    private int maxDepth(TreeNode node) {
        if (node == null) return 0;
        
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        
        maxDiameter = Math.max(maxDiameter, left + right);
        return 1 + Math.max(left, right);
    }
}

// Using array to return multiple values
class SolutionArray {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] result = diameterHelper(root);
        return result[1];
    }
    
    private int[] diameterHelper(TreeNode node) {
        if (node == null) return new int[]{0, 0};
        
        int[] left = diameterHelper(node.left);
        int[] right = diameterHelper(node.right);
        
        int height = 1 + Math.max(left[0], right[0]);
        int diameter = Math.max(left[0] + right[0], Math.max(left[1], right[1]));
        
        return new int[]{height, diameter};
    }
}
