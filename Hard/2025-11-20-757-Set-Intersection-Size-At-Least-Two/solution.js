var intersectionSizeTwo = function(intervals) {
    intervals.sort((a, b) => a[1] - b[1]);
    let count = 0;
    let end = -1;
    let secondEnd = -1;

    for (let [start, finish] of intervals) {
        if (end < finish - 1) {
            count += 2;
            secondEnd = finish;
            end = finish - 1;
        } else if (end === finish - 1) {
            count += 1;
            end = secondEnd;
        }
    }
    
    return count;
};