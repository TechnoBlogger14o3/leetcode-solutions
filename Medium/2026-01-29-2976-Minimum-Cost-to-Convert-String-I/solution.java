import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        int n = source.length();
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        
        for (int i = 0; i < original.length; i++) {
            graph.putIfAbsent(original[i], new HashMap<>());
            graph.get(original[i]).put(changed[i], Math.min(graph.get(original[i]).getOrDefault(changed[i], Integer.MAX_VALUE), cost[i]));
        }
        
        int totalCost = 0;
        for (int i = 0; i < n; i++) {
            char srcChar = source.charAt(i);
            char tgtChar = target.charAt(i);
            if (srcChar == tgtChar) continue;
            
            if (!graph.containsKey(String.valueOf(srcChar))) {
                return -1;
            }
            
            Map<String, Integer> changes = graph.get(String.valueOf(srcChar));
            if (!changes.containsKey(String.valueOf(tgtChar))) {
                return -1;
            }
            
            totalCost += changes.get(String.valueOf(tgtChar));
        }
        
        return totalCost;
    }
}