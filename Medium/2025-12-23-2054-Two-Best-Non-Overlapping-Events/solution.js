var maxTwoEvents = function(events) {
    events.sort((a, b) => a[1] - b[1]);
    const n = events.length;
    let maxValue = 0;
    let maxSingleValue = 0;
    const dp = new Array(n).fill(0);

    for (let i = 0; i < n; i++) {
        dp[i] = events[i][2];
        maxSingleValue = Math.max(maxSingleValue, dp[i]);
        for (let j = 0; j < i; j++) {
            if (events[j][1] < events[i][0]) {
                dp[i] = Math.max(dp[i], dp[j] + events[i][2]);
            }
        }
        maxValue = Math.max(maxValue, dp[i]);
    }

    return Math.max(maxValue, maxSingleValue);
};