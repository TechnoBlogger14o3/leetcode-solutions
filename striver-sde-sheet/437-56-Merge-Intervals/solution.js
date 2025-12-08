/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
var merge = function(intervals) {
    intervals.sort((a, b) => a[0] - b[0]);
    const merged = [];
    
    for (let interval of intervals) {
        if (merged.length === 0 || merged[merged.length - 1][1] < interval[0]) {
            merged.push(interval);
        } else {
            merged[merged.length - 1][1] = Math.max(merged[merged.length - 1][1], interval[1]);
        }
    }
    
    return merged;
};
