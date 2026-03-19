class Solution {
    countSubmatrices(grid) {
        const m = grid.length;
        const n = grid[0].length;
        let count = 0;

        for (let top = 0; top < m; top++) {
            const freq = new Map();

            for (let bottom = top; bottom < m; bottom++) {
                let xCount = 0;
                let yCount = 0;

                for (let col = 0; col < n; col++) {
                    if (grid[bottom][col] === 'X') {
                        xCount++;
                    } else if (grid[bottom][col] === 'Y') {
                        yCount++;
                    }

                    if (bottom === top) {
                        if (grid[bottom][col] === 'X' || grid[bottom][col] === 'Y') {
                            freq.set(col, (freq.get(col) || 0) + 1);
                        }
                    } else {
                        if (grid[bottom][col] === 'X' || grid[bottom][col] === 'Y') {
                            freq.set(col, (freq.get(col) || 0) + 1);
                        }
                    }

                    if (xCount > 0 && xCount === yCount) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}