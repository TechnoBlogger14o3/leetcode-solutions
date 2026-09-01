class Solution {
    minMoves(classroom, energy) {
        const directions = [[0, 1], [1, 0], [0, -1], [-1, 0]];
        const m = classroom.length;
        const n = classroom[0].length;
        let start = null;
        const litter = [];
        
        for (let i = 0; i < m; i++) {
            for (let j = 0; j < n; j++) {
                if (classroom[i][j] === 'S') {
                    start = [i, j];
                } else if (classroom[i][j] === 'L') {
                    litter.push([i, j]);
                }
            }
        }
        
        const litterCount = litter.length;
        const dist = Array.from({ length: litterCount + 1 }, () => Array(litterCount + 1).fill(Infinity));
        
        const bfs = (startX, startY) => {
            const queue = [[startX, startY, energy]];
            const visited = new Set();
            visited.add(`${startX},${startY},${energy}`);
            const localDist = Array.from({ length: m }, () => Array(n).fill(Infinity));
            localDist[startX][startY] = 0;
            
            while (queue.length) {
                const [x, y, currEnergy] = queue.shift();
                
                for (const [dx, dy] of directions) {
                    const nx = x + dx;
                    const ny = y + dy;
                    
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || classroom[nx][ny] === 'X') continue;
                    
                    let nextEnergy = currEnergy - 1;
                    if (classroom[nx][ny] === 'R') {
                        nextEnergy = energy;
                    }
                    
                    if (nextEnergy >= 0 && localDist[nx][ny] > localDist[x][y] + 1) {
                        localDist[nx][ny] = localDist[x][y] + 1;
                        visited.add(`${nx},${ny},${nextEnergy}`);
                        queue.push([nx, ny, nextEnergy]);
                    }
                    
                    if (classroom[nx][ny] === 'L') {
                        const litterIndex = litter.findIndex(([lx, ly]) => lx === nx && ly === ny);
                        if (litterIndex !== -1) {
                            dist[0][litterIndex + 1] = Math.min(dist[0][litterIndex + 1], localDist[nx][ny] + 1);
                            dist[litterIndex + 1][0] = Math.min(dist[litterIndex + 1][0], localDist[nx][ny] + 1);
                        }
                    }
                }
            }
        };
        
        bfs(start[0], start[1]);
        
        for (let i = 0; i < litterCount; i++) {
            bfs(litter[i][0], litter[i][1]);
        }
        
        const dp = Array(1 << litterCount).fill(Infinity);
        dp[0] = 0;
        
        for (let mask = 0; mask < (1 << litterCount); mask++) {
            for (let i = 0; i < litterCount; i++) {
                if (mask & (1 << i)) continue;
                const nextMask = mask | (1 << i);
                dp[nextMask] = Math.min(dp[nextMask], dp[mask] + dist[0][i + 1]);
                for (let j = 0; j < litterCount; j++) {
                    if (mask & (1 << j)) {
                        dp[nextMask] = Math.min(dp[nextMask], dp[mask] + dist[i + 1][j + 1]);
                    }
                }
            }
        }
        
        const result = dp[(1 << litterCount) - 1];
        return result === Infinity ? -1 : result;
    }
}