import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Set<Integer> reserved = new HashSet<>();
        for (int[] seat : reservedSeats) {
            reserved.add(seat[0] * 10 + seat[1]);
        }

        int maxGroups = 0;

        for (int row = 1; row <= n; row++) {
            int available = 0;
            if (!reserved.contains(row * 10 + 2) && !reserved.contains(row * 10 + 3) && 
                !reserved.contains(row * 10 + 4) && !reserved.contains(row * 10 + 5)) {
                available++;
            }
            if (!reserved.contains(row * 10 + 4) && !reserved.contains(row * 10 + 5) && 
                !reserved.contains(row * 10 + 6) && !reserved.contains(row * 10 + 7)) {
                available++;
            }
            if (!reserved.contains(row * 10 + 6) && !reserved.contains(row * 10 + 7) && 
                !reserved.contains(row * 10 + 8) && !reserved.contains(row * 10 + 9)) {
                available++;
            }
            maxGroups += available;
        }

        return maxGroups;
    }
}