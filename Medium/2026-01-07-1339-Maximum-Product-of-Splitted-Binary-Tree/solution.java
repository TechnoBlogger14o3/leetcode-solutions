class Solution {
    private long totalSum = 0;
    private long maxProduct = 0;
    private final int MOD = 1000000007;

    public int maxProduct(TreeNode root) {
        totalSum = calculateSum(root);
        calculateMaxProduct(root);
        return (int) (maxProduct % MOD);
    }

    private long calculateSum(TreeNode node) {
        if (node == null) return 0;
        long leftSum = calculateSum(node.left);
        long rightSum = calculateSum(node.right);
        return node.val + leftSum + rightSum;
    }

    private long calculateMaxProduct(TreeNode node) {
        if (node == null) return 0;
        long leftSum = calculateMaxProduct(node.left);
        long rightSum = calculateMaxProduct(node.right);
        long currentSum = node.val + leftSum + rightSum;

        if (leftSum > 0) {
            maxProduct = Math.max(maxProduct, leftSum * (totalSum - leftSum));
        }
        if (rightSum > 0) {
            maxProduct = Math.max(maxProduct, rightSum * (totalSum - rightSum));
        }
        return currentSum;
    }
}