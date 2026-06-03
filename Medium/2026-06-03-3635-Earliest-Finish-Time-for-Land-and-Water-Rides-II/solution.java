class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;
        int earliestFinish = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Plan A: Land ride first, then water ride
                int landFinish = Math.max(landStartTime[i], 0) + landDuration[i];
                int waterStart = Math.max(waterStartTime[j], landFinish);
                int waterFinish = waterStart + waterDuration[j];
                earliestFinish = Math.min(earliestFinish, waterFinish);

                // Plan B: Water ride first, then land ride
                int waterFinishFirst = Math.max(waterStartTime[j], 0) + waterDuration[j];
                int landStart = Math.max(landStartTime[i], waterFinishFirst);
                int landFinishSecond = landStart + landDuration[i];
                earliestFinish = Math.min(earliestFinish, landFinishSecond);
            }
        }

        return earliestFinish;
    }
}