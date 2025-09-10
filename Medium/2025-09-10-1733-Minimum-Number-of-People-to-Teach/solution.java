import java.util.*;

public class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;
        Set<Integer>[] userLanguages = new HashSet[m];
        for (int i = 0; i < m; i++) {
            userLanguages[i] = new HashSet<>();
            for (int lang : languages[i]) {
                userLanguages[i].add(lang);
            }
        }

        int minTeach = Integer.MAX_VALUE;

        for (int lang = 1; lang <= n; lang++) {
            Set<Integer> usersToTeach = new HashSet<>();
            for (int[] friendship : friendships) {
                int u = friendship[0] - 1;
                int v = friendship[1] - 1;

                boolean uKnows = userLanguages[u].contains(lang);
                boolean vKnows = userLanguages[v].contains(lang);

                if (!uKnows && !vKnows) {
                    usersToTeach.add(u);
                    usersToTeach.add(v);
                } else if (!uKnows) {
                    usersToTeach.add(u);
                } else if (!vKnows) {
                    usersToTeach.add(v);
                }
            }
            minTeach = Math.min(minTeach, usersToTeach.size());
        }

        return minTeach == Integer.MAX_VALUE ? 0 : minTeach;
    }
}