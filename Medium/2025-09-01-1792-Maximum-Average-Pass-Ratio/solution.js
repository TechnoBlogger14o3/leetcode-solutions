var maxAverageRatio = function(classes, extraStudents) {
    const n = classes.length;
    const pq = new MaxPriorityQueue({ priority: (a, b) => b[0] - a[0] });

    for (const [pass, total] of classes) {
        pq.enqueue([pass, total]);
    }

    while (extraStudents > 0) {
        const [pass, total] = pq.dequeue().element;
        pq.enqueue([pass + 1, total + 1]);
        extraStudents--;
    }

    let totalRatio = 0;
    for (const [pass, total] of pq.toArray()) {
        totalRatio += pass / total;
    }

    return totalRatio / n;
};