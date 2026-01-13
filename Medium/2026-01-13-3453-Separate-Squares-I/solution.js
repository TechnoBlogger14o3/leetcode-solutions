class Solution {
    minY(squares) {
        const events = [];
        const totalArea = squares.reduce((acc, [x, y, l]) => {
            events.push([x, y, y + l, 1]);
            events.push([x + l, y, y + l, -1]);
            return acc + l * l;
        }, 0);

        events.sort((a, b) => a[0] - b[0] || a[1] - b[1]);

        let currentArea = 0;
        let lastX = events[0][0];
        const heightCount = new Map();

        const addHeight = (y1, y2) => {
            for (let y = y1; y < y2; y++) {
                heightCount.set(y, (heightCount.get(y) || 0) + 1);
            }
        };

        const removeHeight = (y1, y2) => {
            for (let y = y1; y < y2; y++) {
                if (heightCount.has(y)) {
                    heightCount.set(y, heightCount.get(y) - 1);
                    if (heightCount.get(y) === 0) {
                        heightCount.delete(y);
                    }
                }
            }
        };

        for (const [x, y1, y2, type] of events) {
            const width = x - lastX;
            if (width > 0) {
                const heights = Array.from(heightCount.keys()).sort((a, b) => a - b);
                let areaAbove = 0;
                let areaBelow = 0;
                let lastHeight = 0;

                for (const height of heights) {
                    const heightWidth = height - lastHeight;
                    if (heightWidth > 0) {
                        areaBelow += heightWidth * width;
                    }
                    lastHeight = height;
                }

                areaAbove = totalArea - areaBelow;

                if (Math.abs(areaAbove - areaBelow) < 1e-5) {
                    return (areaAbove + areaBelow) / (2 * width);
                }
            }

            if (type === 1) {
                addHeight(y1, y2);
            } else {
                removeHeight(y1, y2);
            }

            lastX = x;
        }

        return -1; // Should not reach here
    }
}