class Solution {
    maxDistance(side, points, k) {
        const manhattanDistance = (p1, p2) => Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);

        const canPlacePoints = (minDist) => {
            let count = 1;
            let lastPlaced = points[0];

            for (let i = 1; i < points.length; i++) {
                if (manhattanDistance(lastPlaced, points[i]) >= minDist) {
                    count++;
                    lastPlaced = points[i];
                    if (count === k) return true;
                }
            }
            return false;
        };

        let left = 0, right = 2 * side;
        let result = 0;

        while (left <= right) {
            const mid = Math.floor((left + right) / 2);
            if (canPlacePoints(mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}