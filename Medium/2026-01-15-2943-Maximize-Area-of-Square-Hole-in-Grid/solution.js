function maxArea(n, m, hBars, vBars) {
    hBars.sort((a, b) => a - b);
    vBars.sort((a, b) => a - b);
    
    let maxH = Math.max(hBars[0] - 1, n + 2 - hBars[hBars.length - 1]);
    for (let i = 1; i < hBars.length; i++) {
        maxH = Math.max(maxH, hBars[i] - hBars[i - 1] - 1);
    }
    
    let maxV = Math.max(vBars[0] - 1, m + 2 - vBars[vBars.length - 1]);
    for (let i = 1; i < vBars.length; i++) {
        maxV = Math.max(maxV, vBars[i] - vBars[i - 1] - 1);
    }
    
    return Math.min(maxH, maxV) ** 2;
}