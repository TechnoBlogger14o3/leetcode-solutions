import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Solution {
    private Map<String, HashSet<Character>> allowedMap;

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        allowedMap = new HashMap<>();
        for (String pattern : allowed) {
            allowedMap.computeIfAbsent(pattern.substring(0, 2), k -> new HashSet<>()).add(pattern.charAt(2));
        }
        return canBuildPyramid(bottom);
    }

    private boolean canBuildPyramid(String bottom) {
        if (bottom.length() == 1) {
            return true;
        }
        int n = bottom.length();
        StringBuilder nextRow = new StringBuilder();
        boolean canBuild = false;

        for (int i = 0; i < n - 1; i++) {
            String key = bottom.substring(i, i + 2);
            if (!allowedMap.containsKey(key)) {
                return false;
            }
            for (char topBlock : allowedMap.get(key)) {
                nextRow.append(topBlock);
                if (canBuildPyramid(nextRow.toString())) {
                    canBuild = true;
                }
                nextRow.setLength(nextRow.length() - 1); // backtrack
            }
        }
        return canBuild;
    }
}