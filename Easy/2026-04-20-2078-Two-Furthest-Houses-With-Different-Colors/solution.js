function maxDistance(colors) {
    const n = colors.length;
    let firstColor = colors[0];
    let lastColor = colors[n - 1];
    
    let maxDist = 0;
    
    // Check distance with first house
    for (let i = n - 1; i >= 0; i--) {
        if (colors[i] !== firstColor) {
            maxDist = Math.max(maxDist, i);
            break;
        }
    }
    
    // Check distance with last house
    for (let i = 0; i < n; i++) {
        if (colors[i] !== lastColor) {
            maxDist = Math.max(maxDist, n - 1 - i);
            break;
        }
    }
    
    return maxDist;
}