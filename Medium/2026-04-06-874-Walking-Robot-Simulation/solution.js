var robotSim = function(commands, obstacles) {
    const obstacleSet = new Set(obstacles.map(o => o.join(',')));
    const directions = [[0, 1], [1, 0], [0, -1], [-1, 0]];
    let x = 0, y = 0, dir = 0, maxDistSq = 0;

    for (const command of commands) {
        if (command === -2) {
            dir = (dir + 3) % 4; // Turn left
        } else if (command === -1) {
            dir = (dir + 1) % 4; // Turn right
        } else {
            for (let step = 0; step < command; step++) {
                const newX = x + directions[dir][0];
                const newY = y + directions[dir][1];
                if (!obstacleSet.has(`${newX},${newY}`)) {
                    x = newX;
                    y = newY;
                    maxDistSq = Math.max(maxDistSq, x * x + y * y);
                } else {
                    break; // Stop moving if there's an obstacle
                }
            }
        }
    }

    return maxDistSq;
};