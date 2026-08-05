var removeMethods = function(n, k, invocations) {
    const graph = Array.from({ length: n }, () => []);
    const inDegree = Array(n).fill(0);
    
    for (const [a, b] of invocations) {
        graph[a].push(b);
        inDegree[b]++;
    }
    
    const suspicious = new Set();
    const queue = [k];
    suspicious.add(k);
    
    while (queue.length) {
        const method = queue.shift();
        for (const invoked of graph[method]) {
            if (!suspicious.has(invoked)) {
                suspicious.add(invoked);
                queue.push(invoked);
            }
        }
    }
    
    const remaining = [];
    for (let i = 0; i < n; i++) {
        if (!suspicious.has(i) && inDegree[i] === 0) {
            remaining.push(i);
        }
    }
    
    return remaining.length === 0 ? [] : remaining;
};