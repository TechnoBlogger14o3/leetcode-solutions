var countSubstrings = function(s) {
    let n = s.length;
    let count = 0;
    
    for (let i = 0; i < n; i++) {
        let ones = 0, zeros = 0;
        for (let j = i; j < n; j++) {
            if (s[j] === '1') {
                ones++;
            } else {
                zeros++;
            }
            if (ones >= zeros * zeros) {
                count++;
            }
        }
    }
    
    return count;
};