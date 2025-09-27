var largestTriangleArea = function(points) {
    let maxArea = 0;

    const area = (x1, y1, x2, y2, x3, y3) => Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2);

    for (let i = 0; i < points.length; i++) {
        for (let j = i + 1; j < points.length; j++) {
            for (let k = j + 1; k < points.length; k++) {
                const a = area(points[i][0], points[i][1], points[j][0], points[j][1], points[k][0], points[k][1]);
                maxArea = Math.max(maxArea, a);
            }
        }
    }

    return maxArea;
};