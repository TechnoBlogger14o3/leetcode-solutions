var countWays = function(points) {
    const n = points.length;
    let count = 0;

    // Sort points by x-coordinate, then by y-coordinate
    points.sort((a, b) => a[0] - b[0] || a[1] - b[1]);

    for (let i = 0; i < n; i++) {
        for (let j = i + 1; j < n; j++) {
            const [x1, y1] = points[i];
            const [x2, y2] = points[j];

            // Check if points[i] can be the upper left corner and points[j] the lower right corner
            if (x1 < x2 && y1 > y2) {
                let valid = true;

                // Check if any point is inside or on the fence
                for (let k = 0; k < n; k++) {
                    if (k !== i && k !== j) {
                        const [x, y] = points[k];
                        if (x1 < x && x < x2 && y2 < y && y < y1) {
                            valid = false;
                            break;
                        }
                    }
                }

                if (valid) {
                    count++;
                }
            }
        }
    }

    return count;
};