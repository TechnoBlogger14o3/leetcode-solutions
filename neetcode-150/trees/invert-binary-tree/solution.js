/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */

/**
 * Time Complexity: O(n) - Visit each node once
 * Space Complexity: O(h) - Height of tree (recursion stack)
 */
var invertTree = function(root) {
    if (root === null) {
        return null;
    }
    
    // Recursively invert left and right subtrees
    const left = invertTree(root.left);
    const right = invertTree(root.right);
    
    // Swap children
    root.left = right;
    root.right = left;
    
    return root;
};

// Alternative approach using iterative method with queue
var invertTreeIterative = function(root) {
    if (root === null) {
        return null;
    }
    
    const queue = [root];
    
    while (queue.length > 0) {
        const node = queue.shift();
        
        // Swap children
        const temp = node.left;
        node.left = node.right;
        node.right = temp;
        
        // Add children to queue
        if (node.left !== null) {
            queue.push(node.left);
        }
        if (node.right !== null) {
            queue.push(node.right);
        }
    }
    
    return root;
};

// Alternative approach using iterative method with stack
var invertTreeStack = function(root) {
    if (root === null) {
        return null;
    }
    
    const stack = [root];
    
    while (stack.length > 0) {
        const node = stack.pop();
        
        // Swap children
        const temp = node.left;
        node.left = node.right;
        node.right = temp;
        
        // Add children to stack
        if (node.left !== null) {
            stack.push(node.left);
        }
        if (node.right !== null) {
            stack.push(node.right);
        }
    }
    
    return root;
};

// More concise version
var invertTreeConcise = function(root) {
    if (!root) return null;
    
    const left = invertTreeConcise(root.left);
    const right = invertTreeConcise(root.right);
    
    root.left = right;
    root.right = left;
    
    return root;
};

// Using pre-order traversal
var invertTreePreOrder = function(root) {
    if (root === null) {
        return null;
    }
    
    // Swap children first
    const temp = root.left;
    root.left = root.right;
    root.right = temp;
    
    // Then recursively invert subtrees
    invertTreePreOrder(root.left);
    invertTreePreOrder(root.right);
    
    return root;
};

// Using arrow functions
var invertTreeArrow = function(root) {
    if (!root) return null;
    
    [root.left, root.right] = [invertTreeArrow(root.right), invertTreeArrow(root.left)];
    return root;
};
