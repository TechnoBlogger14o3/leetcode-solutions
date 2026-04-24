var furthestDistanceFromOrigin = function(moves) {
    let leftMoves = 0;
    let rightMoves = 0;
    let underscoreCount = 0;

    for (let move of moves) {
        if (move === 'L') {
            leftMoves++;
        } else if (move === 'R') {
            rightMoves++;
        } else if (move === '_') {
            underscoreCount++;
        }
    }

    return Math.abs(leftMoves - rightMoves) + underscoreCount;
};