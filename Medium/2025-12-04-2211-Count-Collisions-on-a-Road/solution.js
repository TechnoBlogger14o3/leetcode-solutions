var countCollisions = function(directions) {
    let collisions = 0;
    let n = directions.length;
    let i = 0;

    while (i < n) {
        if (directions[i] === 'R') {
            let j = i + 1;
            while (j < n && directions[j] === 'S') {
                collisions++;
                j++;
            }
            if (j < n && directions[j] === 'L') {
                collisions += 2; // R and L collide
                i = j + 1; // Move past the collision
            } else {
                i = j; // Move to the next car
            }
        } else if (directions[i] === 'L') {
            // No need to check further as L cars won't collide with anything to the left
            i++;
        } else {
            // If it's 'S', just count it and move on
            i++;
        }
    }

    return collisions;
};