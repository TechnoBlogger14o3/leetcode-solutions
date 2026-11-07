class Server {
    constructor(weight, index) {
        this.weight = weight;
        this.index = index;
        this.freeTime = 0;
    }
}

var assignTasks = function(servers, tasks) {
    const n = servers.length;
    const m = tasks.length;
    const ans = new Array(m);
    const freeServers = new MinPriorityQueue({ priority: server => server.weight });
    const busyServers = new MinPriorityQueue({ priority: server => server.freeTime });
    
    for (let i = 0; i < n; i++) {
        freeServers.enqueue(new Server(servers[i], i));
    }
    
    let time = 0;
    for (let j = 0; j < m; j++) {
        time = Math.max(time, j);
        
        while (busyServers.size() > 0 && busyServers.front().freeTime <= time) {
            const server = busyServers.dequeue().element;
            freeServers.enqueue(server);
        }
        
        if (freeServers.size() > 0) {
            const server = freeServers.dequeue().element;
            ans[j] = server.index;
            server.freeTime = time + tasks[j];
            busyServers.enqueue(server);
        } else {
            const nextFreeServer = busyServers.front().element;
            time = nextFreeServer.freeTime;
            const server = busyServers.dequeue().element;
            ans[j] = server.index;
            server.freeTime = time + tasks[j];
            busyServers.enqueue(server);
        }
    }
    
    return ans;
};