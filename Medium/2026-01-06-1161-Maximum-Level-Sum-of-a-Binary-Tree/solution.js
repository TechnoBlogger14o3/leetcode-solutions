class TreeNode {
    constructor(val, left = null, right = null) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

var maxLevelSum = function(root) {
    if (!root) return 0;

    let queue = [root];
    let maxSum = -Infinity;
    let level = 0;
    let resultLevel = 0;

    while (queue.length > 0) {
        level++;
        let levelSum = 0;
        let levelSize = queue.length;

        for (let i = 0; i < levelSize; i++) {
            let node = queue.shift();
            levelSum += node.val;

            if (node.left) queue.push(node.left);
            if (node.right) queue.push(node.right);
        }

        if (levelSum > maxSum) {
            maxSum = levelSum;
            resultLevel = level;
        }
    }

    return resultLevel;
};