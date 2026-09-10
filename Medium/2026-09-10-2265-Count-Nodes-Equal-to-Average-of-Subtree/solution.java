class Solution {
    private int count = 0;

    public int averageOfSubtree(TreeNode root) {
        calculateSumAndCount(root);
        return count;
    }

    private int[] calculateSumAndCount(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0}; // sum, count
        }
        
        int[] left = calculateSumAndCount(node.left);
        int[] right = calculateSumAndCount(node.right);
        
        int sum = left[0] + right[0] + node.val;
        int count = left[1] + right[1] + 1;
        
        if (node.val == sum / count) {
            count++;
        }
        
        return new int[]{sum, count};
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}