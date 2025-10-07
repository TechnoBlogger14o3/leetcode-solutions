import java.util.*;

class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        
        Set<Integer> fullLakes = new HashSet<>();
        Queue<Integer> dryDays = new PriorityQueue<>();
        
        for (int i = 0; i < n; i++) {
            if (rains[i] > 0) {
                int lake = rains[i];
                if (fullLakes.contains(lake)) {
                    return new int[0]; // Flood occurs
                }
                fullLakes.add(lake);
                ans[i] = -1; // It rained, no drying
                dryDays.offer(i); // Store the day we can dry this lake
            } else {
                ans[i] = 1; // Default to drying lake 1
            }
            
            // Dry lakes on days where it rained before
            while (!dryDays.isEmpty() && !fullLakes.isEmpty()) {
                int dryDay = dryDays.poll();
                if (ans[dryDay] == 1) {
                    int lakeToDry = fullLakes.iterator().next();
                    fullLakes.remove(lakeToDry);
                    ans[dryDay] = lakeToDry; // Dry this lake
                }
            }
        }
        
        return ans;
    }
}