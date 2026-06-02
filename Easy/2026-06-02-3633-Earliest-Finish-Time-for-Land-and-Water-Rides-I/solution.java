class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int earliestFinish = Integer.MAX_VALUE;

        for (int i = 0; i < landStartTime.length; i++) {
            for (int j = 0; j < waterStartTime.length; j++) {
                // Plan A: Land ride first, then water ride
                int landFinish = Math.max(landStartTime[i], 0) + landDuration[i];
                int waterStartAfterLand = Math.max(waterStartTime[j], landFinish);
                int waterFinish = waterStartAfterLand + waterDuration[j];
                earliestFinish = Math.min(earliestFinish, waterFinish);

                // Plan B: Water ride first, then land ride
                int waterFinishFirst = Math.max(waterStartTime[j], 0) + waterDuration[j];
                int landStartAfterWater = Math.max(landStartTime[i], waterFinishFirst);
                int landFinishAfterWater = landStartAfterWater + landDuration[i];
                earliestFinish = Math.min(earliestFinish, landFinishAfterWater);
            }
        }

        return earliestFinish;
    }
}