/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        return sumRootToLeaf(root, 0);
    }
    
    private int sumRootToLeaf(TreeNode node, int currentSum) {
        if (node == null) {
            return 0;
        }
        
        currentSum = (currentSum << 1) | node.val;
        
        if (node.left == null && node.right == null) {
            return currentSum;
        }
        
        return sumRootToLeaf(node.left, currentSum) + sumRootToLeaf(node.right, currentSum);
    }
}