var minimumOperations = function(s) {
    const n = s.length;
    let sorted = [...s].sort().join('');
    
    if (s === sorted) return 0;
    
    let operations = 0;
    let i = 0;
    
    while (i < n) {
        if (s[i] === sorted[i]) {
            i++;
        } else {
            operations++;
            while (i < n && s[i] !== sorted[i]) {
                i++;
            }
        }
    }
    
    return operations === 1 ? -1 : operations;
};