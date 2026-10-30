import java.util.*;

class Solution {
    class State {
        int node, cost, count;
        char lastChar;

        State(int node, int cost, int count, char lastChar) {
            this.node = node;
            this.cost = cost;
            this.count = count;
            this.lastChar = lastChar;
        }
    }

    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingInt(s -> s.cost));
        boolean[][][] visited = new boolean[n][k + 1][26]; // visited[node][count][lastChar]
        pq.offer(new State(0, 0, 0, labels.charAt(0)));
        
        while (!pq.isEmpty()) {
            State curr = pq.poll();
            int node = curr.node, cost = curr.cost, count = curr.count;
            char lastChar = curr.lastChar;

            if (node == n - 1) return cost;

            if (visited[node][count][lastChar - 'a']) continue;
            visited[node][count][lastChar - 'a'] = true;

            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0], weight = neighbor[1];
                char nextChar = labels.charAt(nextNode);
                int nextCount = (nextChar == lastChar) ? count + 1 : 1;

                if (nextCount <= k) {
                    pq.offer(new State(nextNode, cost + weight, nextCount, nextChar));
                }
            }
        }
        return -1;
    }
}