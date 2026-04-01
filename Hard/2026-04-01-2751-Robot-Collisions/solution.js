var surviveRobots = function(positions, healths, directions) {
    const robots = positions.map((pos, i) => ({ pos, health: healths[i], dir: directions[i] }));
    robots.sort((a, b) => a.pos - b.pos);
    
    const stack = [];
    
    for (const robot of robots) {
        while (stack.length && robot.dir === 'L' && stack[stack.length - 1].dir === 'R') {
            const top = stack.pop();
            if (top.health > robot.health) {
                robot.health--;
            } else if (top.health < robot.health) {
                continue;
            }
        }
        if (robot.health > 0) {
            stack.push(robot);
        }
    }
    
    return stack.map(robot => robot.health);
};