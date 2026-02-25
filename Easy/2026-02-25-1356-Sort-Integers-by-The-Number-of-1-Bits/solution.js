var sortByBits = function(arr) {
    return arr.sort((a, b) => {
        const countA = a.toString(2).split('0').join('').length;
        const countB = b.toString(2).split('0').join('').length;
        return countA === countB ? a - b : countA - countB;
    });
};