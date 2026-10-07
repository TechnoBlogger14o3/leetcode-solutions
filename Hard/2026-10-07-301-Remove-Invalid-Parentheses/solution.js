var removeInvalidParentheses = function(s) {
    const isValid = (str) => {
        let count = 0;
        for (const char of str) {
            if (char === '(') count++;
            else if (char === ')') count--;
            if (count < 0) return false;
        }
        return count === 0;
    };

    const bfs = (start) => {
        const queue = [start];
        const visited = new Set();
        visited.add(start);
        let found = false;
        const results = [];

        while (queue.length > 0) {
            const current = queue.shift();
            if (isValid(current)) {
                results.push(current);
                found = true;
            }
            if (found) continue;

            for (let i = 0; i < current.length; i++) {
                if (current[i] !== '(' && current[i] !== ')') continue;
                const next = current.slice(0, i) + current.slice(i + 1);
                if (!visited.has(next)) {
                    visited.add(next);
                    queue.push(next);
                }
            }
        }
        return results;
    };

    return bfs(s);
};