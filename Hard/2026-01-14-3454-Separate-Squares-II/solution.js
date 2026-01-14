class Solution {
    separateSquares(squares) {
        const events = [];
        const areaMap = new Map();

        for (const [x, y, l] of squares) {
            events.push([x, y, y + l, 1]);
            events.push([x + l, y, y + l, -1]);
        }

        events.sort((a, b) => a[0] - b[0] || a[3] - b[3]);

        let totalArea = 0;
        let activeIntervals = [];

        const updateArea = () => {
            let currentArea = 0;
            let lastY = -1;

            for (const [start, end] of activeIntervals) {
                if (lastY < start) {
                    currentArea += end - start;
                    lastY = end;
                } else if (lastY < end) {
                    currentArea += end - lastY;
                    lastY = end;
                }
            }

            return currentArea;
        };

        for (const [x, startY, endY, type] of events) {
            if (type === 1) {
                activeIntervals.push([startY, endY]);
                activeIntervals.sort((a, b) => a[0] - b[0]);
            } else {
                activeIntervals = activeIntervals.filter(interval => !(interval[0] === startY && interval[1] === endY));
            }

            totalArea = updateArea();
        }

        let halfArea = totalArea / 2;
        let currentArea = 0;
        let result = 0;

        for (const [x, startY, endY, type] of events) {
            if (type === 1) {
                activeIntervals.push([startY, endY]);
                activeIntervals.sort((a, b) => a[0] - b[0]);
            } else {
                activeIntervals = activeIntervals.filter(interval => !(interval[0] === startY && interval[1] === endY));
            }

            currentArea = updateArea();

            if (currentArea >= halfArea) {
                result = (startY + endY) / 2;
                break;
            }
        }

        return result;
    }
}