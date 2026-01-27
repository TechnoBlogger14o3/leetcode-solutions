class MinCostPath {
    constructor(n, edges) {
        this.n = n;
        this.adj = new Map();
        this.incoming = new Map();
        
        for (const [u, v, w] of edges) {
            if (!this.adj.has(u)) this.adj.set(u, []);
            this.adj.get(u).push([v, w]);
            
            if (!this.incoming.has(v)) this.incoming.set(v, []);
            this.incoming.get(v).push([u, w]);
        }
    }

    minCost() {
        const dist = Array(this.n).fill(Infinity);
        const pq = new MinHeap();
        pq.insert(0, 0); // cost, node
        dist[0] = 0;

        while (!pq.isEmpty()) {
            const [cost, node] = pq.extractMin();

            if (node === this.n - 1) return cost;

            if (cost > dist[node]) continue;

            // Traverse outgoing edges
            if (this.adj.has(node)) {
                for (const [next, weight] of this.adj.get(node)) {
                    if (cost + weight < dist[next]) {
                        dist[next] = cost + weight;
                        pq.insert(dist[next], next);
                    }
                }
            }

            // Traverse incoming edges with reversal
            if (this.incoming.has(node)) {
                for (const [prev, weight] of this.incoming.get(node)) {
                    if (cost + 2 * weight < dist[prev]) {
                        dist[prev] = cost + 2 * weight;
                        pq.insert(dist[prev], prev);
                    }
                }
            }
        }

        return dist[this.n - 1] === Infinity ? -1 : dist[this.n - 1];
    }
}

class MinHeap {
    constructor() {
        this.heap = [];
    }

    insert(cost, node) {
        this.heap.push([cost, node]);
        this.bubbleUp();
    }

    bubbleUp() {
        let index = this.heap.length - 1;
        while (index > 0) {
            const parentIndex = Math.floor((index - 1) / 2);
            if (this.heap[index][0] >= this.heap[parentIndex][0]) break;
            [this.heap[index], this.heap[parentIndex]] = [this.heap[parentIndex], this.heap[index]];
            index = parentIndex;
        }
    }

    extractMin() {
        if (this.heap.length === 0) return null;
        if (this.heap.length === 1) return this.heap.pop();
        const min = this.heap[0];
        this.heap[0] = this.heap.pop();
        this.bubbleDown();
        return min;
    }

    bubbleDown() {
        let index = 0;
        const length = this.heap.length;
        while (true) {
            let leftChildIndex = 2 * index + 1;
            let rightChildIndex = 2 * index + 2;
            let smallestIndex = index;

            if (leftChildIndex < length && this.heap[leftChildIndex][0] < this.heap[smallestIndex][0]) {
                smallestIndex = leftChildIndex;
            }
            if (rightChildIndex < length && this.heap[rightChildIndex][0] < this.heap[smallestIndex][0]) {
                smallestIndex = rightChildIndex;
            }
            if (smallestIndex === index) break;
            [this.heap[index], this.heap[smallestIndex]] = [this.heap[smallestIndex], this.heap[index]];
            index = smallestIndex;
        }
    }

    isEmpty() {
        return this.heap.length === 0;
    }
}

var minCost = function(n, edges) {
    const graph = new MinCostPath(n, edges);
    return graph.minCost();
};