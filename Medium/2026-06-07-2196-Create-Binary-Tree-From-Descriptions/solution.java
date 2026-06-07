import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Set<Integer> childNodes = new HashSet<>();
        
        for (int[] desc : descriptions) {
            int parentVal = desc[0];
            int childVal = desc[1];
            int isLeft = desc[2];
            
            TreeNode parentNode = nodeMap.getOrDefault(parentVal, new TreeNode(parentVal));
            TreeNode childNode = nodeMap.getOrDefault(childVal, new TreeNode(childVal));
            
            if (isLeft == 1) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }
            
            nodeMap.put(parentVal, parentNode);
            nodeMap.put(childVal, childNode);
            childNodes.add(childVal);
        }
        
        for (int key : nodeMap.keySet()) {
            if (!childNodes.contains(key)) {
                return nodeMap.get(key);
            }
        }
        
        return null; // This line should never be reached if the input is valid
    }
}