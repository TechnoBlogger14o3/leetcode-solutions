import java.util.*;

public class Solution {
    private static final int MOD = 1_000_000_007;

    public int[] numberOfWays(int[][] edges, int[][] queries) {
        int n = edges.length + 1;
        List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            graph.get(edge[0] - 1).add(edge[1] - 1);
            graph.get(edge[1] - 1).add(edge[0] - 1);
        }

        int[] parent = new int[n];
        int[] depth = new int[n];
        Arrays.fill(parent, -1);
        dfs(0, -1, 0, graph, parent, depth);

        Map<Integer, Map<Integer, Integer>> lcaMap = new HashMap<>();
        for (int[] query : queries) {
            int u = query[0] - 1;
            int v = query[1] - 1;
            int lca = lca(u, v, parent, depth);
            int pathLength = depth[u] + depth[v] - 2 * depth[lca];
            lcaMap.computeIfAbsent(u, k -> new HashMap<>()).put(v, pathLength);
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0] - 1;
            int v = queries[i][1] - 1;
            int pathLength = lcaMap.get(u).get(v);
            result[i] = (pathLength % 2 == 0) ? 0 : modPow(2, pathLength - 1, MOD);
        }
        
        return result;
    }

    private void dfs(int node, int par, int d, List<List<Integer>> graph, int[] parent, int[] depth) {
        parent[node] = par;
        depth[node] = d;
        for (int neighbor : graph.get(node)) {
            if (neighbor != par) {
                dfs(neighbor, node, d + 1, graph, parent, depth);
            }
        }
    }

    private int lca(int u, int v, int[] parent, int[] depth) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }
        while (depth[u] > depth[v]) {
            u = parent[u];
        }
        while (u != v) {
            u = parent[u];
            v = parent[v];
        }
        return u;
    }

    private int modPow(int base, int exp, int mod) {
        long result = 1;
        long b = base;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * b) % mod;
            }
            b = (b * b) % mod;
            exp >>= 1;
        }
        return (int) result;
    }
}