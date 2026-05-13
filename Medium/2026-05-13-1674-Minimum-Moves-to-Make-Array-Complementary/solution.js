var minMoves = function(nums, limit) {
    const n = nums.length;
    const moves = new Array(n + 2).fill(0);
    
    for (let i = 0; i < n / 2; i++) {
        const a = nums[i];
        const b = nums[n - 1 - i];
        const low = Math.max(2, a + b);
        const high = Math.min(limit + 1, a + b + 1);
        
        moves[2] += 2; // We need at least 2 moves to make them complementary
        moves[low] -= 1; // We can reduce the moves needed starting from low
        moves[high] += 1; // We can increase the moves needed starting from high
    }
    
    let minMoves = Infinity;
    let currentMoves = 0;
    
    for (let i = 2; i <= limit + 1; i++) {
        currentMoves += moves[i];
        minMoves = Math.min(minMoves, currentMoves);
    }
    
    return minMoves;
};