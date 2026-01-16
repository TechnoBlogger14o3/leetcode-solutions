var maxSquareArea = function(m, n, hFences, vFences) {
    const MOD = 1e9 + 7;

    hFences.sort((a, b) => a - b);
    vFences.sort((a, b) => a - b);

    let maxHeight = Math.max(hFences[0] - 1, m - hFences[hFences.length - 1]);
    for (let i = 1; i < hFences.length; i++) {
        maxHeight = Math.max(maxHeight, hFences[i] - hFences[i - 1] - 1);
    }

    let maxWidth = Math.max(vFences[0] - 1, n - vFences[vFences.length - 1]);
    for (let i = 1; i < vFences.length; i++) {
        maxWidth = Math.max(maxWidth, vFences[i] - vFences[i - 1] - 1);
    }

    const maxSide = Math.min(maxHeight, maxWidth);
    return maxSide > 0 ? (maxSide * maxSide) % MOD : -1;
};