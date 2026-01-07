/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val === undefined ? 0 : val);
 *     this.left = (left === undefined ? null : left);
 *     this.right = (right === undefined ? null : right);
 * }
 */

/**
 * @param {TreeNode} root
 * @return {number}
 */
var maxProduct = function(root) {
    const MOD = 1e9 + 7;
    let totalSum = 0;
    let maxProd = 0;

    const calculateSum = (node) => {
        if (!node) return 0;
        const leftSum = calculateSum(node.left);
        const rightSum = calculateSum(node.right);
        const currentSum = leftSum + rightSum + node.val;
        totalSum += currentSum;
        return currentSum;
    };

    const findMaxProduct = (node) => {
        if (!node) return 0;
        const leftSum = findMaxProduct(node.left);
        const rightSum = findMaxProduct(node.right);
        const currentSum = leftSum + rightSum + node.val;
        const otherSum = totalSum - currentSum;
        maxProd = Math.max(maxProd, currentSum * otherSum);
        return currentSum;
    };

    calculateSum(root);
    findMaxProduct(root);
    
    return maxProd % MOD;
};