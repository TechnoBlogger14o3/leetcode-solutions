var minMoves = function(nums) {
    const minNum = Math.min(...nums);
    let moves = 0;
    for (let num of nums) {
        moves += num - minNum;
    }
    return moves;
};