var findAllPeople = function(n, meetings, firstPerson) {
    const graph = new Map();
    meetings.forEach(([x, y, time]) => {
        if (!graph.has(time)) graph.set(time, []);
        graph.get(time).push([x, y]);
    });

    const secretHolders = new Set([0, firstPerson]);
    const times = Array.from(graph.keys()).sort((a, b) => a - b);
    
    for (const time of times) {
        const currentMeetings = graph.get(time);
        const currentHolders = new Set();
        
        currentMeetings.forEach(([x, y]) => {
            if (secretHolders.has(x) || secretHolders.has(y)) {
                currentHolders.add(x);
                currentHolders.add(y);
            }
        });
        
        currentHolders.forEach(person => secretHolders.add(person));
    }

    return Array.from(secretHolders);
};