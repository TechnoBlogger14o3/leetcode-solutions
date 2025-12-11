import java.util.HashSet;
import java.util.Set;

class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Set<String> buildingSet = new HashSet<>();
        for (int[] building : buildings) {
            buildingSet.add(building[0] + "," + building[1]);
        }

        int coveredCount = 0;

        for (int[] building : buildings) {
            int x = building[0];
            int y = building[1];
            if (buildingSet.contains(x - 1 + "," + y) && 
                buildingSet.contains(x + 1 + "," + y) && 
                buildingSet.contains(x + "," + (y - 1)) && 
                buildingSet.contains(x + "," + (y + 1))) {
                coveredCount++;
            }
        }

        return coveredCount;
    }
}