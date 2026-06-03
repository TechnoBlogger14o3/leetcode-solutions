function earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration) {
    let minFinishTime = Infinity;

    for (let i = 0; i < landStartTime.length; i++) {
        for (let j = 0; j < waterStartTime.length; j++) {
            // Plan A: Land ride first, then water ride
            const landFinishTime = Math.max(landStartTime[i], 0) + landDuration[i];
            const waterStartAfterLand = Math.max(waterStartTime[j], landFinishTime);
            const waterFinishTime = waterStartAfterLand + waterDuration[j];
            minFinishTime = Math.min(minFinishTime, waterFinishTime);

            // Plan B: Water ride first, then land ride
            const waterFinishTimeFirst = Math.max(waterStartTime[j], 0) + waterDuration[j];
            const landStartAfterWater = Math.max(landStartTime[i], waterFinishTimeFirst);
            const landFinishTimeAfterWater = landStartAfterWater + landDuration[i];
            minFinishTime = Math.min(minFinishTime, landFinishTimeAfterWater);
        }
    }

    return minFinishTime;
}