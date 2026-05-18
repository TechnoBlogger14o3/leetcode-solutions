var minJumps = function(arr) {
    const n = arr.length;
    if (n <= 1) return 0;

    const graph = new Map();
    for (let i = 0; i < n; i++) {
        if (!graph.has(arr[i])) {
            graph.set(arr[i], []);
        }
        graph.get(arr[i]).push(i);
    }

    const queue = [0];
    const visited = new Set([0]);
    let steps = 0;

    while (queue.length) {
        const size = queue.length;
        for (let i = 0; i < size; i++) {
            const index = queue.shift();
            if (index === n - 1) return steps;

            // Check the next index
            if (index + 1 < n && !visited.has(index + 1)) {
                visited.add(index + 1);
                queue.push(index + 1);
            }

            // Check the previous index
            if (index - 1 >= 0 && !visited.has(index - 1)) {
                visited.add(index - 1);
                queue.push(index - 1);
            }

            // Check all indices with the same value
            if (graph.has(arr[index])) {
                for (const nextIndex of graph.get(arr[index])) {
                    if (!visited.has(nextIndex)) {
                        visited.add(nextIndex);
                        queue.push(nextIndex);
                    }
                }
                graph.delete(arr[index]); // Clear to prevent future unnecessary checks
            }
        }
        steps++;
    }

    return -1; // This line should never be reached
};