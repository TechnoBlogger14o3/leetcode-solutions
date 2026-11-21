import java.util.*;

public class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        
        for (int i = 1; i < n; i++) {
            tree.get(parent[i]).add(i);
        }
        
        int[] answer = new int[n];
        int[] size = new int[n];
        
        // DFS to calculate sizes of subtrees
        dfs(0, tree, size);
        
        // Adjust the tree based on the character conditions
        int[] newParent = new int[n];
        Arrays.fill(newParent, -1);
        newParent[0] = -1; // root
        
        for (int x = 1; x < n; x++) {
            int y = findAncestorWithSameChar(x, parent, s);
            if (y != -1) {
                newParent[x] = y;
            } else {
                newParent[x] = parent[x];
            }
        }
        
        // Calculate the new sizes based on the new parent relationships
        int[] newSize = new int[n];
        for (int i = 0; i < n; i++) {
            if (newParent[i] != -1) {
                newSize[newParent[i]] += size[i];
            }
        }
        
        for (int i = 0; i < n; i++) {
            answer[i] = newSize[i] + 1; // +1 for the node itself
        }
        
        return answer;
    }
    
    private void dfs(int node, List<List<Integer>> tree, int[] size) {
        size[node] = 1; // count itself
        for (int child : tree.get(node)) {
            dfs(child, tree, size);
            size[node] += size[child];
        }
    }
    
    private int findAncestorWithSameChar(int x, int[] parent, String s) {
        while (x != -1) {
            if (s.charAt(x) == s.charAt(x)) {
                return x;
            }
            x = parent[x];
        }
        return -1;
    }
}