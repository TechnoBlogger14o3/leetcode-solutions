function earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration) {
    let minFinishTime = Infinity;

    for (let i = 0; i < landStartTime.length; i++) {
        for (let j = 0; j < waterStartTime.length; j++) {
            // Plan A: Land ride first, then water ride
            const landFinish = Math.max(landStartTime[i], 0) + landDuration[i];
            const waterStartAfterLand = Math.max(waterStartTime[j], landFinish);
            const waterFinish = waterStartAfterLand + waterDuration[j];
            minFinishTime = Math.min(minFinishTime, waterFinish);

            // Plan B: Water ride first, then land ride
            const waterFinishFirst = Math.max(waterStartTime[j], 0) + waterDuration[j];
            const landStartAfterWater = Math.max(landStartTime[i], waterFinishFirst);
            const landFinishAfterWater = landStartAfterWater + landDuration[i];
            minFinishTime = Math.min(minFinishTime, landFinishAfterWater);
        }
    }

    return minFinishTime;
}