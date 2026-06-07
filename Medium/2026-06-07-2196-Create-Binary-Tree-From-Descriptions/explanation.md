# Create Binary Tree From Descriptions (Medium)

**Problem ID:** 2196  
**Date:** 2026-06-07  
**Link:** https://leetcode.com/problems/create-binary-tree-from-descriptions/

## Approach

To solve the problem of creating a binary tree from the given descriptions, we can follow a systematic approach using a combination of data structures to track parent-child relationships.

### Main Idea:
The goal is to construct a binary tree based on the relationships specified in the `descriptions` array. Each entry in the array indicates a parent-child relationship and whether the child is a left or right child. The key insight is to identify the root of the tree, which is the node that does not appear as a child in any of the descriptions.

### Steps to Approach:
1. **Data Structures**:
   - Use a dictionary (or hashmap) to map each parent node to its corresponding `TreeNode` object. This will allow us to easily access and update the tree structure as we process each description.
   - Maintain a set to keep track of all child nodes. This helps in identifying the root node later, as the root will not be present in this set.

2. **Processing Descriptions**:
   - Iterate through each description in the `descriptions` array.
   - For each entry `[parent, child, isLeft]`:
     - Create or retrieve the `TreeNode` for the `parent`.
     - Create or retrieve the `TreeNode` for the `child`.
     - Depending on the value of `isLeft`, attach the `child` to the left or right of the `parent`.
     - Add the `child` to the set of child nodes.

3. **Identifying the Root**:
   - After processing all descriptions, the root node can be identified as the node that is not present in the set of child nodes. This is because the root has no parent.

4. **Returning the Result**:
   - Finally, return the root node of the constructed binary tree.

### Complexity:
- **Time Complexity**: O(n), where n is the number of descriptions. Each description is processed in constant time.
- **Space Complexity**: O(n) for storing the nodes in the dictionary and the set of child nodes.

This approach efficiently constructs the binary tree while ensuring that we can easily identify the root and maintain the correct parent-child relationships.
