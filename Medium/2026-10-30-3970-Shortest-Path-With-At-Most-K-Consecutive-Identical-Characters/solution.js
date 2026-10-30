class Node {
    constructor(index, weight, consecutiveCount, lastChar) {
        this.index = index;
        this.weight = weight;
        this.consecutiveCount = consecutiveCount;
        this.lastChar = lastChar;
    }
}

var shortestPath = function(n, edges, labels, k) {
    const graph = Array.from({ length: n }, () => []);
    for (const [u, v, w] of edges) {
        graph[u].push([v, w]);
    }

    const pq = new MinPriorityQueue();
    pq.enqueue(new Node(0, 0, 0, ''));
    const dist = Array.from({ length: n }, () => Infinity);
    dist[0] = 0;

    while (!pq.isEmpty()) {
        const { index, weight, consecutiveCount, lastChar } = pq.dequeue().element;

        if (index === n - 1) return weight;

        for (const [nextIndex, edgeWeight] of graph[index]) {
            const currentChar = labels[nextIndex];
            let newConsecutiveCount = (currentChar === lastChar) ? consecutiveCount + 1 : 1;

            if (newConsecutiveCount <= k) {
                const newWeight = weight + edgeWeight;
                if (newWeight < dist[nextIndex]) {
                    dist[nextIndex] = newWeight;
                    pq.enqueue(new Node(nextIndex, newWeight, newConsecutiveCount, currentChar));
                }
            }
        }
    }

    return -1;
};