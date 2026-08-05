import java.util.*;

public class Solution {
    public List<Integer> removeMethods(int n, int k, int[][] invocations) {
        Set<Integer> suspicious = new HashSet<>();
        Set<Integer> invokedByOthers = new HashSet<>();
        
        // Find all suspicious methods
        Queue<Integer> queue = new LinkedList<>();
        queue.add(k);
        while (!queue.isEmpty()) {
            int method = queue.poll();
            if (!suspicious.contains(method)) {
                suspicious.add(method);
                for (int[] invocation : invocations) {
                    if (invocation[0] == method) {
                        queue.add(invocation[1]);
                    }
                }
            }
        }
        
        // Find methods that are invoked by suspicious methods
        for (int[] invocation : invocations) {
            if (suspicious.contains(invocation[1])) {
                invokedByOthers.add(invocation[0]);
            }
        }
        
        // Prepare the result
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!suspicious.contains(i) && !invokedByOthers.contains(i)) {
                result.add(i);
            }
        }
        
        // If we have any suspicious methods that are invoked by others, return empty
        if (!result.isEmpty() || invokedByOthers.isEmpty()) {
            return result;
        }
        
        return new ArrayList<>();
    }
}