var maxHappiness = function(happiness, k) {
    happiness.sort((a, b) => b - a);
    let totalHappiness = 0;
    let n = happiness.length;

    for (let i = 0; i < k; i++) {
        totalHappiness += happiness[i];
        let decrement = Math.min(happiness[i], n - i - 1);
        for (let j = i + 1; j < n; j++) {
            happiness[j] = Math.max(0, happiness[j] - decrement);
        }
    }

    return totalHappiness;
};