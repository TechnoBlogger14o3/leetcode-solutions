function minimumSeconds(mountainHeight, workerTimes) {
    const n = workerTimes.length;
    let minTime = Infinity;

    for (let i = 0; i < n; i++) {
        let totalTime = 0;
        for (let x = 1; x <= mountainHeight; x++) {
            totalTime += workerTimes[i] * x;
        }
        minTime = Math.min(minTime, totalTime);
    }

    return minTime;
}