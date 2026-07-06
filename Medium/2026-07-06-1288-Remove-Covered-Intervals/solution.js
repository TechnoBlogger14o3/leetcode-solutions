var removeCoveredIntervals = function(intervals) {
    intervals.sort((a, b) => a[0] - b[0] || b[1] - a[1]);
    let count = 0;
    let end = 0;

    for (const interval of intervals) {
        if (interval[1] > end) {
            count++;
            end = interval[1];
        }
    }

    return count;
};