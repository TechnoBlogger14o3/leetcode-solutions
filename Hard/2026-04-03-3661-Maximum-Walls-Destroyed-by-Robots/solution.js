var maximumWallsDestroyed = function(robots, distance, walls) {
    const wallSet = new Set(walls);
    const destroyedWalls = new Set();

    const robotData = robots.map((pos, idx) => ({
        pos,
        leftLimit: pos - distance[idx],
        rightLimit: pos + distance[idx]
    }));

    robotData.sort((a, b) => a.pos - b.pos);

    for (const { pos, leftLimit, rightLimit } of robotData) {
        // Check left direction
        for (let wall = leftLimit; wall <= pos; wall++) {
            if (wallSet.has(wall)) {
                destroyedWalls.add(wall);
            }
        }
        
        // Check right direction
        for (let wall = pos + 1; wall <= rightLimit; wall++) {
            if (wallSet.has(wall)) {
                destroyedWalls.add(wall);
            }
        }
    }

    return destroyedWalls.size;
};