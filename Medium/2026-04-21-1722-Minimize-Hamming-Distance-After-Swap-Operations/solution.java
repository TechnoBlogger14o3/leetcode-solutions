import java.util.*;

public class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        UnionFind uf = new UnionFind(n);
        
        for (int[] swap : allowedSwaps) {
            uf.union(swap[0], swap[1]);
        }
        
        Map<Integer, List<Integer>> groups = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            groups.putIfAbsent(root, new ArrayList<>());
            groups.get(root).add(source[i]);
        }
        
        int hammingDistance = 0;
        
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            List<Integer> group = groups.get(root);
            if (!group.remove((Integer) target[i])) {
                hammingDistance++;
            }
        }
        
        return hammingDistance;
    }
    
    class UnionFind {
        private int[] parent;
        
        public UnionFind(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }
        
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootY] = rootX;
            }
        }
    }
}