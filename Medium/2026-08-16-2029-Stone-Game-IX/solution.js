var stoneGameIX = function(stones) {
    let count = [0, 0, 0];
    
    for (let stone of stones) {
        count[stone % 3]++;
    }
    
    if (count[0] % 2 === 1) {
        return count[1] > 0 || count[2] > 1;
    } else {
        return count[1] > count[2] || (count[1] > 0 && count[2] > 0);
    }
};