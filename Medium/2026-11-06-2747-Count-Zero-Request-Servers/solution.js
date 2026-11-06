class Solution {
    countServers(n, logs, x, queries) {
        const serverRequests = new Array(n + 1).fill(0);
        const results = new Array(queries.length).fill(0);
        
        // Count requests for each server
        for (const [serverId, time] of logs) {
            serverRequests[serverId]++;
        }
        
        // Create a time map to track server activity
        const timeMap = new Map();
        for (const [serverId, time] of logs) {
            if (!timeMap.has(time)) {
                timeMap.set(time, new Set());
            }
            timeMap.get(time).add(serverId);
        }
        
        // Process each query
        for (let i = 0; i < queries.length; i++) {
            const queryTime = queries[i];
            const startTime = queryTime - x;
            const activeServers = new Set();
            
            // Check all logs within the time range
            for (let time = startTime; time <= queryTime; time++) {
                if (timeMap.has(time)) {
                    for (const serverId of timeMap.get(time)) {
                        activeServers.add(serverId);
                    }
                }
            }
            
            // Count servers with no requests
            results[i] = n - activeServers.size;
        }
        
        return results;
    }
}