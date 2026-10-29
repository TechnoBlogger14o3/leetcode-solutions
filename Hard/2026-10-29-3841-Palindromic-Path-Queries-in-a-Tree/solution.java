import java.util.*;

public class Solution {
    private List<List<Integer>> graph;
    private StringBuilder s;
    private int[] parent;
    private int[] depth;
    private int[][] up;
    private int LOG;

    public boolean[] palindromicPaths(int n, int[][] edges, String s, String[] queries) {
        this.s = new StringBuilder(s);
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        LOG = Integer.highestOneBit(n - 1) << 1;
        parent = new int[n];
        depth = new int[n];
        up = new int[n][LOG];
        Arrays.fill(parent, -1);
        dfs(0, -1, 0);

        List<Boolean> result = new ArrayList<>();
        for (String query : queries) {
            String[] parts = query.split(" ");
            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);
                s.setCharAt(u, c);
            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);
                result.add(canFormPalindrome(u, v));
            }
        }
        return result.stream().mapToBoolean(b -> b).toArray();
    }

    private void dfs(int node, int par, int d) {
        parent[node] = par;
        depth[node] = d;
        up[node][0] = par;
        for (int i = 1; i < LOG; i++) {
            if (up[node][i - 1] != -1) {
                up[node][i] = up[up[node][i - 1]][i - 1];
            }
        }
        for (int neighbor : graph.get(node)) {
            if (neighbor != par) {
                dfs(neighbor, node, d + 1);
            }
        }
    }

    private int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }
        for (int i = LOG - 1; i >= 0; i--) {
            if (depth[up[u][i]] >= depth[v]) {
                u = up[u][i];
            }
        }
        if (u == v) return u;
        for (int i = LOG - 1; i >= 0; i--) {
            if (up[u][i] != up[v][i]) {
                u = up[u][i];
                v = up[v][i];
            }
        }
        return parent[u];
    }

    private boolean canFormPalindrome(int u, int v) {
        int lca = lca(u, v);
        Map<Character, Integer> count = new HashMap<>();
        count.put(s.charAt(lca), count.getOrDefault(s.charAt(lca), 0) + 1);
        collectCounts(u, lca, count);
        collectCounts(v, lca, count);
        return canFormPalindrome(count);
    }

    private void collectCounts(int node, int stop, Map<Character, Integer> count) {
        while (node != stop) {
            count.put(s.charAt(node), count.getOrDefault(s.charAt(node), 0) + 1);
            node = parent[node];
        }
    }

    private boolean canFormPalindrome(Map<Character, Integer> count) {
        int oddCount = 0;
        for (int freq : count.values()) {
            if (freq % 2 != 0) oddCount++;
        }
        return oddCount <= 1;
    }
}