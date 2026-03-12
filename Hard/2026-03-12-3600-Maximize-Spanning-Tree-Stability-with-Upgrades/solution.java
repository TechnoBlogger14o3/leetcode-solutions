import java.util.*;

class Solution {
    public int maximizeStability(int n, int[][] edges, int k) {
        List<int[]> mustEdges = new ArrayList<>();
        List<int[]> optionalEdges = new ArrayList<>();
        
        for (int[] edge : edges) {
            if (edge[3] == 1) {
                mustEdges.add(edge);
            } else {
                optionalEdges.add(edge);
            }
        }
        
        if (!canFormSpanningTree(n, mustEdges)) {
            return -1;
        }
        
        int left = 1, right = 100000, result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canAchieveStability(n, mustEdges, optionalEdges, k, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    private boolean canFormSpanningTree(int n, List<int[]> mustEdges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : mustEdges) {
            uf.union(edge[0], edge[1]);
        }
        return uf.getCount() == 1;
    }
    
    private boolean canAchieveStability(int n, List<int[]> mustEdges, List<int[]> optionalEdges, int k, int minStrength) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : mustEdges) {
            if (edge[2] >= minStrength) {
                uf.union(edge[0], edge[1]);
            }
        }
        
        List<int[]> eligibleEdges = new ArrayList<>();
        for (int[] edge : optionalEdges) {
            if (edge[2] >= minStrength) {
                eligibleEdges.add(edge);
            }
        }
        
        eligibleEdges.sort((a, b) -> Integer.compare(b[2], a[2]));
        
        int upgradesUsed = 0;
        for (int[] edge : eligibleEdges) {
            if (uf.find(edge[0]) != uf.find(edge[1])) {
                uf.union(edge[0], edge[1]);
                upgradesUsed++;
                if (upgradesUsed > k) {
                    break;
                }
            }
        }
        
        return uf.getCount() == 1;
    }
    
    class UnionFind {
        private int[] parent;
        private int[] rank;
        private int count;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            count = size;
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
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
                count--;
            }
        }

        public int getCount() {
            return count;
        }
    }
}