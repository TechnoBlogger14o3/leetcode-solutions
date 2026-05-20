var findThePrefixCommonArray = function(A, B) {
    const n = A.length;
    const C = new Array(n).fill(0);
    const seen = new Set();
    
    for (let i = 0; i < n; i++) {
        seen.add(A[i]);
        if (seen.has(B[i])) {
            C[i] = (i > 0 ? C[i - 1] : 0) + 1;
        } else {
            C[i] = i > 0 ? C[i - 1] : 0;
        }
    }
    
    return C;
};