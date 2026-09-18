var maxNumOfSubstrings = function(s) {
    const n = s.length;
    const first = new Array(26).fill(-1);
    const last = new Array(26).fill(-1);
    
    for (let i = 0; i < n; i++) {
        const idx = s.charCodeAt(i) - 'a'.charCodeAt(0);
        if (first[idx] === -1) first[idx] = i;
        last[idx] = i;
    }
    
    const intervals = [];
    
    for (let i = 0; i < 26; i++) {
        if (first[i] === -1) continue;
        let start = first[i];
        let end = last[i];
        for (let j = start; j <= end; j++) {
            const charIdx = s.charCodeAt(j) - 'a'.charCodeAt(0);
            end = Math.max(end, last[charIdx]);
        }
        intervals.push([start, end]);
    }
    
    intervals.sort((a, b) => a[1] - b[1]);
    
    const result = [];
    let lastEnd = -1;
    
    for (const [start, end] of intervals) {
        if (start > lastEnd) {
            result.push(s.slice(start, end + 1));
            lastEnd = end;
        }
    }
    
    return result;
};