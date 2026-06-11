import java.util.*;

public class Solution {
    private static final int MOD = 1000000007;

    public int numberOfWays(int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            graph.get(edge[0] - 1).add(edge[1] - 1);
            graph.get(edge[1] - 1).add(edge[0] - 1);
        }
        
        int[] maxDepth = new int[1];
        List<Integer> deepestNodes = new ArrayList<>();
        dfs(graph, 0, -1, 0, maxDepth, deepestNodes);
        
        int depth = maxDepth[0];
        int count = 0;
        
        for (int node : deepestNodes) {
            int edgesCount = getEdgesCount(graph, node, 0, -1);
            if (edgesCount % 2 == 0) {
                count = (count + modPow(2, edgesCount - 1)) % MOD;
            }
        }
        
        return count;
    }

    private void dfs(List<List<Integer>> graph, int node, int parent, int depth, int[] maxDepth, List<Integer> deepestNodes) {
        if (depth > maxDepth[0]) {
            maxDepth[0] = depth;
            deepestNodes.clear();
            deepestNodes.add(node);
        } else if (depth == maxDepth[0]) {
            deepestNodes.add(node);
        }
        
        for (int neighbor : graph.get(node)) {
            if (neighbor != parent) {
                dfs(graph, neighbor, node, depth + 1, maxDepth, deepestNodes);
            }
        }
    }

    private int getEdgesCount(List<List<Integer>> graph, int node, int parent, int depth) {
        int count = 0;
        for (int neighbor : graph.get(node)) {
            if (neighbor != parent) {
                count++;
                count += getEdgesCount(graph, neighbor, node, depth + 1);
            }
        }
        return count;
    }

    private long modPow(long base, long exp) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return result;
    }
}