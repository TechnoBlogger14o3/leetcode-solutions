import java.util.Arrays;

class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long totalPower = 0;
        for (int battery : batteries) {
            totalPower += battery;
        }
        
        long left = 1, right = totalPower / n;
        
        while (left < right) {
            long mid = right - (right - left) / 2;
            if (canRunAllComputers(mid, n, batteries)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        
        return left;
    }
    
    private boolean canRunAllComputers(long time, int n, int[] batteries) {
        long total = 0;
        for (int battery : batteries) {
            total += Math.min(battery, time);
        }
        return total >= time * n;
    }
}