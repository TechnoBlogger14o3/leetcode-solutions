var countWays = function(corridor) {
    const MOD = 1e9 + 7;
    const seats = [...corridor].filter(c => c === 'S').length;

    if (seats % 2 !== 0) return 0; // Must have even number of seats
    if (seats === 0) return 1; // No seats means one way (no sections)

    const halfSeats = seats / 2;
    let ways = 1;
    let plantCount = 0;
    let sections = 0;

    for (let i = 0; i < corridor.length; i++) {
        if (corridor[i] === 'S') {
            sections++;
            if (sections === halfSeats) break; // Stop when we reach half the seats
        } else {
            plantCount++;
        }
    }

    // Count the number of ways to place dividers
    for (let i = 0; i < corridor.length; i++) {
        if (corridor[i] === 'S') {
            if (sections > 0 && sections < halfSeats) {
                ways = (ways * (plantCount + 1)) % MOD; // Multiply by the number of plants + 1
                plantCount = 0; // Reset plant count after placing a divider
            }
            sections--;
        } else {
            plantCount++;
        }
    }

    return ways;
};