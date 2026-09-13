var largestOverlap = function(img1, img2) {
    const n = img1.length;
    const countOverlap = (offsetX, offsetY) => {
        let count = 0;
        for (let i = 0; i < n; i++) {
            for (let j = 0; j < n; j++) {
                if (i + offsetX >= 0 && i + offsetX < n && j + offsetY >= 0 && j + offsetY < n) {
                    count += img1[i][j] & img2[i + offsetX][j + offsetY];
                }
            }
        }
        return count;
    };

    let maxOverlap = 0;

    for (let x = -n + 1; x < n; x++) {
        for (let y = -n + 1; y < n; y++) {
            maxOverlap = Math.max(maxOverlap, countOverlap(x, y));
        }
    }

    return maxOverlap;
};