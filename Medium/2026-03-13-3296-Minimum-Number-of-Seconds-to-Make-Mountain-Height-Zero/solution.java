class Solution {
    public int minimumSeconds(int mountainHeight, int[] workerTimes) {
        int n = workerTimes.length;
        int[] timeNeeded = new int[n];
        
        for (int i = 0; i < n; i++) {
            timeNeeded[i] = workerTimes[i] * mountainHeight * (mountainHeight + 1) / 2;
        }
        
        int maxTime = 0;
        for (int time : timeNeeded) {
            maxTime = Math.max(maxTime, time);
        }
        
        return maxTime;
    }
}