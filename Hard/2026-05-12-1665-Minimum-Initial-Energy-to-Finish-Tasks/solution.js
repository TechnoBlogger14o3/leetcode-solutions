var minimumEnergy = function(tasks) {
    tasks.sort((a, b) => b[1] - a[1]);
    let totalEnergy = 0;
    let currentEnergy = 0;

    for (const [actual, minimum] of tasks) {
        if (currentEnergy < minimum) {
            totalEnergy += minimum - currentEnergy;
            currentEnergy = minimum;
        }
        currentEnergy -= actual;
    }

    return totalEnergy;
};