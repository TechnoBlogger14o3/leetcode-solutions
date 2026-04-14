var minimumTotalDistance = function(robot, factory) {
    robot.sort((a, b) => a - b);
    factory.sort((a, b) => a[0] - b[0]);
    
    let dp = new Array(factory.length + 1).fill(0).map(() => new Array(robot.length + 1).fill(Infinity));
    dp[0][0] = 0;

    for (let i = 1; i <= factory.length; i++) {
        const [pos, limit] = factory[i - 1];
        for (let j = 0; j <= robot.length; j++) {
            dp[i][j] = dp[i - 1][j]; // not using this factory
            let totalDistance = 0;
            for (let k = 1; k <= limit && j - k >= 0; k++) {
                totalDistance += Math.abs(robot[j - k] - pos);
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k] + totalDistance);
            }
        }
    }
    
    return dp[factory.length][robot.length];
};