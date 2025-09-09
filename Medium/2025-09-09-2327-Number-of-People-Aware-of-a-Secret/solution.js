var peopleAwareOfSecret = function(n, delay, forget) {
    const MOD = 1e9 + 7;
    const dp = new Array(n + 1).fill(0);
    dp[1] = 1;

    for (let day = 2; day <= n; day++) {
        for (let j = Math.max(1, day - forget + 1); j < day - delay + 1; j++) {
            dp[day] = (dp[day] + dp[j]) % MOD;
        }
    }

    let result = 0;
    for (let day = n - forget + 1; day <= n; day++) {
        result = (result + dp[day]) % MOD;
    }

    return result;
};