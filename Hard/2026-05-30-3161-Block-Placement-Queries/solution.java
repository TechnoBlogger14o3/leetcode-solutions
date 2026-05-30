import java.util.*;

public class Solution {
    public boolean[] blockPlacementQueries(int[][] queries) {
        Set<Integer> obstacles = new HashSet<>();
        List<Boolean> results = new ArrayList<>();

        for (int[] query : queries) {
            if (query[0] == 1) {
                // Type 1 query: Add an obstacle
                obstacles.add(query[1]);
            } else {
                // Type 2 query: Check if block can be placed
                int x = query[1];
                int sz = query[2];
                boolean canPlace = true;

                // Check if there's an obstacle in the range [x - sz + 1, x]
                for (int i = x - sz + 1; i <= x; i++) {
                    if (obstacles.contains(i)) {
                        canPlace = false;
                        break;
                    }
                }
                results.add(canPlace);
            }
        }

        // Convert List<Boolean> to boolean[]
        boolean[] resultArray = new boolean[results.size()];
        for (int i = 0; i < results.size(); i++) {
            resultArray[i] = results.get(i);
        }
        return resultArray;
    }
}