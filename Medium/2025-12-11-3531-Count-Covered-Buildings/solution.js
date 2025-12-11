var countCoveredBuildings = function(n, buildings) {
    const buildingSet = new Set(buildings.map(b => b.join(',')));
    let coveredCount = 0;

    for (const [x, y] of buildings) {
        if (
            buildingSet.has(`${x - 1},${y}`) &&
            buildingSet.has(`${x + 1},${y}`) &&
            buildingSet.has(`${x},${y - 1}`) &&
            buildingSet.has(`${x},${y + 1}`)
        ) {
            coveredCount++;
        }
    }

    return coveredCount;
};