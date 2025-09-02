var countPairs = function(points) {
    let count = 0;
    const n = points.length;

    for (let i = 0; i < n; i++) {
        for (let j = 0; j < n; j++) {
            if (i !== j && points[i][0] < points[j][0] && points[i][1] < points[j][1]) {
                let valid = true;
                for (let k = 0; k < n; k++) {
                    if (k !== i && k !== j) {
                        if (points[k][0] > points[i][0] && points[k][0] < points[j][0] &&
                            points[k][1] > points[i][1] && points[k][1] < points[j][1]) {
                            valid = false;
                            break;
                        }
                    }
                }
                if (valid) count++;
            }
        }
    }
    
    return count;
};