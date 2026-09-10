/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val === undefined ? 0 : val)
 *     this.left = (left === undefined ? null : left)
 *     this.right = (right === undefined ? null : right)
 * }
 */

/**
 * @param {TreeNode} root
 * @return {number}
 */
var averageOfSubtree = function(root) {
    let count = 0;

    const dfs = (node) => {
        if (!node) return [0, 0]; // [sum, count]

        const [leftSum, leftCount] = dfs(node.left);
        const [rightSum, rightCount] = dfs(node.right);

        const totalSum = leftSum + rightSum + node.val;
        const totalCount = leftCount + rightCount + 1;
        const average = Math.floor(totalSum / totalCount);

        if (average === node.val) {
            count++;
        }

        return [totalSum, totalCount];
    };

    dfs(root);
    return count;
};