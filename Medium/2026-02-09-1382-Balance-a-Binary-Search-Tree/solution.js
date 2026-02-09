class TreeNode {
    constructor(val, left = null, right = null) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

var balanceBST = function(root) {
    const nodes = [];

    const inorderTraversal = (node) => {
        if (!node) return;
        inorderTraversal(node.left);
        nodes.push(node.val);
        inorderTraversal(node.right);
    };

    inorderTraversal(root);

    const buildBalancedBST = (start, end) => {
        if (start > end) return null;
        const mid = Math.floor((start + end) / 2);
        const node = new TreeNode(nodes[mid]);
        node.left = buildBalancedBST(start, mid - 1);
        node.right = buildBalancedBST(mid + 1, end);
        return node;
    };

    return buildBalancedBST(0, nodes.length - 1);
};