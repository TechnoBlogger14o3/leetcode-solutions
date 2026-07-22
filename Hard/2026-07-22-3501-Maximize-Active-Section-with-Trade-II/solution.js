var maximizeActiveSections = function(s, queries) {
    const n = s.length;
    const activeSections = new Array(n + 2).fill(0);
    let count = 0;

    // Count initial active sections
    for (let i = 0; i < n; i++) {
        if (s[i] === '1' && (i === 0 || s[i - 1] === '0')) {
            count++;
        }
    }

    // Precompute the number of active sections for each query
    const results = [];
    for (const [l, r] of queries) {
        const augmented = '1' + s.slice(l, r + 1) + '1';
        let newCount = 0;

        // Count active sections in the augmented string
        for (let i = 0; i < augmented.length; i++) {
            if (augmented[i] === '1' && (i === 0 || augmented[i - 1] === '0')) {
                newCount++;
            }
        }

        // Check for possible trades
        const leftBlock = l > 0 && s[l - 1] === '0' && s.slice(l, r + 1).includes('1');
        const rightBlock = r < n - 1 && s[r + 1] === '0' && s.slice(l, r + 1).includes('1');

        if (leftBlock && rightBlock) {
            newCount += 2; // Trade both sides
        } else if (leftBlock || rightBlock) {
            newCount++; // Trade one side
        }

        results.push(Math.max(count, newCount));
    }

    return results;
};