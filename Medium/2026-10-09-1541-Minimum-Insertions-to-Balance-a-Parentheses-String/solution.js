var minInsertions = function(s) {
    let open = 0, insertions = 0;
    
    for (let i = 0; i < s.length; i++) {
        if (s[i] === '(') {
            open++;
        } else {
            if (open > 0) {
                open--;
            } else {
                insertions++;
            }
            if (s[i + 1] !== ')') {
                insertions++;
            } else {
                i++;
            }
        }
    }
    
    return insertions + open * 2;
};