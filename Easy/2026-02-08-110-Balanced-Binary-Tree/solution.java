class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int leftHeight = height(node.left);
        if (leftHeight == -1) return -1;

        int rightHeight = height(node.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}