class TreeNode {
    constructor(val = 0, left = null, right = null) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

var isBalanced = function(root) {
    const checkHeight = (node) => {
        if (!node) return 0;
        
        const leftHeight = checkHeight(node.left);
        if (leftHeight === -1) return -1;
        
        const rightHeight = checkHeight(node.right);
        if (rightHeight === -1) return -1;
        
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        
        return Math.max(leftHeight, rightHeight) + 1;
    };
    
    return checkHeight(root) !== -1;
};