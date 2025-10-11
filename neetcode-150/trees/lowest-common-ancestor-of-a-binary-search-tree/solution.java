/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * Time Complexity: O(h) - Height of tree
 * Space Complexity: O(1) - Only uses constant extra space
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                // Both nodes are in left subtree
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                // Both nodes are in right subtree
                root = root.right;
            } else {
                // Current node is LCA
                return root;
            }
        }
        
        return null;
    }
}

// Alternative approach using recursive method
class SolutionRecursive {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}

// Alternative approach using path finding
class SolutionPathFinding {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = findPath(root, p);
        List<TreeNode> pathQ = findPath(root, q);
        
        TreeNode lca = null;
        int minLength = Math.min(pathP.size(), pathQ.size());
        
        for (int i = 0; i < minLength; i++) {
            if (pathP.get(i) == pathQ.get(i)) {
                lca = pathP.get(i);
            } else {
                break;
            }
        }
        
        return lca;
    }
    
    private List<TreeNode> findPath(TreeNode root, TreeNode target) {
        List<TreeNode> path = new ArrayList<>();
        
        while (root != null) {
            path.add(root);
            
            if (target.val < root.val) {
                root = root.left;
            } else if (target.val > root.val) {
                root = root.right;
            } else {
                break;
            }
        }
        
        return path;
    }
}

// More concise version
class SolutionConcise {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}

// Using ternary operator
class SolutionTernary {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            root = (p.val < root.val && q.val < root.val) ? root.left :
                   (p.val > root.val && q.val > root.val) ? root.right : root;
        }
        return null;
    }
}

// Recursive with ternary operator
class SolutionRecursiveTernary {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return (root == null) ? null :
               (p.val < root.val && q.val < root.val) ? lowestCommonAncestor(root.left, p, q) :
               (p.val > root.val && q.val > root.val) ? lowestCommonAncestor(root.right, p, q) : root;
    }
}
