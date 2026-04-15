var closetTarget = function(words, target, startIndex) {
    const n = words.length;
    let minDistance = Infinity;

    for (let i = 0; i < n; i++) {
        if (words[i] === target) {
            const distance = Math.min(Math.abs(i - startIndex), n - Math.abs(i - startIndex));
            minDistance = Math.min(minDistance, distance);
        }
    }

    return minDistance === Infinity ? -1 : minDistance;
};