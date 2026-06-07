class TreeNode {
    constructor(val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

var createBinaryTree = function(descriptions) {
    const map = new Map();
    const hasParent = new Set();

    for (const [parent, child, isLeft] of descriptions) {
        if (!map.has(parent)) {
            map.set(parent, new TreeNode(parent));
        }
        if (!map.has(child)) {
            map.set(child, new TreeNode(child));
        }
        
        if (isLeft === 1) {
            map.get(parent).left = map.get(child);
        } else {
            map.get(parent).right = map.get(child);
        }
        
        hasParent.add(child);
    }

    for (const [parent] of descriptions) {
        if (!hasParent.has(parent)) {
            return map.get(parent);
        }
    }
};