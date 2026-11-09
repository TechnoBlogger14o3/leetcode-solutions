var busiestServers = function(k, arrival, load) {
    const busyUntil = new Array(k).fill(0);
    const requestCount = new Array(k).fill(0);
    
    for (let i = 0; i < arrival.length; i++) {
        const currentTime = arrival[i];
        const serverIndex = i % k;
        
        // Find the first available server
        let assignedServer = -1;
        for (let j = 0; j < k; j++) {
            const index = (serverIndex + j) % k;
            if (busyUntil[index] <= currentTime) {
                assignedServer = index;
                break;
            }
        }
        
        // If an available server is found, assign the request
        if (assignedServer !== -1) {
            busyUntil[assignedServer] = currentTime + load[i];
            requestCount[assignedServer]++;
        }
    }
    
    const maxRequests = Math.max(...requestCount);
    return requestCount
        .map((count, index) => (count === maxRequests ? index : -1))
        .filter(index => index !== -1);
};